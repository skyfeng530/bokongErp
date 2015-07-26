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
import com.erp.entity.Roles;
import com.erp.entity.User;
import com.erp.entity.UserRoles;
import com.erp.service.DepartmentMemberService;
import com.erp.service.DepartmentService;
import com.erp.service.RolesService;
import com.erp.service.UserService;
import com.erp.util.Common;
import com.erp.util.PageView;

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
	 * 保存数据
	 * 
	 * @param model
	 * @param videoType
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, User user) {
		userService.add(user);
		return "redirect:query.html";
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
	public String deleteById(Model model, String userName) {
		userService.deleteByUsername(userName);
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
	public String getById(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		String userName =request.getParameter("userName");  
		byte b[] =userName.getBytes("ISO-8859-1");  
		userName = new String(b, "utf-8");
		//int type = Integer.parseInt(request.getParameter("type"));
		User user = userService.getByUsername(userName);
		model.addAttribute("user", user);
		List<Roles> roles=rolesService.findAll();
		model.addAttribute("roles", roles);
		return "/background/user/edit";
	}

	/**
	 * 更新类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model, User user,UserRoles userRoles) {
		userService.modify(user);
		if(userRoles.getRoleId()!=null)
		rolesService.saveUserRole(userRoles);
		return "redirect:query.html";
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
			userService.deleteByUsername(string);
		}
		return "redirect:query.html";
	}
	
	/**
	 * 给用户分配角色界面
	 * @return
	 */
	@RequestMapping("userRole")
	public String userRole(Model model,String userName){
		User user = userService.getByUsername(userName);
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
		User user = userService.getByUsername(userName);
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
}