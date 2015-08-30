DROP TABLE IF EXISTS resources;	
CREATE TABLE IF NOT EXISTS resources (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 50 ) NOT NULL,
	parentId INTEGER NOT NULL,
	resKey VARCHAR ( 50 ) NOT NULL,
	type VARCHAR ( 10 ) NOT NULL,
	resUrl VARCHAR ( 200 ) NOT NULL,
	level INTEGER NOT NULL,
	description VARCHAR ( 200 ) NOT NULL,
	CONSTRAINT PK_RESOURCES PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
		
DROP TABLE IF EXISTS role;	
CREATE TABLE IF NOT EXISTS role (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 50 ) NOT NULL,
	roleKey VARCHAR ( 50 ) NOT NULL,
	description VARCHAR ( 200 ) NOT NULL,
	enable INTEGER NOT NULL,
	CONSTRAINT PK_ROLE PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS user;	
CREATE TABLE user (
  userId int(11) NOT NULL AUTO_INCREMENT,
  userName varchar(30) NOT NULL,
  userPassword varchar(100) NOT NULL,
  userRealname varchar(20) DEFAULT NULL,
  userBirthday varchar(20) DEFAULT NULL,
  userSex varchar(10) DEFAULT NULL,
  idCard varchar(100) DEFAULT NULL,
  userPhone varchar(30) DEFAULT NULL,
  PRIMARY KEY (userId)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS user_role;	
CREATE TABLE user_role (
  user_id bigint(20) NOT NULL DEFAULT '0',
  role_id bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (user_id,role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS resources_role;	
CREATE TABLE IF NOT EXISTS resources_role (
	resc_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT PK_RESOURE_ROLE PRIMARY KEY (resc_id, role_id)
	)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS DepartmentMember;	
CREATE TABLE IF NOT EXISTS DepartmentMember (
	DepartId INTEGER NOT NULL,
	userName VARCHAR ( 20 ) NOT NULL,
	Position VARCHAR ( 21 ),
	resc_enable SMALLINT,
	discribe VARCHAR ( 51 ),
	CONSTRAINT PK_DepartmentMember PRIMARY KEY (userName, DepartId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS DepartmentInfo;	
CREATE TABLE IF NOT EXISTS DepartmentInfo (
	DepartId INTEGER NOT NULL AUTO_INCREMENT,
	dName VARCHAR ( 51 ) NOT NULL,
	DepartType INTEGER,
	Membership VARCHAR ( 51 ) NOT NULL, 
	Discribe VARCHAR ( 101 ),
	CONSTRAINT PK_DepartInfo PRIMARY KEY (DepartId)
	)ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS department_user;
CREATE TABLE IF NOT EXISTS department_user (
    department_id bigint(20) NOT NULL DEFAULT '0',
    user_id bigint(20) NOT NULL DEFAULT '0',
    PRIMARY KEY (department_id, user_id)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS userloginlist;
CREATE TABLE userloginlist (
    loginId int(11) NOT NULL AUTO_INCREMENT,
    userId int(11) DEFAULT NULL,
    loginTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    loginIP varchar(40) DEFAULT NULL,
    PRIMARY KEY (loginId),
    KEY FK_userloginlist (userId)
) ENGINE=InnoDB AUTO_INCREMENT=451 DEFAULT CHARSET=utf8;

	
DROP TABLE IF EXISTS busleave;
CREATE TABLE IF NOT EXISTS `busleave` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `days` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `leaveDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busprojectfigure;	
CREATE TABLE `busprojectfigure` (
  `pfid` INT(11) NOT NULL AUTO_INCREMENT,
  `ppid` INT(11) DEFAULT NULL,
  `figureLib` VARCHAR(32) NOT NULL,
  `figureNo` VARCHAR(32) NOT NULL,
  `figureName` VARCHAR(32) NOT NULL,
  `figureRequest` VARCHAR(256) DEFAULT NULL,
  `type` INT(11) NOT NULL,
  `batchNum` INT(11) NOT NULL,
  `describe` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`pfid`)
) ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busprojectfigureproductflow;	
CREATE TABLE `busprojectfigureproductflow` (
  `flowId` bigint NOT NULL,
   ppid int(11),
  `figureLib` VARCHAR(32) NOT NULL,
   bak varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busprojectfigureflow;	
CREATE TABLE `busprojectfigureflow` (
  `flowId` bigint NOT NULL,
  `figureNo` VARCHAR(32) NOT NULL,
  `figureName` VARCHAR(32) NOT NULL,
  `figureRequest` VARCHAR(256) DEFAULT NULL,	
  `type` INT(11),
  `batchNum` INT(11) NOT NULL,
  `describe` VARCHAR(256) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busproject;
CREATE TABLE `busproject` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(64) NOT NULL,
  `projectDescribe` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busprojectflow;
CREATE TABLE `busprojectflow` (
  `flowId` bigint NOT NULL,
  `projectName` varchar(64) NOT NULL,
  `projectDescribe` varchar(128) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `busprojectproduct`;
CREATE TABLE `busprojectproduct` (
  `ppid` int(11) NOT NULL AUTO_INCREMENT,
  `projectId`  int(11) NOT NULL,
  `productNo` varchar(16) NOT NULL,
  `productName` varchar(32) DEFAULT NULL,
  `status` varchar(3) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ppid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `busprojectproductflow`;
CREATE TABLE `busprojectproductflow` (
  `flowId` bigint NOT NULL,
  `productNo` varchar(16) NOT NULL,
  `productName` varchar(32) DEFAULT NULL,
  `status` varchar(3) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `busprojectproductprojectflow`;
CREATE TABLE `busprojectproductprojectflow` (
  `flowId` bigint NOT NULL,
  `projectId`  int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bustask`;
CREATE TABLE `bustask` (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `taskNo`  varchar(32) NOT NULL,
  `ppid` int(11) NOT NULL,
  `figureLib` varchar(32) NOT NULL,
  `artId` int(11) NOT NULL,
  `totalSetNum` int(11) NOT NULL,
  `taskSource` varchar(32) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL,
  PRIMARY KEY PK_bustask(`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bustaskFlow`;
CREATE TABLE `bustaskFlow` (
  `flowId` bigint NOT NULL,
  `taskNo`  varchar(32) NOT NULL,
  `totalSetNum` int(11) NOT NULL,
  `taskSource` varchar(32) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bustaskProductFlow`;
CREATE TABLE `bustaskProductFlow` (
  `flowId` bigint NOT NULL,
  `ppid` int(11) NOT NULL,
  `figureLib` varchar(32) NOT NULL,
  `artId` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS Member_info;
CREATE TABLE IF NOT EXISTS Member_info (
	UserNumber VARCHAR ( 30 ) NOT NULL,
	Name VARCHAR ( 15 ) NOT NULL,
	Sex SMALLINT NOT NULL,
	Nation SMALLINT NOT NULL,
	Origin VARCHAR ( 21 ),
	Marry SMALLINT NOT NULL,
	Phone VARCHAR ( 21 ),
	Address VARCHAR ( 101 ),
	Email VARCHAR ( 51 ),
	Birthday DATE NOT NULL,
	GraSchool VARCHAR ( 51 ),
	Professional VARCHAR ( 51 ),
	Height INTEGER NOT NULL,
	Identity VARCHAR ( 21 ),
	Hobby VARCHAR ( 101 ),
	IdNumber VARCHAR ( 31 ) NOT NULL,
	GraDate DATE,
	CONSTRAINT PK_MemberBaseInfo PRIMARY KEY (UserNumber)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;	

DROP TABLE IF EXISTS ProductionManagement;
CREATE TABLE IF NOT EXISTS ProductionManagement (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 31 ) NOT NULL,
	CONSTRAINT PK_ProductionManagement PRIMARY KEY (ProcessIndex, TaskIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS flowProejctInfo;	
CREATE TABLE IF NOT EXISTS flowProejctInfo (
	flowId bigint(20) NOT NULL,
	projectName VARCHAR ( 51 ) NOT NULL,
	taskName VARCHAR ( 21 ) NOT NULL,
	CONSTRAINT PK_flowProejctInfo PRIMARY KEY (projectName, taskName, flowId)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS StorageFlowResult;	
CREATE TABLE IF NOT EXISTS StorageFlowResult (
	flowId bigint(20) NOT NULL,
	MaterialNumber INTEGER NOT NULL,
	projectName VARCHAR ( 51 ) NOT NULL,
	taskName VARCHAR ( 21 ) NOT NULL,
	IdNumber VARCHAR ( 11 ),
	SubType SMALLINT,
	Name VARCHAR ( 51 ),
	codeName VARCHAR ( 31 ),
	AssistantCode VARCHAR ( 11 ),
	Material VARCHAR ( 21 ),
	Shape VARCHAR ( 21 ),
	MaterialType SMALLINT,
	ProType VARCHAR ( 21 ),
	TotalNumber INTEGER,
	MsmUnit VARCHAR ( 11 ),
	MsmUnit2 VARCHAR ( 11 ),
	SavePeriod INTEGER,
	SavePeriodUnit SMALLINT,
	Trusteeship SMALLINT,
	WIP_Sign SMALLINT,
	BeforeFailure INTEGER DEFAULT 0,
	SavePos VARCHAR ( 31 ),
	nSize VARCHAR ( 21 ),
	InspectionMode SMALLINT,
	ProductSource VARCHAR ( 50 ),
	TransferPerson VARCHAR ( 31 ),
	TransferTime TIMESTAMP,
	TestRequirements VARCHAR ( 150 ),
	testNumber INTEGER,
	validNumber INTEGER,
	TestResult VARCHAR ( 150 ),
	TestPerson VARCHAR ( 31 ),
	TestTime TIMESTAMP,
	testLevel VARCHAR ( 31 ),
	TrialOrganization VARCHAR ( 31 ),
	trialNumber  SMALLINT,
	TrialResults VARCHAR ( 150 ),
	TrialPersonnel VARCHAR ( 150 ),
	callPerson VARCHAR ( 31 ),
	TrialTime TIMESTAMP,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_StorageFlowResult1 PRIMARY KEY (projectName, taskName, flowId, MaterialNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS ProductionProcessInfo;		
CREATE TABLE IF NOT EXISTS ProductionProcessInfo (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskId VARCHAR ( 31 ) NOT NULL,
	ParentId VARCHAR ( 51 ) DEFAULT 0 NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ProductionProcessID INTEGER DEFAULT 1 NOT NULL,
	CONSTRAINT PK_ProductionProcessInfo PRIMARY KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS FlowRecordInfo;	
CREATE TABLE IF NOT EXISTS FlowRecordInfo (
	flowId bigint(20) NOT NULL  AUTO_INCREMENT,
	proc_def_id VARCHAR ( 50 ),
	execution_ID VARCHAR ( 31 ),
	info VARCHAR ( 100 ),
	className VARCHAR ( 31 ),
	state SMALLINT NOT NULL,
	HandlePerson VARCHAR ( 21 ),
	CopyPersons VARCHAR ( 200 ),
	createTime TIMESTAMP,
	createPerson VARCHAR ( 21 ),
	closeTime TIMESTAMP,
	closePerson VARCHAR ( 21 ),
	bak VARCHAR ( 50 ),
	CONSTRAINT PK_StorageApply PRIMARY KEY (flowId)
	)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS TechnologicalProcess;			
CREATE TABLE IF NOT EXISTS TechnologicalProcess (
	TechnologicalIndex VARCHAR ( 51 ) NOT NULL,
	ParentProcesIndex VARCHAR ( 51 ) NOT NULL,
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_TechnologicalProcess PRIMARY KEY (TechnologicalIndex, ProcessIndex, ParentProcesIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS TaskContractManagement;	
CREATE TABLE IF NOT EXISTS TaskContractManagement (
	project_id VARCHAR ( 31 ) NOT NULL,
	CONSTRAINT PK_TaskContractManagement PRIMARY KEY (project_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	
DROP TABLE IF EXISTS log;	
CREATE TABLE IF NOT EXISTS log (
	id INTEGER NOT NULL AUTO_INCREMENT,
	username VARCHAR ( 30 ) NOT NULL,
	module VARCHAR ( 30 ) NOT NULL,
	action VARCHAR ( 30 ) NOT NULL,
	actionTime VARCHAR ( 30 ) NOT NULL,
	userIP VARCHAR ( 30 ) NOT NULL,
	operTime TIMESTAMP NOT NULL,
	CONSTRAINT PK_LOG PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS ProductionProcessInspection;	
CREATE TABLE IF NOT EXISTS ProductionProcessInspection (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskId VARCHAR ( 31 ) NOT NULL,
	ParentId VARCHAR ( 51 ) NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ProductionProcessID INTEGER NOT NULL,
	CONSTRAINT PK_ProductionProcessInspection PRIMARY KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS TaskProcessRelationship;	
CREATE TABLE IF NOT EXISTS TaskProcessRelationship (
	TaskId VARCHAR ( 31 ) NOT NULL,
	ProcessId VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_TaskProcessRelationship PRIMARY KEY (ProcessId, TaskId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS PersonLimitInfo;	
CREATE TABLE IF NOT EXISTS PersonLimitInfo (
	UserNumber VARCHAR ( 30 ) NOT NULL,
	password VARCHAR ( 101 ) NOT NULL,
	Cipher INTEGER NOT NULL,
	LimitLevel INTEGER NOT NULL,
	LockState SMALLINT DEFAULT 0 NOT NULL,
	DueDate DATE NOT NULL,
	CONSTRAINT PK_MemberLimitInfo PRIMARY KEY (UserNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS ProjectInfo;	
CREATE TABLE IF NOT EXISTS ProjectInfo (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskNumber VARCHAR ( 21 ) NOT NULL,
	startTime TIMESTAMP,
	endTime TIMESTAMP,
	Info VARCHAR ( 100 ),
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_ProjectInfo PRIMARY KEY (ProjectName, TaskNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS ProcessRule;	
CREATE TABLE IF NOT EXISTS ProcessRule (
	ProcessId VARCHAR ( 51 ) NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ParentPeriodId VARCHAR ( 51 ) NOT NULL,
	RuleId SMALLINT NOT NULL,
	context VARCHAR ( 201 ) NOT NULL,
	CONSTRAINT PK_ProcessRule PRIMARY KEY (ProcessId, PeriodId, ParentPeriodId, RuleId)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS omInStorageAssistance;	
CREATE TABLE IF NOT EXISTS omInStorageAssistance (
	id INTEGER NOT NULL AUTO_INCREMENT,
	taskid INTEGER NOT NULL,
	batchno INT(11),
	graphicPath VARCHAR(128) NOT NULL,
	reserved INT(11),
	CONSTRAINT omInStorageAssistance PRIMARY KEY (id)
	)ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS omInStorage;	
CREATE TABLE IF NOT EXISTS omInStorage (
	id INTEGER NOT NULL AUTO_INCREMENT,
	isaId INTEGER NOT NULL,
	taskId INT(11) NOT NULL,
	pfid INT(11) NOT NULL,
	devNo INT(11),
	devBatchNo VARCHAR(21),
	totalNumber INTEGER DEFAULT 1 NOT NULL,
	vendorNo VARCHAR(64) DEFAULT NULL,
	checkRst VARCHAR(256) DEFAULT NULL,
	checkNum INT(11),
	qualifiedNum INT(11),
	unqualifiedNum INT(11),
	unqualifiedGrade INT(11),
	unqualifiedReason VARCHAR(128),
	reviewRst INT(11),
	reviewGrp INT(11),
	reviewNo VARCHAR(32),
	graphicPath VARCHAR(128),	
	bak VARCHAR(100),
	CONSTRAINT omInStorage PRIMARY KEY (id)
	)ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS omInStorageFlow;	
CREATE TABLE IF NOT EXISTS omInStorageFlow (
    flowId bigint NOT NULL,
	pfid INT(11) NOT NULL,
	devNo INT(11),
	devBatchNo VARCHAR(21),
	totalNumber INTEGER DEFAULT 1 NOT NULL,
	vendorNo VARCHAR(64) DEFAULT NULL,
	checkRst VARCHAR(256) DEFAULT NULL,
	checkNum INT(11),
	qualifiedNum INT(11),
	unqualifiedNum INT(11),
	unqualifiedGrade INT(11),
	unqualifiedReason VARCHAR(128),
	reviewRst INT(11),
	reviewGrp INT(11),
	reviewNo VARCHAR(32),
	graphicPath VARCHAR(128),	
	bak VARCHAR(100)
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
	

DROP TABLE IF EXISTS omInStorageTaskFlow;	
CREATE TABLE IF NOT EXISTS omInStorageTaskFlow (
    `flowId`  bigint NOT NULL,
	`isaId`  INTEGER NOT NULL,
	`projectid` INT(11) NOT NULL,
	`taskId`   INT(11) NOT NULL,
	`devtypeid`  INT(11) NOT NULL,
	 bak VARCHAR(100)
	)ENGINE=INNODB DEFAULT CHARSET=utf8;	

	
DROP TABLE IF EXISTS BasicMaterialInfo;	
CREATE TABLE IF NOT EXISTS BasicMaterialInfo (
	projectName VARCHAR ( 51 ),
	taskName VARCHAR ( 21 ),
	IdNumber VARCHAR ( 11 ) NOT NULL,
	subType SMALLINT DEFAULT 0 NOT NULL,
	name VARCHAR ( 51 ) NOT NULL,
	codeName VARCHAR ( 31 ),
	AssistantCode VARCHAR ( 11 ),
	Material VARCHAR ( 21 ),
	Shape VARCHAR ( 21 ),
	ObjType VARCHAR ( 21 ),
	ProType VARCHAR ( 21 ),
	TotalNumber INTEGER DEFAULT 1 NOT NULL,
	MsmUnit VARCHAR ( 11 ),
	MsmUnit2 VARCHAR ( 11 ),
	SavePeriod INTEGER,
	SavePeriodUnit INTEGER NOT NULL,
	Trusteeship INTEGER NOT NULL,
	WIP_Sign INTEGER NOT NULL,
	BeforeFailure INTEGER,
	SavePos VARCHAR ( 31 ),
	Size VARCHAR ( 21 ),
	InspectionMode SMALLINT,
	ProductSource VARCHAR ( 50 ),
	PurchasingPerson VARCHAR ( 31 ),
	TransferTime TIMESTAMP NOT NULL,
	TestRequirements VARCHAR ( 150 ),
	testNumber INTEGER,
	ValidNumber INTEGER,
	TestResult VARCHAR ( 150 ),
	TestPerson VARCHAR ( 31 ),
	TestTime TIMESTAMP,
	testLevel VARCHAR ( 31 ),
	TrialOrganization VARCHAR ( 31 ),
	TrialResults VARCHAR ( 150 ),
	TrialPersonnel VARCHAR ( 150 ),
	callPerson VARCHAR ( 31 ),
	TrialTime TIMESTAMP,
	SavePerson VARCHAR ( 21 ) NOT NULL,
	StorageTime DATE,
	bak VARCHAR ( 100 )
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS ProcessManagement;	
CREATE TABLE IF NOT EXISTS ProcessManagement (
	ProcessId VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_ProcessManagement PRIMARY KEY (ProcessId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS device;	
create table IF NOT EXISTS `device` (
	`id` int (11),
	`deviceName` varchar (120),
	`deviceVersion` varchar (60),
	`deviceType` varchar (60),
	`deviceCount` int (11),
	`ischeckout` int (11),
	`manufacturers` varchar (300),
	`manufacturersPhone` varchar (90),
	`productDate` timestamp ,
	`outDate` timestamp ,
	`deviceStatus` varchar (60),
	`remark` varchar (600)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS devicetype;
CREATE TABLE devicetype (
	`devid` INT(11) NOT NULL,
	`devName` VARCHAR(16) NOT NULL,
	`devNick` VARCHAR(16) NOT NULL,
	`reserverd1` INT(11) NOT NULL,
	`reserverd2` INT(11) NOT NULL,
	CONSTRAINT PK_devicetype PRIMARY KEY (devid)
	)ENGINE=INNODB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS omOutStorage;
CREATE TABLE omOutStorage (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
	`taskId` INT(11) NOT NULL,
	`componentType` INT(11) NOT NULL,
	`setNum` INT(11) DEFAULT NULL,
	`fetchType` INT(11) NOT NULL,
	`figureId` VARCHAR(32)	NOT NULL,
	`figureName` VARCHAR(32) NOT NULL,
	`figureRequest` VARCHAR(256) DEFAULT NULL,
	`batchNum` INT(11) NOT NULL,
	`mustNum` INT(11) NOT NULL,
	`stockNum` INT(11) NOT NULL,
	`factNum` INT(11) NOT NULL,
	`reserverd1` INT(11) NOT NULL,
	`reserverd2` INT(11) NOT NULL,
	CONSTRAINT PK_omOutStorage PRIMARY KEY (`id`)
	)ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
	
	
DROP TABLE IF EXISTS omOutStorageFlow;
CREATE TABLE omOutStorageFlow (
    `flowId` bigint(20) NOT NULL,
	`componentType` INT(11) NOT NULL,
	`setNum` INT(11) DEFAULT NULL,
	`fetchType` INT(11) NOT NULL,
	`figureId` VARCHAR(32)	NOT NULL,
	`figureName` VARCHAR(32) NOT NULL,
	`figureRequest` VARCHAR(256) DEFAULT NULL,
	`batchNum` INT(11) NOT NULL,
	`mustNum` INT(11) NOT NULL,
	`stockNum` INT(11) NOT NULL,
	`factNum` INT(11) NOT NULL,
	`reserverd1` INT(11) NOT NULL,
	`reserverd2` INT(11) NOT NULL
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS omOutStorageTastFlow;
CREATE TABLE omOutStorageTastFlow (
    `flowId` bigint(20) NOT NULL,
	`taskId` INT(11) NOT NULL,
	`componentType` INT(11) NOT NULL,
	`setNum` INT(11) DEFAULT NULL,
	`fetchType` INT(11) NOT NULL
	)ENGINE=INNODB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS omDiscardStorage;
CREATE TABLE omDiscardStorage (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
	`taskId` INT(11) NOT NULL,
	`devType` INT(11) NOT NULL,
	`discardType` INT(11) NOT NULL,
	`figureName` VARCHAR(32) NOT NULL,
	`devNo`  VARCHAR(32) NOT NULL,
	`figureId` VARCHAR(32)	NOT NULL,
	`num` INT(11) NOT NULL,
	`discardReason`  VARCHAR(256) DEFAULT NULL,
	`questionType` INT(11) NOT NULL,
	`checkRst`  INT(11) NOT NULL,
	`reviewRst`  INT(11) NOT NULL,
	`reviewNo`  VARCHAR(32) NOT NULL,
	`reviewPicture`  VARCHAR(256) NOT NULL,
	CONSTRAINT PK_omOutStorage PRIMARY KEY (`id`)
	)ENGINE=INNODB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS omDiscardStorageTaskFlow;
CREATE TABLE omDiscardStorageTaskFlow (
    `flowid` bigint(20) NOT NULL,
	`taskId` INT(11) NOT NULL,
	`devType` INT(11) NOT NULL,
	`discardType` INT(11) NOT NULL
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
		
DROP TABLE IF EXISTS omDiscardStorageFlow;
CREATE TABLE omDiscardStorageFlow (
    `flowid` bigint(20) NOT NULL,
	`figureName` VARCHAR(32) NOT NULL,
	`devNo` VARCHAR(32) NOT NULL,
	`figureId` VARCHAR(32)	NOT NULL,
	`num` INT(11) NOT NULL,
	`discardReason` VARCHAR(256) DEFAULT NULL,
	`questionType` INT(11) NOT NULL,
	`checkRst` INT(11) NULL,
	`reviewRst` INT(11) NULL,
	`reviewNo` VARCHAR(32) NULL,
    `reviewPicture` VARCHAR(256) NULL
	)ENGINE=INNODB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS instrumentDevice;
CREATE TABLE instrumentDevice (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 51 ),
	specifications VARCHAR ( 31 ),
	instrumentNumber VARCHAR ( 31 ),
	assetNumber VARCHAR ( 31 ),
	usePerson VARCHAR ( 31 ),
	manufacturer VARCHAR ( 51 ),
	instrumentType VARCHAR ( 11 ),
	status VARCHAR ( 21 ),
	measurementInfo VARCHAR ( 11 ),
	price VARCHAR ( 21 ),
	enableDate TIMESTAMP,
	tagNumber VARCHAR ( 31 ),
	verifyCycle INTEGER,
	validDate TIMESTAMP,
	equipmentPosition VARCHAR ( 51 ),
	calibrationVerify VARCHAR ( 31 ),
	hintVerifyDays INTEGER,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_instrumentDevice PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS fixedAsset;
CREATE TABLE fixedAsset (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 51 ),
	tagNumber VARCHAR ( 31 ),
	specifications VARCHAR ( 31 ),
	serialNumber VARCHAR ( 31 ),
	status VARCHAR ( 21 ),
	price VARCHAR ( 31 ),
	enableDate TIMESTAMP,
	responsiblePerson VARCHAR ( 31 ),
	usePerson VARCHAR ( 31 ),
	equipmentPosition VARCHAR ( 51 ),
	assetClass VARCHAR ( 51 ),
	vendorInfo VARCHAR ( 51 ),
	remark VARCHAR ( 100 ),
	CONSTRAINT PK_fixedAsset PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8;
	
	
DROP TABLE IF EXISTS busStorageAssistance;
CREATE TABLE busStorageAssistance (
    `id` SMALLINT NOT NULL,
	`type` SMALLINT NOT NULL, 
    `name` VARCHAR(64) NOT NULL,
    `describe` VARCHAR(64) NOT NULL
	)ENGINE=INNODB DEFAULT CHARSET=utf8;

	
	
