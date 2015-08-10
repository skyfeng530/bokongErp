function topView() {

	var partTransfer = {
		xtype : 'fieldset',
		title : '任务',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
			clumnWidth : 1,
			layout : 'form',
			labelWidth : 100,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'project_id',
				fieldLabel : '项目名称',
				xtype : 'label',
				anchor : '85%',
				html : '<div style="padding-top:3px">' + projectName + '</div>'
			}, {
				id : 'product_id',
				fieldLabel : '产品名称',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + productName + '</div>'
			},  {
				id : 'figureLib_id',
				fieldLabel : '图库名称',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + figureLib + '</div>'
			},{
				id : 'taskNo_id',
				fieldLabel : '任务编号',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空',
				width : 300
			}, {
				id : 'taskSource_id',
				fieldLabel : '任务来源',
				xtype : 'textfield',
				allowBlank : false,
				blankText : '不能为空',
				width : 300
			}, {
				id : 'taskTotal_id',
				fieldLabel : '总套数（任务量）',
				xtype : 'numberfield',
				allowDecimals:false,
				allowBlank : false,
				blankText : '不能为空',
				minValue:1,  
				minText:'最小值为1。',
				width : 300
			} ]
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
		id : 'taskForm_id',
		title : "任务电子流处理",
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
						
						if (!Ext.getCmp("taskNo_id").isValid()) {
							return;
						}
						
						if (!Ext.getCmp("taskSource_id").isValid()) {
							return;
						}
						
						if (!Ext.getCmp("taskTotal_id").isValid()) {
							return;
						}

						var commonRemarkValue = Ext.getCmp("commonMask_id")
								.getValue();
						var outcome = Ext.getCmp("processId").getValue();
						var nextName = Ext.getCmp("processUserId").getValue();
						
						var taskNoValue = Ext.getCmp("taskNo_id").getValue();
						var taskSourceValue = Ext.getCmp("taskSource_id").getValue();
						var tasktotalValue = Ext.getCmp("taskTotal_id").getValue();

						Ext.Ajax.request({
							url : '../project/task/submitFormStorage.html',
							timeout : 300000,
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								outcome : outcome,
								nextName : nextName,
								taskNo : taskNoValue,
								totalSetNum : tasktotalValue,
								taskSource : taskSourceValue,
								flowId : flowId
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "任务电子流提交成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "任务电子流提交失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "任务电子流提交失败");
							}
						});

					}
				}, {
					text : "取消",
					handler : forWordPraPage
				} ]
	});

	mainPanel.render("main_id");
	
	if(!Ext.isEmpty(taskno))
	{
		Ext.getCmp("taskNo_id").setValue(taskno);
		var taskSourceValue = Ext.getCmp("taskSource_id").getValue();
		var tasktotalValue = Ext.getCmp("taskTotal_id").getValue();
	}
	
	if(!Ext.isEmpty(tasksource))
	{
		Ext.getCmp("taskSource_id").setValue(tasksource);
	}
	
	if(!Ext.isEmpty(totalsetno))
	{
		Ext.getCmp("taskTotal_id").setValue(totalsetno);
	}
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