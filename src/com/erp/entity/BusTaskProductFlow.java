package com.erp.entity;

@SuppressWarnings("serial")
public class BusTaskProductFlow implements java.io.Serializable {
    private long flowId;
    private int ppid;
    public BusTaskProductFlow() {
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
}

