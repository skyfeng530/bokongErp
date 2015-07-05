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
			width : 80,
			sortable : false,
			dataIndex : 'id',
			menuDisabled : true
		}, {
			header : "图号",
			width : 80,
			sortable : false,
			dataIndex : 'picid',
			menuDisabled : true
		}, {
			header : "零件名称",
			width : 80,
			sortable : false,
			dataIndex : 'componentName',
			menuDisabled : true
		}, {
			header : "类别",
			width : 80,
			sortable : false,
			dataIndex : 'componentType',
			menuDisabled : true,
			renderer : category_rendererFunc
		},{
			header : "在制品标识",
			width : 80,
			sortable : false,
			dataIndex : 'workinprocessFlag',
			menuDisabled : true,
			renderer : workinprocess_rendererFunc
		}, {
			header : "数量",
			width : 80,
			sortable : false,
			dataIndex : 'total',
			menuDisabled : true
		}, {
			header : "计量单位",
			width : 80,
			sortable : false,
			dataIndex : 'measurementUnit',
			menuDisabled : true
		}, {
			header : "保存期",
			width : 80,
			sortable : false,
			dataIndex : 'shelfLife',
			menuDisabled : true
		}, {
			header : "保存期单位",
			width : 80,
			sortable : false,
			dataIndex : 'saveTime',
			menuDisabled : true,
			renderer : savetime_rendererFunc
		}, {
			header : "产品来源",
			width : 80,
			sortable : false,
			dataIndex : 'productfrom',
			menuDisabled : true
		}, {
			header : "物料形态",
			width : 80,
			sortable : false,
			dataIndex : 'materialForm',
			menuDisabled : true
		}, {
			header : "备注",
			width : 80,
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
				id : 'validMethod_Id',
				fieldLabel : '检验方式',
				anchor : '85%',
				xtype : 'combo',
				store : workflow.states.validMethodStore,
				emptyText : '请选择...',
				mode : 'local',
				valueField : 'value',
				displayField : 'text'
			}, ]
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
			}]
		} ]
	};

	return partTransfer;
}

function mainView() {
	var _topPanel = topView();

	var mainPanel = new Ext.form.FormPanel({
		title : "库管审核",
		height : 630,
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
				Ext.Msg.alert("提示", "提交成功", forWardToNextPage);
			}
		}, {
			text : "取消"
		} ]
	});

	mainPanel.render("main_id");
}

function forWardToNextPage()
{
	window.location.href = "../../background/workflow/toIntaskCheckPage.html?pdid="+pdid;
}

function initview() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'qtip';
	mainView();

};
Ext.onReady(initview);