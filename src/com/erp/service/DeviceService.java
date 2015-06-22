package com.erp.service;


import com.erp.entity.Device;
import com.erp.util.PageView;

public interface DeviceService{
	public PageView query(PageView pageView,Device device);

	public void add(Device device);

	public void delete(String string);
}
