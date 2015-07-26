package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusTaskDao;
import com.erp.entity.BusTask;
import com.erp.service.BusTaskService;
import com.erp.util.PageView;

@Transactional
@Service("bustaskService")
public class BusTaskServiceImpl implements BusTaskService {
    @Autowired
    private BusTaskDao busTaskDao;

    public PageView query(PageView pageView, BusTask busTask) {
        List<BusTask> list = busTaskDao.query(pageView, busTask);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public void add(BusTask busTask) {
        busTaskDao.add(busTask);
    }

    @Override
    public void modify(BusTask busTask) {
        busTaskDao.modify(busTask);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busTaskDao.delete(id);
    }

    @Override
    public BusTask getById(String id) {
        // TODO Auto-generated method stub
        return busTaskDao.getById(id);
    }

}
