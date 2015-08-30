package com.erp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.entity.OmInStorageAssistance;
import com.erp.entity.OmInStorageTaskFlow;
import com.erp.service.OmInStorageFlow;
import com.erp.service.OmInStorageFlowService;
import com.erp.util.JsonUtil;

@Transactional
@Service("omInstorageFlowService")
public class OmInStorageFlowServiceImpl implements OmInStorageFlowService {

	private static final String ADD_OMINSTORAGETASKFLOW_SQL = "INSERT INTO OMINSTORAGETASKFLOW(FLOWID, ISAID, PROJECTID, TASKID, DEVTYPEID, BAK) VALUES(?, ?, ?, ?, ?, ?)";

	private static final String QUERY_OMINSTORAGETASKFLOW_SQL = "SELECT OM.FLOWID, OM.TASKID, P.PROJECTNAME, T.TASKNO, D.DEVID, D.DEVNAME, A.BATCHNO FROM OMINSTORAGETASKFLOW OM LEFT JOIN BUSPROJECT P ON OM.PROJECTID = P.PID LEFT JOIN BUSTASK T ON OM.TASKID = T.TASKID LEFT JOIN DEVICETYPE D ON OM.DEVTYPEID = D.DEVID LEFT JOIN OMINSTORAGEASSISTANCE A ON A.ID = OM.ISAID WHERE OM.FLOWID = ?";

	private static final String QUERY_FIGURE_SQL = "SELECT DISTINCT F.FIGURENO, FIGURENAME FROM BUSTASK T LEFT JOIN BUSPROJECTFIGURE F ON T.FIGURELIB = F.FIGURELIB WHERE TASKID = ? AND F.TYPE = ?";

	private static final String QUERY_FIGURE_REQ_SQL = "SELECT PFID, FIGUREREQUEST FROM BUSPROJECTFIGURE WHERE FIGURENO = ?";

	private static final String QUERY_OMINSTORAGEFLOW_SQL = "SELECT FLOWID,OM.PFID, F.FIGURENO, F.FIGURENAME, F.FIGUREREQUEST, CONCAT('P',DEVBATCHNO,'-', DEVNO) AS DEVBATCHNO,TOTALNUMBER,VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK FROM OMINSTORAGEFLOW OM LEFT JOIN BUSPROJECTFIGURE F ON OM.PFID = F.PFID WHERE OM.FLOWID = ?";

	private static final String QUERY_OMINSTORAGEFLOW_COUNT_SQL = "SELECT COUNT(0) FROM OMINSTORAGEFLOW WHERE FLOWID = ? ";

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	@Override
	public int saveOmInstorageTaskFlow(OmInStorageTaskFlow omInStorageTaskFlow) {

		String querySql = "SELECT MAX(ID) FROM OMINSTORAGEASSISTANCE WHERE TASKID = ?";

		int isaId = commonDao.queryToint(querySql, omInStorageTaskFlow.getTaskId());

		return commonDao.update(ADD_OMINSTORAGETASKFLOW_SQL,
				new Object[] { omInStorageTaskFlow.getFlowId(), isaId, omInStorageTaskFlow.getProjectid(),
						omInStorageTaskFlow.getTaskId(), omInStorageTaskFlow.getDevtypeid(),
						omInStorageTaskFlow.getBak() });
	}

	@Override
	public List<Map<String, Object>> getOmInstorageFlowInfo(String flowId) {
		return commonDao.queryToList(QUERY_OMINSTORAGETASKFLOW_SQL, flowId);
	}

	@Override
	public List<Map<String, Object>> queryFigureInfo(String taskId, String deviceType) {
		return commonDao.queryToList(QUERY_FIGURE_SQL, new Object[] { taskId, deviceType });
	}

	@Override
	public List<Map<String, Object>> queryFigureReqInfo(String figureno) {
		return commonDao.queryToList(QUERY_FIGURE_REQ_SQL, figureno);
	}

	@Override
	public String queryOmInStorageFlowList(String flowId, String unqualifiedGrade, int limit, int offset) {

		List<Map<String, Object>> omInstorageFlowList = null;

		int totalResult = 0;

		if (!StringUtils.isEmpty(unqualifiedGrade)) {
			String querySql = QUERY_OMINSTORAGEFLOW_SQL + " AND OM.UNQUALIFIEDGRADE <> ? LIMIT " + limit + " OFFSET "
					+ offset;

			String countSql = QUERY_OMINSTORAGEFLOW_COUNT_SQL + " AND UNQUALIFIEDGRADE <> ?";

			omInstorageFlowList = commonDao.queryToList(querySql, new Object[] { flowId, unqualifiedGrade });

			totalResult = commonDao.queryToint(countSql, new Object[] { flowId, unqualifiedGrade });
		} else {

			omInstorageFlowList = commonDao
					.queryToList(QUERY_OMINSTORAGEFLOW_SQL + "LIMIT " + limit + " OFFSET " + offset, flowId);

			totalResult = commonDao.queryToint(QUERY_OMINSTORAGEFLOW_COUNT_SQL, flowId);
		}

		return JsonUtil.parseListToJson(omInstorageFlowList, totalResult);
	}

