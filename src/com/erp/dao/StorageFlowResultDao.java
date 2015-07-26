package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.StorageFlowResult;

public interface StorageFlowResultDao extends BaseDao<StorageFlowResult>{
	
	public List<StorageFlowResult> queryByFlowId(Integer flowId);
}
