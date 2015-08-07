function topView() {
	var proxy = new Ext.data.HttpProxy({
		url : '../project/figure/loadFigureData.html',
		method : 'POST'
	});
	var render = new Ext.data.JsonReader({
		root : 'data',
		totalProperty : 'totalCount'
	}, [ {
		name : 'projectName',
		type : 'string'
	}, {
		name : 'productName',
		type : 'string'
	}, {
		name : 'figureName',
		type : 'string'
	}, {
		name : 'figureNo',
		type : 'string'
	}, {
		name : 'pictureName',
		type : 'string'
	}, {
		name : 'figureRequest',
		type : 'string'
	}, {
		name : 'batchNum',
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

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '105%',
		autoWidth : true,
		style : 'margin-left:82px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ {
			header : "项目名称",
			align : 'center',
			width : 125,
			dataIndex : 'projectName',
			sortable : false,
			menuDisabled : true
		}, {
			header : "产品名称",
			align : 'center',
			width : 125,
			sortable : false,
			dataIndex : 'productName',
			menuDisabled : true
		}, {
			header : "图ID",
			width : 125,
			align : 'center',
			sortable : false,
			dataIndex : 'figureNo',
			menuDisabled : true
		}, {
			header : "图名称",
			align : 'center',
			width : 125,
			sortable : false,
			dataIndex : 'figureName',
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 125,
			sortable : false,
			dataIndex : 'figureRequest',
			menuDisabled : true
		}, {
			header : '数量（套）',
			align : 'center',
			width : 125,
			sortable : false,
			dataIndex : 'batchNum',
			menuDisabled : true
		} ],
		viewConfig : {
			forceFit : true
		},
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
				xtype : 'label',
				anchor : '85%',
				html : '<div style="padding-top:3px">' + projectName + '</div>'
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
				xtype : 'label',
				html : '<div style="padding-top:3px">' + productName + '</div>'
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
	var _processInfoStore = loadProcessInfo(taskId);
	var _processUser = loadProcessUser();
	var _flowCommonComp = getFlowCommonComp(taskId);

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "图库电子流审批",
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
							url : '../project/figure/submitFormStorage.html',
							timeout : 300000,
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								outcome : outcome,
								nextName : nextName
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "图库电子流提交成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "图库电子流提交失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "图库电子流提交失败");
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