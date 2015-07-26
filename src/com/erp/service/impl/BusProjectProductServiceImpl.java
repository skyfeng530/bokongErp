package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectProductDao;
import com.erp.entity.BusProjectProduct;
import com.erp.service.BusProjectProductService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectproductService")
public class BusProjectProductServiceImpl implements BusProjectProductService {
    @Autowired
    private BusProjectProductDao busProjectProductDao;

    public PageView query(PageView pageView, BusProjectProduct busProjectProduct) {
        List<BusProjectProduct> list = busProjectProductDao.query(pageView, busProjectProduct);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(BusProjectProduct busProjectProduct) {
        busProjectProductDao.add(busProjectProduct);
    }

    @Override
    public void modify(BusProjectProduct busProjectProduct) {
        busProjectProductDao.modify(busProjectProduct);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectProductDao.delete(id);
    }

    @Override
    public BusProjectProduct getById(String id) {
        // TODO Auto-generated method stub
        return busProjectProductDao.getById(id);
    }

}
