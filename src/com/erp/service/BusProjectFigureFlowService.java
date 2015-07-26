package com.erp.service;


import java.util.List;

import com.erp.entity.BusProjectFigureFlow;

import com.erp.util.PageView;

public interface BusProjectFigureFlowService{
    public PageView query(PageView pageView, BusProjectFigureFlow busProjectFigureFlow);

    public void add(BusProjectFigureFlow busProjectFigureFlow);

    public void modify(BusProjectFigureFlow busProjectFigureFlow);

    public void delete(String id);

    public BusProjectFigureFlow getById(String id);

}
