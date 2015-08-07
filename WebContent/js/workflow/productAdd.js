 var pictureNoOldValue = "";
 var productNameOldValue = "";
 var statusOldValue = "";
 var bakOldValue = "";
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
                       {name:'flowId'},
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
    var tbar=new Ext.Toolbar({
        items:[
         {
             text:"添加",
             xtype:"button",
             cls: 'x-btn-text-icon details',
             icon:"../../style/images/icon-add.gif",
        	 handler:function(){
        		 reset()
        		// Ext.getCmp('pictureNoId').setDisabled(false);
        		 //Ext.getCmp('productNameId').setDisabled(false);
        		 showDialog("添加");
             }
         },
         "-",
         {
             text:"删除",
             xtype:"tbbutton",
             cls: 'x-btn-text-icon details',
             icon:"../../style/images/icon-delete.gif",
        	 handler:function(){
        		 var row = Ext.getCmp("greidId").getSelectionModel().getSelections();
        		 if (row.length == 0)
        		 {
        			 Ext.Msg.alert("提示","请选择一条记录进行删除。")
        		 }
        		 else
        	     {
        			 var productObjs=[];
        			 for (var i=0; i<row.length; i++)
        			 {
        				 var productObj = {
        						'flowId':row[i].data.flowId,
        	                    'productNo':row[i].data.productNo,
        	                    'productName':row[i].data.productName,
        	                    'status':row[i].data.status,
        	                    'bak':row[i].data.bak
        				 }
        				 productObjs.push(productObj);
        			 }
        			 Ext.Ajax.request({
        				 url : '../../background/project/product/flow/delete.html',
        				 timeout : 300000,
        				 params : {delJson:JSON.stringify(productObjs)},
        				 method : 'post',
        				 success : function(response) {
        					 var result = Ext.decode(response.responseText);
        					 
        					 if (result.success) {
        						 Ext.Msg.alert("提示", "删除成功。",
        								 function(){
        							 Ext.getCmp("greidId").store.reload();
        							 Ext.getCmp('topFormId').hide();
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
         },
         "-",
         {
             text:"修改",
             xtype:"tbbutton",
             cls: 'x-btn-text-icon details',
             icon:"../../style/images/icon_edit.png",
        	 handler:function(){
        		 var row = Ext.getCmp("greidId").getSelectionModel().getSelections();
        		 if (row.length ==1) {  
        			 reset()
            		 showDialog("修改");
        			 var objRow = row[0].data;
        			// Ext.getCmp('pictureNoId').setDisabled(true);
        			 //Ext.getCmp('productNameId').setDisabled(true);
        			 flowIdOldValue=objRow.flowId;
        			 pictureNoOldValue = objRow.productNo;
        			 productNameOldValue = objRow.productName;
        			 statusOldValue = objRow.status;
        			 bakOldValue = objRow.bak;
        			 Ext.getCmp('pictureNoId').setValue(objRow.productNo);
        			 Ext.getCmp('productNameId').setValue(objRow.productName);
        			 Ext.getCmp('statusId').setValue(objRow.status);
        			 Ext.getCmp('bakId').setValue(objRow.bak);
        		 }  
        		 if (row.length > 1 || row.length == 0)
        		 {
        			 Ext.Msg.alert("提示","请选择一条记录进行修改。")
        		 }
             }
         }
        ]
       });
    
	var _gridPanel = new Ext.grid.GridPanel({
		id:'greidId',
		width : '105%',
	    height:380,
	    style : 'margin-left:55px; margin-top:10px; margin-bottom:10px',
		store:gridStore,
		cm:colum,
		stripeRows:true,
		bbar:bbar,
		tbar:tbar,
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
		title : "添加产品电子流",
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
								projectId:projectId
							},
							method : 'POST',
							success : function(response) {
								var result = Ext.decode(response.responseText);

								if (result.success) {
									Ext.Msg.alert("提示", "产品电子流提交成功",
											forWardToNextPage);
								} else {
									Ext.Msg.alert("错误", "产品电子流提交失败");
								}
							},
							failure : function() {
								Ext.Msg.alert("错误", "产品电子流提交失败");
							}
						});

					}
				}, {
					text : "取消",
					handler : forWordPraPage
				} ]
	});

	mainPanel.render("main_id");
	 var _window = new Ext.Window({  
         title: "登陆窗体",  
         id:"topFormId",
         frame:true,  
         height:240,  
         width:410,  
         layout:"form",  
         labelWidth:55,  
         /* 样式控制 */  
         plain:true,  
         /* 控制窗口大小 */  
         resizable:false,  
         /* 自定义Window内部 CSS 样式 */  
         bodyStyle:"padding:15px",  
         /* button 定位 */  
         buttonAlign:"center",  
         /* 是否可关闭 */  
         closable:true,  
         modal: true, 
         defaults:{xtype:"textfield", width:200},  
         items:[  
                 {fieldLabel:"产品编号", id:"pictureNoId",xtype:'numberfield',width:300},  
                 {fieldLabel:"产品名称",id:"productNameId", width:300},
                 {fieldLabel:"状态",id:"statusId", width:300},
                 {fieldLabel:"备注",id:"bakId", xtype:'textarea', width:300}  
             ],  
 		    
         buttons:[  
                 {
                	 text:"确定",
                	 handler:function(){
                		 var pictureNoObj = Ext.getCmp("pictureNoId");
                		 var pictureNoValue = pictureNoObj.getValue();
                		 var productNameObj = Ext.getCmp("productNameId");
                		 var productNameValue = productNameObj.getValue();
                		 var statusObj = Ext.getCmp("statusId");
                		 var statusValue = statusObj.getValue();
                		 var bakObj = Ext.getCmp("bakId");
                		 var bakValue = bakObj.getValue();
                		 var error=0;
                		 if (pictureNoValue == null || pictureNoValue == '')
         				 {
                			 pictureNoObj.markInvalid("产品编号不能为空。");
         					error+=1;
         				 }
                		 if (productNameValue == null || productNameValue == '')
         				 {
                			 productNameObj.markInvalid("产品名称不能为空。");
         					 error+=1;
         				 }
                		 if (statusValue == null || statusValue == '')
         				 {
                			 statusObj.markInvalid("状态不能为空。");
         					 error+=1;
         				 }
                		 if (statusValue.length > 3)
                		 {
                			 statusObj.markInvalid("状态最多三个字符。");
         					 error+=1;
                		 }
                		 if (bakValue.length > 50)
         				 {
                			 bakObj.markInvalid("备注不能超过50个字符。");
         					 error+=1;
         				 }
                		 if (error > 0)
                		 {
                			 return;
                		 }
                		 if (_window.title==='添加')
                		 {
                			 Ext.Ajax.request({
                				 url : '../../background/project/product/flow/add.html',
                				 timeout : 300000,
                				 params : {
                					 projectId:projectId,
                					 flowId : flowId,
                					 productNo : pictureNoValue,
                					 productName : productNameValue,
                					 status : statusValue,
                					 bak : bakValue
                				 },
                				 method : 'POST',
                				 success : function(response) {
                					 var result = Ext.decode(response.responseText);
                					 
                					 if (result.success) {
                						 Ext.Msg.alert("提示", "添加成功。",
                								 function(){
                							 Ext.getCmp("greidId").store.reload();
                							 _window.hide();
                						 });
                					 }
                					 else 
                					 {
                						 if (result.msg==="exist")
                						 {
                							 Ext.Msg.alert("错误", "该产品已经存在。");
                						 }
                						 else
                						 {
                							 Ext.Msg.alert("错误", "添加失败。");
                						 }
                					 }
                				 },
                				 failure : function() {
                					 Ext.Msg.alert("错误", "添加失败。");
                				 }
                			 });
                		 }
                		 else
                		 {
                			if(pictureNoOldValue == pictureNoValue && productNameOldValue === productNameValue && statusOldValue === statusValue && bakOldValue === bakValue)
                			{
                				Ext.Msg.alert("提示", "内容没有改变。");
                				return;
                			}
                			else
                			{
                				Ext.Ajax.request({
                   				 url : '../../background/project/product/flow/update.html',
                   				 timeout : 300000,
                   				 params : {
                   					 flowId : flowIdOldValue,
                   					 productNo : pictureNoValue,
                   					 productName : productNameValue,
                   					 status : statusValue,
                   					 bak : bakValue,
                   					 projectId:projectId,
                   					 productNoOld:pictureNoOldValue,
                   					 productNameOld:productNameOldValue,
                   					 statusOld:statusOldValue
                   				 },
                   				 method : 'POST',
                   				 success : function(response) {
                   					 var result = Ext.decode(response.responseText);
                   					 
                   					 if (result.success) {
                   						 Ext.Msg.alert("提示", "修改成功。",
                   								 function(){
                   							 Ext.getCmp("greidId").store.reload();
                   							 _window.hide();
                   						 });
                   					 } else {
                   						 if (result.msg==="exist")
	               						 {
	               							 Ext.Msg.alert("错误", "该产品已经存在。");
	               						 }
	               						 else
	               						 {
	               							Ext.Msg.alert("错误", "修改失败。");
	               						 }
                   					 }
                   				 },
                   				 failure : function() {
                   					 Ext.Msg.alert("错误", "修改失败。");
                   				 }
                   			 });
                			}
                		 }
                     }  
                 },  
                 {  
                     text:"取消",  
                     handler:function(){  
                             _window.hide();                           
                         }  
                 }  
             ]  
     });  
}
function forWardToNextPage() 
{
	window.location.href = "../workflow/myTaskList.html";
}
function reset()
{
	Ext.getCmp("pictureNoId").reset();
	Ext.getCmp("productNameId").reset();
	Ext.getCmp("statusId").reset();
	Ext.getCmp("bakId").reset();
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