package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DepartmentUser implements Serializable{
	private Integer departmentId;
	private Integer userId;
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
