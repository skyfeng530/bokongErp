package com.erp.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.activiti.bpmn.BpmnAutoLayout;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.service.AutoWorkflowService;
import com.erp.util.Log4jUtils;
import com.erp.util.TaskModuleUtil;
import com.erp.util.Log4jUtils.LogLevel;


@Transactional
@Service("autoWorkflowService")
public class AutoWorkFlowServiceImpl implements AutoWorkflowService {

	private static Log4jUtils logger = new Log4jUtils(AutoWorkFlowServiceImpl.class);
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private FormService formService;
	@Autowired
	private HistoryService historyService;

	@Autowired
	public ActivitiRule activitiRule;

	@Override
	public void autoDynamicDeploy(String processId, String processName){
		logger.log(LogLevel.DEBUG, "[AutoWorkFlowServiceImpl] autoDynamicDeploy enter.");
		// 创建bpmn模型
		BpmnModel model = new BpmnModel();
		Process process = new Process();
		model.addProcess(process);
		process.setId(processId);
		process.setName(processName);

		// 创建bpmn元素
		process.addFlowElement(TaskModuleUtil.createStartEvent());
		process.addFlowElement(TaskModuleUtil.createUserTask("task1", "First task", "admin", "audit_leave"));
		process.addFlowElement(TaskModuleUtil.createUserTask("task2", "Second task", "admin", "audit_leave"));
		process.addFlowElement(TaskModuleUtil.createEndEvent());

		process.addFlowElement(TaskModuleUtil.createSequenceFlow("start", "task1", null));
		process.addFlowElement(TaskModuleUtil.createSequenceFlow("task1", "task2", null));
		process.addFlowElement(TaskModuleUtil.createSequenceFlow("task2", "task1","驳回"));
		process.addFlowElement(TaskModuleUtil.createSequenceFlow("task2", "end", "确认"));

		// 2.生成BPMN自动布局
		new BpmnAutoLayout(model).execute();

		// 3. 部署这个BPMN模型
		//Deployment deployment = 
		activitiRule.getRepositoryService()
				.createDeployment().addBpmnModel(processId + ".bpmn", model)
				.name(processName).deploy();
	}
	
	@Override
	public void saveSubmitTask(FlowTaskInfo flowTaskInfo) {
		FlowRecordInfo recordInfo = flowTaskInfo.getFlowRecordInfo();
		//获取任务ID
		String taskId = flowTaskInfo.getTaskId();
		
		// 获取连线的名称
		String outcome = flowTaskInfo.getOutcome();
		
		if(null == flowTaskInfo.getOutcome())
		{
			outcome = "";
		}
		
		// 批注信息
		String message = flowTaskInfo.getComment();
		
		if(null == flowTaskInfo.getComment())
		{
			message = "";
		}

		// 获取请假单ID
		//Long id = recordInfo.getFlowId();
		// 下一步处理人
		String nextName = flowTaskInfo.getNextName();

		// 使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi1 = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		String className = pi1.getBusinessKey().split("\\.")[0];
		Authentication.setAuthenticatedUserId(recordInfo.getHandlePerson());
		taskService.addComment(taskId, processInstanceId, message);
		Map<String, Object> variables = new HashMap<String, Object>();
		if (outcome != null ) {
			variables.put("outcome", outcome);
		}
		variables.put("nextName", nextName);
		taskService.complete(taskId, variables);
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		// 流程结束了
		if (pi == null) {
			// 更新请假单表的状态从1变成2（审核中-->审核完成）
			if ("BusLeave".equals(className)) {
				/*BusLeave bill = leaveDao.getById(id + "");
				bill.setState(2);
				leaveDao.modify(bill);*/
			}
			if ("BusStorage".equals(className)) {
				/*
				 * BusStorage storage = storageDao.getById(id + "");
				 * storage.setState(2); leaveDao.modify(storage);
				 */
			}
		}
		
	}

}
