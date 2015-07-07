package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.FlowRecordInfo;
import com.erp.util.PageView;

public interface FlowRecordInfoDao extends BaseDao<FlowRecordInfo>{
	public int count();
	
	public long getMaxId();
	
	public List<FlowRecordInfo> queryOne(PageView pageView,FlowRecordInfo t);

}
