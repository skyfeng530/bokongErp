package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectFigureDao;
import com.erp.entity.BusProjectFigure;
import com.erp.service.BusProjectFigureService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectfigureService")
public class BusProjectFigureServiceImpl implements BusProjectFigureService {
    @Autowired
    private BusProjectFigureDao busProjectFigureDao;

	@Override
	public PageView query(PageView pageView, BusProjectFigure projectFigure) {
		List<BusProjectFigure> list = busProjectFigureDao.query(pageView, projectFigure);
		pageView.setRecords(list);
		return pageView;
	}

    @Override
    public int add(BusProjectFigure busProjectFigure) {
        return busProjectFigureDao.add(busProjectFigure);
    }

    @Override
    public void modify(BusProjectFigure busProjectFigure) {
        busProjectFigureDao.modify(busProjectFigure);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectFigureDao.delete(id);
    }

	@Override
	public long getNewProjectId() {
		// TODO Auto-generated method stub
		return busProjectFigureDao.getNewProjectId();
	}

    @Override
    public BusProjectFigure getById(String id) {
        // TODO Auto-generated method stub
        return busProjectFigureDao.getById(id);
    }
}
