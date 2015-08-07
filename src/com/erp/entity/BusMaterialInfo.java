package com.erp.entity;

@SuppressWarnings("serial")
public class BusMaterialInfo implements java.io.Serializable {
    private Integer id;
    private int taskId;
    private int pfid;
    private Integer totalNumber;
    private String vendorNo;
    private String checkRst;
    private int checkNum;
    private int qualifiedNum;
    private int unqualifiedNum;
    private int unqualifiedGrade;
    private String unqualifiedReason;
    private int reviewRst;
    private int reviewGrp;
    private String reviewNo;
    private String graphicPath;
    private String bak;
    public BusMaterialInfo() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id =id;
    }
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId =taskId;
    }
    public int getPfid() {
        return pfid;
    }
    public void setPfid(int pfid) {
        this.pfid =pfid;
    }
    public Integer getTotalNumber() {
        return totalNumber;
    }
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber =totalNumber;
    }
    public String getVendorNo() {
        return vendorNo;
    }
    public void setVendorNo(String vendorNo) {
        this.vendorNo =vendorNo;
    }
    public String getCheckRst() {
        return checkRst;
    }
    public void setCheckRst(String checkRst) {
        this.checkRst =checkRst;
    }
    public int getCheckNum() {
        return checkNum;
    }
    public void setCheckNum(int checkNum) {
        this.checkNum =checkNum;
    }
    public int getQualifiedNum() {
        return qualifiedNum;
    }
    public void setQualifiedNum(int qualifiedNum) {
        this.qualifiedNum =qualifiedNum;
    }
    public int getUnqualifiedNum() {
        return unqualifiedNum;
    }
    public void setUnqualifiedNum(int unqualifiedNum) {
        this.unqualifiedNum =unqualifiedNum;
    }
    public int getUnqualifiedGrade() {
        return unqualifiedGrade;
    }
    public void setUnqualifiedGrade(int unqualifiedGrade) {
        this.unqualifiedGrade =unqualifiedGrade;
    }
    public String getUnqualifiedReason() {
        return unqualifiedReason;
    }
    public void setUnqualifiedReason(String unqualifiedReason) {
        this.unqualifiedReason =unqualifiedReason;
    }
    public int getReviewRst() {
        return reviewRst;
    }
    public void setReviewRst(int reviewRst) {
        this.reviewRst =reviewRst;
    }
    public int getReviewGrp() {
        return reviewGrp;
    }
    public void setReviewGrp(int reviewGrp) {
        this.reviewGrp =reviewGrp;
    }
    public String getReviewNo() {
        return reviewNo;
    }
    public void setReviewNo(String reviewNo) {
        this.reviewNo =reviewNo;
    }
    public String getGraphicPath() {
        return graphicPath;
    }
    public void setGraphicPath(String graphicPath) {
        this.graphicPath =graphicPath;
    }
    public String getBak() {
        return bak;
    }
    public void setBak(String bak) {
        this.bak =bak;
    }
}

