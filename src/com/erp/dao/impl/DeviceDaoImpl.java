package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.DeviceDao;
import com.erp.entity.Device;


@Repository("deviceDao")
public class DeviceDaoImpl extends BaseDaoImpl<Device> implements DeviceDao
{
}
