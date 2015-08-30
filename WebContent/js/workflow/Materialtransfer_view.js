// 序号
var mNumber = 0;

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
			limit : 10,
			offset : 0
		}
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
			header : "图号",
			width : 120,
			align : 'center',
			sortable : false,
			dataIndex : 'FIGURENO',
			menuDisabled : true
		}, {
			header : "厂商名称",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'VENDORNO',
			menuDisabled : true
		}, {
			header : "零件名称",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'FIGURENAME',
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'FIGUREREQUEST',
			menuDisabled : true
		}, {
			header : "数量",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'TOTALNUMBER',
			menuDisabled : true
		}, {
			header : "零件编号",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'DEVBATCHNO',
			menuDisabled : true
		}, {
			header : "备注",
			align : 'center',
			width : 120,
			sortable : false,
			dataIndex : 'BAK',
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

					store.removeAt(rowIndex);
					
					var clearAllFlag = false;
					
					if(store.getCount() == 0)
					{
						clearAllFlag = true;
					}

					var _girdData = getGridData();

					Ext.Ajax.request({
						url : '../omInStorage/saveGridData.html',
						params : {
							data : _girdData,
							clearall : clearAllFlag,
							flowId : flowId
						},
						method : 'POST',
						success : function(response) {
							var result = Ext.decode(response.responseText);

							store.reload({
								params : {
									start : 0,
									limit : 10,
									flowId : flowId
								}
							});
							
							loadMaxNoValue(flowId);
						},
						failure : function() {
							Ext.Msg.alert("提示", "添加失败");
						}
					});
				}
			} ]
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
		// tbar : [ {
		// text : '删除',
		// iconCls : 'silk-application-delete',
		// scope : this
		// }, '-' ],
		bbar : new Ext.PagingToolbar({
			pageSize : 1,
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
		items : [
				{
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
						html : '<div style="padding-top:3px">' + projectName
								+ '</div>'
					} ]
				},
				{
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
						html : '<div style="padding-top:3px">' + taskName
								+ '</div>'
					} ]
				},
				{
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
						html : '<div style="padding-top:3px">' + deviceType
								+ '</div>'
					} ]
				},
				{
					clumnWidth : 1,
					layout : 'form',
					labelWidth : 70,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ _gridPanel ]
				},
				{
					columnWidth : .5,
					layout : 'form',
					labelWidth : 80,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [
							{
								id : 'picid',
								fieldLabel : '图号',
								anchor : '85%',
								xtype : 'combo',
								mode : "remote",
								allowBlank : false,
								editable : false,
								blankText : '不能为空',
								emptyText : '请选择...',
								selectOnFocus : true,
								forceSelection : true,
								triggerAction : 'all',
								valueNotFoundText : '',
								valueField : 'FIGURENO',
								displayField : 'FIGURENO',
								enableKeyEvents : true,
								store : new Ext.data.Store({
									autoLoad : true,
									proxy : new Ext.data.HttpProxy({
										url : '../omInStorage/loadFigure.html',
										method : 'POST'
									}),
									baseParams : {
										bustaskId : bustaskId,
										deviceType : ideviceType
									},
									reader : new Ext.data.JsonReader({
										root : "data",
									}, Ext.data.Record.create([ {
										name : 'FIGURENO'
									}, {
										name : 'FIGURENAME'
									} ]))
								}),
								listeners : {
									'select' : function(i, r) {
										Ext.getCmp("componentName_id")
												.setValue(r.data.FIGURENAME);

										var drawingReq = Ext
												.getCmp("Drawingreq_id");
										drawingReq.store.baseParams.figureno = this
												.getValue();
										drawingReq.setValue();
										drawingReq.getStore().reload();
									}
								}
							},
							{
								id : 'componentName_id',
								fieldLabel : '零件名称',
								anchor : '85%',
								xtype : 'textfield',
								readOnly : true
							},
							{
								id : 'add_batch_id',
								fieldLabel : '批量添加',
								anchor : '85%',
								xtype : 'panel',
								layout : 'column',
								items : [
										{
											columnWidth : .2,
											layout : 'form',
											labelWidth : 35,
											labelAlign : "left",
											baseCls : "x-plain",
											labelAlign : "left",
											items : [ {
												id : 'batchNo_id',
												fieldLabel : '批号',
												xtype : 'label',
												html : '<div style="padding-top:3px">'
														+ "P"
														+ batchno
														+ '</div>'
											} ]
										},
										{
											columnWidth : .23,
											layout : 'form',
											labelWidth : 60,
											labelAlign : "left",
											baseCls : "x-plain",
											labelAlign : "left",
											items : [ {
												id : 'batch_start_id',
												fieldLabel : '起始序号',
												xtype : 'label',
												html : '<div id="deviceMaxValue_id" style="padding-top:3px">'
														+ deviceMaxValue
														+ '</div>'
											} ]
										}, {
											columnWidth : .35,
											layout : 'form',
											labelWidth : 60,
											labelAlign : "left",
											baseCls : "x-plain",
											labelAlign : "left",
											items : [ {
												id : 'batch_end_id',
												fieldLabel : '结束序号',
												xtype : 'numberfield',
												width : 70,
												decimalPrecision : 0,
												allowNegative : false,
												minValue : 1,
												minText : '只能输入大于1的整数'
											} ]
										} ]
							}, {
								id : 'remark_id',
								fieldLabel : '备注',
								anchor : '85%',
								xtype : 'textfield'
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
						id : 'factoryCode',
						fieldLabel : '厂商名称',
						anchor : '85%',
						xtype : 'textfield',
						maxLength : 64,
						allowBlank : false,
						blankText : '不能为空'
					}, {
						id : 'Drawingreq_id',
						fieldLabel : '图纸要求',
						anchor : '85%',
						enableKeyEvents : true,
						xtype : 'combo',
						mode : "remote",
						allowBlank : false,
						editable : false,
						blankText : '不能为空',
						emptyText : '请选择...',
						selectOnFocus : true,
						forceSelection : true,
						triggerAction : 'all',
						valueNotFoundText : '',
						valueField : 'PFID',
						displayField : 'FIGUREREQUEST',
						enableKeyEvents : true,
						store : new Ext.data.Store({
							autoLoad : true,
							proxy : new Ext.data.HttpProxy({
								url : '../omInStorage/loadFigureRequest.html',
								method : 'POST'
							}),
							reader : new Ext.data.JsonReader({
								root : "data",
							}, Ext.data.Record.create([ {
								name : 'PFID'
							}, {
								name : 'FIGUREREQUEST'
							} ]))
						})
					}, {
						id : 'total_id',
						fieldLabel : '数量',
						anchor : '85%',
						xtype : 'numberfield',
						allowBlank : false,
						blankText : '不能为空',
						maxLength : 10,
						decimalPrecision : 0,
						allowNegative : false,
						minValue : 1,
						minText : '只能输入大于1的整数'
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
							url : '../omInStorage/submitForm_storage.html',
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

	if ("光学" == deviceType) {
		Ext.getCmp("total_id").setValue(1);
		Ext.getCmp("total_id").setDisabled(true);
	} else {
		Ext.getCmp("total_id").reset();
		Ext.getCmp("total_id").setDisabled(false);
	}
}

function loadMaxNoValue(flowId)
{
	Ext.Ajax.request({
		url : '../omInStorage/queryDevStart.html',
		params : {
			flowId : flowId
		},
		method : 'POST',
		success : function(response) {
			var result = Ext.decode(response.responseText);

			document.getElementById("deviceMaxValue_id").innerHTML = result.data;
			deviceMaxValue = result.data;
		},
		failure : function() {
		}
	});
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