/**
 * 
 */
package com.erp.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.entity.OmInStorageAssistance;
import com.erp.entity.OmInStorageTaskFlow;
import com.erp.service.IWorkflowService;
import com.erp.service.OmInStorageFlow;
import com.erp.service.OmInStorageFlowService;
import com.erp.util.Const;
import com.erp.util.FileUploadUtil;
import com.erp.util.FileUtil;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.SessionContext;
import com.erp.util.UploadFileCommon;

/**
 * @author jason_000
 *
 */
@Controller
@RequestMapping(value = "/background/omInStorage/")
public class OmInStorageFlowController {
	Log4jUtils logger = new Log4jUtils(OmInStorageFlowController.class);

	@Autowired
	private IWorkflowService workflowService;

	@Autowired
	private OmInStorageFlowService omInstorageFlowService;

	/**
	 * 入库电子流申请
	 * 
	 * @param omInStorageTaskFlow
	 * @param request
	 * @param response
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@RequestMapping(value = "startOminstorageFlow", method = RequestMethod.POST)
	public void startOminStorageFlowProcess(OmInStorageTaskFlow omInStorageTaskFlow, HttpServletRequest request,
			HttpServletResponse response) {
		logger.log(LogLevel.INFO, "[OmInStorageFlowController] startOminStorageFlowProcess() start");

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		if (null == omInStorageTaskFlow) {
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			logger.log(LogLevel.ERROR, "[OmInStorageFlowController] startOminStorageFlowProcess() param is null");
			return;
		}

		UploadFileCommon fileCommon = new UploadFileCommon("omInStorage", ".jpg",
				FileUtil.getUploadImageFilePath(request, Const.OMINSTORAGE_PIC_PATH));

		File uploadFile = FileUploadUtil.getUploadFile(request, fileCommon);

		if (null == uploadFile) {
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			logger.log(LogLevel.ERROR, "[OmInStorageFlowController] startOminStorageFlowProcess() file is null");
			return;
		}

		if (null == omInStorageTaskFlow.getProjectid() || null == omInStorageTaskFlow.getTaskId()
				|| null == omInStorageTaskFlow.getDevtypeid()) {
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			logger.log(LogLevel.ERROR,
					"[OmInStorageFlowController] startOminStorageFlowProcess() someone param is null");
			return;
		}

		logger.log(LogLevel.INFO, "[OmInStorageFlowController] startOminStorageFlowProcess() start the process.");
		FlowRecordInfo recordInfo = new FlowRecordInfo();

		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid("BusStorage");

		OmInStorageAssistance assistance = new OmInStorageAssistance();
		assistance.setTaskId(omInStorageTaskFlow.getTaskId());
		assistance.setGraphicPath(uploadFile.getName());

		int flowResult = workflowService.saveFlow(flowTaskInfo, "BusStorage");

		if (0 != flowResult) {
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			logger.log(LogLevel.ERROR,
					"[OmInStorageFlowController] startOminStorageFlowProcess() start the flow is error.");
			return;
		}

		logger.log(LogLevel.INFO,
				"[OmInStorageFlowController] startOminStorageFlowProcess() start save the data to db.");

		omInStorageTaskFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());

		omInstorageFlowService.saveOmInStorageAssistance(assistance);
		int addResult = omInstorageFlowService.saveOmInstorageTaskFlow(omInStorageTaskFlow);

		JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(addResult > 0));

		logger.log(LogLevel.INFO, "[OmInStorageFlowController] startOminStorageFlowProcess() end");
	}

	/**
	 * 查询图号
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "loadFigure", method = RequestMethod.POST)
	public void loadFigureInfo(HttpServletRequest request, HttpServletResponse response) {
		String bustaskId = request.getParameter("bustaskId");

		String deviceType = request.getParameter("deviceType");

		if (StringUtils.isEmpty(bustaskId)) {
			JsonUtil.outJson(response, Const.JSON_NULL);
			return;
		}

		List<Map<String, Object>> figureList = omInstorageFlowService.queryFigureInfo(bustaskId, deviceType);

		JsonUtil.outJson(response, JsonUtil.getJsonStr(figureList));
	}

	/**
	 * 查询图纸要求
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "loadFigureRequest", method = RequestMethod.POST)
	public void loadFigureRequest(HttpServletRequest request, HttpServletResponse response) {
		String figureno = request.getParameter("figureno");

		if (StringUtils.isEmpty(figureno)) {
			JsonUtil.outJson(response, Const.JSON_NULL);
			return;
		}

		List<Map<String, Object>> figureNoList = omInstorageFlowService.queryFigureReqInfo(figureno);

		JsonUtil.outJson(response, JsonUtil.getJsonStr(figureNoList));
	}

	@RequestMapping(value = "loadGridData", method = RequestMethod.POST)
	public void loadOmDisCardStorageData(HttpServletRequest request, HttpServletResponse response) {
		String flowId = request.getParameter("flowId");

		String unqualifiedGrade = request.getParameter("unqualifiedGrade");

		Integer limit = NumberUtils.toInt(request.getParameter("limit"));

		Integer offset = NumberUtils.toInt(request.getParameter("offset"));

		String jsonMsg = omInstorageFlowService.queryOmInStorageFlowList(flowId, unqualifiedGrade, limit, offset);

		JsonUtil.outJson(response, jsonMsg);
	}

	/**
	 * 
	 * @param omDiscardStorageFlow
	 * @param request
	 * @param response
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@RequestMapping(value = "saveGridData", method = RequestMethod.POST)
	public void saveGridData(HttpServletRequest request, HttpServletResponse response) {

		String gridData = request.getParameter("data");

		String clearAll = request.getParameter("clearall");

		String flowId = null;

		boolean clearAllFlag = false;

		if (null == clearAll) {
			clearAllFlag = false;
		} else {
			clearAllFlag = Boolean.valueOf(clearAll);
			flowId = request.getParameter("flowId");
		}

		List<OmInStorageFlow> flowResults = JsonUtil.parseJsonToList(gridData, OmInStorageFlow.class);

		if (clearAllFlag) {
			int removeResult = omInstorageFlowService.removeAllRecord(flowId);
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(removeResult > 0));
			return;
		}

		if (!clearAllFlag && CollectionUtils.isEmpty(flowResults)) {

			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			return;
		}

		int addResult = omInstorageFlowService.add(flowResults);

		JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(addResult > 0));
	}

	/**
	 * 提交入库任务
	 */
	@RequestMapping(value = "submitForm_storage")
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void submitForm_storage(HttpServletRequest request, HttpServletResponse response,
			FlowTaskInfo flowTaskInfo) {

		logger.log(LogLevel.INFO, "[OmInStorageFlowController] submitForm_storage start");

		boolean result = true;

		String strUser = SessionContext.get(request).getUserName();
		int flowResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);

