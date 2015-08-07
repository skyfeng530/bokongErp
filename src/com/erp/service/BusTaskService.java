package com.erp.service;


import com.erp.entity.BusTask;
import com.erp.util.PageView;

public interface BusTaskService{
    public PageView query(PageView pageView, BusTask busTask);

    public int add(BusTask busTask);

    public void modify(BusTask busTask);

    public void delete(String id);

    public BusTask getById(String id);

}
