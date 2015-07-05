package com.erp.dao;

import java.util.List;

import com.erp.base.BaseDao;
import com.erp.entity.ProjectInfo;

public interface ProjectInfoDao extends BaseDao<ProjectInfo>{
	public List<ProjectInfo> queryProject(ProjectInfo t);
}
