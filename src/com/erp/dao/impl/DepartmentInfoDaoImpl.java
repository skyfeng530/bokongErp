package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.DepartmentInfoDao;
import com.erp.entity.Department;
import com.erp.entity.Roles;

@Repository("departmentDao")
public class DepartmentInfoDaoImpl extends BaseDaoImpl<Department> implements DepartmentInfoDao
{

	public Roles findbyDepartmentRole(String dId) {
		return (Roles)getSqlSession().selectOne("roles.findbyUserRole", dId);
	}
	
	public Department getByDepartmentname(String dName)
	{
		Department department = (Department)getSqlSession().selectOne("department.queryDepartmentName",dName);
		return department;
	}
	
	public void deleteByDepartmentname(String dName)
	{
		getSqlSession().selectOne("department.deleteByUsername",dName);
	}
	
}
