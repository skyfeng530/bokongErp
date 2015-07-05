package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.LeaveDao;
import com.erp.entity.BusLeave;
import com.erp.service.LeaveService;
import com.erp.util.PageView;

@Transactional
@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
	@Autowired
	private LeaveDao leaveDao;

	@Override
	public List<BusLeave> query(PageView pageView, BusLeave leave) {
		return leaveDao.query(pageView, leave);
	}

	@Override
	public void add(BusLeave leave) {
		leaveDao.add(leave);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		leaveDao.delete(id);
	}

	@Override
	public BusLeave getById(String id) {
		return leaveDao.getById(id);
	}

}
