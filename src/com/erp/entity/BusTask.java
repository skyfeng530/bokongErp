package com.erp.entity;

@SuppressWarnings("serial")
public class BusTask implements java.io.Serializable {
    private int taskId;
    private String taskNo;
    private int ppid;
    private String projectName;
    private String productName;
    private String productNo;
    private String status;
    private int totalSetNo;
    private String taskSource;
    private String bak;
    public BusTask() {
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
}

