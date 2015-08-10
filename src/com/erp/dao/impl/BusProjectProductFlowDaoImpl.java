package com.erp.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.BusProjectProductFlowDao;
import com.erp.entity.BusProjectProductFlow;
import com.erp.entity.BusProjectProductFlowVo;
import com.erp.util.PageView;


@Repository("busprojectproductflowDao")
public class BusProjectProductFlowDaoImpl extends BaseDaoImpl<BusProjectProductFlow> implements BusProjectProductFlowDao{

	@Override
	public List<BusProjectProductFlow> getPageData(PageView pageView,BusProjectProductFlow Busprojectproductflow,String projectId) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("paging", pageView);
		map.put("t", Busprojectproductflow);
		map.put("projectId", projectId);
		map.put("flowId", Busprojectproductflow.getFlowId());
		return getSqlSession().selectList(this.getClassName()+".query",map);
	}
	
    public List<BusProjectProductFlow> getByFlowId(String flowid) {
		
		return this.getSqlSession().selectList(this.getClassName() + ".getByFlowId", flowid);
	}

	@Override
	public int conditionSelect(BusProjectProductFlowVo busProjectProductFlowVo) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne(this.getClassName() + ".conditionSelect", busProjectProductFlowVo);
	}

	@Override
	public int delete(BusProjectProductFlow busProjectProductFlow) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete(this.getClassName() + ".deleteByObj", busProjectProductFlow);
	}

	@Override
	public int modifyProductFlow(BusProjectProductFlowVo bpfv) {
		// TODO Auto-generated method stub
		return this.getSqlSession().update(this.getClassName() + ".update", bpfv);
	}
}
