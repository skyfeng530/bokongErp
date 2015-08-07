package com.erp.service;


import java.util.List;

import com.erp.entity.BusMaterialInfoTaskFlow;

import com.erp.util.PageView;

public interface BusMaterialInfoTaskFlowService{
    public PageView query(PageView pageView, BusMaterialInfoTaskFlow busMaterialInfoTaskFlow);

    public int add(BusMaterialInfoTaskFlow busMaterialInfoTaskFlow);

    public void modify(BusMaterialInfoTaskFlow busMaterialInfoTaskFlow);

    public void delete(String id);

    public BusMaterialInfoTaskFlow getById(String id);

}
