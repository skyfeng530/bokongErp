// 序号
var mNumber = 0;

function topView() {
	// create the Data Store
	var store = new Ext.data.Store({
		autoLoad : {
			params : {
				start : 0,
				limit : 1
			}
		},
		proxy : new Ext.data.PagingMemoryProxy(),
		reader : new Ext.data.XmlReader({
			record : 'total',
			fields : [ {
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
				name : 'testLevel',
				type : 'string'
			}, {
				name : 'bak',
				type : 'string'
			} ]
		})
	});

	var sm = new Ext.grid.CheckboxSelectionModel();

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '105%',
		autoWidth : true,
		style : 'margin-left:82px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ sm, {
			header : "序号",
			align : 'center',
			width : 82,
			sortable : false,
			dataIndex : 'materialNumber',
			menuDisabled : true
		}, {
			header : "图库",
			align : 'center',
			width : 82,
			sortable : false,
			menuDisabled : true
		}, {
			header : "对应厂商名称",
			align : 'center',
			width : 82,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图号",
			width : 82,
			align : 'center',
			sortable : false,
			dataIndex : 'idNumber',
			menuDisabled : true
		}, {
			header : "子图号",
			align : 'center',
			width : 82,
			sortable : false,
			menuDisabled : true
		}, {
			header : "零件名称",
			align : 'center',
			width : 82,
			sortable : false,
			dataIndex : 'name',
			menuDisabled : true
		}, {
			header : '对应厂商编号',
			align : 'center',
			width : 82,
			sortable : false,
			menuDisabled : true
		}, {
			header : "零件编号",
			align : 'center',
			width : 82,
			sortable : false,
			dataIndex : 'codeName',
			menuDisabled : true
		}, {
			header : "数量",
			align : 'center',
			width : 82,
			sortable : false,
			dataIndex : 'totalNumber',
			menuDisabled : true
		}, {
			header : "备注",
			align : 'center',
			width : 82,
			sortable : false,
			dataIndex : 'bak',
			menuDisabled : true
		}, {
			header : "操作",
			align : 'center',
			text : '操作',
			xtype : 'actioncolumn',
			menuDisabled : true,
			width : 50,
			items : [ {
				icon : '../../style/images/icon-delete.gif',
				tooltip : '操作',
				Align : 'center',
				handler : function(grid, rowIndex, colIndex) {

					if (mNumber == 0) {
						return;
					}

					mNumber = mNmber - 1;
					store.removeAt(rowIndex);
				}
			} ]
		} ],
		viewConfig : {
			forceFit : true
		},
		sm : sm,
		autoWidth : true,
		height : 300,
		stripeRows : true,
		frame : true,
		iconCls : 'icon-grid'
//		tbar : [ {
//			text : '删除',
//			iconCls : 'silk-application-delete',
//			scope : this
//		}, '-' ],
//		bbar : new Ext.PagingToolbar({
//			pageSize : 1,
//			store : store,
//			emptyMsg : "无记录"
//		})
	};

	var partTransfer = {
		xtype : 'fieldset',
		title : '零件交接',
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
			layout : 'form',
			labelWidth : 70,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ _gridPanel ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 80,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'gallery_id',
				fieldLabel : '图库',
				anchor : '85%',
				xtype : 'combo',
				allowBlank : false,
				blankText : '不能为空',
				enableKeyEvents : true
			}, {
				id : 'picid',
				fieldLabel : '图号',
				anchor : '85%',
				xtype : 'combo',
				allowBlank : false,
				blankText : '不能为空',
				enableKeyEvents : true
			}, {
				id : 'subpicid',
				fieldLabel : '子图号',
				anchor : '85%',
				xtype : 'combo',
				allowBlank : false,
				blankText : '不能为空',
				enableKeyEvents : true
			}, {
				id : 'factoryCode',
				fieldLabel : '对应厂商编号',
				anchor : '85%',
				xtype : 'textfield'
			}, {
				id : 'total',
				fieldLabel : '数量',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'add_batch_id',
				fieldLabel : '批量输入功能',
				anchor : '85%',
				xtype : 'panel',
				layout : 'column',
				items : [ {
					columnWidth : .3,
					layout : 'form',
					labelWidth : 35,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '批号',
						xtype : 'textfield',
						width : 70
					} ]
				}, {
					columnWidth : .35,
					layout : 'form',
					labelWidth : 60,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '起始序号',
						xtype : 'numberfield',
						width : 70
					} ]
				}, {
					columnWidth : .35,
					layout : 'form',
					labelWidth : 60,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '结束序号',
						xtype : 'numberfield',
						width : 75
					} ]
				} ]
			}, {
				xtype : 'button',
				text : '增加',
				width : '80',
				style : 'margin-left:84px;',
				handler : function() {
					mNumber = mNumber + 1;
					addFormDataToGrid_handler();
				}
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 80,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'factoryName',
				fieldLabel : '对应厂商名称',
				anchor : '85%',
				xtype : 'textfield'
			}, {
				id : 'componentName',
				fieldLabel : '零件名称',
				anchor : '85%',
				xtype : 'combo'
			}, {
				id : 'Drawingreq_id',
				fieldLabel : '图纸要求',
				anchor : '85%',
				xtype : 'combo',
				enableKeyEvents : true
			}, {
				id : 'componentNumber',
				fieldLabel : '零件编号',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'remark_id',
				fieldLabel : '备注',
				anchor : '85%',
				xtype : 'textfield'
			}, {
				xtype : 'label',
				html : '&nbsp;',
				style : 'margin-bottom : 20px;',
			} ]
		} ]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();
	
	var _flowCommonComp = getFlowCommonComp(taskId);

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "入库电子流处理",
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
				_flowCommonComp],
		buttons : [
				{
					text : "提交",
					handler : function() {

						var _gridData = getGridData();

						// if (Ext.isEmpty(_gridData)) {
						// Ext.Msg.alert("提示", "请先配置零件数据。");
						// return;
						// }

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
							url : '../workflow/submitForm_storage.html',
							timeout : 300000,
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								data : _gridData,
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