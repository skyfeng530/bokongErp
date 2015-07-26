package com.erp.service;


import java.util.List;

import com.erp.entity.BusTask;

import com.erp.util.PageView;

public interface BusTaskService{
    public PageView query(PageView pageView, BusTask busTask);

    public void add(BusTask busTask);

    public void modify(BusTask busTask);

    public void delete(String id);

    public BusTask getById(String id);

}
