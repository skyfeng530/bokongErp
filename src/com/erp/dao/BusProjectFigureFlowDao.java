package com.erp.dao;

import java.util.List;
import java.util.Map;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectFigureFlow;
import com.erp.entity.BusProjectFigureFlowVo;

public interface BusProjectFigureFlowDao extends BaseDao<BusProjectFigureFlow>{
	
	public List<Map<String, Object>> queryByPage(int limit, int offset);
	
	public int delete(BusProjectFigureFlow busProjectFigureFlow);
	
	public List<Map<String, String>> queryFigureName(BusProjectFigureFlow busProjectFigureFlow);
	
	public int insertALL(String flowId);
	
	public int update(BusProjectFigureFlowVo busProjectFigureFlowVo);
	
	public int count();
}
