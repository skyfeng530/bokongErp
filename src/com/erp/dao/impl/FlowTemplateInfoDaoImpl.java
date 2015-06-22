package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FlowTemplateInfoDao;
import com.erp.entity.FlowTemplateInfo;


@Repository("FlowTemplateInfoDao")
public class FlowTemplateInfoDaoImpl extends BaseDaoImpl<FlowTemplateInfo> implements FlowTemplateInfoDao
{
	public FlowTemplateInfo queryOneRecord(int flowType, int stepIndex) {
		FlowTemplateInfo tt = new FlowTemplateInfo() ;
		tt.setFlowType(flowType);
		tt.setnStepIndex(stepIndex);
		return (FlowTemplateInfo)getSqlSession().selectOne("flowtemplateinfo.queryOneRecord",tt);
	}
}

