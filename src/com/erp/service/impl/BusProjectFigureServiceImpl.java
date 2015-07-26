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
@Service("busProjectFigureService")
public class BusProjectFigureServiceImpl implements BusProjectFigureService {
	@Autowired
	private BusProjectFigureDao busProjectFigureDao;

	@Override
	public PageView query(PageView pageView, BusProjectFigure projectFigure) {
		List<BusProjectFigure> list = busProjectFigureDao.query(pageView, projectFigure);
		pageView.setRecords(list);
		return pageView;
	}

	public boolean add(BusProjectFigure projectFigure)
	{
		int result = busProjectFigureDao.add(projectFigure);
		return result > 0 ? true : false;
	}

	@Override
	public void delete(String string) {
		busProjectFigureDao.delete(string);
	}

	@Override
	public long getNewProjectId() {
		// TODO Auto-generated method stub
		return busProjectFigureDao.getNewProjectId();
	}
}
