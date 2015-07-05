package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.FlowRecordInfo;

public interface FlowRecordInfoDao extends BaseDao<FlowRecordInfo>{
	public int count();
	
	public long getMaxId();
}
