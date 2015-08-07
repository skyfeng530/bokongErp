package com.erp.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectFigureFlowDao;
import com.erp.entity.BusProjectFigureFlow;


@Repository("busprojectfigureflowDao")
public class BusProjectFigureFlowDaoImpl extends BaseDaoImpl<BusProjectFigureFlow> implements BusProjectFigureFlowDao{

	@Override
	public List<Map<String, Object>> queryByPage(int limit, int offset) {
		
		Map<String, Object> t = new HashMap<String, Object>();
		t.put("limit", limit);
		t.put("offset", offset);
		
		return getSqlSession().selectList(getClassName() + ".queryByPage", t);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return (int)getSqlSession().selectOne(getClassName() + ".count");
	}
	
	
}
