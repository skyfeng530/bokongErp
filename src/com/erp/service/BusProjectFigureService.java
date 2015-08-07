package com.erp.service;


import com.erp.entity.BusProjectFigure;

import com.erp.util.PageView;

public interface BusProjectFigureService{
    public PageView query(PageView pageView, BusProjectFigure busProjectFigure);

    public int add(BusProjectFigure busProjectFigure);

    public void modify(BusProjectFigure busProjectFigure);

    public void delete(String id);

    public BusProjectFigure getById(String id);
	
	public long getNewProjectId();

}
