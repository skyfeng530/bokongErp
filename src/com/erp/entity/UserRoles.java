package com.erp.entity;


@SuppressWarnings("serial")
public class UserRoles implements java.io.Serializable {

	private Integer roleId;
	private Integer DepartId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDepartId() {
		return DepartId;
	}
	public void setDepartId(Integer departId) {
		DepartId = departId;
	}

}