package com.erp.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.erp.dao.BusProjectDao;
import com.erp.dao.BusProjectFigureDao;
import com.erp.dao.FlowProejctInfoDao;
import com.erp.dao.FlowRecordInfoDao;
import com.erp.dao.LeaveDao;
import com.erp.dao.ProjectInfoDao;
import com.erp.dao.StorageFlowResultDao;
import com.erp.entity.BusLeave;
import com.erp.entity.BusProject;
import com.erp.entity.BusProjectFigure;
import com.erp.entity.BusStorage;
import com.erp.entity.FlowProejctInfo;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.entity.MyTask;
import com.erp.entity.ProjectInfo;
import com.erp.service.IWorkflowService;
import com.erp.util.Log4jUtils;
import com.erp.util.PageView;


@Transactional
@Service("workflowService")
public class WorkFlowServiceImpl implements IWorkflowService {
	

	private static Log4jUtils logger = new Log4jUtils(WorkFlowServiceImpl.class);
	
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
	private LeaveDao leaveDao;
	
	@Autowired
	private FlowRecordInfoDao flowrecordinfoDao;
	
	@Autowired
	private ProjectInfoDao projectinfoDao;
	
	@Autowired
	private FlowProejctInfoDao flowProejctInfoDao;
	
	@Autowired
	private StorageFlowResultDao storageFlowResultDao;
	
	@Autowired
	private BusProjectDao busProjectDao;
	
	@Autowired
	private BusProjectFigureDao busProjectFigureDao;
	/**
	 * 部署新流程
	 */
	@Override
	public void saveNewDeploye(CommonsMultipartFile file, String filename) {
		try {
			ZipInputStream zipInputStream = new ZipInputStream(
					file.getInputStream());
			repositoryService.createDeployment()
							.name(filename)
							.addZipInputStream(zipInputStream)
							.deploy();
		} catch (Exception e) {
		}
	}

	@Override
	public List<Deployment> findDeploymentList() {
		List<Deployment> dplist = repositoryService.createDeploymentQuery()
						.orderByDeploymenTime().asc()
						.list();
		return dplist;
	}

	@Override
	public List<ProcessDefinition> findProcessDefinitionList() {
		List<ProcessDefinition> pdlist = repositoryService.createProcessDefinitionQuery()
						.latestVersion()
						.orderByProcessDefinitionVersion().asc()
						.list();
		return pdlist;
	}

	@Override
	public void deleteProcessDefinitionByDeploymentId(String deploymentId) {
		repositoryService.deleteDeployment(deploymentId, true);
	}

	@Override
	public InputStream findImageInputStream(String deploymentId,
			String imageName) {
		return repositoryService.getResourceAsStream(deploymentId, imageName);
	}

	@Override
	public ProcessDefinition findProcessDefinitionListByPdId(String pdid) {
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
						.deploymentId(pdid)
						.singleResult();
		return pd;
	}

	/**启动流程**/
	@Override
	public void saveStartProcess(FlowTaskInfo flowTaskInfo) {
		FlowRecordInfo record = flowTaskInfo.getFlowRecordInfo();
		Long id = record.getFlowId();
		String pdid = flowTaskInfo.getPdid();
		String key = pdid;
		Map<String, Object> variables = new HashMap<String,Object>();
		if ("BusLeave".equals(pdid)) {
			BusLeave leave = leaveDao.getById(id + "");
			//更新请假单的请假状态从0变成1（初始录入-->审核中）
			leave.setState(1);
			leaveDao.modify(leave);
			//使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
			key = leave.getClass().getSimpleName();
			variables.put("inputUser", leave.getUsername());//表示惟一用户
		}
		if ("BusStorage".equals(pdid)) {
			/*BusStorage storage = storageDao.getById(id + "");
			//更新请假单的请假状态从0变成1（初始录入-->审核中）
			storage.setState(1);
			storageDao.modify(storage);
			//使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
			key = storage.getClass().getSimpleName();*/
			variables.put("nextName", record.getHandlePerson());//表示惟一用户
		}
		if ("BusProject".equals(pdid)) {
			variables.put("nextName", record.getHandlePerson());//表示惟一用户
		}
		if ("BusProjectFigure".equals(pdid)) {
			variables.put("nextName", record.getHandlePerson());//表示惟一用户
		}
		//格式：类名.id的形式（使用流程变量）
		record.setClassName(key);
		String objId = key+"."+id;
		variables.put("objId", objId);
		runtimeService.startProcessInstanceByKey(key,objId,variables);
	}

