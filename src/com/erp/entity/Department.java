package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Department implements Serializable{
	private int DepartId;
	private String dName;
	private String roleName;
	private int DepartType;
	private String Discribe;
	public Department() {
		super();
	}
	public int getDepartId() {
		return DepartId;
	}
	public void setDepartId(int departId) {
		DepartId = departId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getDepartType() {
		return DepartType;
	}
	public void setDepartType(int departType) {
		DepartType = departType;
	}
	public String getDiscribe() {
		return Discribe;
	}
	public void setDiscribe(String discribe) {
		Discribe = discribe;
	}
}
