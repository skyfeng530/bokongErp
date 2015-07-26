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
		name:'ProjectName',
		renderTo: 'projectName',
		width:200,
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
		name:'TaskNumber',
		renderTo: 'taskNumber',
	    width:200,
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
		name:'DeviceType',
		renderTo: 'deviceType',
		width:200,
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
		name:'PloidyNum',
		renderTo: 'ploidyNum',
		msgTarget:'qtip',
		allowDecimals:false,
		allowBlank:false,
		blankText:"套数不能为空。",
		minValue:1,
		width:200,
		minText:"最小值为1"
	});
}

function libraryMode()
{
	var ploidyRadioDoc = document.getElementById("ploidyRadio");
	var devicesRadioDoc = document.getElementById("devicesRadio");
	var ploidyDoc = document.getElementById("ploidyId");
	if (ploidyRadioDoc.checked)
	{
		ploidyDoc.style.display='';
	}
	if (devicesRadioDoc.checked)
	{
		ploidyDoc.style.display='none';
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