package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.BusProjectFigureFlow;
import com.erp.util.PageView;

public interface BusProjectFigureFlowService{
    public PageView query(PageView pageView, BusProjectFigureFlow busProjectFigureFlow);

    public int add(BusProjectFigureFlow busProjectFigureFlow);

    public void modify(BusProjectFigureFlow busProjectFigureFlow);

    public void delete(String id);

    public BusProjectFigureFlow getById(String id);
    
    public List<Map<String, Object>> queryByPage(int limit, int offset);
    
    public int getFiguretotal();

}
