package com.erp.entity;

@SuppressWarnings("serial")
public class InstrumentDevice implements java.io.Serializable {
    private Integer id;
    private String name;
    private String specifications;
    private String instrumentNumber;
    private String assetNumber;
    private String usePerson;
    private String manufacturer;
    private String instrumentType;
    private String status;
    private String measurementInfo;
    private String price;
    private String enableDate;
    private String tagNumber;
    private Integer verifyCycle;
    private String validDate;
    private String equipmentPosition;
    private String calibrationVerify;
    private int hintVerifyDays;
    private String bak;
    public InstrumentDevice() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id =id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name =name;
    }
    public String getSpecifications() {
        return specifications;
    }
    public void setSpecifications(String specifications) {
        this.specifications =specifications;
    }
    public String getInstrumentNumber() {
        return instrumentNumber;
    }
    public void setInstrumentNumber(String instrumentNumber) {
        this.instrumentNumber =instrumentNumber;
    }
    public String getAssetNumber() {
        return assetNumber;
    }
    public void setAssetNumber(String assetNumber) {
        this.assetNumber =assetNumber;
    }
    public String getUsePerson() {
        return usePerson;
    }
    public void setUsePerson(String usePerson) {
        this.usePerson =usePerson;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer =manufacturer;
    }
    public String getInstrumentType() {
        return instrumentType;
    }
    public void setInstrumentType(String instrumentType) {
        this.instrumentType =instrumentType;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status =status;
    }
    public String getMeasurementInfo() {
        return measurementInfo;
    }
    public void setMeasurementInfo(String measurementInfo) {
        this.measurementInfo =measurementInfo;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price =price;
    }
    public String getEnableDate() {
        return enableDate;
    }
    public void setEnableDate(String enableDate) {
        this.enableDate =enableDate;
    }
    public String getTagNumber() {
        return tagNumber;
    }
    public void setTagNumber(String tagNumber) {
        this.tagNumber =tagNumber;
    }
    public Integer getVerifyCycle() {
        return verifyCycle;
    }
    public void setVerifyCycle(Integer verifyCycle) {
        this.verifyCycle =verifyCycle;
    }
    public String getValidDate() {
        return validDate;
    }
    public void setValidDate(String validDate) {
        this.validDate =validDate;
    }
    public String getEquipmentPosition() {
        return equipmentPosition;
    }
    public void setEquipmentPosition(String equipmentPosition) {
        this.equipmentPosition =equipmentPosition;
    }
    public String getCalibrationVerify() {
        return calibrationVerify;
    }
    public void setCalibrationVerify(String calibrationVerify) {
        this.calibrationVerify =calibrationVerify;
    }
    public int getHintVerifyDays() {
		return hintVerifyDays;
	}
	public void setHintVerifyDays(int hintVerifyDays) {
		this.hintVerifyDays = hintVerifyDays;
	}
	public String getBak() {
        return bak;
    }
    public void setBak(String bak) {
        this.bak =bak;
    }
}

