package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectFigureProductFlow implements java.io.Serializable {
    private long flowId;
    private int ppid;
    private String bak;
    public BusProjectFigureProductFlow() {
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
    public String getBak() {
        return bak;
    }
    public void setBak(String bak) {
        this.bak =bak;
    }
}

