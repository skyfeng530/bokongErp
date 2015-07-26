package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.FixedAssetDao;
import com.erp.entity.FixedAsset;


@Repository("fixedassetDao")
public class FixedAssetDaoImpl extends BaseDaoImpl<FixedAsset> implements FixedAssetDao{
}
