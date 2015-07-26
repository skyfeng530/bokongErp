package com.erp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.DepartmentMemberDao;
import com.erp.entity.DepartmentMember;
import com.erp.service.DepartmentMemberService;

@Transactional
@Service("departmentMemberService")
public class DepartmentMemberServiceImpl implements DepartmentMemberService {
	@Autowired
	private DepartmentMemberDao departmentMemberDao;

	@Override
	public boolean saveUserDepaertment(DepartmentMember member) {
		return departmentMemberDao.saveUserRole(member);
	}

}
