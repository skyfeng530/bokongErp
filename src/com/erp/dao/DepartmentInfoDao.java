package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.Department;
import com.erp.entity.Roles;

public interface DepartmentInfoDao extends BaseDao<Department>{
	
	public Roles findbyDepartmentRole(String dName);
	
	public Department getByDepartmentname(String dName);
	
	public void deleteByDepartmentname(String dName);
	
	public List<Department> findAll();

	public List<Department> getDepartmentByUserName(String uname);
}
