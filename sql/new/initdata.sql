#为了把部门纳入角色，这里设计把10到99之间的用户Id留给部门id,也就是说，10至99之间的id值，需要在部门表中同有
#用户id为10至99之间的值，禁止登录，因为是部门使用
#增加用户时，因为是userId为主键，需要人为控制用户名称是否存在（冲突）
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values ('admin','admin','admin','admin',10,'男','枯霜下要孤','0253526','jnfjfjj@163.com','32432','2015-06-08 19:21:58','0000-00-00 00:00:00',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产3号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产4号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产5号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产6号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产7号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产8号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产9号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('生产10号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('库管1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('库管2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('检验1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('检验2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('检验3号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('检验4号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('采购1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('采购2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('领导1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('领导2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('设计1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('设计2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('设计3号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('项目经理1号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');
insert  into `user`(`userName`,`userPassword`,`userNickname`,`userRealname`,`userAge`,`userSex`,`userAddress`,`userPhone`,`userMail`,`userQQ`,`regTime`,`lastLogintime`,`level`,`province`,`city`,`bankName`,`branchBank`,`subbranchBank`,`openBankName`,`bankAccountName`,`bankAccount`,`accountType`,`pay`,`mark`,`status`,`parentNumber`) values('项目经理2号','test','7','7',7,'男','7','7','7','7','2015-06-09 21:40:21','0000-00-00 00:00:00',1,'7','7','7',NULL,'7',NULL,'7','7','企业账号','是','7','待审核','');


insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('1','安全管理','1010','sys_user','0','user','1','用户、权限管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('2','用户管理','1','sys_user_find','1','/background/user/query.html','2','用户增加、权限……操作');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('3','新增用户','2','sys_user_addUI','2','/background/user/addUI.html','3','新增用户');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('5','角色管理','1','sys_role_find','1','/background/role/query.html','5','角色增删改、权限设置');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('7','资源管理','1','sys_resc_find','1','/background/resources/query.html','7','资源列表');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('8','添加资源','7','sys_resc_addUI','2','/background/resources/addUI.html','8','添加资源');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('11','新增角色','5','sys_role_add','2','/background/role/addUI.html','5','新增角色');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('22','登陆信息管理','1010','login','0','login','20','登陆信息管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('23','用户登录记录','22','log_list','1','/background/userLoginList/query.html','21','用户登录记录');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('39','日志管理','1010','log','0','log','30','日志管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('40','操作日志管理','39','log_find','1','/background/log/query.html','31','操作日志管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('41','分配角色','2','sys_user_fenpeirole','2','sys_user_fenpeirole','32','分配角色');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('42','分配权限','2','sys_user_permissions','2','sys_user_permissions','33','分配权限');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('43','编辑用户','2','sys_user_edit','2','/background/user/getById.html','34','编辑');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('44','删除用户','2','sys_user_delete','2','/background/user/deleteById.html','36','删除用户');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('45','分配权限','2','sys_role_permissions','2','sys_role_permissions','37','分配权限');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('46','显示详细信息','5','sys_role_show','2','sys_role_show','39','显示详细信息');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('47','编辑角色','5','sys_role_edit','2','/background/role/getById.html','40','编辑角色');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('48','删除角色','5','sys_role_delete','2','/background/role/deleteById.html','41','删除角色');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('49','显示详细信息','7','sys_res_show','2','sys_res_show','43','显示详细信息');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('50','编辑权限资源','7','sys_res_edit','2','/background/resources/getById.html','44','编辑权限资源');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('51','删除权限资源','7','sys_res_delete','2','/background/resources/deleteById.html','45','删除权限资源');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('52','物料管理','1010','device','0','device','50','物料管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('53','物料列表','52','device_manager','1','/background/device/list.html','51','物料列表');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('71','任务管理','1010','task','0','task','70','任务管理');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('72','部署任务','71','task_deploy','1','/background/workflow/deployHome.html','71','部署任务');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('73','待我审批','71','task_myself','1','/background/workflow/myTaskList.html','72','我的任务');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('74','填写申请','71','task_apply','1','/background/workflow/formTemplateList.html','73','填写申请任务');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('75','申请查询','71','task_manager','1','/background/workflow/myApplyList.html','74','归档任务');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('81','统计分析','1010','statistics','0','statistics','80','统计分析');
insert into `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) values('82','报表分析','81','statistics_manager','1','/background/noDevelop.html','81','设备列表');



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
insert into DepartmentInfo(DepartId, Name, DepartType, Discribe) values(1, '超级管理员', 0, '超级管理员');
insert into DepartmentInfo(DepartId, Name, DepartType, Discribe) values(3, '测试帐户', 0, '测试帐户');
insert into DepartmentInfo(Name, DepartType, Discribe) values('生产部', 1, '车间生产产品');
insert into DepartmentInfo(Name, DepartType, Discribe) values('库管', 0, '仓库管理');
insert into DepartmentInfo(Name, DepartType, Discribe) values('检验部', 0, '产品检验');
insert into DepartmentInfo(Name, DepartType, Discribe) values('采购部', 0, '物料采购');
insert into DepartmentInfo(Name, DepartType, Discribe) values('CCB审批', 0, '裁决问题');
insert into DepartmentInfo(Name, DepartType, Discribe) values('设计部', 0, '工艺设计');
insert into DepartmentInfo(Name, DepartType, Discribe) values('项目部', 0, '项目实施');


insert  into `resources_role`(`resc_id`,`role_id`) values (1,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (1,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (2,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (2,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (3,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (3,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (4,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (4,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (5,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (5,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (6,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (6,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (7,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (7,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (8,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (8,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (11,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (11,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (22,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (22,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (23,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (23,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (39,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (40,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (41,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (42,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (43,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (44,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (45,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (46,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (47,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (48,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (49,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (50,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (51,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (52,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (52,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (52,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (53,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (53,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (53,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (61,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (61,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (62,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (62,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (71,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (71,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (72,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (72,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (73,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (73,5);
INSERT INTO `resources_role` (`resc_id`,`role_id`) VALUES (74, 1);
insert  into `resources_role`(`resc_id`,`role_id`) values (74,5);
INSERT INTO `resources_role` (`resc_id`,`role_id`) VALUES (75, 1);
insert  into `resources_role`(`resc_id`,`role_id`) values (75,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (81,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (81,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (82,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (82,5);
insert  into `resources_role`(`resc_id`,`role_id`) values (1010,1);
insert  into `resources_role`(`resc_id`,`role_id`) values (1010,3);
insert  into `resources_role`(`resc_id`,`role_id`) values (1010,5);

insert  into `user_role`(`DepartId`,`role_id`) values (1,1);
insert  into `user_role`(`DepartId`,`role_id`) values (3,5);
insert  into `user_role`(`DepartId`,`role_id`) values (10,5);
insert  into `user_role`(`DepartId`,`role_id`) values (11,5);
insert  into `user_role`(`DepartId`,`role_id`) values (12,5);
insert  into `user_role`(`DepartId`,`role_id`) values (13,5);
insert  into `user_role`(`DepartId`,`role_id`) values (14,5);
insert  into `user_role`(`DepartId`,`role_id`) values (15,5);
insert  into `user_role`(`DepartId`,`role_id`) values (16,5);


#SELECT userId FROM user WHERE userName LIKE '生产%' 
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(1, 'admin', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产3号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产4号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产5号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产6号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产7号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产8号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产9号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(10, '生产10号', 'normal', 1);
#库管
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '库管1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(11, '库管2号', 'normal', 1);
#检验
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(12, '检验1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(12, '检验2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(12, '检验3号', 'normal', 1);
#采购
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(13, '采购1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(13, '采购2号', 'normal', 1);
#领导
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(14, '领导1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(14, '领导2号', 'normal', 1);
#设计
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(15, '设计1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(15, '设计2号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(15, '设计3号', 'normal', 1);
#项目
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(16, '项目经理1号', 'normal', 1);
insert into DepartmentMember(DepartId, userName,Position, resc_enable) values(16, '项目经理2号', 'normal', 1);

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

insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (1,'9.3','20','64.0','80','75.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>');
insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (2,'0.8','20','60.0','80','75.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>');
insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (3,'1.5','20','59.0','80','75.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>');
insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (4,'0.7','20','57.0','80','75.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>');
insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (5,'2.3','20','57.0','80','75.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：75.0%,超出预设值  60%</font>');
insert  into `serverinfo`(`id`,`cpuUsage`,`setCpuUsage`,`jvmUsage`,`setJvmUsage`,`ramUsage`,`setRamUsage`,`email`,`operTime`,`mark`) values (6,'17.9','20','57.0','80','77.0','80','1212614949@qq.com','2015-06-08 19:21:58','<font color=\'red\'>内存当前：77.0%,超出预设值  60%</font>');

