package com.erp.service;


import java.util.List;

import com.erp.entity.BusLeave;
import com.erp.util.PageView;

public interface LeaveService{
	public List<BusLeave> query(PageView pageView,BusLeave leave);

	public void add(BusLeave leave);

	public void delete(String string);
	
	public BusLeave getById(String id);
}
