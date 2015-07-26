package com.erp.service;


import java.util.List;

import com.erp.entity.BusTaskFlow;

import com.erp.util.PageView;

public interface BusTaskFlowService{
    public PageView query(PageView pageView, BusTaskFlow busTaskFlow);

    public void add(BusTaskFlow busTaskFlow);

    public void modify(BusTaskFlow busTaskFlow);

    public void delete(String id);

    public BusTaskFlow getById(String id);

}
