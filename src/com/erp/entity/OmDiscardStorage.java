package com.erp.entity;

@SuppressWarnings("serial")
public class OmDiscardStorage implements java.io.Serializable {
    private Integer id;
    private int taskId;
    private int devType;
    private int discardType;
    private String figureName;
    private String devNo;
    private String figureId;
    private int num;
    private String discardReason;
    private int questionType;
    private int checkRst;
    private int reviewRst;
    private String reviewNo;
    private String reviewPicture;
    public OmDiscardStorage() {
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
    public int getDevType() {
        return devType;
    }
    public void setDevType(int devType) {
        this.devType =devType;
    }
    public int getDiscardType() {
        return discardType;
    }
    public void setDiscardType(int discardType) {
        this.discardType =discardType;
    }
    public String getFigureName() {
        return figureName;
    }
    public void setFigureName(String figureName) {
        this.figureName =figureName;
    }
    public String getDevNo() {
        return devNo;
    }
    public void setDevNo(String devNo) {
        this.devNo =devNo;
    }
    public String getFigureId() {
        return figureId;
    }
    public void setFigureId(String figureId) {
        this.figureId =figureId;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num =num;
    }
    public String getDiscardReason() {
        return discardReason;
    }
    public void setDiscardReason(String discardReason) {
        this.discardReason =discardReason;
    }
    public int getQuestionType() {
        return questionType;
    }
    public void setQuestionType(int questionType) {
        this.questionType =questionType;
    }
    public int getCheckRst() {
        return checkRst;
    }
    public void setCheckRst(int checkRst) {
        this.checkRst =checkRst;
    }
    public int getReviewRst() {
        return reviewRst;
    }
    public void setReviewRst(int reviewRst) {
        this.reviewRst =reviewRst;
    }
    public String getReviewNo() {
        return reviewNo;
    }
    public void setReviewNo(String reviewNo) {
        this.reviewNo =reviewNo;
    }
    public String getReviewPicture() {
        return reviewPicture;
    }
    public void setReviewPicture(String reviewPicture) {
        this.reviewPicture =reviewPicture;
    }
}

