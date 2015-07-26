package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectFigureFlow implements java.io.Serializable {
    private long flowId;
    private int ppid;
    private String figureLibName;
    private String figureID;
    private String figureName;
    private String figureRequest;
    private int type;
    private int batchNum;
    private String describe;
    public BusProjectFigureFlow() {
    }
    public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public int getPpid() {
        return ppid;
    }
    public void setPpid(int ppid) {
        this.ppid =ppid;
    }
    public String getFigureLibName() {
        return figureLibName;
    }
    public void setFigureLibName(String figureLibName) {
        this.figureLibName =figureLibName;
    }
    public String getFigureID() {
        return figureID;
    }
    public void setFigureID(String figureID) {
        this.figureID =figureID;
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

