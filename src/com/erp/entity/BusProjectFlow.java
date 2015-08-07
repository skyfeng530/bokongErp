package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectFlow implements java.io.Serializable {
    private long flowId;
    private String projectName;
    private String projectDescribe;
    public BusProjectFlow() {
    }
    public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName =projectName;
    }
    public String getProjectDescribe() {
        return projectDescribe;
    }
    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe =projectDescribe;
    }
}

