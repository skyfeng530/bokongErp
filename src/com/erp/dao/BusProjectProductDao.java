package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.BusProjectProduct;

public interface BusProjectProductDao extends BaseDao<BusProjectProduct> {

	public List<BusProjectProduct> queryByProjectId(BusProjectProduct product);
	
	public int addAll(String flowId);
}
