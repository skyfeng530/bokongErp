function topView() {

	var proxy = new Ext.data.HttpProxy({
		url : '../omstorage/discard/loadGridData.html',
		method : 'POST'
	});
	var render = new Ext.data.JsonReader({
		root : 'data',
		totalProperty : 'totalCount'
	}, [ {
		name : 'FLOWID',
		type : 'string'
	}, {
		name : 'FIGURENAME',
		type : 'string'
	}, {
		name : 'DEVNO',
		type : 'string'
	}, {
		name : 'FIGUREID',
		type : 'string'
	}, {
		name : 'CODENAME',
		type : 'string'
	}, {
		name : 'NUM',
		type : 'int'
	}, {
		name : 'DISCARDREASON',
		type : 'string'
	}, {
		name : 'QUESTIONTYPE',
		type : 'int'
	} ]);
	var store = new Ext.data.Store({
		proxy : proxy,
		reader : render,
		autoLoad : true,
		baseParams : {
			flowId : flowId,
			limit : 10,
			offset : 0
		}
	});

	var sm = new Ext.grid.CheckboxSelectionModel({
		singleSelect : true
	});

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '104%',
		style : 'margin-left:102px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ sm, {
			header : "器件名称",
			width : 145,
			sortable : false,
			align : 'center',
			dataIndex : 'FIGURENAME',
			menuDisabled : true
		}, {
			header : "器件编号",
			width : 145,
			sortable : false,
			dataIndex : 'DEVNO',
			align : 'center',
			menuDisabled : true
		}, {
			header : "器件图号",
			width : 145,
			dataIndex : 'FIGUREID',
			sortable : false,
			menuDisabled : true
		}, {
			header : "器件数量",
			width : 145,
			sortable : false,
			align : 'center',
			dataIndex : 'NUM',
			menuDisabled : true
		}, {
			header : "报废原因",
			width : 145,
			sortable : false,
			align : 'center',
			dataIndex : 'DISCARDREASON',
			menuDisabled : true
		}, {
			header : "问题类型",
			width : 145,
			sortable : false,
			align : 'center',
			dataIndex : 'QUESTIONTYPE',
			menuDisabled : true
		} ],
		viewConfig : {
			forceFit : true
		},
		sm : sm,
		autoWidth : true,
		height : 300,
		stripeRows : true,
		frame : true,
		iconCls : 'icon-grid',
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			store : store,
			emptyMsg : "无记录"
		})
	};

	var partTransfer = {
		xtype : 'fieldset',
		title : '报废',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
			columnWidth : .25,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '项目名称',
				xtype : 'label',
				anchor : '85%',
				html : '<div style="padding-top:3px">' + projectName + '</div>'
			} ]
		}, {
			columnWidth : .25,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '任务编号',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + taskno + '</div>'
			} ]
		}, {
			columnWidth : .25,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '器件类型',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + devname + '</div>'
			} ]
		}, {
			columnWidth : .25,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '报废类型',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + omDiscardProcess_discardTypeDispaly(discardType) + '</div>'
			} ]
		}, {
			clumnWidth : 1,
			anchor : '85%',
			colspan : 4,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ _gridPanel ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'figurename_id',
				fieldLabel : '器件名称',
				anchor : '85%',
				xtype : 'textfield',
				maxLength : 10,
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'devno_id',
				fieldLabel : '器件编号',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'figureId_id',
				fieldLabel : '器件图号',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				xtype : 'button',
				text : '添加',
				width : '80',
				style : 'margin-left:104px;',
				handler : addDiscardInput_handler
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'num_id',
				fieldLabel : '器件数量',
				anchor : '85%',
				xtype : 'textfield',
				maxLength : 10,
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'discardReason_id',
				fieldLabel : ' 报废原因',
				anchor : '85%',
				xtype : 'textfield',
				maxLength : 10,
				allowBlank : true
			}, {
				id : 'questionType_id',
				fieldLabel : ' 问题类型',
				anchor : '85%',
				xtype : 'combo',
				maxLength : 10,
				allowBlank : true,
				store : workflow.states.problemStore,
				emptyText : '请选择...',
				mode : 'local',
				valueField : 'value',
				displayField : 'text',
				selectOnFocus : true,
				editable : false,
				forceSelection : true,
				triggerAction : 'all',
				valueNotFoundText : '',
				typeAhead : true,
				allowBlank : false,
				blankText : '不能为空'
			} ]
		} ]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();

	var _processInfoStore = loadProcessInfo(taskId);
	var _processUser = loadProcessUser();
	var _flowCommonComp = getFlowCommonComp(taskId);

	var mainPanel = new Ext.form.FormPanel(
			{
				title : "检验",
				autoHeight : true,
				autoWidth : true,
				labelWidth : 100,
				labelAlign : "left",
				style : 'margin-top:1px;',
				buttonAlign : 'left',
				frame : true,
				defaults : {
					xtype : "textfield",
					width : 600
				},
				items : [ _topPanel, _flowCommonComp ],
				buttons : [
						{
							text : "提交",
							handler : function() {
								
								var _checkGrid = Ext.getCmp("_gridPanel_id");

								var _gridStore = _checkGrid.getStore();

								if (_gridStore.getCount() == 0) {
									Ext.Msg.alert("提示", "请先选择要修改的记录.");
									return;
								}

								if (!Ext.getCmp("processId").isValid()) {
									return;
								}

								if (!Ext.getCmp("processUserId").isValid()) {
									return;
								}

								if (!Ext.getCmp("commonMask_id").isValid()) {
									return;
								}

								var commonRemarkValue = Ext.getCmp("commonMask_id").getValue();
								var outcome = Ext.getCmp("processId").getValue();
								var nextName = Ext.getCmp("processUserId").getValue();

								Ext.Ajax
										.request({
											url : '../omstorage/discard/submitFormStorage.html',
											params : {
												taskId : taskId,
												comment : commonRemarkValue,
												projectName : projectName,
												devname : devname,
												discardType : discardType,
												taskno : taskno,
												outcome : outcome,
												nextName : nextName
											},
											method : 'POST',
											success : function(response) {
												var result = Ext
														.decode(response.responseText);

												if (result.success) {
													Ext.Msg.alert("提示",
															"入库电子流提交成功",
															forWardToNextPage);
												} else {
													Ext.Msg.alert("提示",
															"入库电子流提交失败");
												}
											},
											failure : function() {
												Ext.Msg
														.alert("提示",
																"入库电子流提交失败");
											}
										});
							}
						}, {
							text : "取消",
							handler : forWordPraPage
						} ]
			});

	mainPanel.render("main_id");
}

