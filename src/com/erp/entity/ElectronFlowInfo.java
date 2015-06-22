package com.erp.entity;

import java.io.Serializable;
/*
 * 电子流信息表
 */

@SuppressWarnings("serial")
public class ElectronFlowInfo implements Serializable {
	private String number;             //电子流流水号
    private Integer flowType;			//类型
    private String  name;               //名称，用户填写
    private Integer  nIndex;           //操作记录顺序号，一直增加1
    private Integer stepNumber;        //步骤号
    private String handles;            //当前处理人        
    private Integer state;				//当前状态，1，表示未关闭
    private String createPerson;
    private String createTime;
    private String closePerson;
    private String closeTime;
    private String bak;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getFlowType() {
		return flowType;
	}
	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getnIndex() {
		return nIndex;
	}
	public void setnIndex(Integer nIndex) {
		this.nIndex = nIndex;
	}
	public Integer getStepNumber() {
		return stepNumber;
	}
	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}
	public String getHandles() {
		return handles;
	}
	public void setHandles(String handles) {
		this.handles = handles;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getClosePerson() {
		return closePerson;
	}
	public void setClosePerson(String closePerson) {
		this.closePerson = closePerson;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
    
}

