package com.erp.entity;

public class FlowTemplateInfo {
	private Integer flowType;
	private Integer nStepIndex;
	private String Url;
	private String name;
	private String stepList;
	private String departIdList;
	public Integer getFlowType() {
		return flowType;
	}
	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}
	public Integer getnStepIndex() {
		return nStepIndex;
	}
	public void setnStepIndex(Integer nStepIndex) {
		this.nStepIndex = nStepIndex;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStepList() {
		return stepList;
	}
	public void setStepList(String stepList) {
		this.stepList = stepList;
	}
	public String getDepartIdList() {
		return departIdList;
	}
	public void setDepartIdList(String departIdList) {
		this.departIdList = departIdList;
	}
}

