package com.erp.entity;

import java.util.Date;

/**
 * 申请单
 */
public class MyTask {
	private Long id;//主键ID
	private String title;//流程单标题
	private Date applyDate;// 申请时间
	private String username;// 申请人
	private Integer state=0;// 申请单状态 0初始录入,1.开始审批,2为审批完成
	
	private String pdname;// 申请单类型
	private String pdid;// 流程定义id
	private String pdkey;// 流程定义key
	private String taskId;//任务ID
	private String outcome;		//连线名称
	private String comment;		//备注
	private String nextName;//下一步处理人

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNextName() {
		return nextName;
	}

	public void setNextName(String nextName) {
		this.nextName = nextName;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}
