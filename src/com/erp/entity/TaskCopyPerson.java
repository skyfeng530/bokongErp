package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TaskCopyPerson implements Serializable{
	private Integer id;
	private String pdname;
	private String applyperson;
	private String copyperson;
	private String taskid;
	private String businesskey;
	private Integer state;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPdname() {
		return pdname;
	}
	public String getApplyperson() {
		return applyperson;
	}
	public void setApplyperson(String applyperson) {
		this.applyperson = applyperson;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getCopyperson() {
		return copyperson;
	}
	public void setCopyperson(String copyperson) {
		this.copyperson = copyperson;
	}
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getBusinesskey() {
		return businesskey;
	}
	public void setBusinesskey(String businesskey) {
		this.businesskey = businesskey;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
}
