package com.erp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.dao.BusProjectFigureFlowDao;
import com.erp.entity.BusProjectFigureFlow;
import com.erp.service.BusProjectFigureFlowService;
import com.erp.util.PageView;

@Transactional
@Service("busprojectfigureflowService")
public class BusProjectFigureFlowServiceImpl implements BusProjectFigureFlowService {
	@Autowired
	private BusProjectFigureFlowDao busProjectFigureFlowDao;

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	public PageView query(PageView pageView, BusProjectFigureFlow busProjectFigureFlow) {
		List<BusProjectFigureFlow> list = busProjectFigureFlowDao.query(pageView, busProjectFigureFlow);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int add(BusProjectFigureFlow busProjectFigureFlow) {
		String sql = "INSERT INTO BUSPROJECTFIGUREFLOW(FLOWID, FIGURENO, FIGURENAME, FIGUREREQUEST, BATCHNUM) VALUES (?, ?, ?, ?, ?)";

		return this.commonDao.update(sql,
				new Object[] { busProjectFigureFlow.getFlowId(), busProjectFigureFlow.getFigureNo(),
						busProjectFigureFlow.getFigureName(), busProjectFigureFlow.getFigureRequest(),
						busProjectFigureFlow.getBatchNum()});
	}

	@Override
	public void modify(BusProjectFigureFlow busProjectFigureFlow) {
		busProjectFigureFlowDao.modify(busProjectFigureFlow);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		busProjectFigureFlowDao.delete(id);
	}

	@Override
	public BusProjectFigureFlow getById(String id) {
		// TODO Auto-generated method stub
		return busProjectFigureFlowDao.getById(id);
	}

	@Override
	public List<Map<String, Object>> queryByPage(int limit, int offset) {
		return busProjectFigureFlowDao.queryByPage(limit, offset);
	}

	@Override
	public int getFiguretotal() {
		return busProjectFigureFlowDao.count();
	}
}
