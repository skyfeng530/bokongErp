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
		id  : 'taskForm_id',
		title : "项目申请",
		autoHt : true,
		autoWidth : true,
		labelWidth : 100,
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
			fieldLabel : "项目名称",
			xtype : 'combo',
			store : _projectStore,
			allowBlank : false,
			blankText : '不能为空',
			selectOnFocus : true,
			editable : false,
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
			xtype : 'combo',
			emptyText : '请选择...',
			mode : "local",
			allowBlank : false,
			selectOnFocus : true,
			editable : false,
			forceSelection : true,
			valueNotFoundText : '',
			blankText : '不能为空',
			valueField : 'taskNumber',
			displayField : 'taskNumber',
			store : _taskNumStore,
		}, {
			id : 'remark_id',
			xtype : "textarea",
			name : "mask",
			height : 60,
			allowBlank : false,
			blankText : '不能为空',
			fieldLabel : "备注"
		} ],
		buttons : [
				{
					text : "提交",
					handler : function() {

						if(!Ext.getCmp("taskForm_id").getForm().isValid())
						{
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
	mainView();

};
Ext.onReady(initview);