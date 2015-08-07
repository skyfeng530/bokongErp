package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusMaterialInfoDao;
import com.erp.entity.BusMaterialInfo;
import com.erp.service.BusMaterialInfoService;
import com.erp.util.PageView;

@Transactional
@Service("busmaterialinfoService")
public class BusMaterialInfoServiceImpl implements BusMaterialInfoService {
    @Autowired
    private BusMaterialInfoDao busMaterialInfoDao;

    public PageView query(PageView pageView, BusMaterialInfo busMaterialInfo) {
        List<BusMaterialInfo> list = busMaterialInfoDao.query(pageView, busMaterialInfo);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusMaterialInfo busMaterialInfo) {
        return busMaterialInfoDao.add(busMaterialInfo);
    }

    @Override
    public void modify(BusMaterialInfo busMaterialInfo) {
        busMaterialInfoDao.modify(busMaterialInfo);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busMaterialInfoDao.delete(id);
    }

    @Override
    public BusMaterialInfo getById(String id) {
        // TODO Auto-generated method stub
        return busMaterialInfoDao.getById(id);
    }

}
