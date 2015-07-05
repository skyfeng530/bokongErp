package com.erp.dao.impl;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.ProjectInfoDao;
import com.erp.entity.ProjectInfo;


@Repository("projectinfoDao")
public class ProjectInfoDaoImpl extends BaseDaoImpl<ProjectInfo> implements ProjectInfoDao
{

	@Override
	public List<ProjectInfo> queryProject(ProjectInfo t) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList(this.getClassName()+".queryProject",t);
	}
}
