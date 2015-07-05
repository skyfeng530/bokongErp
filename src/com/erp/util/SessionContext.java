package com.erp.util;

import javax.servlet.http.HttpServletRequest;

import com.erp.entity.User;


public class SessionContext {

	public static final String GLOBLE_USER_SESSION = "userSession";
	
	public static void setUser(HttpServletRequest request,User user){
		if(user!=null){
			request.getSession().setAttribute(GLOBLE_USER_SESSION, user);
		}else{
			request.getSession().removeAttribute(GLOBLE_USER_SESSION);
		}
	}
	
	public static User get(HttpServletRequest request){
		return (User) request.getSession().getAttribute(GLOBLE_USER_SESSION);
	}
}
