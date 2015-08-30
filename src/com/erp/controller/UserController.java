package com.erp.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.entity.Department;
import com.erp.entity.DepartmentMember;
import com.erp.entity.DepartmentUser;
import com.erp.entity.Roles;
import com.erp.entity.User;
import com.erp.entity.UserRoles;
import com.erp.service.DepartmentMemberService;
import com.erp.service.DepartmentService;
import com.erp.service.RolesService;
import com.erp.service.UserService;
import com.erp.util.CiphertextUtil;
import com.erp.util.Common;
import com.erp.util.PageView;
import com.erp.util.SessionContext;

/**
 * 
 */
@Controller
@RequestMapping("/background/user/")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentMemberService departmentMemberService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, User user, String pageNow) {
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = userService.query(pageView, user);
		model.addAttribute("pageView", pageView);
		return "/background/user/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @param videoType
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, User user) {
		User u = userService.querySingleUser(user.getUserName());
		if (null == u) {
			String pwd = user.getUserPassword();
			pwd = CiphertextUtil.passAlgorithmsCiphering(pwd, CiphertextUtil.MD5);
			user.setUserPassword(pwd);
			userService.add(user);
			return "redirect:query.html";
		}
		else
		{
			model.addAttribute("errorMsg", "1");
			model.addAttribute("user", user);
			return "/background/user/add";
		}
	}

	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/user/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @param videoTypeId
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String userId) {
		userService.delete(userId);
		return "redirect:query.html";
	}

	/**
	 * 修改界面
	 * 
	 * @param model
	 * @param videoTypeIds
	 * @return
	 */
	@RequestMapping("getById")
	public String getById(Model model, String userId, int type ,HttpServletRequest request) {
		User user = null;
		if (null != userId) {
			user = userService.getById(userId);
		}else{
			user = userService.querySingleUser(SessionContext.get(request).getUserName());
		}
		model.addAttribute("user", user);
		List<Roles> roles=rolesService.findAll();
		model.addAttribute("roles", roles);
		if (type == 1) {//编辑用户
			return "/background/user/edit";
		} else if(type == 0){//显示个人信息
			return "/background/user/show";
		}else{
			return "/background/user/changePwd";
		}
	}

	/**
	 * 更新类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model, User user,UserRoles userRoles) {
		String pwd = user.getUserPassword();
		pwd = CiphertextUtil.passAlgorithmsCiphering(pwd, CiphertextUtil.MD5);
		user.setUserPassword(pwd);
		userService.modify(user);
		if(userRoles.getRoleId()!=null)
		rolesService.saveUserRole(userRoles);
		return "redirect:query.html";
	}
	
	/**
	 * 改密码
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("changePwd")
	@ResponseBody
	public String changePwd(Model model, HttpServletRequest request) {
		String errorCode = "1000";
		String userName = request.getParameter("userName");
		String oldpwd = request.getParameter("userPassword");
		oldpwd = CiphertextUtil.passAlgorithmsCiphering(oldpwd, CiphertextUtil.MD5);
		String newpwd1 = request.getParameter("newPwd1");
		newpwd1 = CiphertextUtil.passAlgorithmsCiphering(newpwd1, CiphertextUtil.MD5);
		String newpwd2 = request.getParameter("newPwd2");
		newpwd2 = CiphertextUtil.passAlgorithmsCiphering(newpwd2, CiphertextUtil.MD5);
		if (userName != null && oldpwd != null && newpwd1 != null && newpwd2 != null) {
			if (!newpwd1.equals(newpwd2)) {
				return "1001";
			}
			User user = userService.querySingleUser(userName);
			if (!oldpwd.equals(user.getUserPassword())) {
				return "1001";
			}
			try {
				user.setUserPassword(newpwd1);
				boolean result = userService.modify(user);
				if (!result) {
					errorCode="1001";
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorCode="1001";
			}
		}else{
			errorCode = "1001";
		}
		return errorCode;
	}

	/**
	 * 删除所选的
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteAll")
	public String deleteAll(Model model, String[] check) {
		for (String string : check) {
			userService.delete(string);
		}
		return "redirect:query.html";
	}
	
	/**
	 * 给用户分配角色界面
	 * @return
	 */
	@RequestMapping("userRole")
	public String userRole(Model model,String userId){
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		List<Roles> roles = rolesService.findAll();
		model.addAttribute("roles", roles);
		return "/background/user/userRole";
	}
	
	/**
	 * 给用户分配部门界面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("userDepartment")
	public String userDepartment(Model model,HttpServletRequest request) throws UnsupportedEncodingException{
		String userName =request.getParameter("userName");  
		byte b[] =userName.getBytes("ISO-8859-1");  
		userName = new String(b, "utf-8");
		User user = userService.getById(userName);
		model.addAttribute("user", user);
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		return "/background/user/userDepartment";
	}
	
	/**
	 * 保存用户分配角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("allocation")
	public String allocation(Model model,UserRoles userRoles){
		String errorCode = "1000";
		try {
			rolesService.saveUserRole(userRoles);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
	
	
	/**
	 * 保存用户分配部门
	 * @return
	 */
	@ResponseBody
	@RequestMapping("allocationDepartment")
	public String allocationDepartment(Model model,DepartmentMember member){
		String errorCode = "1000";
		try {
			boolean result = departmentMemberService.saveUserDepaertment(member);
			if (!result) {
				errorCode="1002";
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
	
	/**
	 * 检查用户名存在性
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkUserName")
	public String checkUserName(Model model, HttpServletRequest request){
		String errorCode = "1000";
		String userName = request.getParameter("userName");
		User user = userService.querySingleUser(userName);
		if (null != user) {
			errorCode="1001";
		}
		return errorCode;
	}
	
	@RequestMapping("queryUserName")
	@ResponseBody
	public List<Map<String, String>> queryUserName()
	{
		List<User> users = userService.queryAll(new User());
		List<Map<String, String>> userNames = new ArrayList<Map<String, String>>();
		if (users != null)
		{
			for (User user : users)
			{
				Map<String, String> map = new HashMap<String,String>();
				map.put("username", user.getUserName());
				userNames.add(map);
			}
		}
		return userNames;
	}
	
	/**
	 * 给用户分配角色界面
	 * @return
	 */
	@RequestMapping("userSetGroup")
	public String userSetGroup(Model model,String userId){
		User user = userService.getById(userId);
		model.addAttribute("user", user);
		List<Department> departments = departmentService.findAll();
		model.addAttribute("departments", departments);
		return "/background/user/userGroup";
	}
	
	/**
	 * 保存用户分配角色
	 * @return
	 */
	@ResponseBody
	@RequestMapping("setGroup")
	public String setGroup(Model model,DepartmentUser departmentUser){
		String errorCode = "1000";
		try {
			departmentService.saveDepartmentUser(departmentUser);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
	
}