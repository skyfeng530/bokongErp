package com.erp.entity;


@SuppressWarnings("serial")
public class UserRoles implements java.io.Serializable {

	private Integer roleId;
	private Integer departId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}

}