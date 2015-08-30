package com.erp.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.entity.Department;
import com.erp.entity.Roles;
import com.erp.entity.User;
import com.erp.entity.UserRoles;
import com.erp.service.DepartmentService;
import com.erp.service.RolesService;
import com.erp.service.UserService;
import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/department/")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private RolesService rolesService;
	@Autowired
	private UserService userService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, Department department, String pageNow) {
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = departmentService.query(pageView, department);
		model.addAttribute("pageView", pageView);
		return "/background/department/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @param videoType
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, Department department) {
		departmentService.add(department);
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
		return "/background/department/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @param videoTypeId
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("deleteById")
	public String deleteById(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		String dName =request.getParameter("dName");  
		byte b[] =dName.getBytes("ISO-8859-1");  
		dName = new String(b, "utf-8");
		departmentService.deleteByDepartmentname(dName);
		return "redirect:query.html";
	}

	/**
	 * 修改界面
	 * 
	 * @param model
	 * @param videoTypeIds
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("getById")
	public String getById(Model model, HttpServletRequest request, int type) throws UnsupportedEncodingException {
		String dName =request.getParameter("dName");  
		byte b[] =dName.getBytes("ISO-8859-1");  
		dName = new String(b, "utf-8");  
		Department department = departmentService.getByDepartmentName(dName);
		model.addAttribute("department", department);
		 List<Roles> roles=rolesService.findAll();
		 model.addAttribute("roles", roles);
		if (type == 1) {
			return "/background/department/edit";
		} else {
			return "/background/department/show";
		}
	}

	/**
	 * 更新类型
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("update")
	public String update(Model model, Department department) {
		departmentService.modify(department);
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
			departmentService.deleteByDepartmentname(string);
		}
		return "redirect:query.html";
	}
	
	/**
	 * 给用户分配角色界面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("departmentRole")
	public String departmentRole(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
		String dName =request.getParameter("dName");  
		byte b[] =dName.getBytes("ISO-8859-1");  
		dName = new String(b, "utf-8");  
		Department department = departmentService.getByDepartmentName(dName);
		model.addAttribute("department", department);
		List<Roles> roles = rolesService.findAll();
		model.addAttribute("roles", roles);
		return "/background/department/userRole";
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
	 * 给用户分配角色界面
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("departmentGroup")
	public String departmentGroup(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
		String dName =request.getParameter("dName");  
		byte b[] =dName.getBytes("ISO-8859-1");  
		dName = new String(b, "utf-8");  
		List<User> users = userService.getUsersByDepartmentName(dName);
		model.addAttribute("users", users);
		model.addAttribute("dName", dName);
		return "/background/department/userGroup";
	}
}