	/**根据用户名获取任务列表*/
	@Override
	public List<Task> findTaskListByName(PageView pageView, String name) {
		return taskService.createTaskQuery()
						.taskAssignee(name)
						.orderByTaskCreateTime().asc()
						.listPage(pageView.getStartPage(), pageView.getStartPage() + pageView.getPageSize());
	}

	/**使用任务ID，获取当前任务节点中对应的Form key中的连接的值*/
	@Override
	public String findTaskFormKeyByTaskId(String taskId) {
		TaskFormData formData = formService.getTaskFormData(taskId);
		String url = formData.getFormKey();
		return url;
	}

	/**一：使用任务ID，查找请假单ID，从而获取请假单信息*/
	@Override
	public BusLeave findLeaveBillByTaskId(String taskId) {
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		String buniness_key = pi.getBusinessKey();
		String id = "";
		if(StringUtils.isNotBlank(buniness_key)){
			id = buniness_key.split("\\.")[1];
		}
		//查询请假单对象
		BusLeave leaveBill = leaveDao.getById(id);
		return leaveBill;
	}
	
	/**一：使用任务ID，查找请假单ID，从而获取请假单信息*/
	@Override
	public BusProject findProjectBillByTaskId(String taskId) {
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		String buniness_key = pi.getBusinessKey();
		String id = "";
		if(StringUtils.isNotBlank(buniness_key)){
			id = buniness_key.split("\\.")[1];
		}
		//查询请假单对象
		BusProject busProject = busProjectDao.getById(id);
		return busProject;
	}
	
	/**一：使用任务ID，查找请假单ID，从而获取请假单信息*/
	@Override
	public BusProjectFigure findProjectFigureByTaskId(String taskId) {
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		String buniness_key = pi.getBusinessKey();
		String id = "";
		if(StringUtils.isNotBlank(buniness_key)){
			id = buniness_key.split("\\.")[1];
		}
		//查询请假单对象
		BusProjectFigure busProjectFigure = busProjectFigureDao.getById(id);
		return busProjectFigure;
	}
	
