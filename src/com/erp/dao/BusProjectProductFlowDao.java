package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectProductFlow;
import com.erp.entity.BusProjectProductFlowVo;
import com.erp.util.PageView;

public interface BusProjectProductFlowDao extends BaseDao<BusProjectProductFlow>{
	
	List<BusProjectProductFlow> getPageData(PageView pageView,BusProjectProductFlow Busprojectproductflow,String projectId);
	
	List<BusProjectProductFlow> getByFlowId(String flowid);
	
	int conditionSelect(BusProjectProductFlowVo busProjectProductFlowVo);
	
	int delete(BusProjectProductFlow busProjectProductFlow);
	
	int modifyProductFlow(BusProjectProductFlowVo bpfv);
	
	List<BusProjectProductFlow> getByproductNo(BusProjectProductFlowVo busProjectProductFlowVo);
}
