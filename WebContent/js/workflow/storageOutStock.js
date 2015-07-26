function mainView()
{
	var page_size = 20;
	var gridStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../../background/storageOutStock/queryListData.html"}),  
        reader: new Ext.data.JsonReader(  
                      {
                    	  totalProperty:'totalProperty',
                          root:'data'
                      },  
                      [
                       {name:'PictureNo'},
                       {name:'ChildPictureNo'},
                       {name:'PictureName'},
                       {name:'PictureRequire'},
                       {name:'PloidyNum'},
                       {name:'ShouldReceiveNum'},
                       {name:'DepotSaveNum'},
                       {name:'RealReceiveNum'},
                       {name:'SerialNumber'}
                       ]
                      )
    });  
	gridStore.load({
	   params : {
	    start : 0,  
	    limit : page_size
	   } });
	var sm=new Ext.grid.CheckboxSelectionModel();
	
	var colum=new Ext.grid.ColumnModel(
		    [
		    sm,
		    {
		    	 header:"图号",
		         dataIndex:"PictureNo",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"子图号",
		         dataIndex:"ChildPictureNo",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"图纸名称",
		         dataIndex:"PictureName",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:200
		    },
		    {
		    	 header:"图纸要求",
		         dataIndex:"PictureRequire",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:400
		    },
		    {
		    	 header:"配套数量",
		         dataIndex:"PloidyNum",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"应出数量",
		         dataIndex:"ShouldReceiveNum",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"库存数量",
		         dataIndex:"DepotSaveNum",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"实出料量",
		         dataIndex:"RealReceiveNum",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
		    },
		    {
		    	 header:"编号",
		         dataIndex:"SerialNumber",//绑定字段
		         sortable:false,//是否排序 
		         menuDisabled : true,
		         width:70
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
    
    var tbar=new Ext.Toolbar({
        items:[
         {
             text:"添加",
             xtype:"tbbutton",
        	 handler:function(){
        		 Ext.getCmp('formId').setTitle("添加");
        		 document.getElementById("update_id").style.display='';
        		 setDisabled(false);
        		 Ext.getCmp('pictureNoId').setValue("");
    			 Ext.getCmp('childPictureNoId').setValue("");
    			 Ext.getCmp('pictureNameId').setValue("");
    			 Ext.getCmp('pictureRequireId').setValue("");
    			 Ext.getCmp('ploidyNumId').setValue("");
    			 Ext.getCmp('shouldReceiveNumId').setValue("");
    			 Ext.getCmp('realReceiveNumId').setValue("");
    			 Ext.getCmp('depotSaveNumId').setValue("");
    			 Ext.getCmp('serialNumberId').setValue("");
                }
         },
         "-",
         {
             text:"修改",
             xtype:"tbbutton",
        	 handler:function(){
        		 var row = Ext.getCmp("greidId").getSelectionModel().getSelections();
        		 if (row.length ==1) {  
        			 Ext.getCmp('formId').setTitle("修改");
        			 document.getElementById("update_id").style.display='';
            		 setDisabled(true);
        			 var objRow = row[0].data;   
        			 Ext.getCmp('pictureNoId').setValue(objRow.PictureNo);
        			 Ext.getCmp('childPictureNoId').setValue(objRow.ChildPictureNo);
        			 Ext.getCmp('pictureNameId').setValue(objRow.PictureName);
        			 Ext.getCmp('pictureRequireId').setValue(objRow.PictureRequire);
        			 Ext.getCmp('ploidyNumId').setValue(objRow.PloidyNum);
        			 Ext.getCmp('shouldReceiveNumId').setValue(objRow.ShouldReceiveNum);
        			 Ext.getCmp('realReceiveNumId').setValue(objRow.RealReceiveNum);
        			 Ext.getCmp('depotSaveNumId').setValue(objRow.DepotSaveNum);
        			 Ext.getCmp('serialNumberId').setValue(objRow.SerialNumber);
        		 }  
        		 if (row.length > 1 || row.length == 0)
        		 {
        			 Ext.Msg.alert("提示","请选择一条记录进行修改。")
        		  }
                }
         },
         "-",
         {
             text:"删除",
             xtype:"tbbutton",
        	 handler:function(){
        		 var row = Ext.getCmp("greidId").getSelectionModel().getSelections();
                }
         },
         "-",
         {
             text:"查询",
             xtype:"tbbutton",
             handler:function(){
            	 Ext.getCmp('formId').setTitle("查询");
        		 document.getElementById("update_id").style.display='';
        		 setDisabled(false);
        		 Ext.getCmp('pictureNoId').setValue("");
    			 Ext.getCmp('childPictureNoId').setValue("");
    			 Ext.getCmp('pictureNameId').setValue("");
    			 Ext.getCmp('pictureRequireId').setValue("");
    			 Ext.getCmp('ploidyNumId').setValue("");
    			 Ext.getCmp('shouldReceiveNumId').setValue("");
    			 Ext.getCmp('realReceiveNumId').setValue("");
    			 Ext.getCmp('depotSaveNumId').setValue("");
    			 Ext.getCmp('serialNumberId').setValue("");
                }
         },
         {xtype:"tbfill"}
        ]
       });
    
	var grid = new Ext.grid.GridPanel({
		id:'greidId',
		renderTo:'main_id',
		width:'auto',
	    height:300,
		store:gridStore,
		cm:colum,
		stripeRows:true,
		bbar:bbar,
		tbar:tbar,
		sm : sm,
		loadMask:{
		      msg:"数据正在加载中...."
		 }
	});
	
	var form = new Ext.form.FormPanel({
		id:"formId",
		title:"form",
		renderTo:'update_id',
		lableAlign:'right',
		buttonAlign:'right',
		labelWidth:55,
		layout:'column',
		frame:true,
		items:[{columnWidth:.25,layout:'form',items:[{
			xtype:'textfield',id:'pictureNoId',msgTarget:'qtip',fieldLabel:'图号'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'textfield',id:'childPictureNoId',msgTarget:'qtip',fieldLabel:'子图号'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'textfield',id:'pictureNameId',msgTarget:'qtip',fieldLabel:'图纸名称'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'textfield',id:'pictureRequireId',msgTarget:'qtip',fieldLabel:'图纸要求'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'numberfield',id:'ploidyNumId',msgTarget:'qtip',fieldLabel:'配套数量'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'numberfield',id:'shouldReceiveNumId',msgTarget:'qtip',fieldLabel:'应领数量'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'numberfield',id:'depotSaveNumId',msgTarget:'qtip',fieldLabel:'库存数量'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'numberfield',id:'realReceiveNumId',msgTarget:'qtip',fieldLabel:'实出数量'
		}]},
		{columnWidth:.25,layout:'form',items:[{
			xtype:'numberfield',id:'serialNumberId',msgTarget:'qtip',fieldLabel:'编号'
		}]}
		],
		buttons:[{
			text:"确认",
			handler:function(){
				var pictureNoObj = Ext.getCmp('pictureNoId');
				var childPictureNoObj = Ext.getCmp('childPictureNoId');
				var pictureNameObj = Ext.getCmp('pictureNameId');
				var pictureRequireObj = Ext.getCmp('pictureRequireId');
				var ploidyNumObj = Ext.getCmp('ploidyNumId');
				var shouldReceiveNumObj = Ext.getCmp('shouldReceiveNumId');
				var realReceiveNumObj = Ext.getCmp('realReceiveNumId');
				var depotSaveNumObj = Ext.getCmp('depotSaveNumId');
				var serialNumberObj = Ext.getCmp('serialNumberId');
				
				var pictureNo =  pictureNoObj.getValue();
				var childPictureNo =  childPictureNoObj.getValue();
				var pictureName =  pictureNameObj.getValue();
				var pictureRequire =  pictureRequireObj.getValue();
				var ploidyNum =  ploidyNumObj.getValue();
				var shouldReceiveNum =  shouldReceiveNumObj.getValue();
				var realReceiveNum =  realReceiveNumObj.getValue();
				var depotSaveNum =  depotSaveNumObj.getValue();
				var serialNumber =  serialNumberObj.getValue();
				var error = 0;
				if (pictureNo == null || pictureNo == '')
				{
					pictureNoObj.markInvalid("图号不能为空!");
					error+=1;
				}
				if (childPictureNo == null || childPictureNo == '')
				{
					childPictureNoObj.markInvalid("子图号不能为空!");
					error+=1;
				}
				if (pictureName == null || pictureName == '')
				{
					pictureNameObj.markInvalid("图纸名称不能为空!");
					error+=1;
				}
				if (pictureRequire == null || pictureRequire == '')
				{
					pictureRequireObj.markInvalid("图纸要求不能为空!");
					error+=1;
				}
				if (ploidyNum == null || ploidyNum == '')
				{
					ploidyNumObj.markInvalid("配套数不能为空!");
					error+=1;
				}
				if (shouldReceiveNum == null || shouldReceiveNum == '')
				{
					shouldReceiveNumObj.markInvalid("应领数量不能为空!");
					error+=1;
				}
				if (depotSaveNum == null || depotSaveNum == '')
				{
					depotSaveNumObj.markInvalid("库存数量不能为空!");
					error+=1;
				}
				if (realReceiveNum == null || realReceiveNum == '')
				{
					realReceiveNumObj.markInvalid("实领数量不能为空!");
					error+=1;
				}
				if (serialNumber == null || serialNumber == '')
				{
					serialNumberObj.markInvalid("编号不能为空!");
					error+=1;
				}
				if (error > 0)
				{
					return;
				}
			}
		},
		{
			text:"取消",
            handler:function(){
            	document.getElementById("update_id").style.display='none';
			}
		}]
	});
	function setDisabled(bool)
	{
		 Ext.getCmp('pictureNoId').setDisabled(bool);
		 Ext.getCmp('childPictureNoId').setDisabled(bool);
		 Ext.getCmp('pictureRequireId').setDisabled(bool);
		 Ext.getCmp('pictureNameId').setDisabled(bool);
		 Ext.getCmp('ploidyNumId').setDisabled(bool);
		 Ext.getCmp('shouldReceiveNumId').setDisabled(bool);
		 Ext.getCmp('depotSaveNumId').setDisabled(bool);
		 Ext.getCmp('serialNumberId').setDisabled(bool);
	}
	var submit = new Ext.Button({
		renderTo:'submit_id',
		width:50,
		text: "提交"
	});
    var cancel = new Ext.Button({
    	renderTo:'cancel_id',
    	width:50,
    	text: "返回"
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
	document.getElementById("update_id").style.display='none';
};
Ext.onReady(initview);