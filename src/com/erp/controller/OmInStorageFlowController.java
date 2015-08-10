/**
 * 
 */
package com.erp.controller;

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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.entity.OmInStorageTaskFlow;
import com.erp.service.IWorkflowService;
import com.erp.service.OmInStorageFlow;
import com.erp.service.OmInStorageFlowService;
import com.erp.util.Const;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.SessionContext;

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

		response.setCharacterEncoding("UTF-8");

		if (null == omInStorageTaskFlow) {
			JsonUtil.outJson(response, JsonUtil.getJsonResultMessage(false));
			logger.log(LogLevel.ERROR, "[OmInStorageFlowController] startOminStorageFlowProcess() param is null");
			return;
		}

		if (null == omInStorageTaskFlow.getProjectid() || null == omInStorageTaskFlow.getTaskId()
				|| null == omInStorageTaskFlow.getDevtypeid() || StringUtils.isEmpty(omInStorageTaskFlow.getBak())) {
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

		if (StringUtils.isEmpty(bustaskId)) {
			JsonUtil.outJson(response, Const.JSON_NULL);
			return;
		}

		List<Map<String, Object>> figureList = omInstorageFlowService.queryFigureInfo(bustaskId);

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

		List<OmInStorageFlow> flowResults = JsonUtil.parseJsonToList(gridData, OmInStorageFlow.class);

		if (CollectionUtils.isEmpty(flowResults)) {

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
}
