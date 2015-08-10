function topView() {
	// create the Data Store
	var page_size = 10;
	var gridStore = new Ext.data.Store({ 
		autoLoad: false,
        proxy: new Ext.data.HttpProxy({ url: "../../background/project/figure/loadFigureData.html"}),  
        reader: new Ext.data.JsonReader(  
                      {
                    	  totalProperty:'totalCount',
                          root:'data'
                      },  
                      [
                       {name:'flowId'},
                       {name:'figureNo'},
                       {name:'figureName'},
                       {name:'figureRequest'},
                       {name:'type'},
                       {name:'batchNum'},
                       {name:'describe'},
                       {name:'devid'}
                       ]
                      ),
	      listeners: {  
	          'beforeload': function (store, op, options) {  
	              var params = {  
	          		    flowId:flowId,
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
		   } 
	});

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
		       Ext.apply(_o, { flowId:flowId });//增加自定义参数
			   return true;
			}, 
            this);
	var sm = new Ext.grid.CheckboxSelectionModel();

	var _gridPanel = {
		id : '_gridPanel_id',
		xtype : 'grid',
		anchor : '105%',
		autoWidth : true,
		style : 'margin-left:60px; margin-top:10px; margin-bottom:10px',
		store : gridStore,
		columns : [ sm,{
			header : "图ID",
			width : 100,
			align : 'center',
			sortable : false,
			dataIndex : 'figureNo',
			menuDisabled : true
		}, {
			header : "图名称",
			align : 'center',
			width : 150,
			sortable : false,
			dataIndex : 'figureName',
			menuDisabled : true
		}, {
			header : "图纸要求",
			align : 'center',
			width : 250,
			sortable : false,
			dataIndex : 'figureRequest',
			menuDisabled : true
		}, {
			header : "类型",
			align : 'center',
			width : 100,
			sortable : false,
			dataIndex : 'type',
			menuDisabled : true
		}, {
			header : '数量（套）',
			align : 'center',
			width : 100,
			sortable : false,
			dataIndex : 'batchNum',
			menuDisabled : true
		} , {
			header : '描述',
			align : 'center',
			width : 250,
			sortable : false,
			dataIndex : 'describe',
			menuDisabled : true
		} ,{
			header : 'devid',
			hidden:true,
			align : 'center',
			width : 50,
			sortable : false,
			dataIndex : 'devid',
			menuDisabled : true
		} ],
		viewConfig : {
			forceFit : true
		},
		sm : sm,
		autoWidth : true,
		height : 380,
		stripeRows : true,
		frame : true,
		iconCls : 'icon-grid',
		tbar : [ {
			text : '添加',
			iconCls : 'silk-application-add',
			scope : this,
			handler : function(){addGalleryWindow("添加")}
		}, '-', {
			text : '删除',
			iconCls : 'silk-application-delete',
			scope : this,
			handler : function(){
       		 var row = Ext.getCmp("_gridPanel_id").getSelectionModel().getSelections();
       		 if (row.length == 0)
       		 {
       			 Ext.Msg.alert("提示","请选择一条记录进行删除。")
       		 }
       		 else
       	     {
       			 var flowObjs=[];
       			 for (var i=0; i<row.length; i++)
       			 {
       				 var flowObj = {
       						'flowId':row[i].data.flowId,
       	                    'figureNo':row[i].data.figureNo,
       	                    'figureName':row[i].data.figureName,
       	                    'figureRequest':row[i].data.figureRequest,
       	                    'type':row[i].data.devid,
       	                    'batchNum':row[i].data.batchNum,
       	                    'describe':row[i].data.describe,
       				 }
       				flowObjs.push(flowObj);
       			 }
       			 Ext.Ajax.request({
       				 url : '../../background/project/figure/delete.html',
       				 timeout : 300000,
       				 params : {delJson:JSON.stringify(flowObjs)},
       				 method : 'post',
       				 success : function(response) {
       					 var result = Ext.decode(response.responseText);
       					 
       					 if (result.success) {
       						 Ext.Msg.alert("提示", "删除成功。",
       								 function(){
       							 Ext.getCmp("_gridPanel_id").store.reload();
       						 });
       					 } else {
       						 Ext.Msg.alert("错误", "删除失败。");
       					 }
       				 },
       				 failure : function() {
       					 Ext.Msg.alert("错误", "删除失败。");
       				 }
       			 });
       	     }
            
			}
		}, '-', {
			text : '修改',
			iconCls : 'silk-application-edit',
			scope : this,
			handler : function(){
       		 var row = Ext.getCmp("_gridPanel_id").getSelectionModel().getSelections();
    		 if (row.length ==1) {  
    			 var objRow = row[0].data;
    			 addGalleryWindow("修改",objRow)
    		 }  
    		 if (row.length > 1 || row.length == 0)
    		 {
    			 Ext.Msg.alert("提示","请选择一条记录进行修改。")
    		 }
         }
		} ],
		bbar : bbar
	};
     
	var partTransfer = {
		xtype : 'fieldset',
		title : '图库',
		autoHeight : true,
		autoWidth : true,
		layout : 'column',
		items : [ {
			columnWidth : .33,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'project_id',
				fieldLabel : '项目名称',
				xtype : 'label',
				anchor : '85%',
				html : '<div style="padding-top:3px">' + projectName + '</div>'
			} ]
		}, {
			columnWidth : .33,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'product_id',
				fieldLabel : '产品名称',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + productName + '</div>'
			} ]
		},{
			columnWidth : .33,
			layout : 'form',
			labelWidth : 55,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ {
				id : 'figurelib_id',
				fieldLabel : '图库名称',
				anchor : '85%',
				xtype : 'label',
				html : '<div style="padding-top:3px">' + figureLib + '</div>'
			} ]
		},  {
			clumnWidth : 1,
			layout : 'form',
			labelWidth : 70,
			labelAlign : "left",
			baseCls : "x-plain",
			labelAlign : "left",
			items : [ _gridPanel ]
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
		title : "图库电子流处理",
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

						var commonRemarkValue = Ext.getCmp("commonMask_id").getValue();
						var outcome = Ext.getCmp("processId").getValue();
						if (outcome !== '撤销')
						{
							var total = Ext.getCmp("_gridPanel_id").store.getCount();
							if (total < 1) {
								Ext.Msg.alert("提示", "请先配置图库数据。");
								return;
							}
						}
						var nextName = Ext.getCmp("processUserId").getValue();

						Ext.Ajax.request({
							url : '../project/figure/submitFormFigure.html',
							timeout : 300000,
							params : {
								flowId:flowId,
								taskId : taskId,
								comment : commonRemarkValue,
								outcome : outcome,
								nextName : nextName
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "图库电子流提交成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("提示", "图库电子流提交失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("提示", "图库电子流提交失败");
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