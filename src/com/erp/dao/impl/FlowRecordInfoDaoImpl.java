package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FlowRecordInfoDao;
import com.erp.entity.FlowRecordInfo;


@Repository("flowrecordinfoDao")
public class FlowRecordInfoDaoImpl extends BaseDaoImpl<FlowRecordInfo> implements FlowRecordInfoDao
{

	@Override
	public int count() {
		// TODO Auto-generated method stub
		FlowRecordInfo flowRecordInfo = new FlowRecordInfo();
		return (Integer)getSqlSession().selectOne(this.getClassName()+".count",flowRecordInfo);
	}

	@Override
	public long getMaxId() {
		FlowRecordInfo flowRecordInfo = new FlowRecordInfo();
		return (long)getSqlSession().selectOne(this.getClassName()+".getMaxId",flowRecordInfo);
	}
	
	
}
