package com.erp.entity;

import com.erp.util.StringUtil;

@SuppressWarnings("serial")
public class BusProjectFigureFlow implements java.io.Serializable {
	private long flowId;
	// 图ID
	private String figureNo;
	// 图名称
	private String figureName;
	// 图纸要求
	private String figureRequest;
	//
	private int type;
	// 数量
	private int batchNum;
	// 描述
	private String describe;

	public BusProjectFigureFlow() {
	}

	public long getFlowId() {
		return flowId;
	}

	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}

	public String getFigureNo() {
		return figureNo;
	}

	public void setFigureNo(String figureNo) {
		this.figureNo = figureNo;
	}

	public String getFigureName() {
		return figureName;
	}

	public void setFigureName(String figureName) {
		this.figureName = figureName;
	}

	public String getFigureRequest() {
		return figureRequest;
	}

	public void setFigureRequest(String figureRequest) {
		this.figureRequest = figureRequest;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = StringUtil.parseNullStrToEmpty(describe);
	}
}
