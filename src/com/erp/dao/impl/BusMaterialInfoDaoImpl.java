package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusMaterialInfoDao;
import com.erp.entity.BusMaterialInfo;


@Repository("busmaterialinfoDao")
public class BusMaterialInfoDaoImpl extends BaseDaoImpl<BusMaterialInfo> implements BusMaterialInfoDao{
}
