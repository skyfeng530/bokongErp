package com.erp.dao.impl;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectFigureDao;
import com.erp.entity.BusProjectFigure;


@Repository("busprojectfigureDao")
public class BusProjectFigureDaoImpl extends BaseDaoImpl<BusProjectFigure> implements BusProjectFigureDao{
	@Override
	public long getNewProjectId() {
		return getSqlSession().selectOne("busprojectfigure.getNewProject");
	}

	@Override
	public int getCountByCondition(BusProjectFigure busProjectFigure) {
		return this.getSqlSession().selectOne("busprojectfigure.getCountByCondition", busProjectFigure);
	}

	@Override
	public List<Map<String,String>> getFigureLibByPpid(String ppid) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("busprojectfigure.getFigureLibByPpid",ppid);
	}

}
