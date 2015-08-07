package com.erp.entity;

public class BusProjectProductFlowVo {
	private long flowId;
    private String productNo;
    private String productName;
    private String status;
    private String bak;
    private String productNoOld;
    private String productNameOld;
    private String statusOld;
    private int projectId;
   
    public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProductNoOld() {
		return productNoOld;
	}
	public void setProductNoOld(String productNoOld) {
		this.productNoOld = productNoOld;
	}
	public String getProductNameOld() {
		return productNameOld;
	}
	public void setProductNameOld(String productNameOld) {
		this.productNameOld = productNameOld;
	}
	public String getStatusOld() {
		return statusOld;
	}
	public void setStatusOld(String statusOld) {
		this.statusOld = statusOld;
	}
	public long getFlowId() {
        return flowId;
    }
    public void setFlowId(long flowId) {
        this.flowId =flowId;
    }
    public String getProductNo() {
        return productNo;
    }
    public void setProductNo(String productNo) {
        this.productNo =productNo;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName =productName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status =status;
    }
    public String getBak() {
        return bak;
    }
    public void setBak(String bak) {
        this.bak =bak;
    }
}
