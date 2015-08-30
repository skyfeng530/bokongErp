package com.erp.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectProductDao;
import com.erp.entity.BusProjectProduct;

@Repository("busprojectproductDao")
public class BusProjectProductDaoImpl extends BaseDaoImpl<BusProjectProduct>implements BusProjectProductDao {

	@Override
	public List<BusProjectProduct> queryByProjectId(BusProjectProduct product) {
		return getSqlSession().selectList(this.getClassName() + ".queryByProjectId", product);
	}

	@Override
	public int addAll(String flowId) {
		// TODO Auto-generated method stub
		return getSqlSession().insert(this.getClassName() + ".addAll", flowId);
	}

}
