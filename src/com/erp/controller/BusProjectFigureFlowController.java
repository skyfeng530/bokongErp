package com.erp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erp.base.CommonDao;
import com.erp.entity.BusProject;
import com.erp.entity.BusProjectFigureFlow;
import com.erp.entity.BusProjectFigureProductFlow;
import com.erp.entity.BusProjectProduct;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.service.BusProjectFigureFlowService;
import com.erp.service.BusProjectFigureProductFlowService;
import com.erp.service.BusProjectProductService;
import com.erp.service.BusProjectService;
import com.erp.service.IWorkflowService;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.SessionContext;

/**
 * 处理图库电子流
 */
@Controller
@RequestMapping("/background/project/figure/")
public class BusProjectFigureFlowController {

	Log4jUtils logger = new Log4jUtils(BusProjectFigureFlowController.class);

	@Autowired
	private IWorkflowService workflowService;

	@Autowired
	private BusProjectService busprojectService;

	@Autowired
	private BusProjectProductService busprojectproductService;

	@Autowired
	private BusProjectFigureProductFlowService busprojectfigureproductflowService;

	@Autowired
	private BusProjectFigureFlowService busprojectfigureflowService;

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "saveStorage", method = RequestMethod.POST)
	public void saveStorage(BusProjectFigureProductFlow figureProductFlow, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		boolean result = false;

		String pdid = request.getParameter("pdid");

		FlowRecordInfo recordInfo = new FlowRecordInfo();

		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid(pdid);

		workflowService.saveFlow(flowTaskInfo, pdid);

		figureProductFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());

		busprojectfigureproductflowService.add(figureProductFlow);

		JsonUtil.outJson(response, "{success:'" + result + "'}");
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "submitFormStorage", method = RequestMethod.POST)
	public void submitFormStorage(FlowTaskInfo flowTaskInfo, HttpServletRequest request, HttpServletResponse response) {
		logger.log(LogLevel.INFO, "[BusProjectFigureFlowController] submitForm_storage start");

		String url = workflowService.findTaskFormKeyByTaskId(flowTaskInfo.getTaskId());

		if ("projectFigure_input".equals(url)) {
			String gridData = request.getParameter("data");

			List<BusProjectFigureFlow> flowResults = JsonUtil.parseJsonToList(gridData, BusProjectFigureFlow.class);

			if (CollectionUtils.isEmpty(flowResults)) {
				JsonUtil.outJson(response, "{success:'false'}");
				return;
			}

			saveFigureData(url, flowResults);
		}

		boolean result = true;

		flowTaskInfo.setPdid("BusProjectFigure");

		String strUser = SessionContext.get(request).getUserName();

		int iResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);

		if (0 == iResult) {
			JsonUtil.outJson(response, "{success:'true'}");
			return;
		}

		JsonUtil.outJson(response, "{success:'" + result + "'}");

		logger.log(LogLevel.INFO, "[BusProjectFigureFlowController] submitForm_storage end");
	}

	private void saveFigureData(String url, List<BusProjectFigureFlow> flowResults) {

		busprojectfigureflowService.delete(Long.toString(flowResults.get(0).getFlowId()));
		// BusStorage storage 逐行插入
		for (BusProjectFigureFlow busProjectFigureFlow : flowResults) {

			try {
				busprojectfigureflowService.add(busProjectFigureFlow);
			} catch (Exception e) {
				logger.log(LogLevel.ERROR, "[BusProjectFigureFlowController] addStorage has exception:" + e);
			}
		}
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "queryProjectName", method = RequestMethod.POST)
	public void queryProjectName(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<BusProject> busProjects = busprojectService.queryAll(new BusProject());

		String jsonReuslt = JsonUtil.getJsonStr(busProjects);

		JsonUtil.outJson(response, jsonReuslt);
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "queryProduct", method = RequestMethod.POST)
	public void queryProduct(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String projectId = request.getParameter("projectId");

		BusProjectProduct product = new BusProjectProduct();

		product.setProjectId(NumberUtils.toInt(projectId));

		List<BusProjectProduct> busProjectProducts = busprojectproductService.queryByProjectId(product);

		String jsonReuslt = JsonUtil.getJsonStr(busProjectProducts);

		JsonUtil.outJson(response, jsonReuslt);
	}

	@RequestMapping(value = "loadFigureData", method = RequestMethod.POST)
	public void loadBusProjectFigureData(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int limit = NumberUtils.toInt(request.getParameter("limit"));
		int offset = NumberUtils.toInt(request.getParameter("offset"));

		String flowId = request.getParameter("flowId");

		String sql = "SELECT * FROM BUSPROJECTFIGUREFLOW LIMIT " + limit + " OFFSET " + offset;
		String totalSql = "SELECT COUNT(0) FROM BUSPROJECTFIGUREFLOW";

		List<Map<String, Object>> figurePageList = commonDao.queryToList(sql);

		int total = commonDao.queryToint(totalSql);

		List<Map<String, String>> productList = busprojectfigureproductflowService.getProductInfoByid(flowId);

		String jsonReuslt = "";

		if (CollectionUtils.isEmpty(figurePageList)) {
			jsonReuslt = JsonUtil.getJsonStr(figurePageList);
			JsonUtil.outJson(response, jsonReuslt);
			return;
		}

		for (Map<String, Object> figureMap : figurePageList) {

			figureMap.put("projectName", productList.get(0).get("projectname"));
			figureMap.put("productName", productList.get(0).get("productname"));
		}

		jsonReuslt = JsonUtil.parseListToJson(figurePageList, total);
		JsonUtil.outJson(response, jsonReuslt);
	}
}
