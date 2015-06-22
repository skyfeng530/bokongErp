package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.FlowTypeInfo;
import com.erp.entity.User;
import com.erp.service.WorkFlowService;
import com.erp.util.Common;
import com.erp.util.PageView;

@Controller
@RequestMapping(value="/background/workflow/")
public class Workflowcontroller{
	
	@Autowired
	private WorkFlowService workFlowService;

	/**
	 * 部署管理首页显示
	 * @return
	 */
	@RequestMapping(value="deployHome")
	public String deployHome(){
		return "/background/workflow/deployHome";
	}
	
	/**
	 * 跳转至部署页面
	 * @return
	 */
	@RequestMapping(value="deployUI")
	public String deployUI(){
		return "/background/workflow/deployUI";
	}
	
	/**
	 * 跳转至填写申请页面
	 * @return
	 */
	@RequestMapping(value="formTemplateList")
	public String formTemplateList(Model model, FlowTypeInfo flowTypeInfo, String pageNow){
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView=workFlowService.query(pageView, flowTypeInfo);
		model.addAttribute("pageView", pageView);
		return "/background/workflow/formTemplateList";
	}
	
	/**
	 * 跳转至填写申请页面
	 * @return
	 */
	@RequestMapping(value="applyFormUI")
	public String applyFormUI(Model model,FlowTypeInfo flowTypeInfo){
		flowTypeInfo.getnIndex();
		
		return "/background/workflow/applyFormUI";
	}
	
	/**
	 * 未处理任务页面
	 * @return
	 */
	@RequestMapping(value="myTaskList")
	public String myTaskList(){
		return "/background/workflow/myTaskList";
	}
	
	/**
	 * 我的申请查询页面
	 * @return
	 */
	@RequestMapping(value="myApplyList")
	public String myApplyList(){
		return "/background/workflow/myApplyList";
	}
	
	/**
	 * 查看申请信息
	 * @return
	 */
	@RequestMapping(value="showForm")
	public String showForm(){
		return "/background/workflow/showForm";
	}
	
	/**
	 * 查看流转记录
	 * @return
	 */
	@RequestMapping(value="approvedHistory")
	public String approvedHistory(){
		return "/background/workflow/approvedHistory";
	}
}
