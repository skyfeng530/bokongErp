package com.erp.service;


import java.util.List;

import com.erp.entity.BusMaterialInfo;

import com.erp.util.PageView;

public interface BusMaterialInfoService{
    public PageView query(PageView pageView, BusMaterialInfo busMaterialInfo);

    public int add(BusMaterialInfo busMaterialInfo);

    public void modify(BusMaterialInfo busMaterialInfo);

    public void delete(String id);

    public BusMaterialInfo getById(String id);

}
