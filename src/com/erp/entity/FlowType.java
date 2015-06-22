package com.erp.entity;
/**
 * 电子流类型实体表
 */
@SuppressWarnings("serial")

public class FlowType implements java.io.Serializable{
	private String index;

	private String name;

	private String bak;


	public void setFlowTypeIndex(String index) {
		this.index = index;
	}

	public String FlowTypeIndex() {
		return index;
	}

	public void setFlowTypeName(String name) {
		this.name = name;
	}

	public String getFlowTypeName() {
		return name;
	}

	public void setFlowTypeBak(String bak) {
		this.bak = bak;
	}
	public String getFlowTypeBak() {
		return bak;
	}

}
