DROP TABLE IF EXISTS userloginlist;
CREATE TABLE IF NOT EXISTS userloginlist (
	loginId INTEGER NOT NULL AUTO_INCREMENT,
	userName VARCHAR ( 20 ) NOT NULL,
	loginTime TIMESTAMP NOT NULL,
	loginIP VARCHAR ( 40 ) NOT NULL,
	CONSTRAINT PK_userloginlist PRIMARY KEY (loginId)
	)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	
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
  `figureLibName` VARCHAR(64) NOT NULL,
  `figureID` VARCHAR(32) NOT NULL,
  `figureName` VARCHAR(32) NOT NULL,
  `figureRequest` VARCHAR(256) DEFAULT NULL,
  `type` INT(11) NOT NULL,
  `batchNum` INT(11) NOT NULL,
  `describe` VARCHAR(256) DEFAULT NULL,
  PRIMARY KEY (`pfid`)
) ENGINE=INNODB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS busproject;
CREATE TABLE `busproject` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(64) NOT NULL,
  `projectDescribe` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `busprojectproduct`;
CREATE TABLE `busprojectproduct` (
  ppid int(11) NOT NULL AUTO_INCREMENT,
  projectId  int(11) NOT NULL,
  productNo varchar(16) NOT NULL,
  productName varchar(32) DEFAULT NULL,
  status varchar(3) DEFAULT NULL,
  bak varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ppid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bustask`;
CREATE TABLE `bustask` (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `taskNo`  varchar(32) NOT NULL,
  `pid` int(11) NOT NULL,
  `ppid` int(11) NOT NULL,
  `totalSetNo` int(11) NOT NULL,
  `taskSource` varchar(32) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL,
  PRIMARY KEY PK_bustask(`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `bustaskFlow`;
CREATE TABLE `bustaskFlow` (
  `flowId` bigint NOT NULL,
  `taskId` int(11) NOT NULL ,
  `taskNo`  varchar(32) NOT NULL,
  `pid` int(11) NOT NULL,
  `ppid` int(11) NOT NULL,
  `totalSetNo` int(11) NOT NULL,
  `taskSource` varchar(32) DEFAULT NULL,
  `bak` varchar(128) DEFAULT NULL,
  PRIMARY KEY PK_bustaskFlow(`taskId`, `flowId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

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
	
DROP TABLE IF EXISTS role;	
CREATE TABLE IF NOT EXISTS role (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 50 ) NOT NULL,
	roleKey VARCHAR ( 50 ) NOT NULL,
	description VARCHAR ( 200 ) NOT NULL,
	enable INTEGER NOT NULL,
	CONSTRAINT PK_ROLE PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;	

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
	
DROP TABLE IF EXISTS user;	
CREATE TABLE `user` (
  `userName` varchar(20) NOT NULL,
  `userPassword` varchar(100) NOT NULL,
  `userRealname` varchar(20) DEFAULT NULL,
  `userBirthday` varchar(20) DEFAULT NULL,
  `userSex` varchar(10) DEFAULT NULL,
  `idCard` varchar(100) DEFAULT NULL,
  `userPhone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS user_role;	
CREATE TABLE IF NOT EXISTS user_role (
	DepartId INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT PK_USER_ROLE PRIMARY KEY (DepartId, role_id)
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
	
DROP TABLE IF EXISTS DepartmentInfo;	
CREATE TABLE IF NOT EXISTS DepartmentInfo (
	DepartId INTEGER NOT NULL AUTO_INCREMENT,
	dName VARCHAR ( 51 ) NOT NULL,
	DepartType INTEGER,
	Discribe VARCHAR ( 101 ),
	CONSTRAINT PK_DepartInfo PRIMARY KEY (DepartId)
	)ENGINE=InnoDB  AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS ProcessRule;	
CREATE TABLE IF NOT EXISTS ProcessRule (
	ProcessId VARCHAR ( 51 ) NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ParentPeriodId VARCHAR ( 51 ) NOT NULL,
	RuleId SMALLINT NOT NULL,
	context VARCHAR ( 201 ) NOT NULL,
	CONSTRAINT PK_ProcessRule PRIMARY KEY (ProcessId, PeriodId, ParentPeriodId, RuleId)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
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
	
DROP TABLE IF EXISTS DepartmentMember;	
CREATE TABLE IF NOT EXISTS DepartmentMember (
	DepartId INTEGER NOT NULL,
	userName VARCHAR ( 20 ) NOT NULL,
	Position VARCHAR ( 21 ),
	resc_enable SMALLINT,
	discribe VARCHAR ( 51 ),
	CONSTRAINT PK_DepartmentMember PRIMARY KEY (userName, DepartId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
DROP TABLE IF EXISTS resources_role;	
CREATE TABLE IF NOT EXISTS resources_role (
	resc_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT PK_RESOURE_ROLE PRIMARY KEY (resc_id, role_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
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
	CONSTRAINT PK_omOutStorage PRIMARY KEY (devid)
	)ENGINE=INNODB  DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS omOutStorage;
CREATE TABLE omOutStorage (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
	`pid` INT(11) NOT NULL,
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
	)ENGINE=INNODB DEFAULT CHARSET=utf8;
	
	
DROP TABLE IF EXISTS omOutStorageFlow;
CREATE TABLE omOutStorageFlow (
        `flowId` bigint(20) NOT NULL,
	`pid` INT(11) NOT NULL,
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
	`reserverd2` INT(11) NOT NULL
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
	verifyCycleUnit SMALLINT,
	validDate TIMESTAMP,
	equipmentPosition VARCHAR ( 51 ),
	calibrationVerify VARCHAR ( 100 ),
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

ALTER TABLE TaskProcessRelationship ADD CONSTRAINT FK_TaskProcessRelationship FOREIGN KEY (TaskId) REFERENCES TaskContractManagement (project_id)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE TaskProcessRelationship ADD CONSTRAINT FK_TaskProcessRelationship1 FOREIGN KEY (ProcessId) REFERENCES ProcessManagement (ProcessId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_role ADD CONSTRAINT FK_user_role02 FOREIGN KEY (DepartId) REFERENCES DepartmentInfo (DepartId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_role ADD CONSTRAINT FK_USER_KEY FOREIGN KEY (role_id) REFERENCES role (id)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionManagement ADD CONSTRAINT FK_ProductionManagement FOREIGN KEY (ProcessIndex, TaskIndex) REFERENCES TaskProcessRelationship (ProcessId, TaskId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE PersonLimitInfo ADD CONSTRAINT FK_MemberLimitInfo FOREIGN KEY (UserNumber) REFERENCES Member_info (UserNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProcessRule ADD CONSTRAINT FK_ProcessRule FOREIGN KEY (ProcessId, PeriodId, ParentPeriodId) REFERENCES TechnologicalProcess (TechnologicalIndex, ProcessIndex, ParentProcesIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionProcessInfo ADD CONSTRAINT FK_ProductionProcessInfo FOREIGN KEY (ProcessIndex, TaskId) REFERENCES ProductionManagement (ProcessIndex, TaskIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE flowProejctInfo ADD CONSTRAINT FK_flowProejctInfo FOREIGN KEY (projectName, taskName) REFERENCES ProjectInfo (ProjectName, TaskNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageFlowResult ADD CONSTRAINT FK_StorageFlowResult FOREIGN KEY (projectName, taskName, flowId) REFERENCES flowProejctInfo (projectName, taskName, flowId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE DepartmentMember ADD CONSTRAINT FK_DepartmentMember FOREIGN KEY (DepartId) REFERENCES DepartmentInfo (DepartId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE DepartmentMember ADD CONSTRAINT FK_DepartmentMember02 FOREIGN KEY (userName) REFERENCES user (userName)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionProcessInspection ADD CONSTRAINT FK_ProductionProcessInspection FOREIGN KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID) REFERENCES ProductionProcessInfo (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE TechnologicalProcess ADD CONSTRAINT FK_TechnologicalProcess FOREIGN KEY (TechnologicalIndex) REFERENCES ProcessManagement (ProcessId)  ON DELETE NO ACTION ON UPDATE NO ACTION;

