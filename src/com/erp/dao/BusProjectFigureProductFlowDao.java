package com.erp.dao;

import java.util.List;
import java.util.Map;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectFigureProductFlow;

public interface BusProjectFigureProductFlowDao extends BaseDao<BusProjectFigureProductFlow>{
	
	public List<Map<String, String>> getProductInfoByid(String flowId); 
}
