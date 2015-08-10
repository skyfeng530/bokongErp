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
			unqualifiedGrade : 1,
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

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '104%',
		style : 'margin-left:102px; margin-top:10px; margin-bottom:10px',
		store : store,
		columns : [ sm, {
			header : "图号",
			width : 55,
			align : 'center',
			sortable : false,
			dataIndex : 'FIGURENO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "对应厂商编号",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'VENDORNO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "零件名称",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'FIGURENAME',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'FIGUREREQUEST',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "数量",
			align : 'center',
			align : 'center',
			width : 40,
			sortable : false,
			dataIndex : 'TOTALNUMBER',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "零件编号",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'DEVBATCHNO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "检验结果",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'CHECKRST',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "检验数量",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'CHECKNUM',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "不合格数量",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'UNQUALIFIEDNUM',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "合格等级",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'UNQUALIFIEDGRADE',
			renderer : unqualifiedgrade_display,
			menuDisabled : true
		}, {
			header : "不合格原因",
			align : 'center',
			width : 60,
			sortable : false,
			dataIndex : 'UNQUALIFIEDREASON',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "审理单号",
			align : 'center',
			width : 90,
			sortable : false,
			dataIndex : 'REVIEWNO',
			renderer : renderer_handler,
			menuDisabled : true
		}, {
			header : "审理结果",
			align : 'center',
			width : 60,
			sortable : false,
			dataIndex : 'REVIEWRST',
			renderer : reviewrst_renderer_handler,
			menuDisabled : true
		}, {
			header : "审理组织",
			align : 'center',
			width : 55,
			sortable : false,
			dataIndex : 'REVIEWGRP',
			renderer : reviewgroup_renderer_handler,
			menuDisabled : true
		},
		// {
		// header : "图片",
		// width : 55,
		// sortable : false,
		// dataIndex : 'GRAPHICPATH',
		// renderer : renderer_handler,
		// menuDisabled : true
		// },
		{
			header : "备注",
			align : 'center',
			width : 55,
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
		title : '审理结果',
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
				html : '<div style="padding-top:3px">' + deviceType + '</div>'
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

	var _flowCommonComp = getFlowCommonComp(taskId);

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
		items : [ _topPanel, _flowCommonComp ],
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