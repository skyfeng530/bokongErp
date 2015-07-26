package com.erp.entity;

import java.io.Serializable;

/**
 * 出库申请单实体类
 * @author Administrator
 */
@SuppressWarnings("serial")
public class BusStorageOut implements Serializable{
	
	//项目名称
	private String ProjectName;
	
	//任务编号
	private String TaskNumber;
	
	//器件类型
	private String DeviceType;
	
	//出库方式
	private String LibraryMode;
	
	//套数
	private int PloidyNum;

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getTaskNumber() {
		return TaskNumber;
	}

	public void setTaskNumber(String taskNumber) {
		TaskNumber = taskNumber;
	}

	public String getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}

	public String getLibraryMode() {
		return LibraryMode;
	}

	public void setLibraryMode(String libraryMode) {
		LibraryMode = libraryMode;
	}

	public int getPloidyNum() {
		return PloidyNum;
	}

	public void setPloidyNum(int ploidyNum) {
		PloidyNum = ploidyNum;
	}
	
}
