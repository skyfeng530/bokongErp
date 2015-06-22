package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.ElectronFlowInfoDao;
import com.erp.entity.ElectronFlowInfo;


@Repository("ElectronFlowInfoDao")
public class ElectronFlowInfoDaoImpl extends BaseDaoImpl<ElectronFlowInfo> implements ElectronFlowInfoDao
{
}
