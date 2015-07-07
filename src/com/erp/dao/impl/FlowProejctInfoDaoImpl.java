package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FlowProejctInfoDao;
import com.erp.entity.FlowProejctInfo;


@Repository("flowproejctinfoDao")
public class FlowProejctInfoDaoImpl extends BaseDaoImpl<FlowProejctInfo> implements FlowProejctInfoDao
{

	@Override
	public int getFlowIdByTask(int taskId) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(this.getClassName()+".getFlowIdByTask", taskId);
	}
	
}
