function mainView()
{
	var _flowCommonComp = getFlowCommonComp(taskId);
	var form = new Ext.form.FormPanel({
		id:"formId",
		title:'提交立项',
		style : 'margin-top:1px;',
		renderTo:'project_submit_id',
		lableAlign:'right',
		autoWidth : true,
		buttonAlign:'center',
		labelWidth:100,
		frame:true,
		defaults : {
			xtype : "textfield",
			width : 300
		},
		items:[{
            xtype: "label",
            forId: "projectName",
            fieldLabel : '项目名称',
            html : '<div style="padding-top:3px">' + projectName + '</div>'
        },_flowCommonComp],
		buttons:[{
			text:"提交",
			handler:function(){
				var commonMaskObj = Ext.getCmp("commonMask_id");
				var processObj = Ext.getCmp("processId");
				var processUserObj = Ext.getCmp("processUserId");
				var commonRemarkValue = commonMaskObj.getValue();
			    var processVal = processObj.getValue();
			    var nextName = processUserObj.getValue();
				var error = 0;
				if (commonRemarkValue == null || commonRemarkValue == '')
				{
					commonMaskObj.markInvalid("不能为空。");
					error+=1;
				}
				if (processVal == null || processVal == '')
				{
					processObj.markInvalid("不能为空。");
					error+=1;
				}
				if (nextName == null || nextName == '')
				{
					processUserObj.markInvalid("不能为空。");
					error+=1;
				}
				if (error > 0)
				{
					return;
				}
				Ext.Ajax.request({
					url:'../../background/workflow/submit_project.html',
					params:{
						comment:commonMaskObj,
						outcome:processVal,
						taskId:taskId,
						nextName:nextName
					},
					success: function(resp,opts){
						 var respText = Ext.util.JSON.decode(resp.responseText);
						 if(respText.success)
						 {
							 Ext.Msg.alert('提示', '提交成功！',forWardToNextPage);
//							 projectNameObj.reset();
//							 projectDescObj.reset();
						 }
						 else
						 {
							 Ext.Msg.alert('错误', '提交失败！');
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
		window.location.href = "../workflow/myTaskList.html";
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