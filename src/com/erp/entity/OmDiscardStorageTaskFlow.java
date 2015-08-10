package com.erp.entity;

@SuppressWarnings("serial")
public class OmDiscardStorageTaskFlow implements java.io.Serializable {
    private Long flowid;
    private int taskId;
    private int devType;
    private int discardType;
    public OmDiscardStorageTaskFlow() {
    }
    public Long getFlowid() {
        return flowid;
    }
    public void setFlowid(Long flowid) {
        this.flowid =flowid;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId =taskId;
    }
    public int getDevType() {
        return devType;
    }
    public void setDevType(int devType) {
        this.devType =devType;
    }
    public int getDiscardType() {
        return discardType;
    }
    public void setDiscardType(int discardType) {
        this.discardType =discardType;
    }
}

