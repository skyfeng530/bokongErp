package com.erp.entity;

//入库电子流第一步,清点录入
public class StorageComponent {
	private String procInstID; // 流程实例ID
	private String storageID; // 流程实例ID
	private String materialNumber; // 物料序号
	private Integer idNumber; // 图号编码
	private Integer subType; // 子类型
	private String name; // 名称
	private String codeName; // 零件编码
	private String AssistantCode; // 助记码
	private String material; // 材质
	private String shape; // 物料形态
	private Integer materialType; // 物料类别
	private String proType; // 产品序列
	private Integer totalNumber; // 总数量
	private String msmUnit; // 计量单位
	private String msmUnit2; // 辅助计量单位
	private Integer savePeriod; // 保存周期
	private Integer savePeriodUnit; // 保存周期单位
	private Integer trusteeship; // 寄存标志
	private Integer wip_Sign; // 在制品标志
	private Integer beforeFailure; // 失效前提醒
	private String savePos; // 存储位置
	private String nSize; // 尺寸
	private Integer inspectionMode; // 检验方式
	private String productSource; // 产品来源
	private String transferPerson; // 交接人员
	private String transferTime; // 交接时间
	private String bak; // 备注

	public String getProcInstID() {
		return procInstID;
	}

	public void setProcInstID(String procInstID) {
		this.procInstID = procInstID;
	}

	public String getMaterialNumber() {
		return materialNumber;
	}

	public void setMaterialNumber(String materialNumber) {
		this.materialNumber = materialNumber;
	}

	public Integer getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(Integer idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getSubType() {
		return subType;
	}

	public void setSubType(Integer subType) {
		this.subType = subType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getAssistantCode() {
		return AssistantCode;
	}

	public void setAssistantCode(String assistantCode) {
		AssistantCode = assistantCode;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Integer getMaterialType() {
		return materialType;
	}

	public void setMaterialType(Integer materialType) {
		this.materialType = materialType;
	}

	public String getProType() {
		return proType;
	}

	public void setProType(String proType) {
		this.proType = proType;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getMsmUnit() {
		return msmUnit;
	}

	public void setMsmUnit(String msmUnit) {
		this.msmUnit = msmUnit;
	}

	public String getMsmUnit2() {
		return msmUnit2;
	}

	public void setMsmUnit2(String msmUnit2) {
		this.msmUnit2 = msmUnit2;
	}

	public Integer getSavePeriod() {
		return savePeriod;
	}

	public void setSavePeriod(Integer savePeriod) {
		this.savePeriod = savePeriod;
	}

	public Integer getSavePeriodUnit() {
		return savePeriodUnit;
	}

	public void setSavePeriodUnit(Integer savePeriodUnit) {
		this.savePeriodUnit = savePeriodUnit;
	}

	public Integer getTrusteeship() {
		return trusteeship;
	}

	public void setTrusteeship(Integer trusteeship) {
		this.trusteeship = trusteeship;
	}

	public Integer getWip_Sign() {
		return wip_Sign;
	}

	public void setWip_Sign(Integer wip_Sign) {
		this.wip_Sign = wip_Sign;
	}

	public Integer getBeforeFailure() {
		return beforeFailure;
	}

	public void setBeforeFailure(Integer beforeFailure) {
		this.beforeFailure = beforeFailure;
	}

	public String getSavePos() {
		return savePos;
	}

	public void setSavePos(String savePos) {
		this.savePos = savePos;
	}

	public String getnSize() {
		return nSize;
	}

	public void setnSize(String nSize) {
		this.nSize = nSize;
	}

	public Integer getInspectionMode() {
		return inspectionMode;
	}

	public void setInspectionMode(Integer inspectionMode) {
		this.inspectionMode = inspectionMode;
	}

	public String getProductSource() {
		return productSource;
	}

	public void setProductSource(String productSource) {
		this.productSource = productSource;
	}

	public String getTransferPerson() {
		return transferPerson;
	}

	public void setTransferPerson(String transferPerson) {
		this.transferPerson = transferPerson;
	}

	public String getTransferTime() {
		return transferTime;
	}

	public void setTransferTime(String transferTime) {
		this.transferTime = transferTime;
	}

	public String getBak() {
		return bak;
	}

	public void setBak(String bak) {
		this.bak = bak;
	}

}
