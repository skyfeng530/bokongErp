package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusMaterialInfoFlowDao;
import com.erp.entity.BusMaterialInfoFlow;
import com.erp.service.BusMaterialInfoFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busmaterialinfoflowService")
public class BusMaterialInfoFlowServiceImpl implements BusMaterialInfoFlowService {
    @Autowired
    private BusMaterialInfoFlowDao busMaterialInfoFlowDao;

    public PageView query(PageView pageView, BusMaterialInfoFlow busMaterialInfoFlow) {
        List<BusMaterialInfoFlow> list = busMaterialInfoFlowDao.query(pageView, busMaterialInfoFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusMaterialInfoFlow busMaterialInfoFlow) {
        return busMaterialInfoFlowDao.add(busMaterialInfoFlow);
    }

    @Override
    public void modify(BusMaterialInfoFlow busMaterialInfoFlow) {
        busMaterialInfoFlowDao.modify(busMaterialInfoFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busMaterialInfoFlowDao.delete(id);
    }

    @Override
    public BusMaterialInfoFlow getById(String id) {
        // TODO Auto-generated method stub
        return busMaterialInfoFlowDao.getById(id);
    }

}
