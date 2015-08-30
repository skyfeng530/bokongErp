package com.erp.dao;


import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.Roles;
import com.erp.entity.User;


public interface UserDao extends BaseDao<User>{
	public int countUser(String userName,String userPassword);
	
	public User querySingleUser(String userName);
	
	public Roles findbyUserRole(String userId);
	
	public User getByUsername(String userName);
	
	public void deleteByUsername(String userName);

	public List<User> getUsersByDepartmentName(String dName);
}
