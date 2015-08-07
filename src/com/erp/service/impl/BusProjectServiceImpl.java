package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectDao;
import com.erp.entity.BusProject;
import com.erp.service.BusProjectService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectService")
public class BusProjectServiceImpl implements BusProjectService {
    @Autowired
    private BusProjectDao busProjectDao;

    public PageView query(PageView pageView, BusProject busProject) {
        List<BusProject> list = busProjectDao.query(pageView, busProject);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusProject busProject) {
        return busProjectDao.add(busProject);
    }

    @Override
    public void modify(BusProject busProject) {
        busProjectDao.modify(busProject);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectDao.delete(id);
    }

    @Override
    public BusProject getById(String id) {
        // TODO Auto-generated method stub
        return busProjectDao.getById(id);
    }

	@Override
	public List<BusProject> queryAll(BusProject busProject) {
		// TODO Auto-generated method stub
		return busProjectDao.queryAll(busProject);
	}
    
	@Override
	public BusProject getByProjectName(String projectName) {
		// TODO Auto-generated method stub
		return busProjectDao.getByProjectName(projectName);
	}

}
