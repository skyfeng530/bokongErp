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

	if (_unqualifiedTypeValue === "1") {
		if (!Ext.getCmp("qualiTotal_id").isValid()) {
			return "";
		}
	} else {
		if (!Ext.getCmp("unqualiReson_id").isValid()
				|| !Ext.getCmp("unqualiTotal_id").isValid()) {
			return "";
		}
	}

	var qualiTotal = Ext.getCmp("qualiTotal_id").getValue();
	var unqualiReson = Ext.getCmp("unqualiReson_id").getValue();
	var unqualiTotal = Ext.getCmp("unqualiTotal_id").getValue();

	for (var i = 0; i < rs.length; i++) {
		rs[i].set("CHECKRST", _requireValue);
		rs[i].set("CHECKNUM", _componentTypeValue);
		rs[i].set("QUALIFIEDNUM", qualiTotal);
		rs[i].set("UNQUALIFIEDNUM", unqualiTotal);
		rs[i].set("UNQUALIFIEDGRADE", _unqualifiedTypeValue);
		rs[i].set("UNQUALIFIEDREASON", unqualiReson);
		rs[i].set("BAK", inputDataFormate(rs[i], "BAK", _remarkValue));
		rs[i].commit();
	}

	var _girdData = getGridData();

	Ext.Ajax.request({
		url : '../omInStorage/saveGridData.html',
		params : {
			data : _girdData
		},
		method : 'POST',
		success : function(response) {
			var result = Ext.decode(response.responseText);

			_gridStore.reload({
				params : {
					start : 0,
					limit : 10,
					flowId : flowId
				}
			});
		},
		failure : function() {
			Ext.Msg.alert("提示", "修改失败");
		}
	});

	Ext.getCmp("Require_id").reset();
	Ext.getCmp("unqualifiedType_id").reset();
	Ext.getCmp("qualiTotal_id").reset();
	Ext.getCmp("remark_id").reset();
	Ext.getCmp("componentType").reset();
	Ext.getCmp("unqualiReson_id").reset();
	Ext.getCmp("unqualiTotal_id").reset();
}

function inputDataFormate(record, fieldKey, newValue)
{
	var fieldValue = eval("record.data." + fieldKey);
	
	if(Ext.isEmpty(fieldValue))
	{
		return newValue;
	}
	
	return fieldValue;
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

	if (!Ext.getCmp("picid").isValid() || !Ext.getCmp("factoryCode").isValid()
			|| !Ext.getCmp("total_id").isValid()
			|| !Ext.getCmp("remark_id").isValid()) {
		return "";

	}

	// 图号
	var _girdForm_picid = Ext.getCmp("picid").getValue();
	// 厂商编号
	var _girdForm_FactoryName = Ext.getCmp("factoryCode").getValue();
	// 零件名称
	var _girdForm_ComponentName = Ext.getCmp("componentName_id").getValue();
	// 图纸要求
	var _girdForm_DrawingReq = Ext.getCmp("Drawingreq_id").getValue();
	var _girdForm_DrawingReq_RawValue = Ext.getCmp("Drawingreq_id")
			.getRawValue();
	// 数量
	var _girdForm_Total = Ext.getCmp("total_id").getValue();
	// 备注
	var _girdForm_remark = Ext.getCmp("remark_id").getValue();
	// 零件编号配置方式
	var _gridForm_AddCompNoType = Ext.getCmp("addComponNo_id").getValue();

	var batchNum = 0;

	var _devNo = new Array();

	if (_gridForm_AddCompNoType == "1") {
		if (!Ext.getCmp("componentNo_id").isValid()) {
			return "";
		}

		batchNum = 1;
		_devNo.push(Ext.getCmp("componentNo_id").getValue());
	} else {
		if (!Ext.getCmp("batchNo_id").isValid()
				|| !Ext.getCmp("batch_start_id").isValid()
				|| !Ext.getCmp("batch_end_id").isValid()) {
			return "";
		}

		batchNum = (Ext.getCmp("batch_end_id").getValue() - Ext.getCmp(
				"batch_start_id").getValue()) + 1;

		var _batchNoValue = Ext.getCmp("batchNo_id").getValue();
		var _startValue = Ext.getCmp("batch_start_id").getValue();
		var _endValue = Ext.getCmp("batch_end_id").getValue();

		for (var i = 0; i < batchNum; i++) {
			_devNo.push(_batchNoValue + "-"
					+ pad(_startValue + i, _endValue.length));
		}
	}

	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	for (var m = 0; m < _devNo.length; m++) {
		_gridStore.insert(0, new component({
			FLOWID : flowId,
			PFID : _girdForm_DrawingReq,
			FIGURENO : _girdForm_picid,
			VENDORNO : _girdForm_FactoryName,
			FIGURENAME : _girdForm_ComponentName,
			FIGUREREQUEST : _girdForm_DrawingReq_RawValue,
			TOTALNUMBER : _girdForm_Total,
			DEVBATCHNO : _devNo[m],
			BAK : _girdForm_remark
		}));
	}

	var _girdData = getGridData();

	Ext.Ajax.request({
		url : '../omInStorage/saveGridData.html',
		params : {
			data : _girdData
		},
		method : 'POST',
		success : function(response) {
			var result = Ext.decode(response.responseText);

			_gridStore.reload({
				params : {
					start : 0,
					limit : 10,
					flowId : flowId
				}
			});
		},
		failure : function() {
			Ext.Msg.alert("提示", "添加失败");
		}
	});

	Ext.getCmp("picid").reset();
	Ext.getCmp("factoryCode").reset();
	Ext.getCmp("componentName_id").reset();
	Ext.getCmp("Drawingreq_id").reset();
	Ext.getCmp("total_id").reset();
	Ext.getCmp("remark_id").reset();

	if (_gridForm_AddCompNoType == "1") {
		Ext.getCmp("componentNo_id").reset();
	} else {
		Ext.getCmp("batchNo_id").reset();
		Ext.getCmp("batch_start_id").reset();
		Ext.getCmp("batch_end_id").reset();
	}
};

