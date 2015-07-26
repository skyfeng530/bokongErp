package com.erp.entity;

@SuppressWarnings("serial")
public class BusTaskFlow implements java.io.Serializable {
    private long flowId;
    private int taskId;
    private String taskNo;
    private int pid;
    private int ppid;
    private int totalSetNo;
    private String taskSource;
    private String bak;
    public BusTaskFlow() {
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
    public String getTaskNo() {
        return taskNo;
    }
    public void setTaskNo(String taskNo) {
        this.taskNo =taskNo;
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid =pid;
    }
    public int getPpid() {
        return ppid;
    }
    public void setPpid(int ppid) {
        this.ppid =ppid;
    }
    public int getTotalSetNo() {
        return totalSetNo;
    }
    public void setTotalSetNo(int totalSetNo) {
        this.totalSetNo =totalSetNo;
    }
    public String getTaskSource() {
        return taskSource;
    }
    public void setTaskSource(String taskSource) {
        this.taskSource =taskSource;
    }
    public String getBak() {
        return bak;
    }
    public void setBak(String bak) {
        this.bak =bak;
    }
}

