function mainView()
{
	var projectNameStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../../background/storageOut/queryProjectName.html"}),  
        reader: new Ext.data.JsonReader(  
                      {},  
                      ["value", "text"]
                      ),
        autoLoad : true
    });  
	var taskNumberStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../../background/storageOut/querytaskNumber.html?projectName=project1"}),
        reader: new Ext.data.JsonReader(  
                      {},  
                      ["value", "text"]
                      )
    });
	var projectNameCombo = new Ext.form.ComboBox({
		id:'ProjectNameId',
		name:'ProjectName',
		fieldLabel:'&nbsp&nbsp&nbsp&nbsp项目名称',
		width:250,
	    store: projectNameStore,
	    valueField: 'value',
	    displayField: 'text',
	    msgTarget:'qtip',
	    allowBlank:false,
	    blankText:"项目名称不能为空。",
	    mode: 'remote',
	    triggerAction: 'all',
	    editable:false,
	    emptyText: '请选择...',
	    listeners:{'select':function(){
	    	taskNumberCombo.reset();  
	    	taskNumberStore.proxy = new Ext.data.HttpProxy({ url: "../../background/storageOut/querytaskNumber.html?projectName="+this.getRawValue()});
	    	taskNumberStore.reload();
	    }}
	});
	

	var taskNumberCombo = new Ext.form.ComboBox({
		id:'TaskNumberId',
		name:'TaskNumber',
		fieldLabel:'&nbsp&nbsp&nbsp&nbsp任务编号',
	    width:250,
	    store: taskNumberStore,
	    emptyText: '请选择...',
	    mode: 'remote',
	    editable:false,
	    msgTarget:'qtip',
	    allowBlank:false,
	    blankText:"任务编号不能为空。",
	    triggerAction: 'all',
	    valueField: 'value',
	    displayField: 'text',
	    listConfig:
	    {
	        loadMask: false  //add by myself
	    }
	});
	
	var deviceTypeStore = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({ url: "../../background/storageOut/queryDeviceType.html"}),  
        reader: new Ext.data.JsonReader(  
                      {},  
                      ["value", "text"]
                      ),
        autoLoad : true
    });
	
	var deviceTypeCombo = new Ext.form.ComboBox({
		id:'DeviceTypeId',
		name:'DeviceType',
		fieldLabel:'&nbsp&nbsp&nbsp&nbsp器件类型',
		width:250,
	    store: deviceTypeStore,
	    emptyText: '请选择...',
	    editable:false,
	    mode:'remote',
	    msgTarget:'qtip',
	    allowBlank:false,
	    blankText:"器件类型不能为空。",
	    triggerAction: 'all',
	    valueField: 'value',
	    displayField: 'text',
	    listConfig:
	    {
	        loadMask: false  //add by myself
	    }
	});
	
	var ploidyNumInput = new Ext.form.NumberField({
		id:'PloidyNumId',
		name:'PloidyNum',
		fieldLabel:'&nbsp&nbsp&nbsp&nbsp套数',
		msgTarget:'qtip',
		allowDecimals:false,
		allowBlank:false,
		blankText:"套数不能为空且大于0。",
		minValue:1,
		width:250,
		minText:"套数不能为空且大于0。"
	});
	
	var form = new Ext.form.FormPanel({
		id:"formId",
		renderTo:'storage_out_id',
		lableAlign:'right',
		buttonAlign:'center',
		labelWidth:80,
		frame:true,
		//url: "../../background/workflow/submitForm_storageOut.html",
		items:[{
			xtype:'textfield',
			hidden:true,
			name:"pid",
			value:pdid
		},{
			xtype:'textfield',
			hidden:true,
			name:"pdkey",
			value:pdkey
		}
		,projectNameCombo,taskNumberCombo,deviceTypeCombo,
		{
            xtype: "radiogroup",
            name:'LibraryMode',
            id:'LibraryModeId',
            allowBlank : false, 
            fieldLabel: "&nbsp&nbsp&nbsp&nbsp出库方式",
            width:250,
            columns: 2,
            items: [
                { boxLabel: "整套",name: "librarymode", inputValue: "ploidy",checked:true,
                	listeners:{'check' : function(){
                		if (Ext.getCmp('LibraryModeId').getValue().inputValue == 'device')
                		{
                			Ext.getCmp('PloidyNumId').setVisible(false);   
                			Ext.getCmp('PloidyNumId').getEl().up('.x-form-item').setDisplayed(false); 
                		}
                		else
                		{
                			Ext.getCmp('PloidyNumId').reset();
                			Ext.getCmp('PloidyNumId').setVisible(true);   
                			Ext.getCmp('PloidyNumId').getEl().up('.x-form-item').setDisplayed(true);  
                		}
                    }
                }
                },
                { boxLabel: "器件", name: "librarymode", inputValue: "device" }
            ]},
		ploidyNumInput
		],
		buttons:[{
			text:"提交",
			handler:function(){
				var projectNameObj = Ext.getCmp('ProjectNameId');
				var taskNumberObj = Ext.getCmp('TaskNumberId');
				var deviceTypeObj = Ext.getCmp('DeviceTypeId');
				var libraryModeVal = Ext.getCmp('LibraryModeId').getValue().inputValue;
				var ploidyNumObj = Ext.getCmp('PloidyNumId');
				
				var projectNameVal =  projectNameObj.getRawValue();
				var taskNumberVal =  taskNumberObj.getRawValue();
				var deviceTypeVal =  deviceTypeObj.getRawValue();
				var ploidyNumVal = ploidyNumObj.getValue();
				var error = 0;
				if (projectNameVal == null || projectNameVal == '')
				{
					projectNameObj.markInvalid("项目名称不能为空。");
					error+=1;
				}
				if (taskNumberVal == null || taskNumberVal == '')
				{
					taskNumberObj.markInvalid("任务编号不能为空。");
					error+=1;
				}
				if (deviceTypeVal == null || deviceTypeVal == '')
				{
					deviceTypeObj.markInvalid("器件类型不能为空。");
					error+=1;
				}
				if (libraryModeVal == 'ploidy')
				{
					if (ploidyNumVal == null || ploidyNumVal == '' || ploidyNumVal <= 0)
					{
						ploidyNumObj.markInvalid("套数不能为空且大于0。");
						error+=1;
					}
				}
				else
				{
					ploidyNumObj.setValue(1);
				}
				if (error > 0)
				{
					return;
				}
				//form.getForm().submit();
				window.location.href="../../background/workflow/submitForm_storageOut.html";
			}
		},
		{
			text:"返回",
            handler:function(){
            	history.go(-1);
			}
		}]
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

};
Ext.onReady(initview);