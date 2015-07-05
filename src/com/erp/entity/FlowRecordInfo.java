package com.erp.entity;

import java.util.Date;

/**
 * 请假单
 */
public class FlowRecordInfo {
	private Long flowId;			//主键ID
	private String className; 		//任务单实体类
	private String info;           //主题	
	private Integer state;			//当前状态
	private String HandlePerson;   //当前处理人
	private String CopyPersons;	//当前抄送人
	private Date createTime = new Date();     //创建时间
	private String createPerson;   //创建人
	private String closeTime;      //关闭时间
	private String closePerson;    //关闭人
	private String bak;
	//流程相关
	private String execution_ID;   //实例id 
	private String proc_def_id;    //模型id
	private String pdname;// 申请单类型
	private String pdid;// 流程定义id
	private String pdkey;// 流程定义key
	private String taskId;//任务ID
	private String outcome;		//连线名称
	private String comment;		//备注
	private String nextName;//下一步处理人
	
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

	public String getExecution_ID() {
		return execution_ID;
	}
	public void setExecution_ID(String execution_ID) {
		this.execution_ID = execution_ID;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getHandlePerson() {
		return HandlePerson;
	}
	public void setHandlePerson(String handlePerson) {
		HandlePerson = handlePerson;
	}
	public String getCopyPersons() {
		return CopyPersons;
	}
	public void setCopyPersons(String copyPersons) {
		CopyPersons = copyPersons;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getClosePerson() {
		return closePerson;
	}
	public void setClosePerson(String closePerson) {
		this.closePerson = closePerson;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	public Long getFlowId() {
		return flowId;
	}
	public void setFlowId(Long flowId) {
		this.flowId = flowId;
	}
	public String getProc_def_id() {
		return proc_def_id;
	}
	public void setProc_def_id(String proc_def_id) {
		this.proc_def_id = proc_def_id;
	}
	
}
