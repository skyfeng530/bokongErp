package com.erp.service;

import com.erp.entity.UserLoginList;
import com.erp.util.PageView;

public interface UserLoginListService {
	public PageView query(PageView pageView,UserLoginList userLoginList);
	
	public void add(UserLoginList userLoginList);

}
