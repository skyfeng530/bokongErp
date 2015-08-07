package com.erp.service;


import java.util.List;

import com.erp.entity.BusMaterialInfoFlow;

import com.erp.util.PageView;

public interface BusMaterialInfoFlowService{
    public PageView query(PageView pageView, BusMaterialInfoFlow busMaterialInfoFlow);

    public int add(BusMaterialInfoFlow busMaterialInfoFlow);

    public void modify(BusMaterialInfoFlow busMaterialInfoFlow);

    public void delete(String id);

    public BusMaterialInfoFlow getById(String id);

}
