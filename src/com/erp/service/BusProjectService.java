package com.erp.service;


import java.util.List;

import com.erp.entity.BusProject;

import com.erp.util.PageView;

public interface BusProjectService{
    public PageView query(PageView pageView, BusProject busProject);

	public boolean add(BusProject project);

	public void delete(String string);
	
	public long getNewProjectId();

	public void modify(BusProject busProject);

	public BusProject getById(String strId);
}
