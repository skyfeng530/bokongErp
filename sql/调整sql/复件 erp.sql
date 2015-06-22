CREATE TABLE userloginlist (
	loginId INTEGER NOT NULL AUTO_INCREMENT,
	userId INTEGER NOT NULL,
	loginTime TIMESTAMP NOT NULL,
	loginIP VARCHAR ( 40 ) NOT NULL,
	CONSTRAINT PK_userloginlist PRIMARY KEY (loginId)
	)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	
CREATE TABLE StorageflowInvalidInfo4 (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 21 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	FlowNumber VARCHAR ( 25 ) NOT NULL,
	nIndex INTEGER NOT NULL,
	MaterialNumber INTEGER NOT NULL,
	TrialOrganization SMALLINT NOT NULL,
	Results VARCHAR ( 50 ),
	TrialPersonnel VARCHAR ( 100 ) NOT NULL,
	HandlePerson VARCHAR ( 31 ) NOT NULL,
	TrialTime TIMESTAMP NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_StorageflowInvalidInfo4 PRIMARY KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE serverinfo (
	id INTEGER NOT NULL AUTO_INCREMENT,
	cpuUsage VARCHAR ( 255 ) NOT NULL,
	setCpuUsage VARCHAR ( 255 ) NOT NULL,
	jvmUsage VARCHAR ( 255 ) NOT NULL,
	setJvmUsage VARCHAR ( 255 ) NOT NULL,
	ramUsage VARCHAR ( 255 ) NOT NULL,
	setRamUsage VARCHAR ( 255 ) NOT NULL,
	email VARCHAR ( 255 ) DEFAULT NULL,
	operTime TIMESTAMP,
	mark VARCHAR ( 255 ) DEFAULT NULL,
	CONSTRAINT PK_SERVER_STATE PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
	
CREATE TABLE Member_info (
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
	
CREATE TABLE role (
	id INTEGER NOT NULL AUTO_INCREMENT,
	name VARCHAR ( 50 ) NOT NULL,
	roleKey VARCHAR ( 50 ) NOT NULL,
	description VARCHAR ( 200 ) NOT NULL,
	enable INTEGER NOT NULL,
	CONSTRAINT PK_ROLE PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;	
	
CREATE TABLE ProductionManagement (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 31 ) NOT NULL,
	CONSTRAINT PK_ProductionManagement PRIMARY KEY (ProcessIndex, TaskIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE FlowRecordInfo (
	FlowNumber VARCHAR ( 25 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	nIndex INTEGER NOT NULL,
	StepNumber SMALLINT NOT NULL,
	HandlePerson VARCHAR ( 21 ) NOT NULL,
	NextHandle VARCHAR ( 21 ),
	NextCopys VARCHAR ( 100 ),
	HandleTime TIMESTAMP NOT NULL,
	NextStepNum SMALLINT,
	ResultId SMALLINT NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_FlowRecordInfo PRIMARY KEY (FlowType, FlowNumber, nIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE StorageFlowResult1 (
	FlowNumber VARCHAR ( 25 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	nIndex INTEGER NOT NULL,
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskNumber VARCHAR ( 21 ) NOT NULL,
	MaterialNumber INTEGER NOT NULL,
	IdNumber VARCHAR ( 11 ) NOT NULL,
	SubType SMALLINT NOT NULL,
	Name VARCHAR ( 51 ) NOT NULL,
	AssistantCode VARCHAR ( 11 ),
	Material VARCHAR ( 21 ),
	Shape VARCHAR ( 21 ),
	MaterialType SMALLINT NOT NULL,
	ProType VARCHAR ( 21 ),
	TotalNumber INTEGER NOT NULL,
	MsmUnit VARCHAR ( 11 ),
	MsmUnit2 VARCHAR ( 11 ),
	SavePeriod INTEGER,
	SavePeriodUnit SMALLINT NOT NULL,
	Trusteeship SMALLINT NOT NULL,
	WIP_Sign SMALLINT NOT NULL,
	BeforeFailure INTEGER DEFAULT 0,
	SavePos VARCHAR ( 31 ),
	nSize VARCHAR ( 21 ),
	ScrapMark SMALLINT NOT NULL,
	InspectionMode SMALLINT NOT NULL,
	ProductSource VARCHAR ( 50 ),
	TransferPerson VARCHAR ( 31 ) NOT NULL,
	TransferTime TIMESTAMP NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_StorageFlowResult1 PRIMARY KEY (ProjectName, TaskNumber, FlowType, FlowNumber, nIndex, MaterialNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE FlowTypeInfo (
	nIndex INTEGER NOT NULL AUTO_INCREMENT,
	Name VARCHAR ( 100 ) NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_FlowTypeInfo PRIMARY KEY (nIndex)
	)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
	
CREATE TABLE resources (
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
	
CREATE TABLE ProductionProcessInfo (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskId VARCHAR ( 31 ) NOT NULL,
	ParentId VARCHAR ( 51 ) DEFAULT 0 NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ProductionProcessID INTEGER DEFAULT 1 NOT NULL,
	CONSTRAINT PK_ProductionProcessInfo PRIMARY KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE ElectronFlowInfo (
	Number VARCHAR ( 25 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	Name VARCHAR ( 100 ) NOT NULL,
	nIndex SMALLINT DEFAULT 0 NOT NULL,
	StepNumber SMALLINT NOT NULL,
	Handles VARCHAR ( 21 ) NOT NULL,
	State SMALLINT NOT NULL,
	CreatePerson VARCHAR ( 21 ) NOT NULL,
	CreateTime TIMESTAMP NOT NULL,
	ClosePerson VARCHAR ( 21 ),
	CloseTime TIMESTAMP,
	bak VARCHAR ( 51 ),
	CONSTRAINT PK_elcFlow PRIMARY KEY (FlowType, Number)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE FlowTemplateInfo (
	FlowType INTEGER NOT NULL,
	nStepIndex SMALLINT NOT NULL,
	Url VARCHAR ( 100 ) NOT NULL,
	Name VARCHAR ( 51 ) NOT NULL,
	StepList VARCHAR ( 200 ) NOT NULL,
	DepartIdList VARCHAR ( 100 ) NOT NULL,
	CONSTRAINT PK_FLOWTEMPLATE PRIMARY KEY (FlowType, nStepIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE StorageFlowResult3 (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 21 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	FlowNumber VARCHAR ( 25 ) NOT NULL,
	nIndex INTEGER NOT NULL,
	MaterialNumber INTEGER NOT NULL,
	SaveTime TIMESTAMP NOT NULL,
	SavePerson VARCHAR ( 31 ) NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_StorageFlowResult3 PRIMARY KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE TechnologicalProcess (
	TechnologicalIndex VARCHAR ( 51 ) NOT NULL,
	ParentProcesIndex VARCHAR ( 51 ) NOT NULL,
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_TechnologicalProcess PRIMARY KEY (TechnologicalIndex, ProcessIndex, ParentProcesIndex)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE TaskContractManagement (
	project_id VARCHAR ( 31 ) NOT NULL,
	CONSTRAINT PK_TaskContractManagement PRIMARY KEY (project_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE InspectionInfo (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 21 ) NOT NULL,
	IdNumber VARCHAR ( 11 ) NOT NULL,
	SubType SMALLINT NOT NULL,
	InspectionTime TIMESTAMP NOT NULL,
	Rules VARCHAR ( 150 ) NOT NULL,
	TotalNumber INTEGER NOT NULL,
	ValidNumber INTEGER,
	Results VARCHAR ( 160 ) NOT NULL,
	Person VARCHAR ( 21 ) NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_InspectionInfo PRIMARY KEY (ProjectName, TaskIndex, IdNumber, SubType, InspectionTime)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE log (
	id INTEGER NOT NULL AUTO_INCREMENT,
	username VARCHAR ( 30 ) NOT NULL,
	module VARCHAR ( 30 ) NOT NULL,
	action VARCHAR ( 30 ) NOT NULL,
	actionTime VARCHAR ( 30 ) NOT NULL,
	userIP VARCHAR ( 30 ) NOT NULL,
	operTime TIMESTAMP NOT NULL,
	CONSTRAINT PK_LOG PRIMARY KEY (id)
	)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
	
CREATE TABLE ProductionProcessInspection (
	ProcessIndex VARCHAR ( 51 ) NOT NULL,
	TaskId VARCHAR ( 31 ) NOT NULL,
	ParentId VARCHAR ( 51 ) NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ProductionProcessID INTEGER NOT NULL,
	CONSTRAINT PK_ProductionProcessInspection PRIMARY KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE TaskProcessRelationship (
	TaskId VARCHAR ( 31 ) NOT NULL,
	ProcessId VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_TaskProcessRelationship PRIMARY KEY (ProcessId, TaskId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE user (
        userId int(11) NOT NULL AUTO_INCREMENT,
	userName VARCHAR ( 20 ) NOT NULL,
	userPassword VARCHAR ( 100 ) NOT NULL,
	userNickname VARCHAR ( 20 ),
	userRealname VARCHAR ( 20 ) NOT NULL,
	userAge SMALLINT NOT NULL,
	userSex VARCHAR ( 10 ),
	userAddress VARCHAR ( 100 ),
	userPhone VARCHAR ( 30 ),
	userMail VARCHAR ( 50 ),
	userQQ VARCHAR ( 30 ),
        `regTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	lastLogintime TIMESTAMP,
	level SMALLINT NOT NULL,
	province VARCHAR ( 50 ),
	city VARCHAR ( 50 ),
	bankName VARCHAR ( 100 ),
	branchBank VARCHAR ( 100 ),
	subbranchBank VARCHAR ( 100 ),
	openBankName VARCHAR ( 50 ),
	bankAccountName VARCHAR ( 50 ),
	bankAccount VARCHAR ( 50 ),
	accountType VARCHAR ( 20 ),
	pay VARCHAR ( 20 ),
	mark VARCHAR ( 20 ),
	status VARCHAR ( 20 ),
	parentNumber VARCHAR ( 50 ),
	CONSTRAINT PK_user PRIMARY KEY (userId)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
	
CREATE TABLE user_role (
	user_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT PK_USER_ROLE PRIMARY KEY (user_id, role_id)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE PersonLimitInfo (
	UserNumber VARCHAR ( 30 ) NOT NULL,
	password VARCHAR ( 101 ) NOT NULL,
	Cipher INTEGER NOT NULL,
	LimitLevel INTEGER NOT NULL,
	LockState SMALLINT DEFAULT 0 NOT NULL,
	DueDate DATE NOT NULL,
	CONSTRAINT PK_MemberLimitInfo PRIMARY KEY (UserNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE ProjectInfo (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskNumber VARCHAR ( 21 ) NOT NULL,
	Info VARCHAR ( 100 ) NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_ProjectInfo PRIMARY KEY (ProjectName, TaskNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE DepartmentInfo (
	DepartId INTEGER NOT NULL AUTO_INCREMENT,
	Name VARCHAR ( 51 ) NOT NULL,
	DepartType INTEGER,
	Discribe VARCHAR ( 101 ),
	CONSTRAINT PK_DepartInfo PRIMARY KEY (DepartId)
	)ENGINE=InnoDB  AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
	
CREATE TABLE ProcessRule (
	ProcessId VARCHAR ( 51 ) NOT NULL,
	PeriodId VARCHAR ( 51 ) NOT NULL,
	ParentPeriodId VARCHAR ( 51 ) NOT NULL,
	RuleId SMALLINT NOT NULL,
	context VARCHAR ( 201 ) NOT NULL,
	CONSTRAINT PK_ProcessRule PRIMARY KEY (ProcessId, PeriodId, ParentPeriodId, RuleId)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
CREATE TABLE BasicMaterialInfo (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 21 ) NOT NULL,
	IdNumber VARCHAR ( 11 ) NOT NULL,
	subType SMALLINT DEFAULT 0 NOT NULL,
	name VARCHAR ( 51 ) NOT NULL,
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
	ScrapMark SMALLINT,
	InspectionMode SMALLINT,
	PurchasingPerson VARCHAR ( 31 ),
	TransferTime TIMESTAMP NOT NULL,
	ProductSource VARCHAR ( 50 ),
	SavePerson VARCHAR ( 21 ) NOT NULL,
	StorageTime DATE,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_BasicMaterialInfo PRIMARY KEY (ProjectName, TaskIndex, IdNumber, subType)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE StorageFlowTestResult2 (
	ProjectName VARCHAR ( 51 ) NOT NULL,
	TaskIndex VARCHAR ( 21 ) NOT NULL,
	FlowType INTEGER NOT NULL,
	FlowNumber VARCHAR ( 25 ) NOT NULL,
	nIndex INTEGER NOT NULL,
	MaterialNumber INTEGER NOT NULL,
	TestRequirements VARCHAR ( 150 ) NOT NULL,
	RealNumber INTEGER NOT NULL,
	ValidNumber INTEGER NOT NULL,
	TestResult VARCHAR ( 150 ) NOT NULL,
	TestPerson VARCHAR ( 31 ) NOT NULL,
	TestTime TIMESTAMP NOT NULL,
	level SMALLINT NOT NULL,
	bak VARCHAR ( 100 ),
	CONSTRAINT PK_StorageFlowTestResult2 PRIMARY KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE ProcessManagement (
	ProcessId VARCHAR ( 51 ) NOT NULL,
	CONSTRAINT PK_ProcessManagement PRIMARY KEY (ProcessId)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE DepartmentMember (
	DepartId INTEGER NOT NULL,
	UserNumber VARCHAR ( 30 ) NOT NULL,
	Position VARCHAR ( 21 ),
	resc_enable SMALLINT,
	CONSTRAINT PK_DepartPerson PRIMARY KEY (DepartId, UserNumber)
	)ENGINE=InnoDB  DEFAULT CHARSET=utf8;
	
CREATE TABLE resources_role (
	resc_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT PK_RESOURE_ROLE PRIMARY KEY (resc_id, role_id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE ElectronFlowInfo ADD CONSTRAINT FK_FLOW FOREIGN KEY (FlowType) REFERENCES FlowTypeInfo (nIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE TaskProcessRelationship ADD CONSTRAINT FK_TaskProcessRelationship FOREIGN KEY (TaskId) REFERENCES TaskContractManagement (project_id)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE TaskProcessRelationship ADD CONSTRAINT FK_TaskProcessRelationship1 FOREIGN KEY (ProcessId) REFERENCES ProcessManagement (ProcessId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE InspectionInfo ADD CONSTRAINT FK_InspectionInfo FOREIGN KEY (ProjectName, TaskIndex, IdNumber, SubType) REFERENCES BasicMaterialInfo (ProjectName, TaskIndex, IdNumber, subType)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE BasicMaterialInfo ADD CONSTRAINT FK_BasicMaterialInfo FOREIGN KEY (ProjectName, TaskIndex) REFERENCES ProjectInfo (ProjectName, TaskNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_role ADD CONSTRAINT FK_user_role2 FOREIGN KEY (user_id) REFERENCES user (userId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE user_role ADD CONSTRAINT FK_USER_KEY FOREIGN KEY (role_id) REFERENCES role (id)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionManagement ADD CONSTRAINT FK_ProductionManagement FOREIGN KEY (ProcessIndex, TaskIndex) REFERENCES TaskProcessRelationship (ProcessId, TaskId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageflowInvalidInfo4 ADD CONSTRAINT FK_StorageflowInvalidInfo4 FOREIGN KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber) REFERENCES StorageFlowTestResult2 (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageFlowTestResult2 ADD CONSTRAINT FK_StorageFlowTestResult2 FOREIGN KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber) REFERENCES StorageFlowResult1 (ProjectName, TaskNumber, FlowType, FlowNumber, nIndex, MaterialNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageFlowResult3 ADD CONSTRAINT FK_StorageFlowResult3 FOREIGN KEY (ProjectName, TaskIndex, FlowType, FlowNumber, nIndex, MaterialNumber) REFERENCES StorageFlowResult1 (ProjectName, TaskNumber, FlowType, FlowNumber, nIndex, MaterialNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE PersonLimitInfo ADD CONSTRAINT FK_MemberLimitInfo FOREIGN KEY (UserNumber) REFERENCES Member_info (UserNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageFlowResult1 ADD CONSTRAINT FK_StorageFlowResult1_01 FOREIGN KEY (FlowType, FlowNumber, nIndex) REFERENCES FlowRecordInfo (FlowType, FlowNumber, nIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE StorageFlowResult1 ADD CONSTRAINT FK_StorageFlowResult1_02 FOREIGN KEY (ProjectName, TaskNumber) REFERENCES ProjectInfo (ProjectName, TaskNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProcessRule ADD CONSTRAINT FK_ProcessRule FOREIGN KEY (ProcessId, PeriodId, ParentPeriodId) REFERENCES TechnologicalProcess (TechnologicalIndex, ProcessIndex, ParentProcesIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionProcessInfo ADD CONSTRAINT FK_ProductionProcessInfo FOREIGN KEY (ProcessIndex, TaskId) REFERENCES ProductionManagement (ProcessIndex, TaskIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE FlowTemplateInfo ADD CONSTRAINT FK_FLOWTEMPLATE FOREIGN KEY (FlowType) REFERENCES FlowTypeInfo (nIndex)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE DepartmentMember ADD CONSTRAINT FK_DepartDepart FOREIGN KEY (DepartId) REFERENCES DepartmentInfo (DepartId)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE DepartmentMember ADD CONSTRAINT FK_DepartMember FOREIGN KEY (UserNumber) REFERENCES Member_info (UserNumber)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE FlowRecordInfo ADD CONSTRAINT PK_FlowRecord FOREIGN KEY (FlowType, FlowNumber) REFERENCES ElectronFlowInfo (FlowType, Number)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE ProductionProcessInspection ADD CONSTRAINT FK_ProductionProcessInspection FOREIGN KEY (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID) REFERENCES ProductionProcessInfo (ProcessIndex, TaskId, ParentId, PeriodId, ProductionProcessID)  ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE TechnologicalProcess ADD CONSTRAINT FK_TechnologicalProcess FOREIGN KEY (TechnologicalIndex) REFERENCES ProcessManagement (ProcessId)  ON DELETE NO ACTION ON UPDATE NO ACTION;

