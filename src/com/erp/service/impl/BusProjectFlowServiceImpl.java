package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectFlowDao;
import com.erp.entity.BusProjectFlow;
import com.erp.service.BusProjectFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectflowService")
public class BusProjectFlowServiceImpl implements BusProjectFlowService {
    @Autowired
    private BusProjectFlowDao busProjectFlowDao;

    public PageView query(PageView pageView, BusProjectFlow busProjectFlow) {
        List<BusProjectFlow> list = busProjectFlowDao.query(pageView, busProjectFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public boolean add(BusProjectFlow busProjectFlow) {
        int result = busProjectFlowDao.add(busProjectFlow);
        return result > 0;
    }

    @Override
    public void modify(BusProjectFlow busProjectFlow) {
        busProjectFlowDao.modify(busProjectFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectFlowDao.delete(id);
    }

    @Override
    public BusProjectFlow getById(String id) {
        // TODO Auto-generated method stub
        return busProjectFlowDao.getById(id);
    }

	@Override
	public int getByName(BusProjectFlow busProjectFlow) {
		// TODO Auto-generated method stub
		return busProjectFlowDao.getByName(busProjectFlow);
	}

}
