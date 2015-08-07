package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.BusProject;

public interface BusProjectDao extends BaseDao<BusProject>{
	
	public BusProject  getByProjectName(String projectName);
}
