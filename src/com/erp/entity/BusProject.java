package com.erp.entity;

@SuppressWarnings("serial")
public class BusProject implements java.io.Serializable {
    private int pid;
    private String projectName;
    private String projectDescribe;
    public BusProject() {
    }
    public int getPid() {
        return pid;
    }
    public void setPid(int pid) {
        this.pid =pid;
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

