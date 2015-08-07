package com.erp.service;



import com.erp.entity.BusProjectFlow;

import com.erp.util.PageView;

public interface BusProjectFlowService{
    public PageView query(PageView pageView, BusProjectFlow busProjectFlow);

    public boolean add(BusProjectFlow busProjectFlow);

    public void modify(BusProjectFlow busProjectFlow);

    public void delete(String id);

    public BusProjectFlow getById(String id);
    
    public int getByName(BusProjectFlow busProjectFlow);

}
