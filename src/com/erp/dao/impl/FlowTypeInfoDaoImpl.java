package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FlowTypeInfoDao;
import com.erp.entity.FlowTypeInfo;


@Repository("flowTypeInfoDao")
public class FlowTypeInfoDaoImpl extends BaseDaoImpl<FlowTypeInfo> implements FlowTypeInfoDao
{
}
