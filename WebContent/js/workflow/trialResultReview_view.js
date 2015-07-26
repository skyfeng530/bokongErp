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

	var sm = new Ext.grid.CheckboxSelectionModel();

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '104%',
		style : 'margin-left:102px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ sm, {
			header : "序号",
			width : 45,
			sortable : false,
			dataIndex : 'materialNumber',
			menuDisabled : true
		}, {
			header : "图库",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "对应厂商名称",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图号",
			width : 45,
			sortable : false,
			dataIndex : 'idNumber',
			menuDisabled : true
		}, {
			header : "子图号",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "零件名称",
			width : 45,
			sortable : false,
			dataIndex : 'name',
			menuDisabled : true
		}, {
			header : '对应厂商编号',
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "零件编号",
			width : 45,
			sortable : false,
			dataIndex : 'codeName',
			menuDisabled : true
		}, {
			header : "数量",
			width : 45,
			sortable : false,
			dataIndex : 'totalNumber',
			menuDisabled : true
		}, {
			header : "检验结果",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "检验数量",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "合格数量",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "不合格数量",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "不合格原因",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "合格等级",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "审理单号",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "处理结果",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "审理组织",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图片",
			width : 45,
			sortable : false,
			menuDisabled : true
		}, {
			header : "备注",
			width : 45,
			sortable : false,
			menuDisabled : true
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
		title : '不合格品审理',
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
		} ]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();

	var _processInfoStore = loadProcessInfo(taskId);
	var _processUser = loadProcessUser();

	var mainPanel = new Ext.form.FormPanel({
		title : "检验人员审核审理结果",
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
		items : [ _topPanel, {
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
			displayField : 'text'
		}, {
			id : 'processUserId',
			name : "operateUser",
			fieldLabel : "处理人员",
			xtype : 'combo',
			store : _processUser,
			allowBlank : false,
			triggerAction : 'all',
			blankText : '不能为空',
			selectOnFocus : true,
			forceSelection : true,
			valueNotFoundText : '',
			emptyText : '请选择...',
			mode : "local",
			valueField : 'userName',
			displayField : 'userName',
		}, {
			name : "copyUser",
			fieldLabel : "抄送人员",
			xtype : 'combo'
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