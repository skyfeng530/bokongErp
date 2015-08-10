package com.erp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectFigureProductFlowDao;
import com.erp.entity.BusProjectFigureProductFlow;
import com.erp.service.BusProjectFigureProductFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectfigureproductflowService")
public class BusProjectFigureProductFlowServiceImpl implements BusProjectFigureProductFlowService {
    @Autowired
    private BusProjectFigureProductFlowDao busProjectFigureProductFlowDao;

    public PageView query(PageView pageView, BusProjectFigureProductFlow busProjectFigureProductFlow) {
        List<BusProjectFigureProductFlow> list = busProjectFigureProductFlowDao.query(pageView, busProjectFigureProductFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusProjectFigureProductFlow busProjectFigureProductFlow) {
        return busProjectFigureProductFlowDao.add(busProjectFigureProductFlow);
    }

    @Override
    public void modify(BusProjectFigureProductFlow busProjectFigureProductFlow) {
        busProjectFigureProductFlowDao.modify(busProjectFigureProductFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectFigureProductFlowDao.delete(id);
    }

    @Override
    public BusProjectFigureProductFlow getById(String id) {
        // TODO Auto-generated method stub
        return busProjectFigureProductFlowDao.getById(id);
    }

	@Override
	public List<Map<String, String>> getProductInfoByid(String flowId) {
		// TODO Auto-generated method stub
		return busProjectFigureProductFlowDao.getProductInfoByid(flowId);
	}

	@Override
	public List<Map<String, String>> getDeviceAll() {
		// TODO Auto-generated method stub
		return busProjectFigureProductFlowDao.getDeviceAll();
	}

    
}
