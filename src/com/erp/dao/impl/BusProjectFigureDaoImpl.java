package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectFigureDao;
import com.erp.entity.BusProjectFigure;


@Repository("busProjectFigureDao")
public class BusProjectFigureDaoImpl extends BaseDaoImpl<BusProjectFigure> implements BusProjectFigureDao
{

	@Override
	public long getNewProjectId() {
		return getSqlSession().selectOne("busprojectfigure.getNewProject");
	}

}
