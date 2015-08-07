function checkPage_dataGrid_handler() {
	var _checkGrid = Ext.getCmp("_gridPanel_id");

	var _gridStore = _checkGrid.getStore();

	var rs = _checkGrid.getSelectionModel().getSelections();

	if (rs.length == 0) {
		Ext.Msg.alert("提示", "请先选择要修改的记录.");
		return;
	}

	if (!Ext.getCmp("Require_id").isValid()
			|| !Ext.getCmp("unqualifiedType_id").isValid()
			|| !Ext.getCmp("componentType").isValid()
			|| !Ext.getCmp("remark_id").isValid()) {
		return;
	}

	var _requireValue = Ext.getCmp("Require_id").getValue();
	var _unqualifiedTypeValue = Ext.getCmp("unqualifiedType_id").getValue();
	var _componentTypeValue = Ext.getCmp("componentType").getValue();
	var _remarkValue = Ext.getCmp("remark_id").getValue();
	var _inspectionModeValue = Ext.getCmp("validMethod_Id").getValue();

	for (var i = 0; i < rs.length; i++) {
		rs[i].set("TestRequirements", _requireValue);
		rs[i].set("testLevel", _unqualifiedTypeValue);
		rs[i].set("TestResult", _componentTypeValue);
		rs[i].set("inspectionMode", _inspectionModeValue);
		rs[i].set("bak", _remarkValue);
		rs[i].commit();
	}

	Ext.getCmp("Require_id").reset();
	Ext.getCmp("unqualifiedType_id").reset();
	Ext.getCmp("componentType").reset();
	Ext.getCmp("remark_id").reset();
	Ext.getCmp("validMethod_Id").reset();
}

function manageApproval_dataGrid_handler() {
	var _checkGrid = Ext.getCmp("_gridPanel_id");

	var _gridStore = _checkGrid.getStore();

	var rs = _checkGrid.getSelectionModel().getSelections();

	if (rs.length == 0) {
		Ext.Msg.alert("提示", "请先选择要修改的记录.");
		return;
	}

	if (!Ext.getCmp("saveLocaton_Id").isValid()) {
		return;
	}

	var _savePos = Ext.getCmp("saveLocaton_Id").getValue();

	for (var i = 0; i < rs.length; i++) {
		rs[i].set("savePos", _savePos);
		rs[i].commit();
	}

	Ext.getCmp("saveLocaton_Id").reset();
}

function addFormDataToGrid_handler() {

	if (!Ext.getCmp("picid").isValid()
			|| !Ext.getCmp("componentName").isValid()
			|| !Ext.getCmp("componentType").isValid()
			|| !Ext.getCmp("total").isValid()
			|| !Ext.getCmp("componentNumber").isValid()
			|| !Ext.getCmp("remark_id").isValid()) {
		return "";

	}

	// 图号
	var _girdForm_picid = Ext.getCmp("picid").getValue();
	// 零件名称
	var _girdForm_ComponentName = Ext.getCmp("componentName").getValue();
	// 类别
	var _girdForm_componentType = Ext.getCmp("componentType").getValue();
	// 数量
	var _girdForm_Total = Ext.getCmp("total").getValue();
	// 零件编号
	var _girdForm_componentNumber = Ext.getCmp("componentNumber").getValue();
	// 备注
	var _girdForm_remark = Ext.getCmp("remark_id").getValue();

	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	_gridStore.insert(0, new component({
		materialNumber : mNumber,
		idNumber : _girdForm_picid,
		name : _girdForm_ComponentName,
		materialType : _girdForm_componentType,
		codeName : _girdForm_componentNumber,
		totalNumber : _girdForm_Total,
		bak : _girdForm_remark
	}));

	_gridStore.reload({
		params : {
			start : 0,
			limit : 1
		}
	});

	Ext.getCmp("picid").reset();
	Ext.getCmp("componentName").reset();
	Ext.getCmp("componentType").reset();
	Ext.getCmp("total").reset();
	Ext.getCmp("componentNumber").reset();
	Ext.getCmp("componentNumber").reset();
	Ext.getCmp("remark_id").reset();

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

function testLevel_rendererHandler(value) {
	if (value == "1") {
		return "合格";
	} else if (value == "2") {
		return "不合格";
	} else if (value == "3") {
		return "严重不合格";
	} else {
		return "";
	}
}

function inspectionMode_rendererHandler(value) {
	if (value == "1") {
		return "全检";
	} else if (value == "2") {
		return "抽检";
	} else if (value == "3") {
		return "不检";
	} else {
		return "";
	}
}

function getGridData() {
	var _gridPanel = Ext.getCmp("_gridPanel_id");

	var _gridStore = _gridPanel.getStore();

	var localCount = _gridStore.getCount();

	if (localCount <= 0) {
		return "";
	}

	var jsonData = "[";

	for (var i = 0; i < localCount; i++) {

		var record = _gridStore.getAt(i).data;

		jsonData += "{'materialNumber':'" + isStrNull(record.materialNumber)
				+ "', " + "'idNumber':" + isintNull(record.idNumber) + ","
				+ "'name':'" + isStrNull(record.name) + "',"
				+ "'materialType':" + isintNull(record.materialType) + ","
				+ "'codeName' : '" + isStrNull(record.codeName) + "',"
				+ "'totalNumber':" + isintNull(record.totalNumber) + ","
				+ "'TestRequirements':'" + isStrNull(record.TestRequirements)
				+ "'," + "'TestResult':'" + isintNull(record.TestResult) + "',"
				+ "'testLevel':'" + isStrNull(record.testLevel) + "',"
				+ "'savePos':'" + isStrNull(record.savePos) + "',"
				+ "'inspectionMode':" + isintNull(record.inspectionMode) + ","
				+ "'bak':'" + isStrNull(record.bak) + "'},";
	}

	return jsonData.substring(0, jsonData.length - 1) + "]";
}

function isStrNull(value) {
	if (Ext.isEmpty(value)) {
		return "";
	} else {
		return value;
	}
}

function isintNull(value) {
	if (Ext.isEmpty(value)) {
		return 0;
	} else {
		return value;
	}
}

function loadProcessInfo(taskId) {
	var _outComme = Ext.data.Record.create([ {
		name : 'text'
	}, {
		name : 'value'
	} ]);

	var myReader = new Ext.data.JsonReader({
		root : "data",
	}, _outComme);

	var _outComeStore = new Ext.data.Store({
		autoLoad : true,
		baseParams : {
			taskId : taskId
		},
		proxy : new Ext.data.HttpProxy({
			url : '../workflow/loadOutComeList.html',
			method : 'POST'
		}),
		reader : myReader
	});

	return _outComeStore;
}

function loadProcessUser() {
	var _User = Ext.data.Record.create([ {
		name : 'username'
	} ]);

	var UserReader = new Ext.data.JsonReader({
//		root : "data",
	}, _User);

	var _userStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../user/queryUserName.html',
			method : 'POST'
		}),
		reader : UserReader
	});

	return _userStore;
}

function forWardToNextPage() {

	window.location.href = "../workflow/submitTask.html?taskId=" + taskId;
}

function forWordPraPage() {
	window.location.href = "../workflow/myTaskList.html?taskId=" + taskId;
}
