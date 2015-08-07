package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.BusTaskFlow;
import com.erp.util.PageView;

public interface BusTaskFlowService{
    public PageView query(PageView pageView, BusTaskFlow busTaskFlow);

    public int add(BusTaskFlow busTaskFlow);

    public void modify(BusTaskFlow busTaskFlow);

    public void delete(String id);

    public BusTaskFlow getById(String id);
    
    public List<Map<String, Object>> queryBusTaskFlowByFlowId(String flowId);

}
