package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DepartmentInfo implements Serializable{
	private int DepartId;
	private String dName;
	private int DepartType;
	private String Discribe;
	public DepartmentInfo() {
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