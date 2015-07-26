package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusTaskDao;
import com.erp.entity.BusTask;


@Repository("bustaskDao")
public class BusTaskDaoImpl extends BaseDaoImpl<BusTask> implements BusTaskDao{
}
