function addFormDataToGrid_handler(mNumber) {

	//图号
	var _girdForm_picid = Ext.getCmp("picid").getValue();
	//零件名称
	var _girdForm_ComponentName = Ext.getCmp("componentName").getValue();
	//类别
	var _girdForm_componentType = Ext.getCmp("componentType").getValue();
	//数量
	var _girdForm_Total = Ext.getCmp("total").getValue();
	//零件编号
	var _girdForm_componentNumber = Ext.getCmp("componentNumber").getValue();
	//备注
	var _girdForm_remark = Ext.getCmp("remark_id").getValue();

	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	mNumber++;
	_gridStore.insert(0, new component({
		materialNumber : mNumber,
		idNumber : _girdForm_picid,
		name : _girdForm_ComponentName,
		materialType : _girdForm_componentType,
		codeName : _girdForm_componentNumber,
		totalNumber : _girdForm_Total,
		bak : _girdForm_remark
	}));

};

function category_rendererFunc(value) {
	if (value == "1") {
		return "光学零件";
	} else if (value == "2") {
		return "机械零件";
	} else {
		return "";
	}
};

function workinprocess_rendererFunc(value) {
	if (value == "1") {
		return "是";
	} else if (value == "2") {
		return "否";
	} else {
		return "";
	}
}

function savetime_rendererFunc(value) {
	if (value == "1") {
		return "年";
	} else if (value == "2") {
		return "月";
	} else if (value == "3") {
		return "日";
	} else if (value == "4") {
		return "时";
	} else {
		return "";
	}
}