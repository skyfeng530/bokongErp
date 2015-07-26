package com.erp.entity;

public class BusStorageOutInput {

	//图号
	private int PictureNo;
	//子图号
	private int ChildPictureNo;
	//图名称
	private String PictureName;
	//图纸要求
	private String PictureRequire;
	//配套数
	private int PloidyNum;
	//应领数量
	private int ShouldReceiveNum;
	//实领数量
	private int RealReceiveNum;
	public int getPictureNo() {
		return PictureNo;
	}
	public void setPictureNo(int pictureNo) {
		PictureNo = pictureNo;
	}
	public int getChildPictureNo() {
		return ChildPictureNo;
	}
	public void setChildPictureNo(int childPictureNo) {
		ChildPictureNo = childPictureNo;
	}
	public String getPictureName() {
		return PictureName;
	}
	public void setPictureName(String pictureName) {
		PictureName = pictureName;
	}
	public String getPictureRequire() {
		return PictureRequire;
	}
	public void setPictureRequire(String pictureRequire) {
		PictureRequire = pictureRequire;
	}
	public int getPloidyNum() {
		return PloidyNum;
	}
	public void setPloidyNum(int ploidyNum) {
		PloidyNum = ploidyNum;
	}
	public int getShouldReceiveNum() {
		return ShouldReceiveNum;
	}
	public void setShouldReceiveNum(int shouldReceiveNum) {
		ShouldReceiveNum = shouldReceiveNum;
	}
	public int getRealReceiveNum() {
		return RealReceiveNum;
	}
	public void setRealReceiveNum(int realReceiveNum) {
		RealReceiveNum = realReceiveNum;
	}
}
