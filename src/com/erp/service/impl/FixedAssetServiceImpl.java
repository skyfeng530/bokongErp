package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.FixedAssetDao;
import com.erp.entity.FixedAsset;
import com.erp.service.FixedAssetService;
import com.erp.util.PageView;

@Transactional
@Service("fixedassetService")
public class FixedAssetServiceImpl implements FixedAssetService {
    @Autowired
    private FixedAssetDao fixedAssetDao;

    public PageView query(PageView pageView, FixedAsset fixedAsset) {
        List<FixedAsset> list = fixedAssetDao.query(pageView, fixedAsset);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(FixedAsset fixedAsset) {
        fixedAssetDao.add(fixedAsset);
    }

    @Override
    public void modify(FixedAsset fixedAsset) {
        fixedAssetDao.modify(fixedAsset);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        fixedAssetDao.delete(id);
    }

    @Override
    public FixedAsset getById(String id) {
        // TODO Auto-generated method stub
        return fixedAssetDao.getById(id);
    }

}
