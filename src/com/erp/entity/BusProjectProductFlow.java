package com.erp.entity;

@SuppressWarnings("serial")
public class BusProjectProductFlow implements java.io.Serializable {
    private long flowId;
    private String productNo;
    private String productName;
    private String status;
    private String bak;
    public BusProjectProductFlow() {
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

