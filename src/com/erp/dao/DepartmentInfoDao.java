package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.DepartmentInfo;
import com.erp.entity.Roles;

public interface DepartmentInfoDao extends BaseDao<DepartmentInfo>{
	
	public Roles findbyDepartmentRole(String userName);
	
	public DepartmentInfo getByDepartmentname(String userName);
	
	public void deleteByDepartmentname(String userName);
}
