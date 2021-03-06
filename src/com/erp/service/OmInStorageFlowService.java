/**
 * 
 */
package com.erp.service;

import java.util.List;
import java.util.Map;

import com.erp.entity.OmInStorageAssistance;
import com.erp.entity.OmInStorageTaskFlow;

/**
 * @author jason_000
 *
 */
public interface OmInStorageFlowService {

	public int saveOmInstorageTaskFlow(OmInStorageTaskFlow omInStorageTaskFlow);

	public List<Map<String, Object>> getOmInstorageFlowInfo(String flowId);

	public List<Map<String, Object>> queryFigureInfo(String taskId, String deviceType);

	public List<Map<String, Object>> queryFigureReqInfo(String figureno);

	public String queryOmInStorageFlowList(String flowId, String unqualifiedGrade, int limit, int offset);

	public int add(List<OmInStorageFlow> inStorageFlows);

	public int saveFlowToDb(String flowId, String bustaskId);

	public boolean saveOmInStorageAssistance(OmInStorageAssistance assistance);
	
	public int getMaxNo(String flowId);
	
	public int removeAllRecord(String flowId);
}
