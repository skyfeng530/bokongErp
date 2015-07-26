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

	public boolean add(BusProject project)
	{
		int result = busProjectDao.add(project);
		return result > 0 ? true : false;
	}

	@Override
	public void delete(String string) {
		busProjectDao.delete(string);
	}

	@Override
	public long getNewProjectId() {
		// TODO Auto-generated method stub
		return busProjectDao.getNewProjectId();
	}

	@Override
	public void modify(BusProject busProject) {
		busProjectDao.modify(busProject);
	}

    @Override
    public BusProject getById(String id) {
        // TODO Auto-generated method stub
        return busProjectDao.getById(id);
    }

}
