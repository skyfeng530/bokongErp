package com.erp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FlowRecordInfoDao;
import com.erp.entity.FlowRecordInfo;
import com.erp.util.PageView;


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
		return getSqlSession().selectOne(this.getClassName()+".getMaxId",flowRecordInfo);
	}

	@Override
	public List<FlowRecordInfo> queryOne(PageView pageView,FlowRecordInfo t) {
		// TODO Auto-generated method stub
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("paging", pageView);
		map.put("t", t);
		return getSqlSession().selectList(this.getClassName()+".query",map);
	}
	
	
}
