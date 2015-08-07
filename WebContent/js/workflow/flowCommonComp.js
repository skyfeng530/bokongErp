function getFlowCommonComp(_taskId) {

	var _processInfoStore = loadProcessInfo(_taskId);
	var _processUser = loadProcessUser();
	
	return [{
				id : 'processId',
				name : "operate",
				fieldLabel : "选择您要的操作",
				xtype : 'combo',
				store : _processInfoStore,
				allowBlank : false,
				blankText : '不能为空',
				selectOnFocus : true,
				forceSelection : true,
				triggerAction : 'all',
				valueNotFoundText : '',
				emptyText : '请选择...',
				mode : "local",
				valueField : 'value',
				displayField : 'text',
				listeners : {
					'render' : function() {

						Ext.getCmp("processId").store
								.reload({
									callback : function() {

										if (Ext.getCmp("processId").store
												.getTotalCount() == 1) {
											var firstValue = Ext
													.getCmp("processId").store
													.getRange()[0].data.value;

											Ext.getCmp("processId").setValue(
													firstValue);
										}

									}
								});

					}
				}
			}, {
				id : 'processUserId',
				name : "operateUser",
				fieldLabel : "处理人员",
				xtype : 'combo',
				store : _processUser,
				allowBlank : false,
				triggerAction : 'all',
				blankText : '不能为空',
				selectOnFocus : true,
				forceSelection : true,
				valueNotFoundText : '',
				emptyText : '请选择...',
				mode : "remote",
				valueField : 'username',
				displayField : 'username',
			}, {
				name : "copyUser",
				fieldLabel : "抄送人员",
				xtype : 'combo'
			}, {
				id : 'commonMask_id',
				xtype : "textarea",
				name : "mask",
				height : 50,
				fieldLabel : "批注",
				allowBlank : false,
				blankText : '不能为空'
			}];
}