package com.erp.entity;

/**
 * 项目工程信息
 */
public class FlowProejctInfo {
	private String projectName;	// 项目名称
	private String taskName;		// 任务编号
	private long flowId;		    // 流程id
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public long getFlowId() {
		return flowId;
	}
	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}
	
	
	
}


