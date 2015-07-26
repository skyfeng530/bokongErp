function topView() {

	var proxy = new Ext.data.HttpProxy({
		url : '../workflow/loadFormGridData.html',
		method : 'POST'
	});
	var render = new Ext.data.JsonReader({
		root : 'data',
		totalProperty : 'totalCount'
	}, [ {
		name : 'materialNumber',
		type : 'string'
	}, {
		name : 'idNumber',
		type : 'int'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'materialType',
		type : 'int'
	}, {
		name : 'codeName',
		type : 'string'
	}, {
		name : 'totalNumber',
		type : 'int'
	}, {
		name : 'TestRequirements',
		type : 'string'
	}, {
		name : 'TestResult',
		type : 'string'
	}, {
		name : 'inspectionMode',
		type : 'string'
	}, {
		name : 'savePos',
		type : 'string'
	}, {
		name : 'testLevel',
		type : 'string'
	}, {
		name : 'bak',
		type : 'string'
	} ]);
	var store = new Ext.data.Store({
		proxy : proxy,
		reader : render,
		autoLoad : true,
		baseParams : {
			flowId : flowId
		},
		sortInfo : {
			field : 'idNumber',
			direction : 'ASC'
		}
	});

	var sm = new Ext.grid.CheckboxSelectionModel({
		singleSelect : false
	});

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '104%',
		style : 'margin-left:102px; margin-top:10px; margin-bottom:10px',
		loadMask : {
			msg : '正在加载数据,请稍等...'
		},
		store : store,
		columns : [ sm, {
			header : "序号",
			width : 120,
			sortable : false,
			dataIndex : 'materialNumber',
			menuDisabled : true
		}, {
			header : "图号",
			width : 120,
			sortable : false,
			dataIndex : 'idNumber',
			menuDisabled : true
		}, {
			header : "零件名称",
			width : 120,
			sortable : false,
			dataIndex : 'name',
			menuDisabled : true
		}, {
			header : "类别",
			width : 120,
			sortable : false,
			dataIndex : 'materialType',
			menuDisabled : true,
			renderer : category_rendererFunc
		}, {
			header : "零件编号",
			width : 120,
			sortable : false,
			dataIndex : 'codeName',
			menuDisabled : true,
			renderer : workinprocess_rendererFunc
		}, {
			header : "数量",
			width : 120,
			sortable : false,
			dataIndex : 'totalNumber',
			menuDisabled : true
		}, {
			header : "图纸要求",
			hidden : true,
			dataIndex : 'TestRequirements',
			menuDisabled : true
		}, {
			header : "检验结果",
			hidden : true,
			dataIndex : 'TestResult',
			menuDisabled : true
		}, {
			header : "合格程度",
			hidden : true,
			dataIndex : 'testLevel',
			menuDisabled : true
		}, {
			header : "存储位置",
			dataIndex : 'savePos',
			width : 120,
			sortable : false,
			menuDisabled : true
		}, {
			header : "备注",
			width : 120,
			sortable : false,
			dataIndex : 'bak',
			menuDisabled : true
		} ],
		viewConfig : {
			forceFit : true
		},
		sm : sm,
		autoWidth : true,
		height : 300,
		frame : true,
		iconCls : 'icon-grid',
		tbar : [ {
			text : '删除',
			iconCls : 'silk-delete',
			scope : this
		} ],
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			store : store,
			emptyMsg : "无记录"
		})
	};

	var partTransfer = {
		xtype : 'fieldset',
		title : '入库前确认',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
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
				html : '<div style="padding-top:3px">' + projectName + '</div>'
			} ]
		}, {
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
				html : '<div style="padding-top:3px">' + taskName + '</div>'
			} ]
		}, {
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
				html : '<div style="padding-top:3px">光学器件（测试数据）</div>'
			} ]
		}, {
			clumnWidth : 1,
			anchor : '85%',
			colspan : 2,
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
				id : 'saveLocaton_Id',
				fieldLabel : '存储位置',
				anchor : '85%',
				xtype : 'textfield'
			}, {
				xtype : 'button',
				text : '修改',
				width : '80',
				style : 'margin-left:104px;',
				handler : manageApproval_dataGrid_handler
			} ]
		} ]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();

	var _processInfoStore = loadProcessInfo(taskId);
	var _processUser = loadProcessUser();

	var mainPanel = new Ext.form.FormPanel({
		title : "库管审核",
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
		items : [
				_topPanel,
				{
					id : 'processId',
					name : "operate",
					fieldLabel : "选择您要的操作",
					xtype : 'combo',
					store : _processInfoStore,
					allowBlank : false,
					blankText : '不能为空',
					selectOnFocus : true,
					forceSelection : true,
					triggerAction : 'all',
					valueNotFoundText : '',
					emptyText : '请选择...',
					mode : "local",
					valueField : 'value',
					displayField : 'text',
					listeners : {
						'render' : function() {
							Ext.getCmp("processId").store.reload({
								callback : function() {
									if (Ext.getCmp("processId").store
											.getTotalCount() == 1) {
										var firstValue = Ext
												.getCmp("processId").store
												.getRange()[0].data.value;

										Ext.getCmp("processId").setValue(
												firstValue);
									}

								}
							});

						}
					}
				}, {
					id : 'commonMask_id',
					xtype : "textarea",
					name : "mask",
					height : 50,
					fieldLabel : "批注",
					allowBlank : false,
					blankText : '不能为空'
				} ],
		buttons : [
				{
					text : "提交",
					handler : function() {

						var _gridData = getGridData();

						if (!Ext.getCmp("commonMask_id").isValid()) {
							return;
						}

						var commonRemarkValue = Ext.getCmp("commonMask_id")
								.getValue();

						Ext.Ajax.request({
							url : '../workflow/submitForm_storage.html',
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								data : _gridData,
								projectName : projectName,
								taskName : taskName,
								outcome : "",
								nextName : ""
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