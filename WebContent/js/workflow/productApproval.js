function topView() {
	// create the Data Store
	var page_size = 10;
	var gridStore = new Ext.data.Store({ 
		autoLoad: false,
        proxy: new Ext.data.HttpProxy({ url: "../../background/project/product/flow/queryall.html"}),  
        reader: new Ext.data.JsonReader(  
                      {
                    	  totalProperty:'totalProperty',
                          root:'data'
                      },  
                      [
                       {name:'productNo'},
                       {name:'productName'},
                       {name:'status'},
                       {name:'bak'}
                       ]
                      ),
	      listeners: {  
	          'beforeload': function (store, op, options) {  
	              var params = {  
	          		    flowId:flowId,
	          		    projectId:projectId
	              };  
	              Ext.apply(store.proxy.extraParams, params);   
	          }  
	      } 
    });  
	gridStore.load({
		   params : {
		    start : 0,  
		    limit : page_size,
		    flowId:flowId,
		    projectId:projectId
		   } 
	});
	var sm = new Ext.grid.CheckboxSelectionModel();

	var colum=new Ext.grid.ColumnModel(
		    [
		    sm,
		    {
		    	 header:"产品编号",
		         dataIndex:"productNo",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:150
		    },
		    {
		    	 header:"产品名称",
		         dataIndex:"productName",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:150
		    },
		    {
		    	 header:"状态",
		         dataIndex:"status",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:150
		    },
		    {
		    	 header:"备注",
		         dataIndex:"bak",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:300
		    }]);
		    
    var bbar=new Ext.PagingToolbar({
        pageSize:page_size,
        store:gridStore,
        displayInfo:true,
        lastText:"尾页",
        nextText:"下一页",
        beforePageText:"当前",
        refreshText:"刷新",
        afterPageText:"页，共{0}页",
        displayMsg: '显示 {0} - {1} 共 {2}条&nbsp&nbsp&nbsp&nbsp',
        emptyMsg:"对不起，没有您查询的信息&nbsp&nbsp&nbsp&nbsp"
       });
    bbar.on("beforechange", 
    		function(_p, _o)
    		{
		       Ext.apply(_o, { flowId:flowId,projectId:projectId });//增加自定义参数
			   return true;
			}, 
            this);
    
	var _gridPanel = new Ext.grid.GridPanel({
		id:'greidId',
		width : '105%',
	    height:345,
	    style : 'margin-left:55px; margin-top:10px; margin-bottom:10px',
		store:gridStore,
		cm:colum,
		stripeRows:true,
		bbar:bbar,
		sm : sm,
		viewConfig : {
			forceFit : true
		},
		frame : true,
		iconCls : 'icon-grid'
	});

	var partTransfer = {
		xtype : 'fieldset',
		title : '产品',
		autoHeight : true,
		width : 1132,
		layout : 'column',
		items : [ {
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
				html : '<div style="padding-top:3px">' + projectName + '</div>'
			} ]
		}, {
			clumnWidth : 1,
			layout : 'form',
			labelWidth : 70,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ _gridPanel]
		}]
	};
	return partTransfer;
}
function mainView() {
	var _topPanel = topView();
	var _flowCommonComp = getFlowCommonComp(taskId);

	var mainPanel = new Ext.form.FormPanel({
		id : 'taskForm_id',
		title : "审批产品电子流",
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
		items : [
				_topPanel,
				_flowCommonComp],
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

						var commonRemarkValue = Ext.getCmp("commonMask_id").getValue();
						var outcome = Ext.getCmp("processId").getValue();
						var nextName = Ext.getCmp("processUserId").getValue();

						Ext.Ajax.request({
							url : '../workflow/submit_product.html',
							timeout : 300000,
							params : {
								taskId : taskId,
								comment : commonRemarkValue,
								projectName : projectName,
								outcome : outcome,
								nextName : nextName,
								projectId:projectId,
								flowId:flowId
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "产品电子流审批成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "产品电子流审批失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "入库电子流审批失败");
							}
						});

					}
				}, {
					text : "取消",
					handler : forWordPraPage
				} ]
	});
	mainPanel.render("main_id");
}
function forWardToNextPage() 
{
	window.location.href = "../workflow/myTaskList.html";
}
function showDialog(title)
{
	Ext.getCmp('topFormId').setTitle(title);
	Ext.getCmp('topFormId').show();
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