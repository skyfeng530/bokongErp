// JavaScript Document
var demoData = {
	roleList: [
		{ "role.name": "档案管理员", "role.description": "管理档案"}
	],
	departmentList:[
		{ "department.name": "总经理室", "department.parent.name": "", "department.description": ""}
	],
	departmentList2:[
		{ "department.name": "研发部", "department.parent.name": "OA产品部", "department.description": ""}
	],
	userList:[
		{ "user.loginName": "zs", "user.name": "张三", "user.department": "研发部", "user.roles": "程序员", "user.description": "" }
	], 
	menuList:[
		{ "menu.name": "系统设置", "menu.prefix": "", "menu.icon": "FUNC20082.gif", "menu.url": "", "menu.description": "" }
	], 
	formTemplateList:[
		{ "formTemplate.name": "借支单" }
	],
	messageList:[
		{ "message.priority": "！", "message.title": "销售部任务安排", "message.sender": "系统", "message.recipient": "王发财", "message.postTime": "2010-04-15 18:41" }
    ],
	messageList2:[
		{ "message.priority": "！", "message.title": "销售部任务安排", "message.sender": "系统", "message.recipient": "王发财", "message.postTime": "2010-04-15 18:41" }
    ],
    processDefList:[
         { "processDef.id": 1, "processDef.name": "工作报告", "processDef.version": 1, "processDef.description": "" }
    ],
	documentTemplateList:[
         { "documentTemplate.id": 1, "documentTemplate.name": "工作报告", "documentTemplate.processName": "工作报告流程", "documentTemplate.description": "" }
    ],
	systemMenuList: [
		{ "systemMenu.id": 1, "systemMenu.namePrefix": "", "systemMenu.name": "审批流转", "systemMenu.parent.id": ""  }
	],
	processNodeList: [
		{ "processNode.ordinal": 1, "processNode.name": "总经理审批", "processNode.type": "审批", "processNode.description": "" }
	],
	formList: [
		{ "form.id": 1, "form.title": "领款单_李明_2010-05-16 ", "form.applicant.name": "李明", "form.applyTime": "2010-05-16 09:30", "form.status": "已通过" }
	],
	approveInfoList: [
		{ "approveInfo.index": 1, "approveInfo.type": "审批", "approveInfo.approveTime": "2010-05-17 09:45", "approveInfo.approver": "王五", "approveInfo.approval": "同意", "approveInfo.comment": "" },
	],
	dirList:[
		{ "dir.name": "OA方案", "dir.creationTime": "2010-5-24 09:56:33" }
	],
	fileList:[
		{ "file.name": "使用手册.doc", "file.fileType.icon": "doc.gif", "file.size": "3.05MB", "file.creationTime": "2010-5-24 09:56:33" }
	],
	forumList: [
		{ "forum.name": "灌水专区", "forum.description": "大家可以尽情的来这里灌水", "forum.topicCount": 56, "forum.articleCount": 107, "forum.lastTopic.title": "OA是什么？ ", "forum.lastTopic.author.name": "管理员", "forum.lastTopic.postTime": "2010-06-12 17:47"  }
	],
	topicList: [
		{ "topic.type": "0","topic.title": "流程类别是干什么用的？", "topic.replyCount": 17 }
	],
	replyList: [
		{ "reply.title": "回复：新手发帖", "reply.content": "<img src='../script/fckeditor/editor/images/smiley/wangwang/11.gif'/>", "reply.floor": "3", "reply.faceIcon": "face3.gif" }
	],
	faceIcon1_7: [
		{ "faceIconIndex" : "7" }
	],
    xxList: []
};

// list的最后一个元素后不要有逗号，否则在页面中显示数据时，会多出一行模板行。是因为没有数据内容造成的。
// （是使用替换的方式完成的显示数据，如果没有替换值，就不会替换，所以会多一个模板行）
