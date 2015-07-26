package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectFigureFlowDao;
import com.erp.entity.BusProjectFigureFlow;
import com.erp.service.BusProjectFigureFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectfigureflowService")
public class BusProjectFigureFlowServiceImpl implements BusProjectFigureFlowService {
    @Autowired
    private BusProjectFigureFlowDao busProjectFigureFlowDao;

    public PageView query(PageView pageView, BusProjectFigureFlow busProjectFigureFlow) {
        List<BusProjectFigureFlow> list = busProjectFigureFlowDao.query(pageView, busProjectFigureFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(BusProjectFigureFlow busProjectFigureFlow) {
        busProjectFigureFlowDao.add(busProjectFigureFlow);
    }

    @Override
    public void modify(BusProjectFigureFlow busProjectFigureFlow) {
        busProjectFigureFlowDao.modify(busProjectFigureFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectFigureFlowDao.delete(id);
    }

    @Override
    public BusProjectFigureFlow getById(String id) {
        // TODO Auto-generated method stub
        return busProjectFigureFlowDao.getById(id);
    }

}
