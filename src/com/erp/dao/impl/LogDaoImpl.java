package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.LogDao;
import com.erp.entity.Log;


@Repository("logDao")
public class LogDaoImpl extends BaseDaoImpl<Log> implements LogDao
{
}
