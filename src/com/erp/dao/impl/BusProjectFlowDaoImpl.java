package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectFlowDao;
import com.erp.entity.BusProjectFlow;


@Repository("busprojectflowDao")
public class BusProjectFlowDaoImpl extends BaseDaoImpl<BusProjectFlow> implements BusProjectFlowDao{

	@Override
	public int getByName(BusProjectFlow busProjectFlow) {
		
		return this.getSqlSession().selectOne(this.getClassName()+".getByName", busProjectFlow);
	}
}
