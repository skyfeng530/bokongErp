package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.StorageFlowResultDao;
import com.erp.entity.StorageFlowResult;

@Repository("storageflowresultDao")
public class StorageFlowResultDaoImpl extends BaseDaoImpl<StorageFlowResult>implements StorageFlowResultDao {

	@Override
	public List<StorageFlowResult> queryByFlowId(Integer flowId) {
		return getSqlSession().selectList(this.getClassName() + ".queryByFlowId", flowId);
	}

}
