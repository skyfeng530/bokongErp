package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectProductDao;
import com.erp.entity.BusProjectProduct;


@Repository("busprojectproductDao")
public class BusProjectProductDaoImpl extends BaseDaoImpl<BusProjectProduct> implements BusProjectProductDao{
}
