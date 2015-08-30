package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Department implements Serializable{
	private int DepartId;
	private String dName;
	private String membership;//隶属科室
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
	public String getMembership() {
		return membership;
	}
	public void setMembership(String membership) {
		this.membership = membership;
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
