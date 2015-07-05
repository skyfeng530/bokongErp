Ext.namespace('workflow.states');

workflow.states.categoryStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '光学零件' ], [ '2', '机械零件' ] ]
});

workflow.states.workInProcessStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '是' ], [ '2', '否' ] ]
});


workflow.states.saveTimeStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '年' ], [ '2', '月' ], [ '3', '日' ], [ '4', '时' ] ]
});

workflow.states.validMethodStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '全检' ], [ '2', '抽检' ], [ '3', '不检' ] ]
});
