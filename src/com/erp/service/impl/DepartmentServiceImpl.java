package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.DepartmentInfoDao;
import com.erp.entity.Department;
import com.erp.entity.DepartmentUser;
import com.erp.entity.Roles;
import com.erp.service.DepartmentService;
import com.erp.util.PageView;

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentInfoDao departmentDao;

	public PageView query(PageView pageView, Department department) {
		List<Department> list = departmentDao.query(pageView, department);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(Department department) {
		departmentDao.add(department);
	}

	@Override
	public void deleteByDepartmentname(String dName) {
		departmentDao.deleteByDepartmentname(dName);
	}

	@Override
	public void modify(Department department) {
		departmentDao.modify(department);
	}

	@Override
	public Department getByDepartmentName(String dName) {
		return departmentDao.getByDepartmentname(dName);
	}

	@Override
	public Roles findbyDepartmentRole(String dName) {
		return departmentDao.findbyDepartmentRole(dName);
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
	}

	@Override
	public void saveDepartmentUser(DepartmentUser departmentUser) {
		departmentDao.saveDepartmentUser(departmentUser);
	}
	
}
