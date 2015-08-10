/**
 * 
 */
package com.erp.entity;

/**
 * @author jason_000
 *
 */
public class OmInStorageTaskFlow {

	private Long flowId;

	private Long projectid;

	private Long taskId;

	private Long devtypeid;

	private String bak;

	public Long getFlowId() {
		return flowId;
	}

	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public Long getDevtypeid() {
		return devtypeid;
	}

	public void setDevtypeid(Long devtypeid) {
		this.devtypeid = devtypeid;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

}
