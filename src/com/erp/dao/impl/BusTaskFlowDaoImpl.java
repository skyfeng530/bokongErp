package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusTaskFlowDao;
import com.erp.entity.BusTaskFlow;


@Repository("bustaskflowDao")
public class BusTaskFlowDaoImpl extends BaseDaoImpl<BusTaskFlow> implements BusTaskFlowDao{
}
