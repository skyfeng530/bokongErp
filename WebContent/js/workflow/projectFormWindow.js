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
					id : 'picName_form_id',
					columnWidth : .235,
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
						blankText : '不能为空'
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
						id : 'picId_form_id_0',
						fieldLabel : '图ID',
						xtype : 'textfield',
						anchor : '95%',
						allowBlank : false,
						blankText : '不能为空'
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
						id : 'picRequire_form_id_0',
						fieldLabel : '图纸要求',
						xtype : 'textfield',
						anchor : '95%',
						allowBlank : false,
						blankText : '不能为空'
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
						id : 'total_form_id_0',
						fieldLabel : '数量(套)',
						xtype : 'textfield',
						anchor : '95%',
						regexp : /^\d+$/,
						allowBlank : false,
						blankText : '不能为空'
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
							formNum++;
							addFieldItemToForm(formNum, "picName_form_id");
							addFieldItemToForm(formNum, "picId_form_id");
							addFieldItemToForm(formNum, "picRequire_form_id");
							addFieldItemToForm(formNum, "total_form_id",
									/^\d+$/);
							Ext.getCmp("mainPanel_id").doLayout();
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
		id : 'galleryWindow_id',
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
			handler : function() {
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

function addFieldItemToForm(formNum, fromId, _regexp) {
	var subItemField = new Ext.form.TextField({
		id : fromId + "_" + formNum,
		anchor : '95%',
		allowBlank : false,
		regexp : _regexp,
		blankText : '不能为空'
	});

	Ext.getCmp(fromId).add(subItemField);
}

function addWindowDataToGrid(formNum) {
	var _gridStore = Ext.getCmp("_gridPanel_id").getStore();

	var component = _gridStore.recordType;

	for (var i = 0; i <= formNum; i++) {

		if (!Ext.getCmp("picName_form_id" + "_" + i).isValid()
				|| !Ext.getCmp("picId_form_id" + "_" + i).isValid()
				|| !Ext.getCmp("picRequire_form_id" + "_" + i).isValid()
				|| !Ext.getCmp("total_form_id" + "_" + i).isValid()) {
			return "";
		}

		var _picName = Ext.getCmp("picName_form_id" + "_" + i).getValue();
		var _picId = Ext.getCmp("picId_form_id" + "_" + i).getValue();
		var _picRequire = Ext.getCmp("picRequire_form_id" + "_" + i)
				.getValue();
		var _picTotal = Ext.getCmp("total_form_id" + "_" + i).getValue();

		_gridStore.insert(0, new component({
			projectName : projectName,
			productName : productName,
			pictureId : _picId,
			pictureName : _picName,
			pictruerequire : _picRequire,
			total : _picTotal
		}));
	}

	Ext.getCmp("galleryWindow_id").close();
}

function getFigureGridData(_flowId) {
	var _gridPanel = Ext.getCmp("_gridPanel_id");

	var _gridStore = _gridPanel.getStore();

	var localCount = _gridStore.getCount();

	if (localCount <= 0) {
		return "";
	}

	var jsonData = "[";

	for (var i = 0; i < localCount; i++) {

		var record = _gridStore.getAt(i).data;

		jsonData += "{'figureNo':'" + isintNull(record.pictureId) + "', "
				+ "'figureName':'" + isStrNull(record.pictureName) + "',"
				+ "'figureRequest':'" + isStrNull(record.pictruerequire)
				+ "','flowId':'" + _flowId + "','batchNum':'"
				+ isintNull(record.total) + "'},";
	}

	return jsonData.substring(0, jsonData.length - 1) + "]";
}