		if (flowResult == 0) {

			String bustaskId = request.getParameter("bustaskId");
			String flowId = request.getParameter("flowId");

			int saveCount = omInstorageFlowService.saveFlowToDb(flowId, bustaskId);

			if (saveCount <= 0) {
				result = false;
			}
		}

		JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(result));

		logger.log(LogLevel.INFO, "[OmInStorageFlowController] submitForm_storage end");
	}

	@RequestMapping(value = "queryDevStart")
	public void queryDevStartNumber(HttpServletRequest request, HttpServletResponse response) {
		String flowId = request.getParameter("flowId");

		int maxNoValue = omInstorageFlowService.getMaxNo(flowId);

		JsonUtil.outJson(response, JsonUtil.getJsonStr(maxNoValue));
	}
	
	/**
	 * 打印页面预览
	 * 
	 * @return
	 */
	@RequestMapping(value = "printpage_084_1E")
	public String printViewPage0841e(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {

		String taskId = request.getParameter("taskId");
		
		String projectName = request.getParameter("projectName");
		String taskName = request.getParameter("taskName");
		String figurename = request.getParameter("figurename");
		String figureno = request.getParameter("figureno");
		String checknum = request.getParameter("checknum");
		String totalnumber = request.getParameter("totalnumber");
		String unqualifiednum = request.getParameter("unqualifiednum");
		String unqualifiedgrade = request.getParameter("unqualifiedgrade");
		String reviewrst = request.getParameter("reviewrst");
		String reviewgrp = request.getParameter("reviewgrp");
		String reviewno = request.getParameter("reviewno");
		
		model.addAttribute("taskId", taskId);
		model.addAttribute("projectName", projectName);
		model.addAttribute("taskName", taskName);
		model.addAttribute("figurename", figurename);
		model.addAttribute("figureno", figureno);
		model.addAttribute("checknum", checknum);
		model.addAttribute("totalnumber", totalnumber);
		model.addAttribute("unqualifiednum", unqualifiednum);
		model.addAttribute("unqualifiedgrade", unqualifiedgrade);
		model.addAttribute("reviewrst", reviewrst);
		model.addAttribute("reviewgrp", reviewgrp);
		model.addAttribute("reviewno", reviewno);
		

		return "/background/workflow/printpage_084-1E";
	}
}
