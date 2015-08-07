package com.erp.entity;

@SuppressWarnings("serial")
public class BusMaterialInfoTaskFlow implements java.io.Serializable {
    private long flowId;
    private int taskId;
    public BusMaterialInfoTaskFlow() {
    }
    public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId =taskId;
    }
}

