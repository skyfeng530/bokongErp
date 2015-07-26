package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DepartmentMember implements Serializable{
	private int departId;
	private String userName;
	private String position;
	private int resc_enable;
	private String discribe;
	public DepartmentMember() {
		super();
	}
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getResc_enable() {
		return resc_enable;
	}
	public void setResc_enable(int resc_enable) {
		this.resc_enable = resc_enable;
	}
	public String getDiscribe() {
		return discribe;
	}
	public void setDiscribe(String discribe) {
		this.discribe = discribe;
	}
}