	@Override
	@Transactional
	public int add(List<OmInStorageFlow> inStorageFlows) {

		if (CollectionUtils.isEmpty(inStorageFlows)) {
			return 0;
		}

		Long flowId = null;

		String deleteSql = "DELETE FROM OMINSTORAGEFLOW WHERE FLOWID = ?";

		String addSql = "INSERT INTO OMINSTORAGEFLOW( FLOWID,PFID, DEVNO, DEVBATCHNO,TOTALNUMBER,VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		List<Object[]> objeList = new ArrayList<Object[]>();

		String[] devNo = null;

		for (OmInStorageFlow inStorageFlow : inStorageFlows) {

			if (null == flowId) {
				flowId = inStorageFlow.getFlowId();
			}

			devNo = splitBatchNum(inStorageFlow.getDevBatchNo());

			objeList.add(new Object[] { inStorageFlow.getFlowId(), inStorageFlow.getPfId(), devNo[1], devNo[0],
					inStorageFlow.getTotalNumber(), inStorageFlow.getVendorNo(), inStorageFlow.getCheckRst(),
					inStorageFlow.getCheckNum(), inStorageFlow.getQualifiedNum(), inStorageFlow.getUnqualifiedNum(),
					inStorageFlow.getUnqualifiedGrade(), inStorageFlow.getUnqualifiedReason(),
					inStorageFlow.getReviewRst(), inStorageFlow.getReviewGrp(), inStorageFlow.getReviewNo(),
					inStorageFlow.getGraphicPath(), inStorageFlow.getBak() });
		}

		commonDao.update(deleteSql, flowId);

		return commonDao.batchUpdate(addSql, objeList).length;
	}

	private String[] splitBatchNum(String batchNo) {
		String[] devNo = batchNo.split("\\-");

		devNo[0] = NumberUtils.toInt(devNo[0].substring(1, devNo[0].length())) + "";

		return devNo;
	}

	@Override
	public int saveFlowToDb(String flowId, String bustaskId) {

		String saveSql = "INSERT INTO OMINSTORAGE(TASKID, PFID, DEVNO, DEVBATCHNO, TOTALNUMBER,"
				+ " VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,"
				+ "UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK) SELECT"
				+ " ?, PFID, DEVNO, DEVBATCHNO, TOTALNUMBER, VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,"
				+ "UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON, REVIEWRST,REVIEWGRP,REVIEWNO,"
				+ "GRAPHICPATH,BAK FROM OMINSTORAGEFLOW WHERE FLOWID = ?";

		return commonDao.update(saveSql, new Object[] { bustaskId, flowId });
	}

	@Override
	public boolean saveOmInStorageAssistance(OmInStorageAssistance assistance) {

		String querySql = "SELECT MAX(BATCHNO) FROM OMINSTORAGEASSISTANCE";

		int maxValue = commonDao.queryToint(querySql);

		maxValue += 1;

		String addSql = "INSERT INTO OMINSTORAGEASSISTANCE(TASKID, BATCHNO, GRAPHICPATH) VALUES (?, ?, ?)";
		return commonDao.update(addSql,
				new Object[] { assistance.getTaskId(), maxValue, assistance.getGraphicPath() }) > 0;
	}

	@Override
	public int getMaxNo(String flowId) {
		String queryCountSql = "SELECT COUNT(0) FROM OMINSTORAGEFLOW WHERE FLOWID = ?";
		String querySql = "SELECT MAX(DEVNO) FROM OMINSTORAGEFLOW WHERE FLOWID = ?";

		int count = commonDao.queryToint(queryCountSql, flowId);

		if (count == 0) {
			return 1;
		}

		return commonDao.queryToint(querySql, flowId) + 1;
	}

	@Override
	public int removeAllRecord(String flowId) {
		String deleteSql = "DELETE FROM OMINSTORAGEFLOW WHERE FLOWID = ?";
		return commonDao.update(deleteSql, flowId);
	}

}
