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
		name : 'ppid'
	}, {
		name : 'productName'
	} ]);

	var busProductReader = new Ext.data.JsonReader({
		root : "data",
	}, busProduct);

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
			url : '../project/figure/queryProduct.html',
			method : 'POST'
		}),
		reader : busProductReader
	});

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "图库申请",
		autoHeight : true,
//		bodyStyle : "background-color:#F3F9FD",
		autoWidth : true,
		labelWidth : 70,
		labelAlign : "left",
		style : 'margin-top:10px;',
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
					var taskComp = Ext.getCmp("product_id");
					taskComp.store.baseParams.projectId = this.getValue();
					taskComp.setValue();
					_productStore.reload();
				}
			}
		}, {
			id : 'product_id',
			name : "product_name",
			fieldLabel : "产品名称",
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
			valueField : 'ppid',
			displayField : 'productName',
			store : _productStore,
		}, {
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

						var _taskNumValue = Ext.getCmp("product_id").getValue();
						var _remarkValue = Ext.getCmp("remark_id").getValue();

						Ext.Ajax.request({
							url : '../project/figure/saveStorage.html',
							params : {
								ppid : _taskNumValue,
								bak : _remarkValue,
								pdid : pdid
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