	/**已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
	@Override
	public List<String> findOutComeListByTaskId(String taskId) {
		//返回存放连线的名称集合
		List<String> list = new ArrayList<String>();
		//1:使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//2：获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		//3：查询ProcessDefinitionEntiy对象
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(processDefinitionId);
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		String activityId = pi.getActivityId();
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
		List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
		if(pvmList!=null && pvmList.size()>0){
			for(PvmTransition pvm:pvmList){
				String name = (String) pvm.getProperty("name");
				if(StringUtils.isNotBlank(name)){
					list.add(name);
				}
				else{
					list.add("默认提交");
				}
			}
		}
		return list;
	}
	
	/**查询所有历史审核人的审核信息，帮助当前人完成审核，返回List<Comment>*/
	@Override
	public List<Comment> findCommentByTaskId(String taskId) {
		List<Comment> list = new ArrayList<Comment>();
		//使用当前的任务ID，查询当前流程对应的历史任务ID
		//使用当前任务ID，获取当前任务对象
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)//使用任务ID查询
				.singleResult();
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}

	@Override
	public void saveSubmitTask(MyTask myTask) {
		//获取任务ID
		String taskId = myTask.getTaskId();
		//获取连线的名称
		String outcome = myTask.getOutcome();
		//批注信息
		String message = myTask.getComment();
		//获取请假单ID
		Long id = myTask.getId();
		//下一步处理人
		String nextName = myTask.getNextName();
		
		//使用任务ID，查询任务对象，获取流程流程实例ID
		Task task = taskService.createTaskQuery()//
						.taskId(taskId)//使用任务ID查询
						.singleResult();
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		ProcessInstance pi1 = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)//使用流程实例ID查询
				.singleResult();
		String className = pi1.getBusinessKey().split("\\.")[0];
		Authentication.setAuthenticatedUserId(myTask.getUsername());
		taskService.addComment(taskId, processInstanceId, message);
		Map<String, Object> variables = new HashMap<String,Object>();
		if(outcome!=null && !outcome.equals("默认提交")){
			variables.put("outcome", outcome);
		}
		variables.put("inputUser", nextName);
		taskService.complete(taskId, variables);
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
						.processInstanceId(processInstanceId)//使用流程实例ID查询
						.singleResult();
		//流程结束了
		if(pi==null){
			//更新请假单表的状态从1变成2（审核中-->审核完成）
			if ("BusLeave".equals(className)) {
				BusLeave bill = leaveDao.getById(id + "");
				bill.setState(2);
				leaveDao.modify(bill);
			}
			if ("BusStorage".equals(className)) {
				/*BusStorage storage = storageDao.getById(id + "");
				storage.setState(2);
				leaveDao.modify(storage);*/
			}
		}
	}

	@Override
	public List<FlowTaskInfo> findApplyFormByName(PageView pageView, FlowTaskInfo flowTaskInfo) {
		//查询所有流程定义
		FlowRecordInfo record = flowTaskInfo.getFlowRecordInfo();
		List<ProcessDefinition> pdList = findProcessDefinitionList();
		List<FlowRecordInfo> reInfos = flowrecordinfoDao.query(pageView, record);
		if ((null != pdList && pdList.size() > 0) || (null != reInfos && reInfos.size() > 0)) {
			return null;
		}
		List<FlowTaskInfo> reTaskInfos = new ArrayList<FlowTaskInfo>();
		for (ProcessDefinition pd : pdList) {
			for (int i = 0; i < reInfos.size() ; i++) {
				FlowRecordInfo info = reInfos.get(i);
				FlowTaskInfo tmpTaskInfo =new FlowTaskInfo();
				tmpTaskInfo = flowTaskInfo;
				String className = info.getClassName();
				if (pd.getKey().equals(className)) {
					tmpTaskInfo.setPdname(pd.getName());
				}
				reInfos.add(i, info);
				reTaskInfos.add(i, tmpTaskInfo);
			}
		}
		return reTaskInfos;
	}
	
	/**查看请假单审批历史**/
	@Override
	public List<Comment> findLeaveCommentById(String id) {
		//使用请假单ID，查询请假单对象
		BusLeave leave = leaveDao.getById(id);
		//获取对象的名称
		String objectName = leave.getClass().getSimpleName();
		//组织流程表中的字段中的值
		String objId = objectName+"."+id;
		
		HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery()//对应历史的流程变量表
						.variableValueEquals("objId", objId)//使用流程变量的名称和流程变量的值查询
						.singleResult();
		//流程实例ID
		String processInstanceId = hvi.getProcessInstanceId();
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}
	/**使用任务对象获取流程定义ID，查询流程定义对象*/
	@Override
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId) {
		//使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)
					.singleResult();
		//获取流程定义ID
		String processDefinitionId = task.getProcessDefinitionId();
		//查询流程定义的对象
		ProcessDefinition pd = repositoryService.createProcessDefinitionQuery() 
					.processDefinitionId(processDefinitionId)
					.singleResult();
		return pd;
	}
	
	@Override
	public Map<String, Object> findCoordingByTask(String taskId) {
		//存放坐标
		Map<String, Object> map = new HashMap<String,Object>();
		//使用任务ID，查询任务对象
		Task task = taskService.createTaskQuery()//
					.taskId(taskId)//使用任务ID查询
					.singleResult();
		//获取流程定义的ID
		String processDefinitionId = task.getProcessDefinitionId();
		//获取流程定义的实体对象（对应.bpmn文件中的数据）
		ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
		//流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		//使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
					.processInstanceId(processInstanceId)//使用流程实例ID查询
					.singleResult();
		//获取当前活动的ID
		String activityId = pi.getActivityId();
		//获取当前活动对象
		ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
		//获取坐标
		map.put("x", activityImpl.getX());
		map.put("y", activityImpl.getY());
		map.put("width", activityImpl.getWidth());
		map.put("height", activityImpl.getHeight());
		return map;
	}
	

	@Override
	public void saveStartProcess(String pdid) {
		// TODO Auto-generated method stub
		String key = pdid;
		Integer id = 0;
		Map<String, Object> variables = new HashMap<String,Object>();

		if ("BusStorage".equals(pdid)) {
			id = flowrecordinfoDao.count();
			variables.put("nextName", "admin");//表示惟一用户
			/*BusStorage storage = storageDao.getById(id + "");
			//更新请假单的请假状态从0变成1（初始录入-->审核中）
			storage.setState(1);
			storageDao.modify(storage);
			//使用当前对象获取到流程定义的key（对象的名称就是流程定义的key）
			key = storage.getClass().getSimpleName();
			variables.put("inputUser", storage.getUsername());//表示惟一用户
*/		}
		//格式：类名.id的形式（使用流程变量）
		if( key.isEmpty())
		{
			return;
		}
		String objId = key+"."+id;
		variables.put("objId", objId);
		runtimeService.startProcessInstanceByKey(key,objId,variables);

		
		
	}

	@Override
	public List<ProjectInfo> findProjectName() {
		
		return projectinfoDao.queryProject(new ProjectInfo());
	}

	@Override
	public List<ProjectInfo> findTaskNumber(PageView pageView, ProjectInfo projectInfo) {
		
		return projectinfoDao.query(pageView, projectInfo);
	}

	@Override
	public int saveFlow(FlowTaskInfo flowTaskInfo, String flowPrefix) {
		FlowRecordInfo recordInfo = flowTaskInfo.getFlowRecordInfo();
		recordInfo.setState(1);
		flowrecordinfoDao.add(recordInfo);
		
		long maxId = flowrecordinfoDao.getMaxId();
		
		recordInfo.setFlowId((long) maxId);
		
		saveStartProcess(flowTaskInfo);
		
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		
		String key = flowPrefix +"." + maxId;
		
		Task task = taskService.createTaskQuery().processInstanceBusinessKey(key).singleResult();
		flowTaskInfo.setTaskId(task.getId());
		String excuteId = task.getExecutionId();
		String proc_def_id = task.getProcessDefinitionId();
		recordInfo.setExecution_ID(excuteId);
		recordInfo.setProc_def_id(proc_def_id);
		
		flowrecordinfoDao.modify(recordInfo);
		
		return 0;
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

	@Override
//	@Transactional
	public void addStorage(String strUserName, FlowTaskInfo flowTaskInfo, BusStorage storage) {
		// TODO Auto-generated method stub
		Task task = taskService.createTaskQuery()//
				.taskId(flowTaskInfo.getTaskId())// 使用任务ID查询
				.singleResult();
		FlowRecordInfo recordInfo = flowTaskInfo.getFlowRecordInfo();
		String excuteId = task.getExecutionId();
		String proc_def_id = task.getProcessDefinitionId();
		recordInfo.setExecution_ID(excuteId);
		recordInfo.setProc_def_id(proc_def_id);
		PageView pageView = new PageView(1);
		List<FlowRecordInfo> recordList = flowrecordinfoDao.queryOne(pageView, recordInfo);
		if (recordList.size() == 0) {
			return;
		}
		recordInfo = recordList.get(0);
		String url = findTaskFormKeyByTaskId(flowTaskInfo.getTaskId());
		
//		if (CollectionUtils.isEmpty(storage.getStorages())) {
//			return;
//		}
//
//		if ("storage_input".equals(url)) {
//			storageFlowResultDao.delete(Long.toString(recordInfo.getFlowId()));
//			// BusStorage storage 逐行插入
//			for (StorageFlowResult flowResult : storage.getStorages()) {
//				try {
//					storageFlowResultDao.add(flowResult);
//				} catch (Exception e) {
//
//					logger.log(LogLevel.ERROR, "[WorkFlowServiceImpl] addStorage has exception:" + e);
//				}
//			}
//
//		} else {
//			// BusStorage storage 逐行更新
//			for (StorageFlowResult flowResult : storage.getStorages()) {
//				try {
//					storageFlowResultDao.modify(flowResult);
//				} catch (Exception e) {
//
//					logger.log(LogLevel.ERROR, "[WorkFlowServiceImpl] addStorage has exception:" + e);
//				}
//			}
//		}
		recordInfo.setHandlePerson(strUserName);
		flowrecordinfoDao.modify(recordInfo);
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		// nextName是页面选择定的,这边测试
		flowTaskInfo.setNextName(strUserName);
		saveSubmitTask(flowTaskInfo);
	}
	
}
