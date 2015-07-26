function mainView() {

	var projectInfo = Ext.data.Record.create([ {
		name : 'projectName'
	}, {
		name : 'taskNumber'
	} ]);

	var myReader = new Ext.data.JsonReader({
		root : "data",
	}, projectInfo);

	var _projectStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../workflow/queryProjectName.html',
			method : 'POST'
		}),
		reader : myReader
	});

	var _taskNumStore = new Ext.data.Store({
		autoLoad : true,
		proxy : new Ext.data.HttpProxy({
			url : '../workflow/queryTaskNumber.html',
			method : 'POST'
		}),
		reader : myReader
	});

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "项目申请",
		autoHeight : true,
		autoWidth : true,
		labelWidth : 70,
		labelAlign : "left",
		style : 'margin-top:10px;',
		buttonAlign : 'left',
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
			store : _projectStore,
			allowBlank : false,
			blankText : '不能为空',
			triggerAction : 'all',
			selectOnFocus : true,
			forceSelection : true,
			valueNotFoundText : '',
			emptyText : '请选择...',
			mode : "local",
			valueField : 'projectName',
			displayField : 'projectName',
			listeners : {
				'select' : function() {
					var taskComp = Ext.getCmp("projectNum_id");
					taskComp.store.baseParams.projectName = this.getValue();
					taskComp.setValue();
					_taskNumStore.reload();
				}
			}
		}, {
			id : 'projectNum_id',
			name : "projectNum",
			fieldLabel : "项目编号",
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
			valueField : 'taskNumber',
			displayField : 'taskNumber',
			store : _taskNumStore,
		}, {
			id : 'deviceType_id',
			fieldLabel : "器件类型",
			xtype : 'combo',
			emptyText : '请选择...',
			labelStyle : "margin-left:20px;",
			mode : "local",
			allowBlank : true,
			selectOnFocus : true,
			forceSelection : true,
			triggerAction : 'all',
			valueNotFoundText : '',
			blankText : '不能为空',
			valueField : 'taskNumber',
			displayField : 'taskNumber'
		},  {
			id : 'remark_id',
			xtype : "textarea",
			name : "mask",
			labelStyle : "margin-left:20px;",
			height : 60,
			allowBlank : false,
			blankText : '不能为空',
			fieldLabel : "备注"
		} ],
		buttons : [
				{
					text : "提交",
					handler : function() {

						if (!Ext.getCmp("taskForm_id").getForm().isValid()) {
							return;
						}

						var _projectNameValue = Ext.getCmp("projectName_id")
								.getValue();
						var _taskNumValue = Ext.getCmp("projectNum_id")
								.getValue();
						var _remarkValue = Ext.getCmp("remark_id").getValue();

						Ext.Ajax.request({
							url : '../workflow/saveStorage.html',
							params : {
								projectName : _projectNameValue,
								taskNumber : _taskNumValue,
								info : _remarkValue
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "提交成功",
											forWardToNextPage);
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