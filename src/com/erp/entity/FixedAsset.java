package com.erp.entity;

@SuppressWarnings("serial")
public class FixedAsset implements java.io.Serializable {
    private Integer id;
    private String name;
    private String tagNumber;
    private String specifications;
    private String serialNumber;
    private String status;
    private String price;
    private String enableDate;
    private String responsiblePerson;
    private String usePerson;
    private String equipmentPosition;
    private String assetClass;
    private String vendorInfo;
    private String remark;
    public FixedAsset() {
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
    public String getTagNumber() {
        return tagNumber;
    }
    public void setTagNumber(String tagNumber) {
        this.tagNumber =tagNumber;
    }
    public String getSpecifications() {
        return specifications;
    }
    public void setSpecifications(String specifications) {
        this.specifications =specifications;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber =serialNumber;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status =status;
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
    public String getResponsiblePerson() {
        return responsiblePerson;
    }
    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson =responsiblePerson;
    }
    public String getUsePerson() {
        return usePerson;
    }
    public void setUsePerson(String usePerson) {
        this.usePerson =usePerson;
    }
    public String getEquipmentPosition() {
        return equipmentPosition;
    }
    public void setEquipmentPosition(String equipmentPosition) {
        this.equipmentPosition =equipmentPosition;
    }
    public String getAssetClass() {
        return assetClass;
    }
    public void setAssetClass(String assetClass) {
        this.assetClass =assetClass;
    }
    public String getVendorInfo() {
        return vendorInfo;
    }
    public void setVendorInfo(String vendorInfo) {
        this.vendorInfo =vendorInfo;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark =remark;
    }
}

