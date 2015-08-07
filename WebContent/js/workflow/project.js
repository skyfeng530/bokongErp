function mainView()
{
	var form = new Ext.form.FormPanel({
		id:"formId",
		title : "项目申请",
		renderTo:'project_id',
		lableAlign:'right',
		buttonAlign:'center',
		style : 'margin-top:1px;',
		labelWidth:80,
		frame:true,
		items:[{
			xtype:'textfield',
			id:'projectNameId',
			name:"projectName",
			allowBlank:false,
		    blankText:"项目名称不能为空。",
		    width:250,
		    fieldLabel:'&nbsp&nbsp&nbsp&nbsp项目名称'
		},{
			xtype:'textarea',
			id:'projectDescId',
			name:"projectDescribe",
		    width:250,
		    fieldLabel:'&nbsp&nbsp&nbsp&nbsp项目简介'
		}],
		buttons:[{
			text:"提交",
			handler:function(){
				var projectNameObj = Ext.getCmp('projectNameId');
				var projectDescObj = Ext.getCmp('projectDescId');
				var projectNameVal =  projectNameObj.getValue();
				var projectDescVal =  projectDescObj.getValue();
				var error = 0;
				if (projectNameVal == null || projectNameVal == '')
				{
					projectNameObj.markInvalid("项目名称不能为空。");
					error+=1;
				}
				if (projectDescVal.length > 50)
				{
					projectDescObj.markInvalid("项目描述不能超过50个字符。");
					error+=1;
				}
				if (error > 0)
				{
					return;
				}
				Ext.Ajax.request({
					url:'../../background/workflow/save_project.html',
					params:{
						projectName:projectNameVal,
						projectDescribe:projectDescVal,
						pdkey:pdkey
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
							 if (respText.msg==="exist")
							 {
								 Ext.Msg.alert("错误", "该项目已经存在。");
							 }
							 else
							 {
								 Ext.Msg.alert('错误', '提交失败！');
							 }
						 }
					},
					failure: function(resp,opts) {   
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