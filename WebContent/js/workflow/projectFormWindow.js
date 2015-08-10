function addGalleryWindow(titleStr,objRow) {
	var formNum = 0;

	var typeStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../project/figure/getDeviceAll.html"}),  
        reader: new Ext.data.JsonReader(  
                      {},  
                      ["devid", "devName"]
                      ),
        autoLoad : true
    });  
	var typeCombo = new Ext.form.ComboBox({
		id:'typeId',
		name:'typeName',
		width:250,
	    store: typeStore,
	    fieldLabel : '类型',
	    valueField: 'devid',
	    displayField: 'devName',
	    msgTarget:'qtip',
	    allowBlank:false,
	    blankText:"类型不能为空。",
	    anchor : '95%',
	    mode: 'remote',
	    triggerAction: 'all',
	    editable:false,
	    emptyText: '请选择...'
	});
	var mainPanel = new Ext.Panel({
		id : 'mainPanel_id',
		autoHeight : true,
		autoWidth : true,
		bodyStyle : 'margin-left : 25px;',
		frame : true,
		items : [
				{
					id : 'picId_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'picId_form_id_0',
						fieldLabel : '图ID',
						xtype : 'textfield',
						anchor : '95%',
						allowBlank : false,
						blankText : '图ID不能为空',
						maxLength:32,
						maxLengthText:'最多32个字符'
					} ]
				},
				{
					id : 'picName_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'picName_form_id_0',
						fieldLabel : '图名称',
						xtype : 'textfield',
						anchor : '95%',
						allowBlank : false,
						blankText : '图名称不能为空',
						maxLength:32,
						maxLengthText:'最多32个字符'
					} ]
				},
				{
					id : 'picRequire_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'picRequire_form_id_0',
						fieldLabel : '图纸要求',
						xtype : 'textarea',
						anchor : '95%',
						allowBlank : false,
						blankText : '图纸要求不能为空',
						maxLength:250,
						maxLengthText:'最多250个字符'
					} ]
				},
				{
					id : 'type_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ typeCombo ]
				},
				{
					id : 'total_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'total_form_id_0',
						fieldLabel : '数量(套)',
						xtype : 'numberfield',
						anchor : '95%',
						allowDecimals:false,
						minValue:1,  
						minText:'最小值为1。',
						allowBlank : false,
						blankText : '数量不能为空',
						maxValue:9999999999,
						maxText:'最大值为9999999999。'
					} ]
				},
				{
					id : 'describe_form_id',
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'describe_form_id_0',
						fieldLabel : '描述',
						xtype : 'textarea',
						anchor : '95%',
						allowBlank : false,
						blankText : '描述不能为空',
						maxLength:250,
						maxLengthText:'最多250个字符'
					} ]
				}]
	});
	
	var galleryWindow = new Ext.Window({
		id : 'galleryWindow_id',
		title : titleStr,
		layout : 'fit',
		width : 400,
		autoHeight : true,
		closeAction : 'close',
		buttonAlign : 'center',
		modal : true,
		animateTarget : '_gridPanel_id',
		draggable : true,
		closable : true,
		constrain : true,
		frame : true,
		border : true,
		bodyBorder : true,
		resizable : false,
		constrainHeader : true,
		items : [ mainPanel ],
		plain : false,
		buttons : [ {
			text : '确定',
			handler : function() {
				addOrUpdate(titleStr,objRow);
			}
		}, {
			text : '取消',
			handler : function() {
				galleryWindow.close();
			}
		} ]
	});

	galleryWindow.show();
	if (titleStr === '修改')
	{
		Ext.getCmp("picId_form_id_0").setValue(objRow.figureNo);
		Ext.getCmp("picName_form_id_0").setValue(objRow.figureName);
		Ext.getCmp("picRequire_form_id_0").setValue(objRow.figureRequest);
		Ext.getCmp("typeId").setValue(objRow.devid);
		Ext.getCmp("typeId").setRawValue(objRow.type);
		Ext.getCmp("total_form_id_0").setValue(objRow.batchNum);
		Ext.getCmp("describe_form_id_0").setValue(objRow.describe);
	}
}

function addOrUpdate(type,objRow) {
	
	var picidObj = Ext.getCmp("picId_form_id_0");
	var picNameObj = Ext.getCmp("picName_form_id_0");
	var picRequireObj = Ext.getCmp("picRequire_form_id_0");
	var typeObj = Ext.getCmp("typeId");
	var totalObj = Ext.getCmp("total_form_id_0");
	var describeObj = Ext.getCmp("describe_form_id_0");
	if (!picidObj.isValid() || !picNameObj.isValid() || !picRequireObj.isValid()
			|| !typeObj.isValid() ||!totalObj.isValid() ||!describeObj.isValid())
	{
		return;
	}
	var picidVal = picidObj.getValue();
	var picNameVal = picNameObj.getValue();
	var picRequireVal = picRequireObj.getValue();
	var typeVal = typeObj.getValue();
	var totalVal = totalObj.getValue();
	var describeVal = describeObj.getValue();
	if (type === '添加')
	{
		Ext.Ajax.request({
			 url : '../project/figure/add.html',
			 timeout : 300000,
			 params : {
				 flowId,flowId,
				 figureNo:picidVal,
				 figureName : picNameVal,
				 figureRequest : picRequireVal,
				 type : typeVal,
				 batchNum : totalVal,
				 describe : describeVal
			 },
			 method : 'POST',
			 success : function(response) {
				 var result = Ext.decode(response.responseText);
				 
				 if (result.success) {
					 Ext.Msg.alert("提示", "添加成功。",
							 function(){
						 Ext.getCmp("_gridPanel_id").store.reload();
						 Ext.getCmp("galleryWindow_id").close();
					 });
				 }
				 else 
				 {
					 if (result.msg==="exsit")
					 {
						 Ext.Msg.alert("错误", "该图已经存在。");
					 }
					 else if (result.msg==="figureNo")
					 {
						 Ext.Msg.alert("错误", "该图号已经被其它图使用。");
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
	if (type === '修改')
	{
		if (picidVal === objRow.figureNo && picNameVal === objRow.figureName && picRequireVal ===objRow.figureRequest
			&& typeVal === objRow.devid && totalVal === objRow.batchNum && describeVal === objRow.describe)
		{
			Ext.Msg.alert("错误", "内容没有改变。");
			return;
		}
		Ext.Ajax.request({
			 url : '../project/figure/update.html',
			 timeout : 300000,
			 params : {
				 flowId,flowId,
				 figureNo:picidVal,
				 figureName : picNameVal,
				 figureRequest : picRequireVal,
				 type : typeVal,
				 batchNum : totalVal,
				 describe : describeVal,
				 figureNoOld:objRow.figureNo,
				 figureNameOld : objRow.figureName,
				 figureRequestOld : objRow.figureRequest,
				 typeOld : objRow.devid,
				 batchNumOld : objRow.batchNum,
				 describeOld : objRow.describe
			 },
			 method : 'POST',
			 success : function(response) {
				 var result = Ext.decode(response.responseText);
				 
				 if (result.success) {
					 Ext.Msg.alert("提示", "修改成功。",
							 function(){
						 Ext.getCmp("_gridPanel_id").store.reload();
						 Ext.getCmp("galleryWindow_id").close();
					 });
				 }
				 else 
				 {
					 if (result.msg==="exsit")
					 {
						 Ext.Msg.alert("错误", "该图已经存在。");
					 }
					 else if (result.msg==="figureNo")
					 {
						 Ext.Msg.alert("错误", "该图号已经被其它图使用。");
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