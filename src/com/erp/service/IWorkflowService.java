package com.erp.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.erp.entity.BusLeave;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.MyTask;
import com.erp.entity.ProjectInfo;
import com.erp.util.PageView;

public interface IWorkflowService {

	public void saveNewDeploye(CommonsMultipartFile file, String filename);

	public List<Deployment> findDeploymentList();

	public List<ProcessDefinition> findProcessDefinitionList();

	public void deleteProcessDefinitionByDeploymentId(String deploymentId);

	public InputStream findImageInputStream(String deploymentId,
			String imageName);

	public ProcessDefinition findProcessDefinitionListByPdId(String pdid);

	/**启动流程**/
	public void saveStartProcess(FlowRecordInfo record);
	
	/**启动流程**/
	public void saveStartProcess(String pdid);

	/**根据用户名获取任务列表
	 * @param pageView */
	public List<Task> findTaskListByName(PageView pageView, String name);

	/**使用任务ID，获取当前任务节点中对应的Form key中的连接的值*/
	public String findTaskFormKeyByTaskId(String taskId);

	/**使用任务ID，查找请假单ID，从而获取请假单信息*/
	public BusLeave findLeaveBillByTaskId(String taskId);

	/**已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称，并放置到List<String>集合中*/
	public List<String> findOutComeListByTaskId(String taskId);

	/**查询所有历史审核人的审核信息，帮助当前人完成审核，返回List<Comment>*/
	public List<Comment> findCommentByTaskId(String taskId);

	public void saveSubmitTask(MyTask task);
	
	public void saveSubmitTask(FlowRecordInfo recordInfo);

	public List<FlowRecordInfo> findApplyFormByName(PageView pageView, FlowRecordInfo record);

	/**查看请假单审批历史**/
	public List<Comment> findLeaveCommentById(String id);

	/**使用任务对象获取流程定义ID，查询流程定义对象*/
	public ProcessDefinition findProcessDefinitionByTaskId(String taskId);

	public Map<String, Object> findCoordingByTask(String taskId);
	
	public List<ProjectInfo> findProjectName();
	
	public List<ProjectInfo> findTaskNumber(PageView pageView, ProjectInfo projectInfo);
	
	public int saveStorage(ProjectInfo projectInfo, FlowRecordInfo recordInfo);
}
