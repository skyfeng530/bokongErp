package com.erp.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.entity.Resources;
import com.erp.entity.Roles;
import com.erp.service.DepartmentService;
import com.erp.service.ResourcesService;
import com.erp.service.UserService;
import com.erp.util.Common;
import com.erp.util.PageView;

/**
 */
@Controller
@RequestMapping(value="/background/resources/")
public class ResourcesController {
	@Autowired
	private ResourcesService resourcesService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		List<Resources> resources = resourcesService.findAll();
		model.addAttribute("resources", resources);
		return "/background/resources/add";
	} 
	
	/**
	 * 保存新增
	 * @param model
	 * @param resources
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Resources resources){
		resourcesService.add(resources);
		return "redirect:query.html";
	}
	
	/**
	 * 分页查询
	 * @param model
	 * @param resources
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,Resources resources,String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = resourcesService.query(pageView, resources);
		model.addAttribute("pageView", pageView);
		return "/background/resources/list";
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param resourcesId
	 * @return
	 */
	@RequestMapping(value="deleteById")
	public String deleteById(Model model,String resourcesId){
		resourcesService.delete(resourcesId);
		return "redirect:query.html";
	}
	
	/**
	 * 查询单条记录
	 * @param model
	 * @param resourcesId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String resourcesId,int typeKey){
		Resources resources = resourcesService.getById(resourcesId);
		model.addAttribute("resources", resources);
		List<Resources> resLists = resourcesService.findAll();
		model.addAttribute("resLists", resLists);
		if(typeKey == 1){
			return "/background/resources/edit";
		}else{
			return "/background/resources/show";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param resources
	 * @return
	 */
	@RequestMapping(value="update")
	public String updateResources(Model model,Resources resources){
		resourcesService.modify(resources);
		return "redirect:query.html";
	}
	
	@RequestMapping(value="deleteAll")
	public String deleteAll(String[] check,Model model){
		for(String id : check){
			resourcesService.delete(id);
		}
		return "redirect:query.html";
	}
	/**
	 * 某个部门拥有的权限
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="permissioUser")
	public String permissioUser(HttpServletRequest request, Model model) throws UnsupportedEncodingException{
		String dName =request.getParameter("dName");  
		byte b[] =dName.getBytes("ISO-8859-1");  
		dName = new String(b, "utf-8");  
		List<Resources> resources = resourcesService.getDepartmentResources(dName);
		List<Resources> allRes = resourcesService.findAll();
		StringBuffer sb = new StringBuffer();
		sb.append("var data = [];");
		if (null != allRes) {
			for (Resources r : allRes) {
				boolean flag = false;
				if(null != resources)
				{
					for (Resources ur : resources) {//用户拥有的权限
						if (ur.getId().equals(r.getId())) {
							sb.append("data.push({ fid: '"
									+ r.getId() + "', pfid: '"
									+ r.getParentId()
									+ "', fname: '" + r.getName()
									+ "',ischecked: true});");
							flag = true;
						}
					}
					if (!flag) {
						sb.append("data.push({ fid: '"
								+ r.getId() + "', pfid: '"
								+ r.getParentId()
								+ "', fname: '" + r.getName()
								+ "'});");
						
					}
				}
			}
		}
		Roles roles = departmentService.findbyDepartmentRole(dName);
		if(roles!=null){
			model.addAttribute("roleId", roles.getId());
		}
		model.addAttribute("resources", sb);
		return "/background/resources/permissioUser";
	}
	/**
	 * 某个角色拥有的权限
	 * @return
	 */
	@RequestMapping(value="permissioRole")
	public String permissioRole(Model model,String roleId){
		List<Resources> resources = resourcesService.getRoleResources(roleId);
		List<Resources> allRes = resourcesService.findAll();
		StringBuffer sb = new StringBuffer();
		sb.append("var data = [];");
		if (null != allRes) {
			for (Resources r : allRes) {
				boolean flag = false;
				if(null != resources)
				{
					for (Resources ur : resources) {//用户拥有的权限
						if (ur.getId().equals(r.getId())) {
							sb.append("data.push({ fid: '"
									+ r.getId() + "', pfid: '"
									+ r.getParentId()
									+ "', fname: '" + r.getName()
									+ "',ischecked: true});");
							flag = true;
						}
					}
				}
				if (!flag) {
					sb.append("data.push({ fid: '"
							+ r.getId() + "', pfid: '"
							+ r.getParentId()
							+ "', fname: '" + r.getName()
							+ "'});");
					
				}
			}
		}
		model.addAttribute("roleId", roleId);
		model.addAttribute("resources", sb);
		return "/background/resources/permissioUser";
	}
	@ResponseBody
	@RequestMapping(value="saveRoleRescours")
	public String saveRoleRescours(String roleId,String rescId){
		String errorCode = "1000";
		List<String> list = Common.removeSameItem(Arrays.asList(rescId.split(",")));
		try {
			resourcesService.saveRoleRescours(roleId, list);
		} catch (Exception e) {
			e.printStackTrace();
			errorCode="1001";
		}
		return errorCode;
	}
}
