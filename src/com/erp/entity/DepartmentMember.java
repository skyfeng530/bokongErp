package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DepartmentMember implements Serializable{
	private int departId;
	private Integer userId;
	
	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
