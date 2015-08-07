package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusMaterialInfoTaskFlowDao;
import com.erp.entity.BusMaterialInfoTaskFlow;
import com.erp.service.BusMaterialInfoTaskFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busmaterialinfotaskflowService")
public class BusMaterialInfoTaskFlowServiceImpl implements BusMaterialInfoTaskFlowService {
    @Autowired
    private BusMaterialInfoTaskFlowDao busMaterialInfoTaskFlowDao;

    public PageView query(PageView pageView, BusMaterialInfoTaskFlow busMaterialInfoTaskFlow) {
        List<BusMaterialInfoTaskFlow> list = busMaterialInfoTaskFlowDao.query(pageView, busMaterialInfoTaskFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusMaterialInfoTaskFlow busMaterialInfoTaskFlow) {
        return busMaterialInfoTaskFlowDao.add(busMaterialInfoTaskFlow);
    }

    @Override
    public void modify(BusMaterialInfoTaskFlow busMaterialInfoTaskFlow) {
        busMaterialInfoTaskFlowDao.modify(busMaterialInfoTaskFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busMaterialInfoTaskFlowDao.delete(id);
    }

    @Override
    public BusMaterialInfoTaskFlow getById(String id) {
        // TODO Auto-generated method stub
        return busMaterialInfoTaskFlowDao.getById(id);
    }

}
