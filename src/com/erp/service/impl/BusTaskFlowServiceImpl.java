package com.erp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.dao.BusTaskFlowDao;
import com.erp.entity.BusTaskFlow;
import com.erp.service.BusTaskFlowService;
import com.erp.util.PageView;

@Transactional
@Service("bustaskflowService")
public class BusTaskFlowServiceImpl implements BusTaskFlowService {
	@Autowired
	private BusTaskFlowDao busTaskFlowDao;

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	public PageView query(PageView pageView, BusTaskFlow busTaskFlow) {
		List<BusTaskFlow> list = busTaskFlowDao.query(pageView, busTaskFlow);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int add(BusTaskFlow busTaskFlow) {

		String addSql = "INSERT INTO BUSTASKFLOW(FLOWID, TASKNO, TASKSOURCE, TOTALSETNO) VALUES(?, ?, ?, ?)";

		return commonDao.update(addSql, new Object[] { busTaskFlow.getFlowId(), busTaskFlow.getTaskNo(),
				busTaskFlow.getTaskSource(), busTaskFlow.getTotalSetNo() });
	}

	@Override
	public void modify(BusTaskFlow busTaskFlow) {
		busTaskFlowDao.modify(busTaskFlow);
	}

	@Override
	public void delete(String id) {
		String delteSql = "DELETE FROM  BUSTASKFLOW WHERE FLOWID = ?";

		commonDao.update(delteSql, id);
	}

	@Override
	public BusTaskFlow getById(String id) {
		// TODO Auto-generated method stub
		return busTaskFlowDao.getById(id);
	}

	@Override
	public List<Map<String, Object>> queryBusTaskFlowByFlowId(String flowId) {

		String querySql = "SELECT TASKNO, TOTALSETNO, TASKSOURCE FROM BUSTASKFLOW WHERE FLOWID = ?";

		return commonDao.queryToList(querySql, flowId);
	}

}
