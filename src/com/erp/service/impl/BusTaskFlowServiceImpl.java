package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusTaskFlowDao;
import com.erp.entity.BusTaskFlow;
import com.erp.service.BusTaskFlowService;
import com.erp.util.PageView;

@Transactional
@Service("bustaskflowService")
public class BusTaskFlowServiceImpl implements BusTaskFlowService {
    @Autowired
    private BusTaskFlowDao busTaskFlowDao;

    public PageView query(PageView pageView, BusTaskFlow busTaskFlow) {
        List<BusTaskFlow> list = busTaskFlowDao.query(pageView, busTaskFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(BusTaskFlow busTaskFlow) {
        busTaskFlowDao.add(busTaskFlow);
    }

    @Override
    public void modify(BusTaskFlow busTaskFlow) {
        busTaskFlowDao.modify(busTaskFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busTaskFlowDao.delete(id);
    }

    @Override
    public BusTaskFlow getById(String id) {
        // TODO Auto-generated method stub
        return busTaskFlowDao.getById(id);
    }

}