function addDiscardInput_handler() {

	if (!Ext.getCmp("figurename_id").isValid()
			|| !Ext.getCmp("devno_id").isValid()
			|| !Ext.getCmp("figureId_id").isValid()
			|| !Ext.getCmp("num_id").isValid()
			|| !Ext.getCmp("discardReason_id").isValid()
			|| !Ext.getCmp("questionType_id").isValid()) {
		return "";

	}

	// 器件名称
	var _figureNameValue = Ext.getCmp("figurename_id").getValue();
	// 器件编号
	var _devnoValue = Ext.getCmp("devno_id").getValue();
	// 器件图号
	var _figureIdValue = Ext.getCmp("figureId_id").getValue();
	// 器件数量
	var _numValue = Ext.getCmp("num_id").getValue();
	// 报废原因
	var _discardReasonValue = Ext.getCmp("discardReason_id").getValue();
	// 问题类型
	var _questionTypeValue = Ext.getCmp("questionType_id").getValue();

	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	Ext.Ajax.request({
		url : '../omstorage/discard/saveGridData.html',
		params : {
			flowId : flowId,
			figureName : _figureNameValue,
			devNo : _devnoValue,
			figureId : _figureIdValue,
			num : _numValue,
			discardReason : _discardReasonValue,
			questionType : _questionTypeValue
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

	Ext.getCmp("figurename_id").reset();
	Ext.getCmp("devno_id").reset();
	Ext.getCmp("figureId_id").reset();
	Ext.getCmp("num_id").reset();
	Ext.getCmp("discardReason_id").reset();
	Ext.getCmp("questionType_id").reset();

};

function omdiscardGridData(flowId) {

	var _gridPanel = Ext.getCmp("_gridPanel_id");

	var _gridStore = _gridPanel.getStore();

	var localCount = _gridStore.getCount();

	if (localCount <= 0) {
		return "";
	}

	var jsonData = "[";

	for (var i = 0; i < localCount; i++) {

		var record = _gridStore.getAt(i).data;

		jsonData += "{'flowid':'" + flowId + "', " + "'figureName':"
				+ isStrNull(record.figureName) + "," + "'devNo':'"
				+ isStrNull(record.devNo) + "'," + "'figureId':"
				+ isStrNull(record.figureId) + "," + "'num' : '"
				+ isintNull(record.num) + "'," + "'discardReason':"
				+ isStrNull(record.discardReason) + "," + "'questionType':'"
				+ isintNull(record.questionType) + "'," + "'checkRst':'"
				+ isintNull(record.checkRst) + "'," + "'reviewRst':'"
				+ isintNull(record.reviewRst) + "'," + "'reviewNo':'"
				+ isStrNull(record.reviewNo) + "'," + "'reviewPicture':'"
				+ isStrNull(record.reviewPicture) + "'},";
	}

	return jsonData.substring(0, jsonData.length - 1) + "]";
}

function initview() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'qtip';

	var myMask = new Ext.LoadMask(Ext.getBody(), {
		msg : "请稍候..."
	});

	Ext.Ajax.on("beforerequest", function() {
		myMask.show();
	});

	Ext.Ajax.on("requestcomplete", function() {
		myMask.hide();
	});

	Ext.Ajax.on("requestexception", function() {
		myMask.hide();
	});

	mainView();

};
Ext.onReady(initview);