package com.erp.dao.impl;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.ServerInfoDao;
import com.erp.entity.ServerInfo;

@Repository("serverInfoDao")
public class ServerInfoDaoImpl extends BaseDaoImpl<ServerInfo> implements ServerInfoDao{

}
