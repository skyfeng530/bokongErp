package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.DepartmentInfoDao;
import com.erp.entity.DepartmentInfo;
import com.erp.entity.Roles;

@Repository("departmentDao")
public class DepartmentInfoDaoImpl extends BaseDaoImpl<DepartmentInfo> implements DepartmentInfoDao
{

	public Roles findbyDepartmentRole(String dId) {
		return (Roles)getSqlSession().selectOne("roles.findbyUserRole", dId);
	}
	
	public DepartmentInfo getByDepartmentname(String dName)
	{
		return (DepartmentInfo)getSqlSession().selectOne("department.queryUserName",dName);
	}
	
	public void deleteByDepartmentname(String dName)
	{
		getSqlSession().selectOne("department.deleteByUsername",dName);
	}
	
}
