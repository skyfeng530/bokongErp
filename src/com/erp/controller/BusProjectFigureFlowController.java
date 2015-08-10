package com.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.base.CommonDao;
import com.erp.entity.BusProject;
import com.erp.entity.BusProjectFigure;
import com.erp.entity.BusProjectFigureFlow;
import com.erp.entity.BusProjectFigureFlowVo;
import com.erp.entity.BusProjectFigureProductFlow;
import com.erp.entity.BusProjectProduct;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.service.BusProjectFigureFlowService;
import com.erp.service.BusProjectFigureProductFlowService;
import com.erp.service.BusProjectFigureService;
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
	
	@Autowired
	private BusProjectFigureService busprojectfigureService;

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
		BusProjectFigure busProjectFigure  = new BusProjectFigure();
		busProjectFigure.setPpid(figureProductFlow.getPpid());
		busProjectFigure.setFigureLib(figureProductFlow.getFigureLib());
		boolean result = false;
	    int queryResult = busprojectfigureService.getCountByCondition(busProjectFigure);
	    if (queryResult>0)
	    {
	    	JsonUtil.outJson(response, "{{success:false,msg:'exist'}");
	    }
		String pdid = request.getParameter("pdid");

		FlowRecordInfo recordInfo = new FlowRecordInfo();

		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid(pdid);

		workflowService.saveFlow(flowTaskInfo, pdid);

		figureProductFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());

		result = busprojectfigureproductflowService.add(figureProductFlow) > 0;

		JsonUtil.outJson(response, "{success:'" + result + "',msg:'notexist'}");
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "submitFormFigure", method = RequestMethod.POST)
	public void submitFormFigure(FlowTaskInfo flowTaskInfo, HttpServletRequest request, HttpServletResponse response,
			@RequestParam("flowId") String flowId) {
		logger.log(LogLevel.INFO, "[BusProjectFigureFlowController] submitFormFigure start");
		boolean result = false;
		flowTaskInfo.setPdid("BusProjectFigure");
		String strUser = SessionContext.get(request).getUserName();
		int iResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);
		if (0 == iResult) 
		{
			//插入前缺少重复校验
			result = busprojectfigureflowService.insertALL(flowId) > 0;
		}
		if (2 == iResult || result)
		{
			result=true;
			busprojectfigureflowService.delete(flowId);
			busprojectfigureproductflowService.delete(flowId);
		}
		if (iResult == 1)
		{
			result=true;
		}
		JsonUtil.outJson(response, "{success:"+result+"}");
		logger.log(LogLevel.INFO, "[BusProjectFigureFlowController] submitFormFigure end");
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
        if (busProjectProducts != null)
        {
        	for (BusProjectProduct bpp : busProjectProducts)
        	{
        		if (StringUtils.isNotEmpty(bpp.getStatus()))
        		{
        			bpp.setProductName(bpp.getProductName() + "("+bpp.getStatus()+")");
        		}
        	}
        }
		String jsonReuslt = JsonUtil.getJsonStr(busProjectProducts);

		JsonUtil.outJson(response, jsonReuslt);
	}

	@RequestMapping(value = "queryfigureLib", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryfigureLib (HttpServletRequest request, HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("productId");
		List<Map<String, String>> figureLibList= busprojectfigureService.getFigureLibByPpid(productId);
		Map<String, Object> result = new HashMap<String,Object>();
		result.put("data", figureLibList);
		return result;
	}
	
	
	@RequestMapping(value = "loadFigureData", method = RequestMethod.POST)
	public void loadBusProjectFigureData(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int limit = NumberUtils.toInt(request.getParameter("limit"));
		int offset = NumberUtils.toInt(request.getParameter("start"));

		String flowId = request.getParameter("flowId");

		String sql = "SELECT a.flowId, a.figureNo, a.figureName, a.figureRequest, a.batchNum,a.type as devid, d.devName as type,a.describe  FROM BUSPROJECTFIGUREFLOW as a left join devicetype as d on d.devid = a.TYPE where flowId = '"  +flowId + "'  LIMIT " + limit + " OFFSET " + offset;
		String totalSql = "SELECT COUNT(0) FROM BUSPROJECTFIGUREFLOW";

		List<Map<String, Object>> figurePageList = commonDao.queryToList(sql);

		int total = commonDao.queryToint(totalSql);
		String jsonReuslt = "";

		if (CollectionUtils.isEmpty(figurePageList)) {
			jsonReuslt = JsonUtil.getJsonStr(figurePageList);
			JsonUtil.outJson(response, jsonReuslt);
			return;
		}
		jsonReuslt = JsonUtil.parseListToJson(figurePageList, total);
		JsonUtil.outJson(response, jsonReuslt);
	}
	
	@RequestMapping(value = "getDeviceAll")
	@ResponseBody
	public List<Map<String,String>> getDeviceAll()
	{
		return busprojectfigureproductflowService.getDeviceAll();
	}
	
	@RequestMapping(value = "add")
	public void add(HttpServletResponse response,
			@ModelAttribute("busProjectFigureFlow") BusProjectFigureFlow busProjectFigureFlow)
	{
		int exsit = 0;
		//根据ID 查询 名称
		List<Map<String,String>> list = busprojectfigureflowService.queryFigureName(busProjectFigureFlow);
		if (list != null && list.size() > 0)
		{
			String figureName = busProjectFigureFlow.getFigureName();
			String figureRequest = busProjectFigureFlow.getFigureRequest();
			for (Map<String,String> map : list)
			{
				if(!map.get("figureName").equals(figureName))
				{
					exsit = 1;
					break;
				}
				if (map.get("figureRequest").equals(figureRequest))
				{
					exsit = 2;
					break;
				}
			}
		}
		if (exsit == 1)
		{
			JsonUtil.outJson(response, "{success:false,msg:'figureNo'}");
			return;
		}
		if (exsit == 2)
		{
			JsonUtil.outJson(response, "{success:false,msg:'exsit'}");
			return;
		}
		int addResult =busprojectfigureflowService.add(busProjectFigureFlow);
		if (addResult>0)
		{
			JsonUtil.outJson(response, "{success:true}");
			return;
		}
		JsonUtil.outJson(response, "{success:false,msg:'notexsit'}");
	}
	
	/** 删除
     * @param delete
     * @param videoType
     * @return
     */
     @RequestMapping("delete")
     public void delete(HttpServletResponse response, @RequestParam("delJson")  String  delJson) {
   	  List<BusProjectFigureFlow> busProjectFigureFlows = JsonUtil.parseJsonToList(delJson, BusProjectFigureFlow.class);
   	  int result = 0;
   	  for (BusProjectFigureFlow busProjectFigureFlow : busProjectFigureFlows)
   	  {
   		  result+=busprojectfigureflowService.delete(busProjectFigureFlow);
   	  }
   	  if (result > 0)
   	  {
   		  JsonUtil.outJson(response, "{success:true}");
   	  }
   	  else
   	  {
   		  JsonUtil.outJson(response, "{success:false}");
   	  }
         
     }
     
     @RequestMapping("update")
     public void update(HttpServletResponse response,
    		 @ModelAttribute("busProjectFigureFlowVo") BusProjectFigureFlowVo busProjectFigureFlowVo)
     {
    	
    	BusProjectFigureFlow busProjectFigureFlow = new BusProjectFigureFlow();
    	busProjectFigureFlow.setFlowId(busProjectFigureFlowVo.getFlowId());
    	busProjectFigureFlow.setFigureNo(busProjectFigureFlowVo.getFigureNo());
    	busProjectFigureFlow.setFigureName(busProjectFigureFlowVo.getFigureName());
    	
    	List<Map<String,String>> list = getList(busprojectfigureflowService.queryFigureName(busProjectFigureFlow),busProjectFigureFlowVo);
    	int exsit = 0;
 		if (list != null && list.size() > 0)
 		{
 			String figureName = busProjectFigureFlowVo.getFigureName();
 			String figureRequest = busProjectFigureFlowVo.getFigureRequest();
 			for (Map<String,String> map : list)
 			{
 				if(!map.get("figureName").equals(figureName))
 				{
 					exsit = 1;
 					break;
 				}
 				if (map.get("figureRequest").equals(figureRequest))
 				{
 					exsit = 2;
 					break;
 				}
 			}
 		}
 		if (exsit == 1)
		{
			JsonUtil.outJson(response, "{success:false,msg:'figureNo'}");
			return;
		}
		if (exsit == 2)
		{
			JsonUtil.outJson(response, "{success:false,msg:'exsit'}");
			return;
		}
		boolean result = busprojectfigureflowService.update(busProjectFigureFlowVo)>0;
		JsonUtil.outJson(response, "{success:"+result+"}");
     }
     
     private List<Map<String,String>> getList(List<Map<String,String>> list,BusProjectFigureFlowVo busProjectFigureFlowVo)
     {
    	 List<Map<String,String>> lists = new ArrayList<Map<String,String>>();
    	 String figureNameOld = busProjectFigureFlowVo.getFigureNameOld();
    	 String figureNoOld = busProjectFigureFlowVo.getFigureNoOld();
    	 String figureRequestOld = busProjectFigureFlowVo.getFigureRequestOld();
    	 for (Map<String,String> map : list)
		 {
			if (!(map.get("figureName").equals(figureNameOld) && map.get("figureNo").equals(figureNoOld) 
					&& map.get("figureRequest").equals(figureRequestOld)))
			{
				lists.add(map);
			}
		 }
    	 return lists;
     } 
}
