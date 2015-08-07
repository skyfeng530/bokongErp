package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectProductProjectFlowDao;
import com.erp.entity.BusProjectProductProjectFlow;
import com.erp.service.BusProjectProductProjectFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectproductprojectflowService")
public class BusProjectProductProjectFlowServiceImpl implements BusProjectProductProjectFlowService {
    @Autowired
    private BusProjectProductProjectFlowDao busProjectProductProjectFlowDao;

    public PageView query(PageView pageView, BusProjectProductProjectFlow busProjectProductProjectFlow) {
        List<BusProjectProductProjectFlow> list = busProjectProductProjectFlowDao.query(pageView, busProjectProductProjectFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusProjectProductProjectFlow busProjectProductProjectFlow) {
        return busProjectProductProjectFlowDao.add(busProjectProductProjectFlow);
    }

    @Override
    public void modify(BusProjectProductProjectFlow busProjectProductProjectFlow) {
        busProjectProductProjectFlowDao.modify(busProjectProductProjectFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectProductProjectFlowDao.delete(id);
    }

    @Override
    public BusProjectProductProjectFlow getById(String id) {
        // TODO Auto-generated method stub
        return busProjectProductProjectFlowDao.getById(id);
    }

}
