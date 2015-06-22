package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.UserDao;
import com.erp.entity.Roles;
import com.erp.entity.User;
import com.erp.service.UserService;
import com.erp.util.PageView;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public PageView query(PageView pageView, User user) {
		List<User> list = userDao.query(pageView, user);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(User user) {
		userDao.add(user);
		
	}

	public void deleteByUsername(String userName) {
		userDao.deleteByUsername(userName);
		
	}

	public User getByUsername(String userName) {
		return userDao.getByUsername(userName);
	}

	public void modify(User user) {
		userDao.modify(user);
	}

	public int countUser(String userName, String userPassword) {
		return userDao.countUser(userName, userPassword);
	}

	public User querySingleUser(String userName) {
		return userDao.querySingleUser(userName);
	}

	public Roles findbyUserRole(String userName) {
		return userDao.findbyUserRole(userName);
	}
}
