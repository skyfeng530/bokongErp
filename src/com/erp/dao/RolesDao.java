package com.erp.dao;


import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.Roles;
import com.erp.entity.UserRoles;


public interface RolesDao extends BaseDao<Roles>{
	public List<Roles> findAll();
	public void deleteUserRole(String userId);
	public void saveUserRole(UserRoles userRoles);
}
