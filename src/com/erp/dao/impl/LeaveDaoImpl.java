package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.LeaveDao;
import com.erp.entity.BusLeave;


@Repository("leaveDao")
public class LeaveDaoImpl extends BaseDaoImpl<BusLeave> implements LeaveDao
{
}
