package com.erp.service;



import com.erp.entity.OmInstorage;

import com.erp.util.PageView;

public interface OmInstorageService{
    public PageView query(PageView pageView, OmInstorage omInstorage);

    public void add(OmInstorage omInstorage);

    public void modify(OmInstorage omInstorage);

    public void delete(String id);

    public OmInstorage getById(String id);

}
