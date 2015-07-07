function topView() {

	// create the Data Store
	var store = new Ext.data.Store({
		autoDestroy : true,
		url : '',
		autoload : false,
		reader : new Ext.data.XmlReader({
			record : 'total',
			fields : [ {
				name : 'id',
				type : 'string'
			}, {
				name : 'picid',
				type : 'string'
			}, {
				name : 'componentName',
				type : 'string'
			}, {
				name : 'componentType',
				type : 'int'
			}, {
				name : 'total',
				type : 'int'
			}, {
				name : 'shelfLife',
				type : 'int'
			}, {
				name : 'productfrom',
				type : 'string'
			}, {
				name : 'materialForm',
				type : 'string'
			}, {
				name : 'workinprocessFlag',
				type : 'int'
			}, {
				name : 'measurementUnit',
				type : 'string'
			}, {
				name : 'saveTime',
				type : 'int'
			}, {
				name : 'remark',
				type : 'string'
			}

			]
		}),

		sortInfo : {
			field : 'picid',
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
			width : 100,
			sortable : false,
			dataIndex : 'id',
			menuDisabled : true
		}, {
			header : "图号",
			width : 100,
			sortable : false,
			dataIndex : 'picid',
			menuDisabled : true
		}, {
			header : "零件名称",
			width : 100,
			sortable : false,
			dataIndex : 'componentName',
			menuDisabled : true
		}, {
			header : "数量",
			width : 100,
			sortable : false,
			dataIndex : 'total',
			menuDisabled : true
		}, {
			header : "检验方式",
			width : 100,
			sortable : false,
			dataIndex : 'validType',
			menuDisabled : true
		}, {
			header : "图纸要求",
			width : 100,
			sortable : false,
			dataIndex : 'picRequire',
			menuDisabled : true
		}, {
			header : "检验结果",
			width : 100,
			sortable : false,
			dataIndex : 'validResult',
			menuDisabled : true
		}, {
			header : "不合格性质",
			width : 100,
			sortable : false,
			dataIndex : 'unqualifiedType',
			menuDisabled : true
		}, {
			header : "审理结果",
			width : 100,
			sortable : false,
			dataIndex : 'trialresults',
			menuDisabled : true
		}, {
			header : "备注",
			width : 100,
			sortable : false,
			dataIndex : 'remark',
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
		title : '不合格品审理',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '项目名称',
				xtype : 'combo',
				anchor : '85%'
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				fieldLabel : '任务编号',
				anchor : '85%',
				xtype : 'combo'
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
				id : 'trialresults_id',
				fieldLabel : '审理结果',
				anchor : '85%',
				xtype : 'combo',
				maxLength : 10,
				allowBlank : false,
				blankText : '不能为空'
			}, {
				xtype : 'button',
				text : '增加',
				width : '80',
				style : 'margin-left:104px;',
				handler : addFormDataToGrid_handler
			} ]
		}]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();

	var mainPanel = new Ext.form.FormPanel({
		title : "不合格品审理",
		height : 670,
		width : 1200,
		labelWidth : 100,
		labelAlign : "left",
		style : 'margin-top:10px;',
		buttonAlign : 'left',
		frame : true,
		defaults : {
			xtype : "textfield",
			width : 600
		},
		items : [ _topPanel, {
			name : "operate",
			fieldLabel : "选择您要的操作",
			xtype : 'combo'
		}, {
			name : "operateUser",
			fieldLabel : "处理人员",
			xtype : 'combo'
		}, {
			name : "copyUser",
			fieldLabel : "抄送人员",
			xtype : 'combo'
		}, {
			xtype : "textarea",
			name : "mask",
			height : 50,
			fieldLabel : "批注"
		} ],
		buttons : [ {
			text : "提交",
			handler : function(){
				Ext.Ajax.request({
					url : '../workflow/submitForm_storage.html',
					params : {
						taskId : taskId,
						comment : 'aaa'
					},
					method : 'POST',
					success : function(response) {
						var result = Ext.decode(response.responseText);

						if (result.success) {
							Ext.Msg.alert("提示", "提交成功", forWardToNextPage);
						} else {
							Ext.Msg.alert("提示", "提交失败");
						}
					},
					failure : function() {
						Ext.Msg.alert("提示", "提交失败");
					}
				});
			}
		}, {
			text : "取消"
		} ]
	});

	mainPanel.render("main_id");
}

function forWardToNextPage()
{
	window.location.href = ctxPath + "/background/workflow/submitTask.html?taskId="+taskId;
}

function initview() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'qtip';

	mainView();

};
Ext.onReady(initview);