package com.erp.dao;

import java.util.List;
import java.util.Map;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectFigureFlow;

public interface BusProjectFigureFlowDao extends BaseDao<BusProjectFigureFlow>{
	
	public List<Map<String, Object>> queryByPage(int limit, int offset);
	
	public int count();
}
