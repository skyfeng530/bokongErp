package com.erp.entity;

import com.erp.util.StringUtil;

@SuppressWarnings("serial")
public class BusProjectFigureFlowVo implements java.io.Serializable {
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
	
	// 图IDOld
	private String figureNoOld;
	// 图名称Old
	private String figureNameOld;
	// 图纸要求Old
	private String figureRequestOld;
	//Old
	private String typeOld;
	// 数量Old
	private int batchNumOld;
	// 描述Old
	private String describeOld;

	public BusProjectFigureFlowVo() {
	}
	
	public String getFigureNoOld() {
		return figureNoOld;
	}


	public void setFigureNoOld(String figureNoOld) {
		this.figureNoOld = figureNoOld;
	}


	public String getFigureNameOld() {
		return figureNameOld;
	}


	public void setFigureNameOld(String figureNameOld) {
		this.figureNameOld = figureNameOld;
	}


	public String getFigureRequestOld() {
		return figureRequestOld;
	}


	public void setFigureRequestOld(String figureRequestOld) {
		this.figureRequestOld = figureRequestOld;
	}
	
	public String getTypeOld() {
		return typeOld;
	}

	public void setTypeOld(String typeOld) {
		this.typeOld = typeOld;
	}

	public int getBatchNumOld() {
		return batchNumOld;
	}


	public void setBatchNumOld(int batchNumOld) {
		this.batchNumOld = batchNumOld;
	}


	public String getDescribeOld() {
		return describeOld;
	}


	public void setDescribeOld(String describeOld) {
		this.describeOld = describeOld;
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
