package com.erp.service;


import java.util.List;

import com.erp.entity.BusProjectProductProjectFlow;

import com.erp.util.PageView;

public interface BusProjectProductProjectFlowService{
    public PageView query(PageView pageView, BusProjectProductProjectFlow busProjectProductProjectFlow);

    public int add(BusProjectProductProjectFlow busProjectProductProjectFlow);

    public void modify(BusProjectProductProjectFlow busProjectProductProjectFlow);

    public void delete(String id);

    public BusProjectProductProjectFlow getById(String id);

}
