package com.erp.entity;


/**
 * 项目工程信息
 */
public class ProjectInfo {
	private String ProjectName;	// 项目名称
	private String TaskNumber;		// 任务编号
	private String startTime;		// 开始日期
	private String endTime;		// 结束日期
	private String Info;			// 说明
	private String bak;			// 备注
	public String getProjectName() {
		return ProjectName;
	}
	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public String getTaskNumber() {
		return TaskNumber;
	}
	public void setTaskNumber(String taskNumber) {
		TaskNumber = taskNumber;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	
	
	
}


