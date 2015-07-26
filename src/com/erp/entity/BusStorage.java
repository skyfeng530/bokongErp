package com.erp.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 入库申请单实体类
 * @author Administrator
 */
public class BusStorage {
	private String projectInfoID;
	private String flowRecordInfoID;
	private List<StorageFlowResult> storages = new ArrayList<StorageFlowResult>(0);
	
	public String getProjectInfoID() {
		return projectInfoID;
	}
	public void setProjectInfoID(String projectInfoID) {
		this.projectInfoID = projectInfoID;
	}
	public String getFlowRecordInfoID() {
		return flowRecordInfoID;
	}
	public void setFlowRecordInfoID(String flowRecordInfoID) {
		this.flowRecordInfoID = flowRecordInfoID;
	}
	public List<StorageFlowResult> getStorages() {
		return storages;
	}
	public void setStorages(List<StorageFlowResult> storages) {
		this.storages = storages;
	}
	
	/*第二步：检验建议合并到StorageComponent元器件类
	private String MaterialNumber;		// 物料序号
	private String TestRequirements;	// 图纸要求
	private String RealNumber;			// 实际检验数
	private String TestResult;			// 检验结果
	private String TestPerson;			// 检验人员
	private String TestTime;			// 检验时间
	private String level;				// 合格程度
	*/
	/*第三步：审核建议合并到BusStorage入库单类
	private String MaterialNumber;		// 物料序号
	private Integer TrialOrganization;	// 审理组织
	private String Results;			// 审理结果
	private String TrialPersonnel;		// 审理人员
	private String HandlePerson;		// 召集人
	private String TrialTime;			// 审理时间
	private String bak;				// 备注
	*/
}
