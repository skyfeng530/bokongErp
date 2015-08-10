package com.erp.entity;

@SuppressWarnings("serial")
public class BusTaskFlow implements java.io.Serializable {
    private Long flowId;
    private String taskNo;
    private Integer totalSetNum;
    private String taskSource;
    private String bak;
    public BusTaskFlow() {
    }
    public Long getFlowId() {
        return flowId;
    }
    public void setFlowId(Long flowId) {
        this.flowId =flowId;
    }
    public String getTaskNo() {
        return taskNo;
    }
    public void setTaskNo(String taskNo) {
        this.taskNo =taskNo;
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
	public Integer getTotalSetNum() {
		return totalSetNum;
	}
	public void setTotalSetNum(Integer totalSetNum) {
		this.totalSetNum = totalSetNum;
	}
    
}
