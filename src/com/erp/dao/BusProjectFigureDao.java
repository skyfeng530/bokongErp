package com.erp.dao;

import java.util.List;
import java.util.Map;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectFigure;

public interface BusProjectFigureDao extends BaseDao<BusProjectFigure>{

	public long getNewProjectId();
	
	public int getCountByCondition(BusProjectFigure busProjectFigure);
	
	public List<Map<String,String>> getFigureLibByPpid(String ppid);
}
