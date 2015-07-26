package com.erp.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BusProjectFigure implements Serializable {
	  private Integer pfid;
	  private String projectName;
	  private String taskName;
	  private Integer materialType;
	  private String materialNumber;
	  private String subTypeNumber;
	  private String pfName;
	  private String testRequirements;
	  private Integer status;
	  private String bak;
	public Integer getPfid() {
		return pfid;
	}
	public void setPfid(Integer pfid) {
		this.pfid = pfid;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Integer getMaterialType() {
		return materialType;
	}
	public void setMaterialType(Integer materialType) {
		this.materialType = materialType;
	}
	public String getMaterialNumber() {
		return materialNumber;
	}
	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}
	public String getSubTypeNumber() {
		return subTypeNumber;
	}
	public void setSubTypeNumber(String subTypeNumber) {
		this.subTypeNumber = subTypeNumber;
	}
	public String getPfName() {
		return pfName;
	}
	public void setPfName(String pfName) {
		this.pfName = pfName;
	}
	public String getTestRequirements() {
		return testRequirements;
	}
	public void setTestRequirements(String testRequirements) {
		this.testRequirements = testRequirements;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
}
