function addGalleryWindow() {

	var formNum = 0;

	var mainPanel = new Ext.Panel({
		id : 'mainPanel_id',
		layout : 'column',
		autoHeight : true,
		autoWidth : true,
		bodyStyle : 'margin-left : 25px;',
		frame : true,
		items : [
				{
					columnWidth : 1,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						id : 'galleryName_id',
						fieldLabel : '图库名称',
						xtype : 'textfield',
						anchor : '40%'
					} ]
				},
				{
					id : 'picName_form_id',
					columnWidth : .235,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '图名称',
						xtype : 'textfield',
						anchor : '95%'
					} ]
				},
				{
					id : 'picId_form_id',
					columnWidth : .235,
					layout : 'form',
					labelWidth : 35,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '图ID',
						xtype : 'textfield',
						anchor : '95%'
					} ]
				},
				{
					id : 'picRequire_form_id',
					columnWidth : .235,
					layout : 'form',
					labelWidth : 55,
					width : 70,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '图纸要求',
						xtype : 'textfield',
						anchor : '95%'
					} ]
				},
				{
					id : 'total_form_id',
					columnWidth : .235,
					layout : 'form',
					labelWidth : 55,
					labelAlign : "left",
					baseCls : "x-plain",
					labelAlign : "left",
					items : [ {
						fieldLabel : '数量(套)',
						xtype : 'textfield',
						anchor : '95%'
					} ]
				},
				{
					columnWidth : .025,
					layout : 'form',
					baseCls : "x-plain",
					items : [ {
						iconCls : 'silk-application-add',
						width : 20,
						xtype : 'button',
						handler : function() {
							addFieldItemToForm(formNum, "picName_form_id");
							addFieldItemToForm(formNum, "picId_form_id");
							addFieldItemToForm(formNum, "picRequire_form_id");
							addFieldItemToForm(formNum, "total_form_id");
							Ext.getCmp("mainPanel_id").doLayout();
							formNum++;
						}
					} ]
				},
				{
					columnWidth : .03,
					layout : 'form',
					baseCls : "x-plain",
					items : [ {
						iconCls : 'silk-application-delete',
						autoWidth : true,
						xtype : 'button',
						handler : function() {
							if (formNum == 0) {
								return;
							}

							formNum = formNum - 1;

							Ext.getCmp("picName_form_id").remove(
									"picName_form_id" + "_" + formNum);
							Ext.getCmp("picId_form_id").remove(
									"picId_form_id" + "_" + formNum);
							Ext.getCmp("picRequire_form_id").remove(
									"picRequire_form_id" + "_" + formNum);
							Ext.getCmp("total_form_id").remove(
									"total_form_id" + "_" + formNum);
							Ext.getCmp("mainPanel_id").doLayout();
						}
					} ]
				} ]
	});

	var galleryWindow = new Ext.Window({
		title : '添加图库',
		layout : 'fit',
		width : 920,
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
			text : '添加',
			handlere : function() {
				addWindowDataToGrid(formNum);
			}
		}, {
			text : '取消',
			handler : function() {
				galleryWindow.close();
			}
		} ]
	});

	galleryWindow.show();
}

function addFieldItemToForm(formNum, fromId) {
	var subItemField = new Ext.form.TextField({
		id : fromId + "_" + formNum,
		anchor : '95%'
	});

	Ext.getCmp(fromId).add(subItemField);
}

function addWindowDataToGrid(formNum) {
	var _projectValue = Ext.getCmp("project_id").getValue();
	var _productValue = Ext.getCmp("product_id").getValue();
	var _galleryValue = Ext.getCmp("galleryName_id").getValue();

	for (var i = 0; i < formNum; i++) {
		
		var _picName = Ext.getCmp("picName_form_id" + "_" + formNum).getValue();
		var _picId = Ext.getCmp("picId_form_id" + "_" + formNum).getValue();
		var _picRequire = Ext.getCmp("picRequire_form_id" + "_" + formNum).getValue();
		var _picTotal = Ext.getCmp("total_form_id" + "_" + formNum).getValue();
		
		
	}
}