function pad(num, n) {
	return Array(n > num ? (n - ('' + num).length + 1) : 0).join(0) + num;
}

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

		jsonData += "{'flowId':'" + isintNull(record.FLOWID) + "','pfId':'"
				+ isintNull(record.PFID) + "','devBatchNo':'"
				+ isStrNull(record.DEVBATCHNO) + "','totalNumber':'"
				+ isintNull(record.TOTALNUMBER) + "','vendorNo':'"
				+ isStrNull(record.VENDORNO) + "','checkRst':'"
				+ isintNull(record.CHECKRST) + "','checkNum':'"
				+ isintNull(record.CHECKNUM) + "','qualifiedNum':'"
				+ isintNull(record.QUALIFIEDNUM) + "','unqualifiedNum':'"
				+ isintNull(record.UNQUALIFIEDNUM) + "','unqualifiedGrade':'"
				+ isintNull(record.UNQUALIFIEDGRADE) + "','unqualifiedReason':'"
				+ isStrNull(record.UNQUALIFIEDREASON) + "','reviewRst':'"
				+ isintNull(record.REVIEWRST) + "','reviewGrp':'"
				+ isintNull(record.REVIEWGRP) + "','reviewNo':'"
				+ isStrNull(record.REVIEWNO) + "','graphicPath':'"
				+ isStrNull(record.GRAPHICPATH) + "','bak':'"
				+ isStrNull(record.BAK) + "'},";
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
		return "";
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
	// root : "data",
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

function omDiscardProcess_discardTypeDispaly(value) {
	if (value == "1") {
		return '不合格审理';
	} else {
		return '研制过程相关问题报告';
	}
}

var trialNum = 0;

function reviewNoDispaly(_trialNum)
{
	if(deviceType === "光学")
	{
		return "SLD_" + taskName +"_"+ new Date().getFullYear() + "_" + _trialNum
		+ "(G)";
	}
	else
	{
		return "SLD_" + taskName +"_"+ new Date().getFullYear() + "_" + _trialNum
		+ "(J)";
	}
}

function addUnqualifiedtrial_handler() {

	var _checkGrid = Ext.getCmp("_gridPanel_id");

	var _gridStore = _checkGrid.getStore();

	var rs = _checkGrid.getSelectionModel().getSelections();

	if (rs.length == 0) {
		Ext.Msg.alert("提示", "请先选择要修改的记录.");
		return;
	}


	if (!Ext.getCmp("trialresults_id").isValid()
			|| !Ext.getCmp("Trialorg_id").isValid()) {
		return "";

	}

	//审理组织
	var _groupValue = Ext.getCmp("Trialorg_id").getValue();
	// 审理结果
	var _trialResult = Ext.getCmp("trialresults_id").getValue();

	var component = _gridStore.recordType;

	for (var i = 0; i < rs.length; i++) {
		
	trialNum++;
	
	var _trialReviewNo = reviewNoDispaly(trialNum);
	
		rs[i].set("REVIEWGRP", _groupValue);
		rs[i].set("REVIEWRST", _groupValue);
		rs[i].set("REVIEWNO", _trialReviewNo);
		rs[i].commit();
	}

	var _girdData = getGridData();

	Ext.Ajax.request({
		url : '../omInStorage/saveGridData.html',
		params : {
			data : _girdData
		},
		method : 'POST',
		success : function(response) {
			var result = Ext.decode(response.responseText);

			_gridStore.reload({
				params : {
					start : 0,
					limit : 10,
					flowId : flowId
				}
			});
		},
		failure : function() {
			Ext.Msg.alert("提示", "添加失败");
		}
	});

	Ext.getCmp("Trialorg_id").reset();
	Ext.getCmp("trialresults_id").reset();
};

function reviewrst_renderer_handler(value) {
	if (value == "1") {
		return '<div ext:qtitle="" ext:qtip="返工">返工</div>';
	} else if (value == "2") {
		return '<div ext:qtitle="" ext:qtip="返修">返修</div>';
	} else if (value == "3") {
		return '<div ext:qtitle="" ext:qtip="降级">降级</div>';
	} else if (value == "4") {
		return '<div ext:qtitle="" ext:qtip="报废">报废</div>';
	} else if (value == "5") {
		return '<div ext:qtitle="" ext:qtip="让步接收">让步接收</div>';
	} else if (value == "6") {
		return '<div ext:qtitle="" ext:qtip="退回供方">退回供方</div>';
	} else {
		return "";
	}
}

function reviewgroup_renderer_handler(value) {
	if (value == "1") {
		return '<div ext:qtitle="" ext:qtip="审理小组">审理小组</div>';
	} else if (value == "2") {
		return '<div ext:qtitle="" ext:qtip="审理委员会">审理委员会</div>';
	} else {
		return "";
	}
}

function unqualifiedgrade_display(value)
{
	if (value == "1") {
		return '<div ext:qtitle="" ext:qtip="合格">合格</div>';
	} else if (value == "2") {
		return '<div ext:qtitle="" ext:qtip="一般不合格">一般不合格</div>';
	}  else if (value == "3") {
		return '<div ext:qtitle="" ext:qtip="严重不合格">严重不合格</div>';
	}else {
		return "";
	}
}
