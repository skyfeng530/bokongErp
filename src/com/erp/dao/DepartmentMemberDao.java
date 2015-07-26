package com.erp.dao;

import com.erp.base.BaseDao;
import com.erp.entity.DepartmentMember;

public interface DepartmentMemberDao extends BaseDao<DepartmentMember>{

	public boolean saveUserRole(DepartmentMember member);
}
