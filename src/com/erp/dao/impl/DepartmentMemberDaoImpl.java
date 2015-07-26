package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.DepartmentMemberDao;
import com.erp.entity.DepartmentMember;

@Repository("departmentMemberDao")
public class DepartmentMemberDaoImpl extends BaseDaoImpl<DepartmentMember> implements DepartmentMemberDao
{

	@Override
	public boolean saveUserRole(DepartmentMember member) {
		int result = getSqlSession().insert("departmentmember.add", member);
		return result > 0 ? true : false;
	}
}
