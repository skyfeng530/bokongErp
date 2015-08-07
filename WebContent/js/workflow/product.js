function mainView()
{
	var projectNameStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../../background/project/queryAll.html"}),  
        reader: new Ext.data.JsonReader(  
                      {},  
                      ["pid", "projectName"]
                      ),
        autoLoad : true
    });  
	var projectNameCombo = new Ext.form.ComboBox({
		id:'ProjectNameId',
		name:'ProjectName',
		fieldLabel:'&nbsp&nbsp&nbsp&nbsp项目名称',
		width:250,
	    store: projectNameStore,
	    valueField: 'pid',
	    displayField: 'projectName',
	    msgTarget:'qtip',
	    allowBlank:false,
	    blankText:"项目名称不能为空。",
	    mode: 'remote',
	    triggerAction: 'all',
	    editable:false,
	    emptyText: '请选择...'
	});
	var form = new Ext.form.FormPanel({
		id:"formId",
		title:'产品电子流',
		style:'margin-top:1px;',
		renderTo:'product_id',
		lableAlign:'right',
		buttonAlign:'center',
		labelWidth:80,
		frame:true,
		items:[projectNameCombo],
		buttons:[{
			text:"提交",
			handler:function(){
				var projectNameObj = Ext.getCmp('ProjectNameId');
				var projectNameVal =  projectNameObj.getValue();
			
				if (projectNameVal == null || projectNameVal == '')
				{
					projectNameObj.markInvalid("项目名称不能为空。");
					return;
				}
				Ext.Ajax.request({
					url:'../../background/workflow/save_product.html',
					params:{
						projectId:projectNameVal,
						pdkey:pdkey,
						pdid:pdid
					},
					success: function(resp,opts){
						 var respText = Ext.util.JSON.decode(resp.responseText); 
						 if(respText.success)
						 {
							 Ext.Msg.alert("提示", "提交成功",
										forWardToNextPage);
						 }
						 else
						 {
							 Ext.Msg.alert('错误', '提交失败！');
						 } 
					},
					failure: function(resp,opts) {   
                         var respText = Ext.util.JSON.decode(resp.responseText);   
                         Ext.Msg.alert('错误', '提交失败！');   
                    }     
				});
			}
		},
		{
			text:"返回",
            handler:function(){
            	history.go(-1);
			}
		}]
	});
	function forWardToNextPage() {
		window.location.href = "../workflow/myTaskList.html?pdid=" + pdkey;
	}
}

function initview() {
	Ext.QuickTips.init();
	//Ext.form.Field.prototype.msgTarget = 'qtip';
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