package com.erp.service;


import com.erp.entity.InstrumentDevice;
import com.erp.util.PageView;

public interface InstrumentDeviceService{
    public PageView query(PageView pageView, InstrumentDevice instrumentDevice);

    public void add(InstrumentDevice instrumentDevice);

    public void modify(InstrumentDevice instrumentDevice);

    public void delete(String id);

    public InstrumentDevice getById(String id);

}
