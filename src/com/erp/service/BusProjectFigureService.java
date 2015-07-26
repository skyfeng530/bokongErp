package com.erp.service;


import com.erp.entity.BusProjectFigure;
import com.erp.util.PageView;

public interface BusProjectFigureService{
	public PageView query(PageView pageView,BusProjectFigure projectFigure);

	public boolean add(BusProjectFigure projectFigure);

	public void delete(String string);
	
	public long getNewProjectId();
}
