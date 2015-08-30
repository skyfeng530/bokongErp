package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.RuTaskDao;
import com.erp.entity.RuTask;


@Repository("ruTaskDao")
public class RuTaskDaoImpl extends BaseDaoImpl<RuTask> implements RuTaskDao
{
}
