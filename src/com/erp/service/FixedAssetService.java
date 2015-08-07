package com.erp.service;


import com.erp.entity.FixedAsset;
import com.erp.util.PageView;

public interface FixedAssetService{
    public PageView query(PageView pageView, FixedAsset fixedAsset);

    public void add(FixedAsset fixedAsset);

    public void modify(FixedAsset fixedAsset);

    public void delete(String id);

    public FixedAsset getById(String id);

}
