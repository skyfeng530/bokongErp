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
			header : "项目名称",
			align : 'center',
			width : 125,
			sortable : false,
			menuDisabled : true
		}, {
			header : "产品名称",
			align : 'center',
			width : 125,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图库名称",
			align : 'center',
			width : 125,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图ID",
			width : 125,
			align : 'center',
			sortable : false,
			menuDisabled : true
		}, {
			header : "图名称",
			align : 'center',
			width : 125,
			sortable : false,
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 125,
			sortable : false,
			menuDisabled : true
		}, {
			header : '数量（套）',
			align : 'center',
			width : 125,
			sortable : false,
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
		tbar : [ {
			text : '添加',
			iconCls : 'silk-application-add',
			scope : this,
			handler : addGalleryWindow
		}, '-', {
			text : '删除',
			iconCls : 'silk-application-delete',
			scope : this
		}, '-', {
			text : '修改',
			iconCls : 'silk-application-edit',
			scope : this
		} ],
		bbar : new Ext.PagingToolbar({
			pageSize : 1,
			store : store,
			emptyMsg : "无记录"
		})
	};

	var partTransfer = {
		xtype : 'fieldset',
		title : '图库',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'project_id',
				fieldLabel : '项目名称',
				xtype : 'combo',
				anchor : '85%'
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'product_id',
				fieldLabel : '产品名称',
				anchor : '85%',
				xtype : 'combo'
			} ]
		}, {
			clumnWidth : 1,
			layout : 'form',
			labelWidth : 70,
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
		items : [ _topPanel ],
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
							timeout : 300000,
							params : {},
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

function forWardToNextPage() {

	window.location.href = "../workflow/myTaskList.html?pdid=" + pdid;
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