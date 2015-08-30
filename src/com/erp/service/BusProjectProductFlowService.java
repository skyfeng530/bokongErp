package com.erp.service;


import java.util.List;


import com.erp.entity.BusProjectProductFlow;
import com.erp.entity.BusProjectProductFlowVo;
import com.erp.util.PageView;

public interface BusProjectProductFlowService{
	
    public PageView query(PageView pageView, BusProjectProductFlow busProjectProductFlow);

    public int add(BusProjectProductFlow busProjectProductFlow);

    public void modify(BusProjectProductFlow busProjectProductFlow);

    public void delete(String id);

    public int delete(BusProjectProductFlow busProjectProductFlow);
    
    public PageView getPageData(PageView pageView,BusProjectProductFlow busprojectproductflow,String projectId);
    
    public List<BusProjectProductFlow> getByFlowId(String flowid);
    
    public List<BusProjectProductFlow> getByproductNo(BusProjectProductFlowVo busProjectProductFlowVo);
    
    public int conditionSelect(BusProjectProductFlowVo busProjectProductFlowVo);
    
    public int modifyProductFlow(BusProjectProductFlowVo busProjectProductFlowVo );
}
