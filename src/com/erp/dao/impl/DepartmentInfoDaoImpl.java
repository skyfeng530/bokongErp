package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.DepartmentInfoDao;
import com.erp.entity.Department;
import com.erp.entity.Roles;

@Repository("departmentDao")
public class DepartmentInfoDaoImpl extends BaseDaoImpl<Department> implements DepartmentInfoDao
{

	public Roles findbyDepartmentRole(String dName) {
		return (Roles)getSqlSession().selectOne("roles.findbyDepartmentRole", dName);
	}
	
	public Department getByDepartmentname(String dName)
	{
		Department department = (Department)getSqlSession().selectList("department.queryDepartmentName",dName).get(0);
		return department;
	}
	
	public void deleteByDepartmentname(String dName)
	{
		getSqlSession().selectOne("department.deleteByUsername",dName);
	}

	@Override
	public List<Department> findAll() {
		return getSqlSession().selectList("department.findAll");
	}

	@Override
	public List<Department> getDepartmentByUserName(String uname) {
		return getSqlSession().selectList("department.getDepartmentByUserName",uname);
	}
	
}
