package com.erp.service;


import com.erp.entity.Roles;
import com.erp.entity.User;
import com.erp.util.PageView;

public interface UserService{
	public PageView query(PageView pageView,User user);
	
	public void add(User user);
	
	public void deleteByUsername(String userName);
	
	public void modify(User user);
	
	public User getByUsername(String userName);
	
	public int countUser(String userName,String userPassword);
	
	public User querySingleUser(String userName);
	
	public Roles findbyUserRole(String userId);
}
