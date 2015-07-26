package com.erp.service;


import java.util.List;

import com.erp.entity.BusProjectProduct;

import com.erp.util.PageView;

public interface BusProjectProductService{
    public PageView query(PageView pageView, BusProjectProduct busProjectProduct);

    public void add(BusProjectProduct busProjectProduct);

    public void modify(BusProjectProduct busProjectProduct);

    public void delete(String id);

    public BusProjectProduct getById(String id);

}
