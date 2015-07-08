package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.DepartmentInfoDao;
import com.erp.entity.DepartmentInfo;
import com.erp.entity.Roles;
import com.erp.service.DepartmentService;
import com.erp.util.PageView;

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentInfoDao departmentDao;

	public PageView query(PageView pageView, DepartmentInfo department) {
		List<DepartmentInfo> list = departmentDao.query(pageView, department);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(DepartmentInfo department) {
		departmentDao.add(department);
	}

	@Override
	public void deleteByDepartmentname(String dName) {
		// TODO Auto-generated method stub
		departmentDao.deleteByDepartmentname(dName);
	}

	@Override
	public void modify(DepartmentInfo department) {
		// TODO Auto-generated method stub
		departmentDao.modify(department);
	}

	@Override
	public DepartmentInfo getByDepartmentrname(String dName) {
		// TODO Auto-generated method stub
		return departmentDao.getByDepartmentname(dName);
	}

	@Override
	public Roles findbyDepartmentRole(String dId) {
		// TODO Auto-generated method stub
		return departmentDao.findbyDepartmentRole(dId);
	}

}
