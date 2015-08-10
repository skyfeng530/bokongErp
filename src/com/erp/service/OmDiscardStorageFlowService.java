package com.erp.service;


import java.util.List;
import java.util.Map;

import com.erp.entity.OmDiscardStorageFlow;
import com.erp.entity.OmDiscardStorageTaskFlow;
import com.erp.util.PageView;

public interface OmDiscardStorageFlowService{
    public PageView query(PageView pageView, OmDiscardStorageFlow omDiscardStorageFlow);

    public int add(OmDiscardStorageTaskFlow omDiscardStorageTaskFlow);

    public int modify(OmDiscardStorageFlow omDiscardStorageFlow, String checkFlag);
    
    public int add(OmDiscardStorageFlow storageFlows);

    public void delete(String id);

    public OmDiscardStorageFlow getById(String id);
    
    public List<Map<String, Object>> queryOmdisCardInfo(String flowId);
    
    public String queryOmDiscardStorageList(String flowId, Integer limit, Integer offset);
    
    public String queryDiscardType(String flowId);
    
    public List<Map<String, Object>> queryDeviceType();
    
    public List<Map<String, Object>> queryProjectInfo();
    
    public List<Map<String, Object>> queryTaskInfo(String projectId);
}
