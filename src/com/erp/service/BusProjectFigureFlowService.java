package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.BusProjectFigureFlow;
import com.erp.entity.BusProjectFigureFlowVo;
import com.erp.util.PageView;

public interface BusProjectFigureFlowService{
    public PageView query(PageView pageView, BusProjectFigureFlow busProjectFigureFlow);

    public int add(BusProjectFigureFlow busProjectFigureFlow);

    public void modify(BusProjectFigureFlow busProjectFigureFlow);

    public void delete(String id);
    
    public int delete(BusProjectFigureFlow busProjectFigureFlow);

    public BusProjectFigureFlow getById(String id);
    
    public List<Map<String, Object>> queryByPage(int limit, int offset);
    
    public int insertALL(String flowId);
    
    public int update(BusProjectFigureFlowVo busProjectFigureFlowVo);
    
    public int getFiguretotal();
    
    public List<Map<String, String>> queryFigureName(BusProjectFigureFlow busProjectFigureFlow);

}
