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

workflow.states.testLevelStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '合格' ], [ '2', '一般不合格' ],
			[ '3', '严重不合格' ] ]
});
workflow.states.trialResultsStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '返工' ], [ '2', '返修' ], [ '3', '降级' ], [ '4', '报废' ], [ '5', '让步接收' ], [ '6', '退回供方' ]]
});

workflow.states.trialOrgStore = new Ext.data.SimpleStore({
	fields : [ 'value', 'text' ],
	data : [ [ '1', '审理小组' ], [ '2', '审理委员会' ]]
});
