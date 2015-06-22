package com.erp.entity;

public class Device {
	private int id;
	private String deviceName;
	private String deviceVersion;
	private String deviceType;
	private int deviceCount;
	private int ischeckout;
	private String manufacturers;
	private String manufacturersPhone;
	private String productDate;
	private String outDate;
	private String deviceStatus;
	private String remark;
	public Device() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public int getDeviceCount() {
		return deviceCount;
	}
	public void setDeviceCount(int deviceCount) {
		this.deviceCount = deviceCount;
	}
	public int getIscheckout() {
		return ischeckout;
	}
	public void setIscheckout(int ischeckout) {
		this.ischeckout = ischeckout;
	}
	public String getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}
	public String getManufacturersPhone() {
		return manufacturersPhone;
	}
	public void setManufacturersPhone(String manufacturersPhone) {
		this.manufacturersPhone = manufacturersPhone;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public String getOutDate() {
		return outDate;
	}
	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}
	public String getDeviceStatus() {
		return deviceStatus;
	}
	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
