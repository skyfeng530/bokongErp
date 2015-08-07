package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.BusProjectProductFlowDao;
import com.erp.entity.BusProjectProductFlow;
import com.erp.entity.BusProjectProductFlowVo;
import com.erp.service.BusProjectProductFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectproductflowService")
public class BusProjectProductFlowServiceImpl implements BusProjectProductFlowService {
    @Autowired
    private BusProjectProductFlowDao busProjectProductFlowDao;

    public PageView query(PageView pageView, BusProjectProductFlow busProjectProductFlow) {
        List<BusProjectProductFlow> list = busProjectProductFlowDao.query(pageView, busProjectProductFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusProjectProductFlow busProjectProductFlow) {
        return busProjectProductFlowDao.add(busProjectProductFlow);
    }

    @Override
    public void modify(BusProjectProductFlow busProjectProductFlow) {
        busProjectProductFlowDao.modify(busProjectProductFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busProjectProductFlowDao.delete(id);
    }

	@Override
	public PageView getPageData(PageView pageView,BusProjectProductFlow busprojectproductflow,String projectId) {
		List<BusProjectProductFlow> list = busProjectProductFlowDao.getPageData(pageView,busprojectproductflow,projectId);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<BusProjectProductFlow> getByFlowId(String flowid) {
		// TODO Auto-generated method stub
		return busProjectProductFlowDao.getByFlowId(flowid);
	}

	@Override
	public int conditionSelect(BusProjectProductFlowVo busProjectProductFlowVo) {
		// TODO Auto-generated method stub
		return busProjectProductFlowDao.conditionSelect(busProjectProductFlowVo);
	}

	@Override
	public int delete(BusProjectProductFlow busProjectProductFlow) {
		// TODO Auto-generated method stub
		return busProjectProductFlowDao.delete(busProjectProductFlow);
	}

	@Override
	public int modifyProductFlow(BusProjectProductFlowVo  busProjectProductFlowVo)
	{
		return busProjectProductFlowDao.modifyProductFlow(busProjectProductFlowVo);
	}
}
