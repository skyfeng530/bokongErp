package com.erp.service;


import java.util.List;

import com.erp.entity.BusProject;

import com.erp.util.PageView;

public interface BusProjectService{
    public PageView query(PageView pageView, BusProject busProject);

    public int add(BusProject busProject);

    public void modify(BusProject busProject);

    public void delete(String id);

    public BusProject getById(String id);
    
    public List<BusProject> queryAll(BusProject busProject);
    
    public BusProject  getByProjectName(String projectName);

}
