package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.OmInstorageDao;
import com.erp.entity.OmInstorage;
import com.erp.service.OmInstorageService;
import com.erp.util.PageView;

@Transactional
@Service("ominstorageService")
public class OmInstorageServiceImpl implements OmInstorageService {
    @Autowired
    private OmInstorageDao omInstorageDao;

    public PageView query(PageView pageView, OmInstorage omInstorage) {
        List<OmInstorage> list = omInstorageDao.query(pageView, omInstorage);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(OmInstorage omInstorage) {
        omInstorageDao.add(omInstorage);
    }

    @Override
    public void modify(OmInstorage omInstorage) {
        omInstorageDao.modify(omInstorage);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        omInstorageDao.delete(id);
    }

    @Override
    public OmInstorage getById(String id) {
        // TODO Auto-generated method stub
        return omInstorageDao.getById(id);
    }

}
