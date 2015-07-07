package com.erp.entity;

import com.erp.entity.FlowRecordInfo;
/**
 * 请假单
 */
public class FlowTaskInfo {
	FlowRecordInfo flowRecordInfo = new FlowRecordInfo();
	//流程相关
	private String pdname;// 申请单类型
	private String pdid;// 流程定义id
	private String pdkey;// 流程定义key
	private String taskId;//任务ID
	private String outcome;		//连线名称
	private String comment;		//备注
	private String nextName;//下一步处理人
	public FlowRecordInfo getFlowRecordInfo() {
		return flowRecordInfo;
	}
	public void setFlowRecordInfo(FlowRecordInfo flowRecordInfo) {
		this.flowRecordInfo = flowRecordInfo;
	}
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getPdid() {
		return pdid;
	}
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	public String getPdkey() {
		return pdkey;
	}
	public void setPdkey(String pdkey) {
		this.pdkey = pdkey;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getNextName() {
		return nextName;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	
	
}
