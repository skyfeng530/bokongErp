function addFormDataToGrid_handler() {

	var _girdForm_picid = Ext.getCmp("picid").getValue();
	var _girdForm_ComponentName = Ext.getCmp("componentName").getValue();
	var _girdForm_componentType = Ext.getCmp("componentType").getValue();
	var _girdForm_Total = Ext.getCmp("total").getValue();
	var _girdForm_ShelfLife = Ext.getCmp("Shelf_life").getValue();
	var _girdForm_productfrom = Ext.getCmp("productfrom").getValue();
	var _girdForm_MaterialForm = Ext.getCmp("Material_form").getValue();
	var _girdForm_workinprocessFlag = Ext.getCmp("workinprocessFlag")
			.getValue();
	var _girdForm_Measurement_unit = Ext.getCmp("Measurement_unit").getValue();
	var _girdForm_saveTime = Ext.getCmp("saveTimeid").getValue();
	var _girdForm_remark = Ext.getCmp("remark_id").getValue();

	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	_gridStore.insert(0, new component({
		id : "1",
		picid : _girdForm_picid,
		componentName : _girdForm_ComponentName,
		componentType : _girdForm_componentType,
		total : _girdForm_Total,
		shelfLife : _girdForm_ShelfLife,
		productfrom : _girdForm_productfrom,
		materialForm : _girdForm_MaterialForm,
		workinprocessFlag : _girdForm_workinprocessFlag,
		measurementUnit : _girdForm_Measurement_unit,
		saveTime : _girdForm_saveTime,
		remark : _girdForm_remark,
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