function mainView() {

	var projectInfo = Ext.data.Record.create([ {
		name : 'PROJECTNAME'
	}, {
		name : 'PID'
	} ]);

	var myReader = new Ext.data.JsonReader({
		root : "data",
	}, projectInfo);

	var _projectStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../workflow/loadProject.html',
			method : 'POST'
		}),
		reader : myReader
	});

	var taskRecord = Ext.data.Record.create([ {
		name : 'TASKID'
	}, {
		name : 'TASKNO'
	} ]);

	var taskReader = new Ext.data.JsonReader({
		root : "data",
	}, taskRecord);

	var _taskNumStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../workflow/loadTask.html',
			method : 'POST'
		}),
		reader : taskReader
	});

	var _devicetypeRecord = Ext.data.Record.create([ {
		name : 'DEVID'
	}, {
		name : 'DEVNAME'
	} ]);

	var deviceReader = new Ext.data.JsonReader({
		root : "data",
	}, _devicetypeRecord);

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
		fileUpload: true,
		title : "项目申请",
		autoHeight : true,
		bodyStyle : "background-color:#F3F9FD",
		autoWidth : true,
		labelWidth : 130,
		labelAlign : "left",
		style : 'margin-top:10px;',
		buttonAlign : 'left',
		border : false,
		frame : false,
		defaults : {
			xtype : "textfield",
			width : 300
		},
		items : [ {
			id : 'projectName_id',
			name : "projectName_name",
			labelStyle : "margin-left:20px;",
			style : 'margin-left:-20px;',
			fieldLabel : "项目名称",
			xtype : 'combo',
			store : _projectStore,
			allowBlank : false,
			blankText : '不能为空',
			triggerAction : 'all',
			selectOnFocus : true,
			forceSelection : true,
			valueNotFoundText : '',
			emptyText : '请选择...',
			editable : false,
			mode : "local",
			valueField : 'PID',
			displayField : 'PROJECTNAME',
			listeners : {
				'select' : function() {
					var taskComp = Ext.getCmp("taskNo_id");
					taskComp.store.baseParams.projectId = this.getValue();
					taskComp.setValue();
					_taskNumStore.reload();
				}
			}
		}, {
			id : 'taskNo_id',
			name : "taskNo_Name",
			fieldLabel : "任务编号",
			style : 'margin-left:-20px;',
			labelStyle : "margin-left:20px;",
			xtype : 'combo',
			emptyText : '请选择...',
			mode : "local",
			allowBlank : false,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			editable : false,
			blankText : '不能为空',
			valueField : 'TASKID',
			displayField : 'TASKNO',
			store : _taskNumStore,
		}, {
			id : 'deviceType_id',
			fieldLabel : "器件类型",
			xtype : 'combo',
			emptyText : '请选择...',
			style : 'margin-left:-20px;',
			labelStyle : "margin-left:20px;",
			mode : "local",
			allowBlank : true,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			blankText : '不能为空',
			editable : false,
			valueField : 'DEVID',
			displayField : 'DEVNAME',
			store : _deviceTypeStore,
		}, {
			id: 'form-file',
			 name: 'form-file-path',
			fieldLabel : '零件交接明细表图片',
			labelStyle : "margin-left:20px;",
			xtype : 'fileuploadfield',
			allowBlank : false,
			blankText : '不能为空',
			emptyText : '请选择要上传的文件...',
			buttonText : '',
			regex:/\.jpg$/,
			regexText : '上传文件类型只能是*.jpg',
			buttonCfg : {
				iconCls : 'silk-application-upload'
			}
		}, {
			id : 'remark_id',
			style : 'margin-left:-20px;',
			xtype : "textarea",
			name : "mask",
			labelStyle : "margin-left:20px;",
			height : 60,
			maxLength : 100,
			fieldLabel : "备注"
		} ],
		buttons : [
				{
					text : "提交",
					handler : function() {

						if (!Ext.getCmp("taskForm_id").getForm().isValid()) {
							return;
						}

						var _projectIdValue = Ext.getCmp("projectName_id")
								.getValue();
						var _taskIdValue = Ext.getCmp("taskNo_id").getValue();
						var deviceIdValue = Ext.getCmp("deviceType_id")
								.getValue();
						var _remarkValue = Ext.getCmp("remark_id").getValue();
						
						Ext.getCmp("taskForm_id").getForm().submit({
							url : '../omInStorage/startOminstorageFlow.html',
							params : {
								projectid : _projectIdValue,
								taskId : _taskIdValue,
								devtypeid : deviceIdValue,
								bak : _remarkValue
							},
							method : 'POST',
							success : function(form, action){
								if (action.result.success) {
									Ext.Msg.alert("提示", "入库电子流创建成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "入库电子流创建失败");
								}
							
							},
							 failure : function(form,action) {
								 Ext.Msg.alert("提示", "入库电子流创建失败");
							 }
						});
					}
				}, {
					text : "取消",
					handler : function()
					{
						forWordPraPage();
					}
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