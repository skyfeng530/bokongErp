package com.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.erp.entity.BusProjectProductFlow;
import com.erp.entity.BusProjectProductFlowVo;

import com.erp.service.BusProjectProductFlowService;

import com.erp.util.JsonUtil;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/project/product/flow")
public class BusProjectProductFlowController {
    @Autowired
    private BusProjectProductFlowService busProjectProductFlowService;

    /**
    * 添加
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public void add(HttpServletResponse response, 
    		BusProjectProductFlowVo busProjectProductFlowVo,
    		BusProjectProductFlow busProjectProductFlow) {
    	int exsit = isExist(busProjectProductFlowService.getByproductNo(busProjectProductFlowVo),busProjectProductFlowVo);
 		if (exsit == 1)
 		{
 			JsonUtil.outJson(response, "{success:false,msg:'productNo'}");
 			return;
 		}
 		if (exsit == 2)
 		{
 			JsonUtil.outJson(response, "{success:false,msg:'exsit'}");
 			return;
 		}
    	
        int addResult = busProjectProductFlowService.add(busProjectProductFlow);
        if (addResult <= 0)
        {
        	JsonUtil.outJson(response, "{success:false,msg:'failed'}");
        	return;
        }
        JsonUtil.outJson(response, "{success:true}");
    }
    
    @RequestMapping("queryall")
    @ResponseBody
    public Map<String,Object> queryall(@RequestParam(value="start") int start,
    		@RequestParam(value="limit") int limit,
    		@RequestParam(value="projectId") String projectId,
    		BusProjectProductFlow busProjectProductFlow) {
    	Map<String,Object> dataMap = new HashMap<String,Object>();
    	PageView   pageView = new PageView((int)Math.ceil(start/limit)+1);
		pageView=this.busProjectProductFlowService.getPageData(pageView, busProjectProductFlow, projectId);
		dataMap.put("totalProperty", pageView.getRowCount());
		dataMap.put("data", pageView.getRecords());
        return dataMap;
    }
    
    /**
     * 修改
     * @param model
     * @param videoType
     * @return
     */
     @RequestMapping("update")
     public void update(HttpServletResponse response, BusProjectProductFlowVo busProjectProductFlowVo)
     {
    	// int isExist = busProjectProductFlowService.conditionSelect(busProjectProductFlowVo);
    	List<BusProjectProductFlow> list = getList(busProjectProductFlowService.getByproductNo(busProjectProductFlowVo),busProjectProductFlowVo);
    	int exsit = isExist(list,busProjectProductFlowVo);
 		if (exsit == 1)
 		{
 			JsonUtil.outJson(response, "{success:false,msg:'productNo'}");
 			return;
 		}
 		if (exsit == 2)
 		{
 			JsonUtil.outJson(response, "{success:false,msg:'exsit'}");
 			return;
 		}
         int result = busProjectProductFlowService.modifyProductFlow(busProjectProductFlowVo);
         if (result <= 0)
         {
        	 JsonUtil.outJson(response, "{success:false,msg:'failed'}");
        	 return;
         }
         JsonUtil.outJson(response, "{success:true}");
     }
     
     /**
      * 删除
      * @param delete
      * @param videoType
      * @return
      */
      @RequestMapping("delete")
      public void delete(HttpServletResponse response, @RequestParam("delJson")  String  delJson) {
    	  List<BusProjectProductFlow> busProjectProductFlows = JsonUtil.parseJsonToList(delJson, BusProjectProductFlow.class);
    	  int result = 0;
    	  for (BusProjectProductFlow busProjectProductFlow : busProjectProductFlows)
    	  {
    		  result+=busProjectProductFlowService.delete(busProjectProductFlow);
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
      
      private List<BusProjectProductFlow> getList(List<BusProjectProductFlow> list,BusProjectProductFlowVo busProjectProductFlowVo)
      {
     	 List<BusProjectProductFlow> lists = new ArrayList<BusProjectProductFlow>();
     	 String productNoOld = busProjectProductFlowVo.getProductNoOld();
     	 String productNameOld = busProjectProductFlowVo.getProductNameOld();
     	 String statusOld = busProjectProductFlowVo.getStatusOld();
     	 for (BusProjectProductFlow busProjectProductFlow : list)
 		 {
 			if (!(busProjectProductFlow.getProductNo().equals(productNoOld) 
 					&& busProjectProductFlow.getProductName().equals(productNameOld) 
 					&& busProjectProductFlow.getStatus().equals(statusOld)))
 			{
 				lists.add(busProjectProductFlow);
 			}
 		 }
     	 return lists;
      } 
      
      private int isExist(List<BusProjectProductFlow> list,BusProjectProductFlowVo busProjectProductFlowVo)
      {
    	  int exsit = 0;
    	  if (list != null && list.size() > 0)
  		  {
  			String productName = busProjectProductFlowVo.getProductName();
  			String status = busProjectProductFlowVo.getStatus();
  			for (BusProjectProductFlow busProjectProductFlow : list)
  			{
  				if(!busProjectProductFlow.getProductName().equals(productName))
  				{
  					exsit = 1;
  					break;
  				}
  				if (busProjectProductFlow.getStatus().equals(status))
  				{
  					exsit = 2;
  					break;
  				}
  			}
  		  }
    	  return exsit;
      }
}
