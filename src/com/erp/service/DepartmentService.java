package com.erp.service;


import java.util.List;

import com.erp.entity.Department;
import com.erp.entity.DepartmentUser;
import com.erp.entity.Roles;
import com.erp.util.PageView;

public interface DepartmentService{
	public PageView query(PageView pageView,Department department);
	
	public void add(Department department);
	
	public void deleteByDepartmentname(String dName);
	
	public void modify(Department department);
	
	public Department getByDepartmentName(String userName);
	
	public Roles findbyDepartmentRole(String dName);
	
	public List<Department> findAll();

	public void saveDepartmentUser(DepartmentUser departmentUser);

}
