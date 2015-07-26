package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.InstrumentDeviceDao;
import com.erp.entity.InstrumentDevice;


@Repository("instrumentdeviceDao")
public class InstrumentDeviceDaoImpl extends BaseDaoImpl<InstrumentDevice> implements InstrumentDeviceDao{
}
