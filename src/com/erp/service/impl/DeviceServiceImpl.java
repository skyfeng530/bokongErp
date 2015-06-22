package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.DeviceDao;
import com.erp.entity.Device;
import com.erp.service.DeviceService;
import com.erp.util.PageView;

@Transactional
@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	@Autowired
	private DeviceDao deviceDao;

	@Override
	public PageView query(PageView pageView, Device device) {
		List<Device> list = deviceDao.query(pageView, device);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(Device device)
	{
		deviceDao.add(device);
	}

	@Override
	public void delete(String string) {
		deviceDao.delete(string);
	}
}
