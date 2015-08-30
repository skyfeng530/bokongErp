function topView() {

	var proxy = new Ext.data.HttpProxy({
		url : '../omInStorage/loadGridData.html',
		method : 'POST'
	});

	var render = new Ext.data.JsonReader({
		root : 'data',
		totalProperty : 'totalCount'
	}, [ {
		name : 'FLOWID',
		type : 'string'
	}, {
		name : 'PFID',
		type : 'string'
	}, {
		name : 'FIGURENO',
		type : 'string'
	}, {
		name : 'FIGURENAME',
		type : 'string'
	}, {
		name : 'FIGUREREQUEST',
		type : 'string'
	}, {
		name : 'DEVBATCHNO',
		type : 'string'
	}, {
		name : 'TOTALNUMBER',
		type : 'string'
	}, {
		name : 'VENDORNO',
		type : 'string'
	}, {
		name : 'CHECKRST',
		type : 'string'
	}, {
		name : 'CHECKNUM',
		type : 'string'
	}, {
		name : 'QUALIFIEDNUM',
		type : 'string'
	}, {
		name : 'UNQUALIFIEDNUM',
		type : 'string'
	}, {
		name : 'UNQUALIFIEDGRADE',
		type : 'string'
	}, {
		name : 'UNQUALIFIEDREASON',
		type : 'string'
	}, {
		name : 'REVIEWRST',
		type : 'string'
	}, {
		name : 'REVIEWGRP',
		type : 'string'
	}, {
		name : 'REVIEWNO',
		type : 'string'
	}, {
		name : 'GRAPHICPATH',
		type : 'string'
	}, {
		name : 'BAK',
		type : 'string'
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

	function renderer_handler(value) {
		if (Ext.isEmpty(value)) {
			return "";
		}

		return '<div ext:qtitle="" ext:qtip="' + value + '">' + value
				+ '</div>';
	}

	var sm = new Ext.grid.CheckboxSelectionModel({
		singleSelect : false
	});

	function unqualifiednum_renderer_handler(value) {
		if (value != "1") {
			var firstValue = Ext.getCmp("processId").store.getRange()[0].data.value;
			Ext.getCmp("processId").setValue(firstValue);
		}

		if (value == "1") {
			return '<div ext:qtitle="" ext:qtip="合格">合格</div>';
		} else if (value == "2") {
			return '<div ext:qtitle="" ext:qtip="一般不合格">一般不合格</div>';
		} else if (value == "3") {
			return '<div ext:qtitle="" ext:qtip="严重不合格">严重不合格</div>';
		} else {
			return "";
		}
	}

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '104%',
		style : 'margin-left:102px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ sm, {
			header : "图号",
			width : 60,
			align : 'center',
			sortable : false,
			dataIndex : 'FIGURENO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "厂商名称",
			align : 'center',
			width : 90,
			sortable : false,
			dataIndex : 'VENDORNO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "零件名称",
			align : 'center',
			width : 65,
			sortable : false,
			dataIndex : 'FIGURENAME',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 65,
			sortable : false,
			dataIndex : 'FIGUREREQUEST',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "数量",
			align : 'center',
			width : 40,
			sortable : false,
			dataIndex : 'TOTALNUMBER',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "零件编号",
			align : 'center',
			width : 65,
			sortable : false,
			dataIndex : 'DEVBATCHNO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "检验结果",
			width : 65,
			sortable : false,
			dataIndex : 'CHECKRST',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "检验数量",
			width : 65,
			sortable : false,
			dataIndex : 'CHECKNUM',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "合格数量",
			width : 65,
			sortable : false,
			dataIndex : 'QUALIFIEDNUM',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "不合格数量",
			width : 75,
			sortable : false,
			dataIndex : 'UNQUALIFIEDNUM',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "合格等级",
			width : 65,
			sortable : false,
			dataIndex : 'UNQUALIFIEDGRADE',
			renderer : unqualifiednum_renderer_handler,
			menuDisabled : true
		}, {
			header : "不合格原因",
			width : 75,
			sortable : false,
			dataIndex : 'UNQUALIFIEDREASON',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "备注",
			align : 'center',
			width : 65,
			sortable : false,
			dataIndex : 'BAK',
			renderer : renderer_handler,
			menuDisabled : true
		} ],
		viewConfig : {
			forceFit : true
		},
		sm : sm,
		autoWidth : true,
		height : 343,
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
		title : '检验',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [
				{
					columnWidth : .3,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '项目名称',
						xtype : 'label',
						anchor : '85%',
						html : '<div style="padding-top:3px">' + projectName
								+ '</div>'
					} ]
				},
				{
					columnWidth : .3,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '任务编号',
						anchor : '85%',
						xtype : 'label',
						html : '<div style="padding-top:3px">' + taskName
								+ '</div>'
					} ]
				},
				{
					columnWidth : .3,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '器件类型',
						anchor : '85%',
						xtype : 'label',
						html : '<div style="padding-top:3px">' + deviceType
								+ '</div>'
					} ]
				},
				{
					clumnWidth : 1,
					anchor : '85%',
					colspan : 2,
					layout : 'form',
					labelWidth : 100,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ _gridPanel ]
				},
				{
					columnWidth : .5,
					layout : 'form',
					labelWidth : 100,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [
							{
								id : 'Require_id',
								fieldLabel : '检验结果',
								anchor : '85%',
								xtype : 'textfield',
								maxLength : 10,
								allowBlank : false,
								blankText : '不能为空'
							},
							{
								id : 'unqualifiedType_id',
								fieldLabel : ' 合格等级',
								anchor : '85%',
								xtype : 'combo',
								maxLength : 10,
								allowBlank : true,
								store : workflow.states.testLevelStore,
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
								blankText : '不能为空',
								listeners : {
									'change' : function() {
										var testLevelValue = this.getValue();

										if (testLevelValue == 2
												|| testLevelValue == 3) {
											var firstValue = Ext
													.getCmp("processId").store
													.getRange()[0].data.value;
											Ext.getCmp("processId").setValue(
													firstValue);
											Ext.getCmp("processId").readOnly = true;
											Ext.getCmp("unqualiReson_id")
													.reset();
											Ext.getCmp("unqualiReson_id")
													.setDisabled(false);

											Ext.getCmp("unqualiTotal_id")
													.reset();
											Ext.getCmp("unqualiTotal_id")
													.setDisabled(false);
											Ext.getCmp("qualiTotal_id").reset();
											Ext.getCmp("qualiTotal_id")
													.setDisabled(true);
										} else {
											var firstValue = Ext
													.getCmp("processId").store
													.getRange()[1].data.value;
											Ext.getCmp("processId").setValue(
													firstValue);
											Ext.getCmp("processId").readOnly = true;
											Ext.getCmp("unqualiReson_id")
													.reset();
											Ext.getCmp("unqualiReson_id")
													.setDisabled(true);
											Ext.getCmp("unqualiTotal_id")
													.reset();
											Ext.getCmp("unqualiTotal_id")
													.setDisabled(true);
											Ext.getCmp("qualiTotal_id").reset();
											Ext.getCmp("qualiTotal_id")
													.setDisabled(false);
										}
									},
									'select' : function() {
										var testLevelValue = this.getValue();

										if (testLevelValue == 2
												|| testLevelValue == 3) {
											var firstValue = Ext
													.getCmp("processId").store
													.getRange()[0].data.value;
											Ext.getCmp("processId").setValue(
													firstValue);
											Ext.getCmp("processId").readOnly = true;
											Ext.getCmp("unqualiReson_id")
													.reset();
											Ext.getCmp("unqualiReson_id")
													.setDisabled(false);

											Ext.getCmp("unqualiTotal_id")
													.reset();
											Ext.getCmp("unqualiTotal_id")
													.setDisabled(false);
											Ext.getCmp("qualiTotal_id").reset();
											Ext.getCmp("qualiTotal_id")
													.setDisabled(true);
										} else {
											var firstValue = Ext
													.getCmp("processId").store
													.getRange()[1].data.value;
											Ext.getCmp("processId").setValue(
													firstValue);
											Ext.getCmp("processId").readOnly = true;
											Ext.getCmp("unqualiReson_id")
													.reset();
											Ext.getCmp("unqualiReson_id")
													.setDisabled(true);
											Ext.getCmp("unqualiTotal_id")
													.reset();
											Ext.getCmp("unqualiTotal_id")
													.setDisabled(true);
											Ext.getCmp("qualiTotal_id").reset();
											Ext.getCmp("qualiTotal_id")
													.setDisabled(false);
										}
									}
								}
							}, {
								id : 'qualiTotal_id',
								fieldLabel : '合格数量',
								anchor : '85%',
								xtype : 'numberfield',
								allowBlank : false,
								blankText : '不能为空'
							}, {
								id : 'remark_id',
								fieldLabel : ' 备注',
								anchor : '85%',
								xtype : 'textfield',
								allowBlank : true
							}, {
								xtype : 'button',
								text : '修改',
								width : '80',
								style : 'margin-left:104px;',
								handler : checkPage_dataGrid_handler
							} ]
				}, {
					columnWidth : .5,
					layout : 'form',
					labelWidth : 100,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'componentType',
						fieldLabel : '检验数量',
						anchor : '85%',
						xtype : 'numberfield',
						maxLength : 10,
						allowBlank : false,
						blankText : '不能为空'
					}, {
						id : 'unqualiReson_id',
						fieldLabel : '不合格原因',
						anchor : '85%',
						xtype : 'textfield',
						allowBlank : false,
						blankText : '不能为空'
					}, {
						id : 'unqualiTotal_id',
						fieldLabel : ' 不合格数量',
						anchor : '85%',
						xtype : 'numberfield',
						maxLength : 10,
						allowBlank : true
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

	var mainPanel = new Ext.form.FormPanel({
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

						if (!checkGrid()) {
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

						var commonRemarkValue = Ext.getCmp("commonMask_id")
								.getValue();
						var outcome = Ext.getCmp("processId").getValue();
						var nextName = Ext.getCmp("processUserId").getValue();

						Ext.Ajax.request({
							url : '../omInStorage/submitForm_storage.html',
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								projectName : projectName,
								taskName : taskName,
								outcome : outcome,
								nextName : nextName
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "入库电子流提交成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "入库电子流提交失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "入库电子流提交失败");
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

function checkGrid() {
	var _gridPanel = Ext.getCmp("_gridPanel_id");

	var _gridStore = _gridPanel.getStore();

	var localCount = _gridStore.getCount();

	for (var i = 0; i < localCount; i++) {

		var record = _gridStore.getAt(i).data;

		if (Ext.isEmpty(record.UNQUALIFIEDGRADE)) {
			Ext.Msg.alert("提示", "请先检验零件");
			return false;
		}
	}

	return true;
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