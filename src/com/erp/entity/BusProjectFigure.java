package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectFigure implements java.io.Serializable {
    private int pfid;
    private int ppid;
    private String figureLib;
    private String figureNo;
    private String figureName;
    private String figureRequest;
    private int type;
    private int batchNum;
    private String describe;
    
    public String getFigureLib() {
		return figureLib;
	}
	public void setFigureLib(String figureLib) {
		this.figureLib = figureLib;
	}
	public BusProjectFigure() {
    }
    public int getPfid() {
        return pfid;
    }
    public void setPfid(int pfid) {
        this.pfid =pfid;
    }
    public int getPpid() {
        return ppid;
    }
    public void setPpid(int ppid) {
        this.ppid =ppid;
    }
    public String getFigureNo() {
        return figureNo;
    }
    public void setFigureNo(String figureNo) {
        this.figureNo =figureNo;
    }
    public String getFigureName() {
        return figureName;
    }
    public void setFigureName(String figureName) {
        this.figureName =figureName;
    }
    public String getFigureRequest() {
        return figureRequest;
    }
    public void setFigureRequest(String figureRequest) {
        this.figureRequest =figureRequest;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type =type;
    }
    public int getBatchNum() {
        return batchNum;
    }
    public void setBatchNum(int batchNum) {
        this.batchNum =batchNum;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe =describe;
    }
}

