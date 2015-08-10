package com.erp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.erp.base.CommonDao;
import com.erp.entity.BusTaskFlow;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.entity.OmDiscardStorageFlow;
import com.erp.entity.OmDiscardStorageTaskFlow;
import com.erp.service.IWorkflowService;
import com.erp.service.OmDiscardStorageFlowService;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.SessionContext;

/**
 * 
 */
@Controller
@RequestMapping("/background/omstorage/discard/")
public class OmDiscardStorageFlowController {

	Log4jUtils logger = new Log4jUtils(OmDiscardStorageFlowController.class);

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	@Autowired
	private IWorkflowService workflowService;

	@Autowired
	private OmDiscardStorageFlowService omdiscardstorageflowService;

	@RequestMapping("loadTaskId")
	public void update(HttpServletRequest request, HttpServletResponse response) {
		String projectId = request.getParameter("projectId");

		if (StringUtils.isEmpty(projectId)) {
			JsonUtil.outJson(response, JsonUtil.getJsonStr(null));
			return;
		}

		String sql = "SELECT DISTINCT TASKID, TASKNO FROM BUSTASK B LEFT JOIN BUSPROJECTPRODUCT PP ON B.PPID = PP.PPID WHERE PP.PROJECTID = ?";

		List<Map<String, Object>> taskList = commonDao.queryToList(sql, projectId);

		JsonUtil.outJson(response, JsonUtil.getJsonStr(taskList));

	}

	@RequestMapping(value = "saveGridData", method = RequestMethod.POST)
	public void saveGridData(OmDiscardStorageFlow omDiscardStorageFlow, HttpServletRequest request,
			HttpServletResponse response) {
		omdiscardstorageflowService.add(omDiscardStorageFlow);
	}

	@RequestMapping(value = "saveCheckGridData", method = RequestMethod.POST)
	public void saveCheckGridData(OmDiscardStorageFlow omDiscardStorageFlow, HttpServletRequest request,
			HttpServletResponse response) {

		String checkFlag = request.getParameter("checkFlag");

		omdiscardstorageflowService.modify(omDiscardStorageFlow, checkFlag);
	}

	@RequestMapping(value = "loadGridData", method = RequestMethod.POST)
	public void loadOmDisCardStorageData(HttpServletRequest request, HttpServletResponse response) {
		String flowId = request.getParameter("flowId");

		Integer limit = NumberUtils.toInt(request.getParameter("limit"));

		Integer offset = NumberUtils.toInt(request.getParameter("offset"));

		String jsonMsg = omdiscardstorageflowService.queryOmDiscardStorageList(flowId, limit, offset);

		JsonUtil.outJson(response, jsonMsg);
	}

	@RequestMapping(value = "loadDeviceType", method = RequestMethod.POST)
	public void loadDeviceType(HttpServletRequest request, HttpServletResponse response) {
		List<Map<String, Object>> deviceList = omdiscardstorageflowService.queryDeviceType();

		JsonUtil.outJson(response, JsonUtil.getJsonStr(deviceList));
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "saveStorage", method = RequestMethod.POST)
	public void saveStorage(OmDiscardStorageTaskFlow omDiscardStorageTaskFlow, HttpServletRequest request,
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

		omDiscardStorageTaskFlow.setFlowid(flowTaskInfo.getFlowRecordInfo().getFlowId());

		int addResult = omdiscardstorageflowService.add(omDiscardStorageTaskFlow);

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
		logger.log(LogLevel.INFO, "[OmDiscardStorageFlowController] submitForm_storage start");

		boolean result = true;

		flowTaskInfo.setPdid("OmDiscardProcess");

		String strUser = SessionContext.get(request).getUserName();

		int iResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);

		if (0 == iResult) {
			JsonUtil.outJson(response, "{success:'true'}");
			return;
		}

		JsonUtil.outJson(response, "{success:'" + result + "'}");

		logger.log(LogLevel.INFO, "[BusTaskController] submitForm_storage end");
	}
}
