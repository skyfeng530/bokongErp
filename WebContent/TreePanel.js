Ext.BLANK_IMAGE_URL="../ext3/resources/images/default/s.gif";
var tname = "";
var tpwd = "";
Ext.onReady(function() {
	
	// 开启悬浮提示
	Ext.QuickTips.init();
	
	// 不用启动项目, 本地即可查看
	var treePanel = new Ext.tree.TreePanel({
		title: '读取远程数据',
		renderTo: 'tree',
		width: 500,
		autoHeight: true,	// 如果不指名高度, 设置此项自动计算高度
		frame: true,		// 使面板主体颜色与主题一致
		autoScroll: true,
		userArrows: true,	// 在树中使用Vista样式箭头, 默认为false. 个人感觉毫无区别
		animate: true,		// 折叠 展开是具有动画效果
		containerScroll: true,
		rootVisible: true,	// 根节点可见, 默认为true
		dataUrl: 'href.html',	// 自动创建TreeLoader
		root: {
			id: '0',
			text: '全部人员',
			icon: '../images/22.gif',
			nodeType: 'async'	// 异步(等同于Ext.tree.AsyncTreeNode)
		}
	});
	// 自动展开根节点
	treePanel.getRootNode().expand();
	
	// 右键菜单
	var cth = function() {};
	var contextMenu = new Ext.menu.Menu({
		id: 'TreeContextMenu',
		items: [{
			text: '查看',
			handler: function() {
				Ext.Msg.alert('提示', '你单击了'+cth.node.id);
			}
		},{
			text: '添加',
			handler:function() {
				var nid = cth.node.id;
				Ext.Ajax.request({
					url:'getUserById.html',
					params:{
						id:nid
					},
					success: function(resp,opts){
						 var respText = Ext.util.JSON.decode(resp.responseText); 
						 console.log(respText);
						 var tid = respText[0].id;
						 var text = respText[0].text;
						 new Ext.Window({
							 title:'添加',
							 width:300,
							 height:250,
							 modal :true,
							 labelAlign:"left",
							 frame : true,
							 bodyStyle:"padding:5px;",
							 layout: 'form',  
							 colspan: 2,
							 items:[
								tname = new Ext.form.TextField({
									name:"tv_name",
									allowBlank : false,
									fieldLabel:"姓名",
								}),
								tpwd = new Ext.form.TextField(
								{
									name:"password",
									inputType:"password",
									fieldLabel:"密码",
									allowBlank:false
								}),
								new Ext.Button({
									text:'确定',
									handler: function() {
										Ext.Msg.alert('提示', 'name=' + tname.getValue() + ";pwd=" + tpwd.getValue());
									}
								}),
							 ]
						 }).show();
					},
					failure: function(resp,opts) {   
                         var respText = Ext.util.JSON.decode(resp.responseText);   
                         Ext.Msg.alert('错误', '提交失败！');   
                    }     
				});
			}
		}
		]
	});
	treePanel.on('contextmenu', function(node, e) {
		e.preventDefault();		// 阻止弹出默认右键菜单
		node.select();			// 选中节点
		cth.node = node;		// 赋给cth, 这样在菜单事件中就可以使用了
		contextMenu.showAt(e.getXY());
	});
	
	// 编辑节点名称
	var treeEditor = new Ext.tree.TreeEditor(treePanel, {
		allowBlank: false
	});
	treeEditor.on('beforestartedit', function(editor, tree, value) {
		// 只允许编辑叶子节点
		return editor.editNode.isLeaf();
	});
	treeEditor.on('complete', function(editor, value, startValue) {
		Ext.Msg.show({
			title: '提示',
			msg: '旧值: '+startValue+', 节点新值: '+value
		});
	});
});