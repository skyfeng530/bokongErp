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
		type : 'int'
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
	}, {
		name : 'CHECKRST',
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
			width : 120,
			sortable : false,
			align : 'center',
			dataIndex : 'FIGURENAME',
			menuDisabled : true
		}, {
			header : "器件编号",
			width : 120,
			sortable : false,
			dataIndex : 'DEVNO',
			align : 'center',
			menuDisabled : true
		}, {
			header : "器件图号",
			width : 120,
			dataIndex : 'FIGUREID',
			sortable : false,
			menuDisabled : true
		}, {
			header : "器件数量",
			width : 120,
			sortable : false,
			align : 'center',
			dataIndex : 'NUM',
			menuDisabled : true
		}, {
			header : "报废原因",
			width : 120,
			sortable : false,
			align : 'center',
			dataIndex : 'DISCARDREASON',
			menuDisabled : true
		}, {
			header : "问题类型",
			width : 120,
			sortable : false,
			align : 'center',
			dataIndex : 'QUESTIONTYPE',
			menuDisabled : true
		}, {
			header : "检验结果",
			width : 120,
			sortable : false,
			align : 'center',
			dataIndex : 'CHECKRST',
			menuDisabled : true,
			renderer : reviewResusltDisplay
		}],
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
		title : '报废品检验',
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
				id : 'checkResult_id',
				fieldLabel : '检验结果',
				anchor : '85%',
				xtype : 'combo',
				maxLength : 10,
				allowBlank : true,
				store : workflow.states.omdiscardReviewStore,
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
			}, {
				xtype : 'button',
				text : '修改',
				width : '80',
				style : 'margin-left:104px;',
				handler : omDiscardApproval_handler
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : []
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
				title : "审核",
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

								var commonRemarkValue = Ext.getCmp(
										"commonMask_id").getValue();
								var outcome = Ext.getCmp("processId")
										.getValue();
								var nextName = Ext.getCmp("processUserId")
										.getValue();

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

function reviewResusltDisplay(value) {
	if (value == "1") {
		return "可报废";
	} else if (value == "2") {
		return "不可报废";
	} else {
		return "";
	}
}

function omDiscardApproval_handler() {
	var _checkGrid = Ext.getCmp("_gridPanel_id");

	var _gridStore = _checkGrid.getStore();

	var rs = _checkGrid.getSelectionModel().getSelections();

	if (rs.length == 0) {
		Ext.Msg.alert("提示", "请先选择要修改的记录.");
		return;
	}

	if (!Ext.getCmp("checkResult_id").isValid()) {
		return;
	}

	var _checkResult = Ext.getCmp("checkResult_id").getValue();

	var _devno;
	for (var i = 0; i < rs.length; i++) {
		rs[i].set("CHECKRST", _checkResult);
		rs[i].commit();
		_devno = rs[i].get("DEVNO");
		;
	}

	Ext.Ajax.request({
		url : '../omstorage/discard/saveCheckGridData.html',
		params : {
			flowId : flowId,
			devNo : _devno,
			checkRst : _checkResult,
			checkFlag : 1
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

	Ext.getCmp("checkResult_id").reset();
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