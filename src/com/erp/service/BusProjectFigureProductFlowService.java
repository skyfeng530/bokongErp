package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.BusProjectFigureProductFlow;

import com.erp.util.PageView;

public interface BusProjectFigureProductFlowService{
    public PageView query(PageView pageView, BusProjectFigureProductFlow busProjectFigureProductFlow);

    public int add(BusProjectFigureProductFlow busProjectFigureProductFlow);

    public void modify(BusProjectFigureProductFlow busProjectFigureProductFlow);

    public void delete(String id);

    public BusProjectFigureProductFlow getById(String id);
    
    public List<Map<String, String>> getProductInfoByid(String ppid);

}
