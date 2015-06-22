package com.erp.entity;

import java.io.Serializable;
/*
 * 电子流类型表
 */
public class FlowTypeInfo implements Serializable {
    private Integer nIndex;
    private String name;
    private String bak;
	public Integer getnIndex() {
		return nIndex;
	}
	public void setnIndex(Integer nIndex) {
		this.nIndex = nIndex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
    
}

