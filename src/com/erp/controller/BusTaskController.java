package com.erp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erp.base.CommonDao;
import com.erp.entity.BusTaskFlow;
import com.erp.entity.BusTaskProductFlow;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.service.BusTaskFlowService;
import com.erp.service.BusTaskProductFlowService;
import com.erp.service.IWorkflowService;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.SessionContext;

import java.io.UnsupportedEncodingException;
import org.springframework.ui.Model;
import com.erp.entity.BusTask;
import com.erp.service.BusTaskService;
import com.erp.util.Common;
import com.erp.util.PageView;


/**
 * 
 */
@Controller
@RequestMapping("/background/project/task/")
public class BusTaskController {

	Log4jUtils logger = new Log4jUtils(BusTaskController.class);

	@Autowired
	private IWorkflowService workflowService;

	@Autowired
	private BusTaskProductFlowService bustaskproductflowService;

	@Autowired
	private BusTaskFlowService bustaskflowService;
    
	@Autowired
    private BusTaskService busTaskService;
	
	@Resource(name = "commonDao")
	private CommonDao commonDao;

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "saveStorage", method = RequestMethod.POST)
	public void saveStorage(BusTaskProductFlow busTaskProductFlow, HttpServletRequest request,
			HttpServletResponse response) {

		boolean result = false;

		String pdid = request.getParameter("pdid");

		FlowRecordInfo recordInfo = new FlowRecordInfo();

		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid(pdid);

		workflowService.saveFlow(flowTaskInfo, pdid);

		busTaskProductFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());

		int addResult = bustaskproductflowService.add(busTaskProductFlow);

		if (addResult > 0) {
			result = true;
		}

		JsonUtil.outJson(response, "{success:'" + result + "'}");
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "submitFormStorage", method = RequestMethod.POST)
	public void submitFormStorage(FlowTaskInfo flowTaskInfo, BusTaskFlow busTaskFlow, HttpServletRequest request,
			HttpServletResponse response) {
		logger.log(LogLevel.INFO, "[BusTaskController] submitForm_storage start");

		String url = workflowService.findTaskFormKeyByTaskId(flowTaskInfo.getTaskId());

		if ("task_input".equals(url)) {

			bustaskflowService.delete(busTaskFlow.getFlowId() + "");
			bustaskflowService.add(busTaskFlow);
		}

		boolean result = false;

		flowTaskInfo.setPdid("BusTaskProcess");

		String strUser = SessionContext.get(request).getUserName();

		int iResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);

		if (0 == iResult)
		{
			//插入前缺少重复校验
			result = bustaskflowService.addAll(busTaskFlow.getFlowId()+"") > 0;
		}
		if (2 == iResult || result)
		{
			result=true;
			bustaskflowService.delete(busTaskFlow.getFlowId()+"");
			bustaskproductflowService.delete(busTaskFlow.getFlowId()+"");
		}
		if (iResult == 1)
		{
			result = true;
		}
		JsonUtil.outJson(response, "{success:"+result+"}");
		logger.log(LogLevel.INFO, "[BusTaskController] submitForm_storage end");
	}
	
	/**
    * @param model
    * 存放返回界面的model
    * @return
    */
    @RequestMapping("query")
    public String query(Model model, BusTask busTask, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = busTaskService.query(pageView, busTask);
        model.addAttribute("pageView", pageView);
        return "/background/project/task/list";
    }

    /**
    * 保存数据
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, BusTask busTask) {
        busTaskService.add(busTask);
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
        return "/background/project/task/add";
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
        String strId =request.getParameter("id");
        byte b[] =strId.getBytes("ISO-8859-1");
        strId = new String(b, "utf-8");
        busTaskService.delete(strId);
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
        String strId =request.getParameter("id");
        byte b[] =strId.getBytes("ISO-8859-1");
        strId = new String(b, "utf-8");
        BusTask busTask = busTaskService.getById(strId);
        model.addAttribute("busTask", busTask);
        return "/background/project/task/edit";
    }

    /**
    * 更新类型
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, BusTask busTask) {
        busTaskService.modify(busTask);
        return "redirect:query.html";
    }

}
