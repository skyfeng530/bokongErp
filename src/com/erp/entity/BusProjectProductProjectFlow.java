package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectProductProjectFlow implements java.io.Serializable {
    private long flowId;
    private int projectId;
    public BusProjectProductProjectFlow() {
    }
    public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public int getProjectId() {
        return projectId;
    }
    public void setProjectId(int projectId) {
        this.projectId =projectId;
    }
}

