package com.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.entity.FlowTemplateInfo;
import com.erp.entity.FlowTypeInfo;
import com.erp.service.WorkFlowService;
import com.erp.util.PageView;
import com.erp.dao.ElectronFlowInfoDao;
import com.erp.dao.FlowTemplateInfoDao;
import com.erp.dao.FlowTypeInfoDao;
@Transactional
@Service("workFlowService")
public class WorkFlowServiceImpl implements WorkFlowService {
	
	@Autowired
	private FlowTypeInfoDao flowTypeInfoDao;
	@Autowired
	private ElectronFlowInfoDao electronFlowInfoDao;
	@Autowired
	private FlowTemplateInfoDao flowTemplateInfoDao;

	@Override
	public PageView query(PageView pageView, FlowTypeInfo flowTypeInfo) {
		// TODO Auto-generated method stub
		pageView.setRecords(flowTypeInfoDao.query(pageView, flowTypeInfo));
		return pageView;
	}

	@Override
	public void add(FlowTypeInfo flowTypeInfo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public FlowTemplateInfo queryOneRecord(int flowType, int stepIndex) {
		// TODO Auto-generated method stub
		return flowTemplateInfoDao.queryOneRecord(flowType, stepIndex);
	}

}
