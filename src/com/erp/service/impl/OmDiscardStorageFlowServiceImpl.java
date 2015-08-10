package com.erp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.entity.OmDiscardStorageFlow;
import com.erp.entity.OmDiscardStorageTaskFlow;
import com.erp.service.OmDiscardStorageFlowService;
import com.erp.util.JsonUtil;
import com.erp.util.PageView;

@Transactional
@Service("omdiscardstorageflowService")
public class OmDiscardStorageFlowServiceImpl implements OmDiscardStorageFlowService {

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	@Override
	public PageView query(PageView pageView, OmDiscardStorageFlow omDiscardStorageFlow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(OmDiscardStorageTaskFlow omDiscardStorageTaskFlow) {
		String addSql = "INSERT INTO OMDISCARDSTORAGETASKFLOW(FLOWID, TASKID, DEVTYPE, DISCARDTYPE) VALUES (?, ?, ?, ?)";

		return commonDao.update(addSql,
				new Object[] { omDiscardStorageTaskFlow.getFlowid(), omDiscardStorageTaskFlow.getTaskId(),
						omDiscardStorageTaskFlow.getDevType(), omDiscardStorageTaskFlow.getDiscardType() });

	}

	@Override
	public int modify(OmDiscardStorageFlow omDiscardStorageFlow, String checkFlag) {
		if ("1".equals(checkFlag)) {
			String updateSql = "UPDATE OMDISCARDSTORAGEFLOW SET CHECKRST = ? WHERE DEVNO = ? AND FLOWID = ?";
			return commonDao.update(updateSql, new Object[] { omDiscardStorageFlow.getCheckRst(),
					omDiscardStorageFlow.getDevNo(), omDiscardStorageFlow.getFlowId() });
		} else {
			String updateSql = "UPDATE OMDISCARDSTORAGEFLOW SET REVIEWRST = ?, REVIEWNO = ? WHERE DEVNO = ? AND FLOWID = ?";
			return commonDao.update(updateSql,
					new Object[] { omDiscardStorageFlow.getReviewRst(), omDiscardStorageFlow.getReviewNo(),
							omDiscardStorageFlow.getDevNo(), omDiscardStorageFlow.getFlowId() });
		}

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public OmDiscardStorageFlow getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> queryOmdisCardInfo(String flowId) {

		String querySql = "SELECT B.TASKNO, D.DEVNAME, OM.DISCARDTYPE, PT.PROJECTNAME FROM OMDISCARDSTORAGETASKFLOW OM LEFT JOIN BUSTASK B ON B.TASKID = OM.TASKID LEFT JOIN DEVICETYPE D ON D.DEVID = OM.DEVTYPE LEFT JOIN BUSPROJECT PT ON PT.PID = B.PPID WHERE FLOWID = ?";

		return commonDao.queryToList(querySql, flowId);
	}

	@Override
	public int add(OmDiscardStorageFlow storageFlows) {

		String addSql = "INSERT INTO OMDISCARDSTORAGEFLOW(FLOWID, FIGURENAME, DEVNO, FIGUREID, NUM, DISCARDREASON, QUESTIONTYPE)VALUES(?, ?, ?, ?, ?, ?, ?)";

		return commonDao.update(addSql,
				new Object[] { storageFlows.getFlowId(), storageFlows.getFigureName(), storageFlows.getDevNo(),
						storageFlows.getFigureId(), storageFlows.getNum(), storageFlows.getDiscardReason(),
						storageFlows.getQuestionType() });
	}

	@Override
	public String queryOmDiscardStorageList(String flowId, Integer limit, Integer offset) {
		String querySql = "SELECT FLOWID, FIGURENAME, DEVNO, FIGUREID, NUM, DISCARDREASON, QUESTIONTYPE,"
				+ " CHECKRST, REVIEWRST, REVIEWNO, REVIEWPICTURE FROM OMDISCARDSTORAGEFLOW WHERE FLOWID = ? LIMIT "
				+ limit + " OFFSET " + offset;

		List<Map<String, Object>> queryList = commonDao.queryToList(querySql, flowId);

		String countSql = "SELECT COUNT(0) FROM OMDISCARDSTORAGEFLOW WHERE FLOWID = ?";

		int total = commonDao.queryToint(countSql, flowId);

		return JsonUtil.parseListToJson(queryList, total);
	}

	@Override
	public String queryDiscardType(String flowId) {
		String querySql = "SELECT DISCARDTYPE FROM OMDISCARDSTORAGETASKFLOW WHERE FLOWID = ?";

		return commonDao.queryToObject(querySql, String.class);
	}

	@Override
	public List<Map<String, Object>> queryDeviceType() {
		String querySql = "SELECT DEVID, DEVNAME FROM DEVICETYPE";

		return commonDao.queryToList(querySql);
	}

	@Override
	public List<Map<String, Object>> queryProjectInfo() {
		String querySql = "SELECT PID, PROJECTNAME, PROJECTDESCRIBE FROM BUSPROJECT";
		
		return commonDao.queryToList(querySql);
	}

	@Override
	public List<Map<String, Object>> queryTaskInfo(String projectId) {
		
		String querySql = "SELECT TASKID, TASKNO FROM BUSTASK WHERE PPID = ?";
		
		return commonDao.queryToList(querySql, projectId);
	}
}
