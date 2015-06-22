package com.erp.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.entity.FlowTemplateInfo;
import com.erp.entity.FlowTypeInfo;
import com.erp.util.PageView;


public interface WorkFlowService{
	public PageView query(PageView pageView,FlowTypeInfo flowTypeInfo);

	public void add(FlowTypeInfo flowTypeInfo);

	public void delete(String string);
	
	public FlowTemplateInfo queryOneRecord(int flowType, int stepIndex);
}
