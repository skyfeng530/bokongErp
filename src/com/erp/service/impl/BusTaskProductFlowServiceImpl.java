package com.erp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.base.CommonDao;
import com.erp.dao.BusTaskProductFlowDao;
import com.erp.entity.BusTaskProductFlow;
import com.erp.service.BusTaskProductFlowService;
import com.erp.util.PageView;

@Transactional
@Service("bustaskproductflowService")
public class BusTaskProductFlowServiceImpl implements BusTaskProductFlowService {
	
    @Autowired
    private BusTaskProductFlowDao busTaskProductFlowDao;
	
	@Resource(name = "commonDao")
	private CommonDao commonDao;

    public PageView query(PageView pageView, BusTaskProductFlow busTaskProductFlow) {
        List<BusTaskProductFlow> list = busTaskProductFlowDao.query(pageView, busTaskProductFlow);
        pageView.setRecords(list);
        return pageView;
    }

    @Override
    public int add(BusTaskProductFlow busTaskProductFlow) {
    	
    	String addSql = "INSERT INTO BUSTASKPRODUCTFLOW(FLOWID, PPID,FIGURELIB,ARTID) VALUES(?, ?, ?,?)";
    	
    	return commonDao.update(addSql, new Object[]{busTaskProductFlow.getFlowId(), 
    			busTaskProductFlow.getPpid(),busTaskProductFlow.getFigureLib(),
    			busTaskProductFlow.getArtId()});
    }

    @Override
    public void modify(BusTaskProductFlow busTaskProductFlow) {
        busTaskProductFlowDao.modify(busTaskProductFlow);
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        busTaskProductFlowDao.delete(id);
    }

    @Override
    public BusTaskProductFlow getById(String id) {
        // TODO Auto-generated method stub
        return busTaskProductFlowDao.getById(id);
    }

	@Override
	public List<Map<String, Object>> queryTaskInfoByFlowId(String flowId) {
		
		String querySql = "SELECT distinct PROJECTNAME, PRODUCTNAME,f.figureLib FROM BUSTASKPRODUCTFLOW F LEFT JOIN BUSPROJECTPRODUCT D ON D.PPID = F.PPID LEFT JOIN BUSPROJECT P ON D.PROJECTID = P.PID LEFT JOIN busprojectfigure b ON b.ppid = D.PPID WHERE F.FLOWID = ?";
		
		return commonDao.queryToList(querySql, flowId);
	}
}
