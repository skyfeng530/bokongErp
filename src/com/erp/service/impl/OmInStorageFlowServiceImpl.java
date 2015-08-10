package com.erp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.entity.OmInStorageTaskFlow;
import com.erp.service.OmInStorageFlow;
import com.erp.service.OmInStorageFlowService;
import com.erp.util.JsonUtil;

@Transactional
@Service("omInstorageFlowService")
public class OmInStorageFlowServiceImpl implements OmInStorageFlowService {

	private static final String ADD_OMINSTORAGETASKFLOW_SQL = "INSERT INTO OMINSTORAGETASKFLOW(FLOWID, PROJECTID, TASKID, DEVTYPEID, BAK) VALUES(?, ?, ?, ?, ?)";

	private static final String QUERY_OMINSTORAGETASKFLOW_SQL = "SELECT OM.FLOWID, OM.TASKID, P.PROJECTNAME, T.TASKNO, D.DEVNAME FROM OMINSTORAGETASKFLOW OM LEFT JOIN BUSPROJECT P ON  OM.PROJECTID = P.PID LEFT JOIN BUSTASK T ON OM.TASKID = T.TASKID LEFT JOIN DEVICETYPE D ON OM.DEVTYPEID = D.DEVID WHERE OM.FLOWID = ?";

	private static final String QUERY_FIGURE_SQL = "SELECT DISTINCT F.FIGURENO, FIGURENAME FROM BUSTASK T LEFT JOIN BUSPROJECTFIGURE F ON T.FIGURELIB = F.FIGURELIB WHERE TASKID = ?";

	private static final String QUERY_FIGURE_REQ_SQL = "SELECT  PFID, FIGUREREQUEST FROM BUSPROJECTFIGURE WHERE FIGURENO = ?";

	private static final String QUERY_OMINSTORAGEFLOW_SQL = "SELECT FLOWID,OM.PFID, F.FIGURENO, F.FIGURENAME, F.FIGUREREQUEST,DEVBATCHNO,TOTALNUMBER,VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK FROM OMINSTORAGEFLOW OM LEFT JOIN BUSPROJECTFIGURE F ON OM.PFID = F.PFID WHERE OM.FLOWID = ? ";

	private static final String QUERY_OMINSTORAGEFLOW_COUNT_SQL = "SELECT COUNT(0) FROM OMINSTORAGEFLOW WHERE FLOWID = ? ";

	@Resource(name = "commonDao")
	private CommonDao commonDao;

	@Override
	public int saveOmInstorageTaskFlow(OmInStorageTaskFlow omInStorageTaskFlow) {

		return commonDao.update(ADD_OMINSTORAGETASKFLOW_SQL,
				new Object[] { omInStorageTaskFlow.getFlowId(), omInStorageTaskFlow.getProjectid(),
						omInStorageTaskFlow.getTaskId(), omInStorageTaskFlow.getDevtypeid(),
						omInStorageTaskFlow.getBak() });
	}

	@Override
	public List<Map<String, Object>> getOmInstorageFlowInfo(String flowId) {
		return commonDao.queryToList(QUERY_OMINSTORAGETASKFLOW_SQL, flowId);
	}

	@Override
	public List<Map<String, Object>> queryFigureInfo(String taskId) {
		return commonDao.queryToList(QUERY_FIGURE_SQL, taskId);
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

		String addSql = "INSERT INTO OMINSTORAGEFLOW( FLOWID,PFID, DEVBATCHNO,TOTALNUMBER,VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		List<Object[]> objeList = new ArrayList<Object[]>();

		for (OmInStorageFlow inStorageFlow : inStorageFlows) {

			if (null == flowId) {
				flowId = inStorageFlow.getFlowId();
			}

			objeList.add(new Object[] { inStorageFlow.getFlowId(), inStorageFlow.getPfId(),
					inStorageFlow.getDevBatchNo(), inStorageFlow.getTotalNumber(), inStorageFlow.getVendorNo(),
					inStorageFlow.getCheckRst(), inStorageFlow.getCheckNum(), inStorageFlow.getQualifiedNum(),
					inStorageFlow.getUnqualifiedNum(), inStorageFlow.getUnqualifiedGrade(),
					inStorageFlow.getUnqualifiedReason(), inStorageFlow.getReviewRst(), inStorageFlow.getReviewGrp(),
					inStorageFlow.getReviewNo(), inStorageFlow.getGraphicPath(), inStorageFlow.getBak() });
		}

		commonDao.update(deleteSql, flowId);

		return commonDao.batchUpdate(addSql, objeList).length;
	}

	@Override
	public int saveFlowToDb(String flowId, String bustaskId) {

		String saveSql = "INSERT INTO OMINSTORAGE(TASKID, PFID, DEVBATCHNO, TOTALNUMBER,"
				+ " VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,UNQUALIFIEDNUM,UNQUALIFIEDGRADE,"
				+ "UNQUALIFIEDREASON,REVIEWRST,REVIEWGRP,REVIEWNO,GRAPHICPATH,BAK) SELECT"
				+ " ?, PFID, DEVBATCHNO, TOTALNUMBER, VENDORNO,CHECKRST, CHECKNUM,QUALIFIEDNUM,"
				+ "UNQUALIFIEDNUM,UNQUALIFIEDGRADE,UNQUALIFIEDREASON, REVIEWRST,REVIEWGRP,REVIEWNO,"
				+ "GRAPHICPATH,BAK FROM OMINSTORAGEFLOW WHERE FLOWID = ?";

		return commonDao.update(saveSql, new Object[] { bustaskId, flowId });
	}

}
