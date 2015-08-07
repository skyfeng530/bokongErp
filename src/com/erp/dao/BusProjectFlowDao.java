package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectFlow;

public interface BusProjectFlowDao extends BaseDao<BusProjectFlow>{
	int getByName(BusProjectFlow busProjectFlow);
}
