package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.FlowProejctInfo;

public interface FlowProejctInfoDao extends BaseDao<FlowProejctInfo>{
	
	public int getFlowIdByTask(int taskId);
}
