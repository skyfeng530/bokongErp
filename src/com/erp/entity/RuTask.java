package com.erp.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class RuTask implements Serializable{
	protected String id_;
	  protected String name_;
	  protected Date create_Time_; // The time when the task has been created
	  protected String assignee_;
	public String getId_() {
		return id_;
	}
	public void setId_(String id_) {
		this.id_ = id_;
	}
	public String getName_() {
		return name_;
	}
	public void setName_(String name_) {
		this.name_ = name_;
	}
	public Date getCreate_Time_() {
		return create_Time_;
	}
	public void setCreate_Time_(Date create_Time_) {
		this.create_Time_ = create_Time_;
	}
	public String getAssignee_() {
		return assignee_;
	}
	public void setAssignee_(String assignee_) {
		this.assignee_ = assignee_;
	}
}
