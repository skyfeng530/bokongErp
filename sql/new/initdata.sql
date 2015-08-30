#为了把部门纳入角色，这里设计把10到99之间的用户Id留给部门id,也就是说，10至99之间的id值，需要在部门表中同有
#用户id为10至99之间的值，禁止登录，因为是部门使用
#增加用户时，因为是userId为主键，需要人为控制用户名称是否存在（冲突）
insert  into `user`(`userId`,`userName`,`userPassword`,`userRealname`,`userBirthday`,`userSex`,`idCard`,`userPhone`) values 
(1,'admin','21232F297A57A5A743894A0E4A801FC3','admin','1999-01-01','男','6111111111111111111','0253526'),
(2,'库管1号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(5,'库管2号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(6,'检验1号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(7,'检验2号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(8,'检验3号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(9,'检验4号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(10,'生产10号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(11,'生产1号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(12,'生产2号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7'),
(13,'生产3号','098F6BCD4621D373CADE4E832627B4F6','张三','1999-01-01','男','6111111111111111111','7');

insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values 
		(1,'安全管理',1010,'sys_user','0','user',1,'用户、权限管理'),
		(2,'电子流管理',1010,'task','0','task',70,'任务管理'),
		(3,'库房管理',1010,'device','0','device',50,'库房管理'),
		(4,'统计分析',1010,'statistics','0','statistics',80,'统计分析'),
		(5,'日志管理',1010,'log','0','log',30,'日志管理'),
		(6,'登陆信息管理',1010,'login','0','login',20,'登陆信息管理'),
		(7,'项目管理',1010,'login','0','login',20,'项目管理'),
		(8,'生产管理',1010,'login','0','login',20,'生产管理'),
		(21,'部门管理',1,'sys_department_find','1','/background/department/query.html',2,'部门增加、权限……操作'),
		(22,'用户管理',1,'sys_user_find','1','/background/user/query.html',4,'用户管理'),
		(23,'角色管理',1,'sys_role_find','1','/background/role/query.html',5,'角色增删改、权限设置'),
		(25,'新增部门',21,'sys_department_add','2','/background/department/addUI.html',22,'新增部门'),
		(26,'编辑部门',21,'sys_department_edit','2','/background/department/getById.html',22,'编辑部门'),
		(27,'删除部门',21,'sys_department_delete','2','/background/department/deleteById.html',22,'删除部门'),
		(29,'新增用户',22,'sys_user_addUI','2','/background/user/addUI.html',3,'新增用户'),
		(30,'添加资源',24,'sys_resc_addUI','2','/background/resources/addUI.html',8,'添加资源'),
		(31,'新增角色',23,'sys_role_add','2','/background/role/addUI.html',5,'新增角色'),
		(32,'用户登录记录',6,'log_list','1','/background/userLoginList/query.html',21,'用户登录记录'),
		(40,'操作日志管理',5,'log_find','1','/background/log/query.html',31,'操作日志管理'),
		(41,'分配角色',22,'sys_user_fenpeirole','2','sys_user_fenpeirole',32,'分配角色'),
		(42,'分配权限',22,'sys_user_permissions','2','sys_user_permissions',33,'分配权限'),
		(43,'编辑用户',22,'sys_user_edit','2','/background/department/getById.html',34,'编辑'),
		(44,'删除用户',22,'sys_user_delete','2','/background/department/deleteById.html',36,'删除用户'),
		(45,'分配权限',23,'sys_role_permissions','2','sys_role_permissions',37,'分配权限'),
		(46,'显示详细信息',23,'sys_role_show','2','sys_role_show',39,'显示详细信息'),
		(47,'编辑角色',23,'sys_role_edit','2','/background/role/getById.html',40,'编辑角色'),
		(48,'删除角色',23,'sys_role_delete','2','/background/role/deleteById.html',41,'删除角色'),
		(49,'显示详细信息',24,'sys_res_show','2','sys_res_show',43,'显示详细信息'),
		(50,'编辑权限资源',24,'sys_res_edit','2','/background/resources/getById.html',44,'编辑权限资源'),
		(51,'删除权限资源',24,'sys_res_delete','2','/background/resources/deleteById.html',45,'删除权限资源'),
		(72,'部署任务',2,'task_deploy','1','/background/workflow/deployHome.html',71,'部署任务'),
		(73,'待我审批',2,'task_myself','1','/background/workflow/myTaskList.html',72,'我的任务'),
		(74,'填写申请',2,'task_apply','1','/background/workflow/formTemplateList.html',73,'填写申请任务'),
		(75,'申请查询',2,'task_manager','1','/background/workflow/myApplyList.html',74,'归档任务'),
		(76,'抄送我的',2,'task_copyperson','1','/background/workflow/copyPersonUI.html',75,'抄送我的'),
		(83,'项目查询',7,'statistics_manager','1','/background/project/query.html',4,'项目查询'),
		(84,'生产查询',8,'statistics_manager','1','/background/noDevelop.html',4,'生产查询'),
		(85,'产品查询',7,'statistics_manager','1','/background/project/product/query.html',4,'产品查询'),
		(86,'报表分析',4,'statistics_manager','1','/background/noDevelop.html',4,'设备列表'),
		(87,'任务查询',7,'statistics_manager','1','/background/project/task/query.html',4,'任务查询');


insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(77,'机械器件',3,'statistics_manager','1','/background/device/material/mechanicsquery.html',4,'机械器件');
insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(78,'光学器件',3,'statistics_manager','1','/background/device/material/opticalquery.html',4,'光学器件');
insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(79,'工装设备',3,'statistics_manager','1','/background/noDevelop.html',4,'工装设备');
insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(80,'固定资产',3,'statistics_manager','1','/background/device/fixedasset/query.html',4,'固定资产');
insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(81,'仪表设备',3,'statistics_manager','1','/background/device/instrument/query.html',4,'仪表设备');
insert  into `resources`(`id`,`name`,`parentId`,`resKey`,`type`,`resUrl`,`level`,`description`) values(88,'图库查询',7,'statistics_manager','1','/background/project/figureLib/query.html',4,'图库查询');

#增加角色控制，可以和部门对应
#一个用户可以属于多个部门，一个具体的用户，其角色权限=其所属所有部门权限+自己的权限（初始化资源显示)
insert  into `role`(`id`,`name`,`roleKey`,`description`,`enable`) values (1,'用户角色','ROLE_USER','用户角色',1);
insert  into `role`(`id`,`name`,`roleKey`,`description`,`enable`) values (3,'删除','ROLE_DELETE','删除',0);
insert  into `role`(`id`,`name`,`roleKey`,`description`,`enable`) values (5,'55','55','55',1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('生产人员', 'ROLE_PRODUCT', '生产车间人员', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('库管人员', 'ROLE_PRODUCT', '库存管理', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('检验员', 'ROLE_PRODUCT', '产品检验', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('采购员', 'ROLE_PRODUCT', '物料采购', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('审批员', 'ROLE_PRODUCT', '流程审批', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('设计人员', 'ROLE_PRODUCT', '工艺设计', 1);
INSERT INTO `role` (`name`,`roleKey`,`description`,`enable`) VALUES ('项目经理', 'ROLE_PRODUCT', '项目管理', 1);
#初始化部门,其中类型DepartType, 1,表示实际上有这个部门，0表示虚拟团队
insert into DepartmentInfo(DepartId, dName, DepartType, Discribe) values(1, '超级管理员', 0, '超级管理员');
insert into DepartmentInfo(DepartId, dName, DepartType, Discribe) values(3, '测试帐户', 0, '测试帐户');
insert into DepartmentInfo(dName, DepartType, Discribe) values('生产部', 1, '车间生产产品');
insert into DepartmentInfo(dName, DepartType, Discribe) values('库管', 0, '仓库管理');
insert into DepartmentInfo(dName, DepartType, Discribe) values('检验部', 0, '产品检验');
insert into DepartmentInfo(dName, DepartType, Discribe) values('采购部', 0, '物料采购');
insert into DepartmentInfo(dName, DepartType, Discribe) values('CCB审批', 0, '裁决问题');
insert into DepartmentInfo(dName, DepartType, Discribe) values('设计部', 0, '工艺设计');
insert into DepartmentInfo(dName, DepartType, Discribe) values('项目部', 0, '项目实施');

insert  into `resources_role`(`resc_id`,`role_id`) values 
				(1,1),(1,3),(1,5),(1,10),(2,1),(2,3),(2,5),
				(3,1),(3,3),(4,1),(4,3),(5,1),(5,3),(6,1),
				(6,3),(6,5),(7,1),(7,3),(8,1),(8,3),(21,1),
				(21,3),(21,5),(21,10),(22,1),(22,3),(22,5),
				(23,1),(23,3),(23,5),(23,10),(24,1),(24,3),
				(24,5),(25,1),(25,3),(25,5),(26,1),(26,3),
				(26,5),(27,1),(27,3),(27,5),(28,3),(28,5),
				(29,1),(30,1),(31,1),(32,1),(40,1),(41,1),
				(41,5),(42,1),(42,5),(42,10),(43,1),(43,5),
				(43,10),(44,1),(44,5),(44,10),(45,1),(45,5),
				(46,1),(46,5),(47,1),(47,5),(48,1),(48,5),
				(49,1),(49,5),(50,1),(50,5),(51,1),(51,5),
				(72,1),(72,5),(73,1),(73,5),(74,1),(74,5),
				(75,1),(75,5),(76,1),(77,1),(78,1),(79,1),
				(80,1),(81,1),(82,1),(83,1),(84,1),(85,1),
				(86,1),(86,5),(1010,1),(1010,3),(1010,5);

				
insert  into `resources_role`(`resc_id`,`role_id`) values (87,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (87,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (88,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (88,5);

insert  into `user_role`(`user_id`,`role_id`) values (1,1),(2,1),(5,1),(7,10),(8,10);

insert  into `department_user`(`department_id`,`user_id`) values (1,1);


#SELECT userId FROM user WHERE userName LIKE '生产%' 
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(1, 'admin', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产3号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产4号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产5号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产6号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产7号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产8号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产9号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '生产10号', 'normal', 1);
#库管
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(12, '库管1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(12, '库管2号', 'normal', 1);
#检验
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(13, '检验1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(13, '检验2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(13, '检验3号', 'normal', 1);
#采购
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(14, '采购1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(14, '采购2号', 'normal', 1);
#领导
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(15, '领导1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(15, '领导2号', 'normal', 1);
#设计
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(16, '设计1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(16, '设计2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(16, '设计3号', 'normal', 1);
#项目
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(17, '项目经理1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(17, '项目经理2号', 'normal', 1);

#############################################################################
insert into `device` (`id`, `deviceName`, `deviceVersion`, `deviceType`, `deviceCount`, `ischeckout`, `manufacturers`, `manufacturersPhone`, `productDate`, `outDate`, `deviceStatus`, `remark`) values('4','电阻','v0001','0','300','0','利尔达','13888888888','2015-06-13 16:50:41','2015-06-10 21:57:40','0','用于………………');
insert into `device` (`id`, `deviceName`, `deviceVersion`, `deviceType`, `deviceCount`, `ischeckout`, `manufacturers`, `manufacturersPhone`, `productDate`, `outDate`, `deviceStatus`, `remark`) values('5','显示器','050120001150112','1','23','1','三星','13999999999','2015-03-13 12:57:37','2017-03-13 12:57:37','1','sdvsdvsdvds');
insert into `device` (`id`, `deviceName`, `deviceVersion`, `deviceType`, `deviceCount`, `ischeckout`, `manufacturers`, `manufacturersPhone`, `productDate`, `outDate`, `deviceStatus`, `remark`) values('7','主板','v111110909','1','13','0','技嘉','02988888888','2015-03-13 12:57:37','2017-03-13 12:57:37','0','aaaaaaaaaaaaaaa');
#############################################################################
#项目表
insert into projectinfo(ProjectName,TaskNumber, info) values('APS星敏感器','RW-G14005','APS');
insert into projectinfo(ProjectName,TaskNumber, info) values('APS星敏感器','RW-G1543','测试验');
insert into projectinfo(ProjectName,TaskNumber, info) values('虚拟云','计划1','APS');
insert into projectinfo(ProjectName,TaskNumber, info) values('虚拟云','计划2','APS');
insert into projectinfo(ProjectName,TaskNumber, info) values('虚拟云','计划3','APS');

insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('量块','(125-500)mm 大8块','070311','陈生辉','-','哈尔滨量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('亚微米数显光栅测长仪','SKS50','080310','杜水生','02-090062','成都思凯','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('三点内径千分尺','(175-200/0.005)mm','S/N1580（005274）','陈生辉','-','日本三丰','B',2,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('读数显微镜','XGJ-4/03','12-3#','段战军','02-120081','孝感华中精密仪器有限公司','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('读数显微镜','XGJ-4/03','12-4#','秦星','02-120082','孝感华中精密仪器有限公司','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('平行光管','FPG-3A(80mm)','20150405','付西红','-','孝感华中精密仪器有限公司','B',2,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('平行光管','FPG-3A(80mm)','20150406','付西红','-','孝感华中精密仪器有限公司','B',2,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('扭矩扳手','(1-5)N·M','2242447','张建','-','丹纳赫工具（上海）有限公司','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('杠杆千分表','0-0.6/0.002)mm','NEG061','杜水生','-','日本三丰','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('外径千分尺','(20-50/0.01)mm','ZX02-029(O273)','杜水生','-','上海量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('外径千分尺','(0-25/0.01)mm','ZX02-017(C1727)','杜水生','-','哈尔滨量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('游标高度尺','(0-300/0.02)mm','ZX01-030(85378)','杜水生','-','上海量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('杠杆千分表','(0-0.14/0.001)mm','MXU427','杨宾宏','-','日本三丰','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('千分表','(0-1/0.001)mm','NFH337','陈生辉','-','日本三丰','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('百分表','(0-10/0.01)mm','ZX03-013(A486)','杜水生','-','桂林量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('千分表','(0-1/0.001)mm','NEB649','杜水生','-','日本三丰','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('外径千分尺','(0-25/0.01)mm','0773244','陈生辉','-','哈尔滨量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('外径千分尺','(150-175/0.01)mm','ZX02-022(772089)','仝宇高','-','哈尔滨量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('外径千分尺','(175-200/0.01)mm','ZX02-023(7112)','仝宇高','-','青海量刃具厂','B',1,10);
insert  into instrumentDevice(name,specifications,instrumentNumber,usePerson,assetNumber,manufacturer,instrumentType,verifyCycle,hintVerifyDays) values('数显卡尺','(0-200/0.01)mm','00858868','蔺明明','-','桂林广陆数字测控公司','B',1,10);


insert into omDiscardStorage (`id`, `taskId`, `devType`,	`discardType`, `figureName`, `devNo`, `figureId`, `num`, `discardReason`, `questionType`, `checkRst`, `reviewRst`, `reviewNo`, `reviewPicture`) 
values(1, 1, 1, 1, '钢圈', '1', '1-01', 1, '损坏', 1, 1, 1, '20150730(G)- 01', '');
insert into omDiscardStorage (`id`, `taskId`, `devType`,	`discardType`, `figureName`, `devNo`, `figureId`, `num`, `discardReason`, `questionType`, `checkRst`, `reviewRst`, `reviewNo`, `reviewPicture`) 
values(2, 1, 1, 1, '铸件', '1', '1-02', 1, '损坏', 1, 1, 1, '20150730(G)- 02', '');
insert into omDiscardStorage (`id`, `taskId`, `devType`,	`discardType`, `figureName`, `devNo`, `figureId`, `num`, `discardReason`, `questionType`, `checkRst`, `reviewRst`, `reviewNo`, `reviewPicture`) 
values(3, 1, 1, 1, '皮筋', '1', '1-03', 1, '断掉', 1, 1, 1, '20150730(G)- 03', '');

insert  into fixedAsset(name,tagNumber,specifications,serialNumber,status,responsiblePerson,usePerson,equipmentPosition,assetClass, vendorInfo) values('数显卡尺','00858868','(0-200/0.01)mm','001', '完好','蔺明明', '黎声树','南昌市','家具','桂林广陆数字测控公司');

insert into busproject(pid, projectName, projectDescribe) values(1, '长征5号','国家航天重点A级项目');
insert into busproject(pid, projectName, projectDescribe) values(2, '嫦娥11号','国家航天重点项目');



insert into busprojectproduct(ppid, projectId, productNo, productName, status, bak) values(1, 1, '705', '前仓镜头', 'C', '出样');
insert into busprojectproduct(ppid, projectId, productNo, productName, status, bak) values(2, 1, '705', '前仓镜头', 'Z', '终样');
insert into busprojectproduct(ppid, projectId, productNo, productName, status, bak) values(3, 2, '705', '前仓镜头', 'C', '出样');
insert into busprojectproduct(ppid, projectId, productNo, productName, status, bak) values(4, 2, '705', '前仓镜头', 'Z', '终样');

insert into bustask(taskid, taskNo, ppid, figureLib, artId, totalSetNum, taskSource) values(1, 'RW-G14005', 1, '图库1', 1, 10, '705');
insert into bustask(taskid, taskNo, ppid, figureLib, artId, totalSetNum, taskSource) values(2, 'RW-G14006', 1, '图库1', 1, 5, '705');
insert into bustask(taskid, taskNo, ppid, figureLib, artId, totalSetNum, taskSource) values(3, 'RW-G14005', 1, '图库1', 2, 4, '705');
insert into bustask(taskid, taskNo, ppid, figureLib, artId, totalSetNum, taskSource) values(4, 'RW-G14006', 1, '图库1', 2, 3, '705');

INSERT INTO devicetype(devid, devName, devNick, reserverd1, reserverd2) VALUES(1, '光学', '',  0, 0);
INSERT INTO devicetype(devid, devName, devNick, reserverd1, reserverd2) VALUES(2, '机械', '',  0, 0);

INSERT INTO busprojectfigure(`pfid`, `ppid`, `figureLib`, `figureNo`, `figureName`, `figureRequest`, `type`, `batchNum`, `describe`) VALUES(1, 1, '图库1', '1-01', '钢圈', '直径0.3', 1, 3, '');
INSERT INTO busprojectfigure(`pfid`, `ppid`, `figureLib`, `figureNo`, `figureName`, `figureRequest`, `type`, `batchNum`, `describe`) VALUES(2, 1, '图库1', '1-02', '镜片', '厚度0.3', 1, 3, '');

INSERT INTO ominstorage(id, taskId, pfid,devBatchNo, totalNumber, vendorNo, checkRst, checkNum, qualifiedNum, unqualifiedNum, unqualifiedGrade, unqualifiedReason, reviewRst, reviewGrp, reviewNo, graphicPath, bak) 
VALUES(1, 1, 1, '001', 20, 'sx-xa-om', '测量长度0.5mm', 20, 10, 10, 2, '误差太大', 1, 1, '20140102-G-01', 'D:\002.jpg', '');
INSERT INTO ominstorage(id, taskId, pfid, devBatchNo, totalNumber, vendorNo, checkRst, checkNum, qualifiedNum, unqualifiedNum, unqualifiedGrade, unqualifiedReason, reviewRst, reviewGrp, reviewNo, graphicPath, bak) 
VALUES(2, 2, 2, '002', 1, 'sx-xa-om', '测量长度0.5mm', 1, 1, 0, 0, '', 0, 0, '', '', '');


INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(1, '合格', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(2, '一般不合格', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(3, '严重不合格', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(4, '审理小组', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(5, '审理委员会', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(6, '返工', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(7, '返修', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(8, '退回', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(9, '降级', '');
INSERT INTO busStorageAssistance(`id`, `name` , `describe`) VALUES(10, '报废', '');



