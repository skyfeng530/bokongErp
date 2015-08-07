package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.BusTaskProductFlow;
import com.erp.util.PageView;

public interface BusTaskProductFlowService{
    public PageView query(PageView pageView, BusTaskProductFlow busTaskProductFlow);

    public int add(BusTaskProductFlow busTaskProductFlow);

    public void modify(BusTaskProductFlow busTaskProductFlow);

    public void delete(String id);

    public BusTaskProductFlow getById(String id);
    
    public List<Map<String, Object>> queryTaskInfoByFlowId(String flowId);

}
