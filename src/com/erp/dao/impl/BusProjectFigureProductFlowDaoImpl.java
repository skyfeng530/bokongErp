package com.erp.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectFigureProductFlowDao;
import com.erp.entity.BusProjectFigureProductFlow;


@Repository("busprojectfigureproductflowDao")
public class BusProjectFigureProductFlowDaoImpl extends BaseDaoImpl<BusProjectFigureProductFlow> implements BusProjectFigureProductFlowDao{

	@Override
	public List<Map<String, String>> getProductInfoByid(String flowId) {

		return getSqlSession().selectList(this.getClassName() + ".getProductInfoByid", flowId);
	}

	@Override
	public List<Map<String, String>> getDeviceAll() {
		
		return getSqlSession().selectList(this.getClassName() + ".getDeviceAll");
	}

	
}
