package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectDao;
import com.erp.entity.BusProject;


@Repository("busprojectDao")
public class BusProjectDaoImpl extends BaseDaoImpl<BusProject> implements BusProjectDao{

	@Override
	public BusProject getByProjectName(String projectName) {
		
		return getSqlSession().selectOne(this.getClassName()+".getByProjectName",projectName);
	}
}
