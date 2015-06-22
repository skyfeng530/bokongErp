package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.UserLoginListDao;
import com.erp.entity.UserLoginList;

@Repository("userLoginListDao")
public class UserLoginListDaoImpl extends BaseDaoImpl<UserLoginList> implements UserLoginListDao{

}
