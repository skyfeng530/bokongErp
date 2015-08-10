function mainView() {

	var busProject = Ext.data.Record.create([ {
		name : 'projectName'
	}, {
		name : 'pid'
	} ]);

	var busProjectReader = new Ext.data.JsonReader({
		root : "data",
	}, busProject);

	var busProduct = Ext.data.Record.create([ {
		name : 'TASKID'
	}, {
		name : 'TASKNO'
	} ]);

	var busProductReader = new Ext.data.JsonReader({
		root : "data",
	}, busProduct);

	var _devicetypeRecord = Ext.data.Record.create([ {
		name : 'DEVID'
	}, {
		name : 'DEVNAME'
	} ]);

	var deviceReader = new Ext.data.JsonReader({
		root : "data",
	}, _devicetypeRecord);

	var _projecttStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../project/figure/queryProjectName.html',
			method : 'POST'
		}),
		reader : busProjectReader
	});

	var _productStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../omstorage/discard/loadTaskId.html',
			method : 'POST'
		}),
		reader : busProductReader
	});

	var _deviceTypeStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../omstorage/discard/loadDeviceType.html',
			method : 'POST'
		}),
		reader : deviceReader
	});

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "报废申请",
		autoHeight : true,
		autoWidth : true,
		labelWidth : 70,
		labelAlign : "left",
		style : 'margin-top:1px;',
		buttonAlign : 'left',
		border : false,
		frame : true,
		defaults : {
			xtype : "textfield",
			width : 300
		},
		items : [ {
			id : 'projectName_id',
			name : "projectName_name",
			labelStyle : "margin-left:20px;",
			fieldLabel : "项目名称",
			xtype : 'combo',
			store : _projecttStore,
			allowBlank : false,
			blankText : '不能为空',
			triggerAction : 'all',
			selectOnFocus : true,
			forceSelection : true,
			valueNotFoundText : '',
			emptyText : '请选择...',
			mode : "local",
			valueField : 'pid',
			displayField : 'projectName',
			listeners : {
				'select' : function() {
					var taskComp = Ext.getCmp("taskNo_id");
					taskComp.store.baseParams.projectId = this.getValue();
					taskComp.setValue();
					_productStore.reload();
				}
			}
		}, {
			id : 'taskNo_id',
			name : "taskNo_Name",
			fieldLabel : "任务编号",
			labelStyle : "margin-left:20px;",
			xtype : 'combo',
			emptyText : '请选择...',
			mode : "local",
			allowBlank : false,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			blankText : '不能为空',
			valueField : 'TASKID',
			displayField : 'TASKNO',
			store : _productStore,
		}, {
			id : 'category_id',
			name : "category_name",
			fieldLabel : "器件类型",
			labelStyle : "margin-left:20px;",
			xtype : 'combo',
			emptyText : '请选择...',
			mode : "local",
			allowBlank : false,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			blankText : '不能为空',
			valueField : 'DEVID',
			displayField : 'DEVNAME',
			store : _deviceTypeStore,
		}, {
			id : 'scrapType_id',
			name : "scrapType_name",
			fieldLabel : "报废类型",
			labelStyle : "margin-left:20px;",
			xtype : 'combo',
			emptyText : '请选择...',
			mode : "local",
			allowBlank : false,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			blankText : '不能为空',
			valueField : 'value',
			displayField : 'text',
			store : workflow.states.scrapStore,
		} ],
		buttons : [
				{
					text : "提交",
					handler : function() {

						if (!Ext.getCmp("taskForm_id").getForm().isValid()) {
							return;
						}

						var _taskIdValue = Ext.getCmp("taskNo_id").getValue();
						var _devTypeValue = Ext.getCmp("category_id")
								.getValue();
						var _discardTypeValue = Ext.getCmp("scrapType_id")
								.getValue();

						Ext.Ajax.request({
							url : '../omstorage/discard/saveStorage.html',
							params : {
								pdid : pdid,
								taskId : _taskIdValue,
								devType : _devTypeValue,
								discardType : _discardTypeValue
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "报废电子流申请创建成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "报废电子流申请创建失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "报废电子流申请创建失败");
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