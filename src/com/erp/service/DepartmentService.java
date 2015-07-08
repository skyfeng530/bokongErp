package com.erp.service;


import com.erp.entity.DepartmentInfo;
import com.erp.entity.Roles;
import com.erp.util.PageView;

public interface DepartmentService{
	public PageView query(PageView pageView,DepartmentInfo department);
	
	public void add(DepartmentInfo department);
	
	public void deleteByDepartmentname(String dName);
	
	public void modify(DepartmentInfo department);
	
	public DepartmentInfo getByDepartmentrname(String userName);
	
	public Roles findbyDepartmentRole(String dId);
}
