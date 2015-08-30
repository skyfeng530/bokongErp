package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.InstrumentDeviceDao;
import com.erp.entity.InstrumentDevice;
import com.erp.service.InstrumentDeviceService;
import com.erp.util.PageView;

@Transactional
@Service("instrumentdeviceService")
public class InstrumentDeviceServiceImpl implements InstrumentDeviceService {
    @Autowired
    private InstrumentDeviceDao instrumentDeviceDao;

    public PageView query(PageView pageView, InstrumentDevice instrumentDevice) {
        List<InstrumentDevice> list = instrumentDeviceDao.query(pageView, instrumentDevice);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(InstrumentDevice instrumentDevice) {
        instrumentDeviceDao.add(instrumentDevice);
    }

    @Override
    public void modify(InstrumentDevice instrumentDevice) {
        instrumentDeviceDao.modify(instrumentDevice);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        instrumentDeviceDao.delete(id);
    }

    @Override
    public InstrumentDevice getById(String id) {
        // TODO Auto-generated method stub
        return instrumentDeviceDao.getById(id);
    }
    
    @Override
    public List<InstrumentDevice> queryAll(InstrumentDevice instrumentDevice){
    	return instrumentDeviceDao.queryAll(instrumentDevice);
    }
}
