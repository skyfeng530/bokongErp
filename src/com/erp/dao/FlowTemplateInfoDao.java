package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.FlowTemplateInfo;

public interface FlowTemplateInfoDao extends BaseDao<FlowTemplateInfo>{
	public FlowTemplateInfo queryOneRecord(int flowType, int stepIndex);
}

