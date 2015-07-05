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
			width : 120,
			sortable : false,
			dataIndex : 'id',
			menuDisabled : true
		}, {
			header : "图号",
			width : 120,
			sortable : false,
			dataIndex : 'picid',
			menuDisabled : true
		}, {
			header : "零件名称",
			width : 120,
			sortable : false,
			dataIndex : 'componentName',
			menuDisabled : true
		}, {
			header : "类别",
			width : 120,
			sortable : false,
			dataIndex : 'componentType',
			menuDisabled : true,
			renderer : category_rendererFunc
		}, {
			header : "零件编号",
			width : 120,
			sortable : false,
			dataIndex : 'workinprocessFlag',
			menuDisabled : true,
			renderer : workinprocess_rendererFunc
		}, {
			header : "数量",
			width : 120,
			sortable : false,
			dataIndex : 'total',
			menuDisabled : true
		},
		// {
		// header : "计量单位",
		// width : 80,
		// sortable : false,
		// dataIndex : 'measurementUnit',
		// menuDisabled : true
		// }, {
		// header : "保存期",
		// width : 80,
		// sortable : false,
		// dataIndex : 'shelfLife',
		// menuDisabled : true
		// }, {
		// header : "保存期单位",
		// width : 80,
		// sortable : false,
		// dataIndex : 'saveTime',
		// menuDisabled : true,
		// renderer : savetime_rendererFunc
		// }, {
		// header : "产品来源",
		// width : 80,
		// sortable : false,
		// dataIndex : 'productfrom',
		// menuDisabled : true
		// }, {
		// header : "物料形态",
		// width : 80,
		// sortable : false,
		// dataIndex : 'materialForm',
		// menuDisabled : true
		// },
		{
			header : "备注",
			width : 120,
			sortable : false,
			dataIndex : 'remark',
			menuDisabled : true
		}, {
			header : "操作",
			text : '操作',
			xtype : 'actioncolumn',
			width : 50,
			items : [ {
				icon : '../../style/images/icon-delete.gif',
				tooltip : '操作',
				handler : function(grid, rowIndex, colIndex) {
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
		iconCls : 'icon-grid',
		tbar : [ {
			text : '删除',
			iconCls : 'silk-application-delete',
			scope : this
		}, '-' ],
		bbar : new Ext.PagingToolbar({
			pageSize : 10,
			store : store,
			emptyMsg : "无记录"
		})
	};

	var partTransfer = {
		xtype : 'fieldset',
		title : '零件交接',
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
				id : 'picid',
				fieldLabel : '图号',
				anchor : '85%',
				xtype : 'textfield',
				maxLength : 10,
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'componentType',
				fieldLabel : '类别',
				anchor : '85%',
				xtype : 'combo',
				store : workflow.states.categoryStore,
				emptyText : '请选择...',
				mode : 'local',
				valueField : 'value',
				displayField : 'text',
				selectOnFocus : true,
				editable : false,
				forceSelection : true,
				valueNotFoundText : '',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'total',
				fieldLabel : '数量',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'savePic_id',
				fieldLabel : '上传图片',
				anchor : '85%',
				xtype : 'fileuploadfield',
				allowBlank : false,
				blankText : '不能为空',
				emptyText : '请选择要上传的文件...',
				buttonText : '',
				buttonCfg : {
					iconCls : 'upload-icon'
				}
			}
			// , {
			// id : 'Shelf_life',
			// fieldLabel : '保存期',
			// anchor : '85%',
			// xtype : 'textfield',
			// allowBlank : false,
			// blankText : '不能为空'
			// }, {
			// id : 'productfrom',
			// fieldLabel : '产品来源',
			// anchor : '85%',
			// xtype : 'textfield',
			// allowBlank : false,
			// blankText : '不能为空'
			// }, {
			// id : 'Material_form',
			// fieldLabel : '物料形态',
			// xtype : 'textfield',
			// anchor : '85%',
			// allowBlank : false,
			// blankText : '不能为空'
			// }
			, {
				xtype : 'button',
				text : '增加',
				width : '80',
				style : 'margin-left:104px;',
				handler : addFormDataToGrid_handler
			} ]
		}, {
			columnWidth : .5,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'componentName',
				fieldLabel : '零件名称',
				anchor : '85%',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空'
			}, {
				id : 'workinprocessFlag',
				fieldLabel : '零件编号',
				anchor : '85%',
				xtype : 'combo',
				store : workflow.states.workInProcessStore,
				emptyText : '请选择...',
				mode : 'local',
				valueField : 'value',
				displayField : 'text',
				selectOnFocus : true,
				editable : false,
				forceSelection : true,
				valueNotFoundText : '',
				allowBlank : false,
				blankText : '不能为空'
			}
			// , {
			// id : 'Measurement_unit',
			// fieldLabel : '计量单位',
			// anchor : '85%',
			// xtype : 'textfield',
			// allowBlank : false,
			// blankText : '不能为空'
			// }, {
			// id : 'saveTimeid',
			// fieldLabel : '保存期单位',
			// anchor : '85%',
			// xtype : 'combo',
			// store : workflow.states.saveTimeStore,
			// emptyText : '请选择...',
			// mode : 'local',
			// valueField : 'value',
			// displayField : 'text',
			// selectOnFocus : true,
			// editable : false,
			// forceSelection : true,
			// valueNotFoundText : '',
			// allowBlank : false,
			// blankText : '不能为空'
			// }
			, {
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

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "入库电子流处理",
		height : 780,
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
			handler : function() {

				Ext.Ajax.request({
					url : '../workflow/submitTask.html',
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

function forWardToNextPage() {

	window.location.href = "../workflow/submitTask.html?taskId=" + taskId;
}

function initview() {
	Ext.QuickTips.init();
	Ext.form.Field.prototype.msgTarget = 'qtip';

	mainView();

};
Ext.onReady(initview);