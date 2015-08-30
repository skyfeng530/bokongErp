package com.erp.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.erp.dao.FlowProejctInfoDao;
import com.erp.dao.StorageFlowResultDao;
import com.erp.dao.UserDao;
import com.erp.entity.BusLeave;
import com.erp.entity.BusProject;
import com.erp.entity.BusProjectFigure;
import com.erp.entity.BusProjectFlow;
import com.erp.entity.BusProjectProductProjectFlow;
import com.erp.entity.BusStorage;
import com.erp.entity.BusStorageOut;
import com.erp.entity.FlowProejctInfo;
import com.erp.entity.FlowRecordInfo;
import com.erp.entity.FlowTaskInfo;
import com.erp.entity.MyTask;
import com.erp.entity.ProjectInfo;
import com.erp.entity.RuTask;
import com.erp.entity.StorageFlowResult;
import com.erp.entity.TaskCopyPerson;
import com.erp.entity.User;
import com.erp.entity.WorkflowBean;
import com.erp.service.AutoWorkflowService;
import com.erp.service.BusProjectFigureProductFlowService;
import com.erp.service.BusProjectFigureService;
import com.erp.service.BusProjectFlowService;
import com.erp.service.BusProjectProductFlowService;
import com.erp.service.BusProjectProductProjectFlowService;
import com.erp.service.BusProjectProductService;
import com.erp.service.BusProjectService;
import com.erp.service.BusTaskFlowService;
import com.erp.service.BusTaskProductFlowService;
import com.erp.service.IWorkflowService;
import com.erp.service.LeaveService;
import com.erp.service.OmDiscardStorageFlowService;
import com.erp.service.OmInStorageFlowService;
import com.erp.service.TaskCopyPersonService;
import com.erp.util.Common;
import com.erp.util.Const;
import com.erp.util.JsonUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.Log4jUtils.LogLevel;
import com.erp.util.PageView;
import com.erp.util.SessionContext;

@Controller
@RequestMapping(value = "/background/workflow/")
public class Workflowcontroller {

	Log4jUtils logger = new Log4jUtils(Workflowcontroller.class);

	@Autowired
	private IWorkflowService workflowService;

	@Autowired
	private LeaveService leaveService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private FlowProejctInfoDao flowproejctinfoDao;

	@Autowired
	private StorageFlowResultDao storageFlowResultDao;

	@Autowired
	private BusProjectService busProjectService;

	@Autowired
	private BusProjectFigureService busProjectFigureService;

	@Autowired
	private FlowProejctInfoDao flowProejctInfoDao;

	@Autowired
	private AutoWorkflowService autoWorkflowService;

	@Autowired
	private BusProjectFigureProductFlowService busprojectfigureproductflowService;

	@Autowired
	private BusProjectFlowService busProjectFlowService;

	@Autowired
	private BusProjectProductProjectFlowService busprojectproductprojectflowService;
	
	@Autowired
	private BusProjectProductFlowService busprojectproductflowService;
	
	@Autowired
	private BusProjectProductService busProjectProductService;

	@Autowired
	private BusTaskProductFlowService bustaskproductflowService;

	@Autowired
	private BusTaskFlowService bustaskflowService;
	
	@Autowired
	private TaskCopyPersonService taskCopyPersonService;

	@Autowired
	private OmDiscardStorageFlowService omdiscardstorageflowService;
	
	@Autowired
	private OmInStorageFlowService omInstorageFlowService;

	/**
	 * 部署管理首页显示
	 * 
	 * @return
	 */
	@RequestMapping(value = "deployHome")
	public String deployHome(Model model) {
		logger.log(LogLevel.INFO, "[Workflowcontroller] deployHome start");
		// 1:查询部署对象信息，对应表（act_re_deployment）
		List<Deployment> depList = workflowService.findDeploymentList();
		// 2:查询流程定义的信息，对应表（act_re_procdef）
		List<ProcessDefinition> pdList = workflowService.findProcessDefinitionList();
		// 放置到上下文对象中
		model.addAttribute("depList", depList);
		model.addAttribute("pdList", pdList);
		logger.log(LogLevel.INFO, "[Workflowcontroller] deployHome end");
		return "/background/workflow/deployHome";
	}

	/**
	 * 跳转至部署页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "deployUI")
	public String deployUI() {
		logger.log(LogLevel.INFO, "[Workflowcontroller] deployUI start");
		return "/background/workflow/deployUI";
	}

	/**
	 * 发布流程
	 * 
	 * @return
	 */
	@RequestMapping(value = "newdeploy")
	public String newdeploy(WorkflowBean workflowBean) {
		// 获取页面传递的值
		// 1：获取页面上传递的zip格式的文件，格式是File类型
		CommonsMultipartFile file = workflowBean.getFile();

		// 文件名称
		String filename = workflowBean.getFilename();
		// 完成部署
		workflowService.saveNewDeploye(file, filename);
		return "redirect:deployHome.html";
	}

	/**
	 * 自动发布流程
	 * 
	 * @return
	 */
	@RequestMapping(value = "autoNewdeploy")
	public String autoNewdeploy(WorkflowBean workflowBean) {
		autoWorkflowService.autoDynamicDeploy("BusLeave", "请假电子流");
		return "redirect:deployHome.html";
	}

	/**
	 * 删除部署信息
	 */
	@RequestMapping(value = "delDeployment")
	public String delDeployment(WorkflowBean workflowBean) {
		// 1：获取部署对象ID
		String deploymentId = workflowBean.getDeploymentId();
		// 2：使用部署对象ID，删除流程定义
		try {
			workflowService.deleteProcessDefinitionByDeploymentId(deploymentId);
		} catch (Exception e) {
		}
		return "redirect:deployHome.html";
	}

	/**
	 * 查看流程图
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "viewImage")
	public String viewImage(HttpServletResponse response, WorkflowBean workflowBean) throws Exception {
		// 部署对象ID
		String deploymentId = workflowBean.getDeploymentId();
		// 资源图片名称
		String imageName = workflowBean.getImageName();
		// 获取资源文件表（act_ge_bytearray）中资源图片输入流InputStream
		InputStream in = workflowService.findImageInputStream(deploymentId, imageName);
		OutputStream out = response.getOutputStream();
		for (int b = -1; (b = in.read()) != -1;) {
			out.write(b);
		}
		out.close();
		in.close();
		// 将图写到页面上，用输出流写
		return null;
	}

	/**
	 * 跳转至填写申请页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "formTemplateList")
	public String formTemplateList(Model model) {
		logger.log(LogLevel.INFO, "[Workflowcontroller] formTemplateList start");
		// 查询流程定义的信息，对应表（act_re_procdef）
		List<ProcessDefinition> pdList = workflowService.findProcessDefinitionList();
		// 放置到上下文对象中
		model.addAttribute("pdList", pdList);
		logger.log(LogLevel.INFO, "[Workflowcontroller] formTemplateList end");
		return "/background/workflow/formTemplateList";
	}

	/**
	 * 跳转至填写申请页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "applyFormUI")
	public String applyFormUI(HttpServletRequest request, Model model) {
		logger.log(LogLevel.INFO, "[Workflowcontroller] applyFormUI start");
		String pdid = request.getParameter("deploymentId");
		// 查询流程定义的信息，对应表（act_re_procdef）
		ProcessDefinition pd = workflowService.findProcessDefinitionListByPdId(pdid);
		// 放置到上下文对象中
		model.addAttribute("pd", pd);
		model.addAttribute("pdid", pdid);
		// 根据流程定义的key设置url
		if ("BusLeave".equals(pd.getKey())) {
			model.addAttribute("url", "leave");
			return "/background/workflow/LeaveFormUI";
		} else if ("BusStorage".equals(pd.getKey())) {
			model.addAttribute("url", "storage");
			return "/background/workflow/taskApplyUI";
		} else if ("BusProject".equals(pd.getKey())) {
			model.addAttribute("url", "project");
			return "/background/workflow/page/project";
		} else if ("BusProduct".equals(pd.getKey())) {
			model.addAttribute("url", "product");
			return "/background/workflow/page/product";
		} else if ("BusProjectFigure".equals(pd.getKey())) {
			model.addAttribute("url", "projectFigure");
			return "/background/workflow/projectfigureflow/projectfigureApply";
		} else if ("BusStorageOut".equals(pd.getKey())) {
			model.addAttribute("url", "storageOut");
			return "/background/workflow/page/storageOut";// gai
		} else if ("BusTaskProcess".equals(pd.getKey())) {
			model.addAttribute("url", "storageOut");
			return "/background/workflow/taskflow/taskFlowApply";
		} else if ("OmDiscardProcess".equals(pd.getKey())) {
			model.addAttribute("url", "storageOut");
			return "/background/workflow/omdiscard/omDisCardFlowApply";
		} else {
			return "/background/workflow/applyFormUI";
		}
	}

	/**
	 * 保存出库电子流并启动
	 * 
	 * @param request
	 * @param response
	 *            ProjectInfo projectInfo改成对应实体类 1、保存数据
	 *            2、启动流程workflowService.saveStorage
	 */
	@RequestMapping(value = "submitForm_storageOut", method = RequestMethod.POST)
	public String saveStorageOut(BusStorageOut busStorageOut, HttpServletRequest request,
			HttpServletResponse response) {
		// leaveService.add(busLeave);//保存至数据库
		// String pdkey = request.getParameter("pdkey");
		// FlowRecordInfo recordInfo = new FlowRecordInfo();
		// recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		// recordInfo.setCreatePerson(SessionContext.get(request).getUserName());
		// FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		// flowTaskInfo.setFlowRecordInfo(recordInfo);
		// flowTaskInfo.setPdid(pdkey);
		// workflowService.saveStartProcess(flowTaskInfo);//启动流程
		return "/background/workflow/storageOutInput";
		// return "redirect:myTaskList.html";
	}

	/**
	 * 填写出库申请单 领料单
	 */
	@RequestMapping(value = "storageout_input")
	public String storageout_input(HttpServletRequest request, BusLeave busLeave) {
		// busLeave.setUsername(SessionContext.get(request).getUserName());
		// leaveService.add(busLeave);
		return "/background/workflow/storageOutInput";
	}

	/**
	 * 仓库管理员备货、填写领料单 仓库管理员
	 */
	@RequestMapping(value = "storageout_stock")
	public String storageout_stock(HttpServletRequest request, BusLeave busLeave) {
		// busLeave.setUsername(SessionContext.get(request).getUserName());
		// leaveService.add(busLeave);
		// return "redirect:myTaskList.html";
		return "/background/workflow/storageOutStock";
	}

	/**
	 * 出库确认
	 */
	@RequestMapping(value = "storageout_verify")
	public String storageout_verify(HttpServletRequest request, BusLeave busLeave) {
		// busLeave.setUsername(SessionContext.get(request).getUserName());
		// leaveService.add(busLeave);
		return "redirect:myTaskList.html";
	}

	/**
	 * 提交请假任务
	 */
	@RequestMapping(value = "submitForm_leave")
	public String submitForm_leave(HttpServletRequest request, BusLeave busLeave) {
		busLeave.setUsername(SessionContext.get(request).getUserName());
		leaveService.add(busLeave);
		return "redirect:myApplyList.html";
	}

	/**
	 * 图库流程任务
	 */
	@RequestMapping(value = "submitForm_projectFigure")
	public String submitForm_projectFigure(HttpServletRequest request, BusProjectFigure projectFigure) {
		int result = busProjectFigureService.add(projectFigure);
		String pdkey = request.getParameter("pdkey");
		if (result > 0) {
			FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
			long pid = busProjectFigureService.getNewProjectId();
			FlowRecordInfo record = new FlowRecordInfo();
			record.setFlowId(pid);
			record.setHandlePerson(SessionContext.get(request).getUserName());
			flowTaskInfo.setFlowRecordInfo(record);
			flowTaskInfo.setPdid(pdkey);
			workflowService.saveStartProcess(flowTaskInfo);
		}
		return "redirect:myTaskList.html";
	}

	/**
	 * 准备表单数据----立项单
	 * 
	 * @return
	 */
	@RequestMapping(value = "projectFigure_input")
	public String projectFigure_input(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initFigureModel(model, taskId);

		return "/background/workflow/projectFormUI";
	}

	/**
	 * 准备表单数据----立项单
	 * 
	 * @return
	 */
	@RequestMapping(value = "task_input")
	public String taskInput(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initTaskModel(model, taskId);

		return "/background/workflow/taskflow/taskInputFormUI";
	}

	@RequestMapping(value = "task_approval")
	public String taskApproval(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initTaskModel(model, taskId);

		return "/background/workflow/taskflow/taskInputFormUIReview";
	}

	private void initTaskModel(Model model, String taskId) {

		model.addAttribute("taskId", taskId);

		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		List<Map<String, Object>> list = bustaskproductflowService.queryTaskInfoByFlowId(flowId + "");

		List<Map<String, Object>> taskList = bustaskflowService.queryBusTaskFlowByFlowId(flowId + "");

		model.addAttribute("projectName", list.get(0).get("projectname"));
		model.addAttribute("productName", list.get(0).get("productname"));
		model.addAttribute("figureLib", list.get(0).get("figureLib"));

		if (!CollectionUtils.isEmpty(taskList)) {
			model.addAttribute("taskno", taskList.get(0).get("taskno"));
			model.addAttribute("totalSetNum", taskList.get(0).get("totalSetNum"));
			model.addAttribute("tasksource", taskList.get(0).get("tasksource"));
		}

		model.addAttribute("flowId", flowId);
	}

	/**
	 * 图库审核
	 * 
	 * @return
	 */
	@RequestMapping(value = "projectFigure_review")
	public String projectFigure_review(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initFigureModel(model, taskId);

		return "/background/workflow/projectfigureflow/projectFormReviewUI";
	}

	/**
	 * 保存立项
	 */
	@RequestMapping(value = "save_project")
	public void save_project(HttpServletRequest request, HttpServletResponse response, BusProjectFlow busProjectFlow) {
		response.setCharacterEncoding("UTF-8");
		BusProject busProject = busProjectService.getByProjectName(busProjectFlow.getProjectName());
		if (busProject != null) {
			JsonUtil.outJson(response, "{success:false,msg:'exist'}");
			return;
		}
		boolean result = false;
		String pdkey = request.getParameter("pdkey");
		FlowRecordInfo recordInfo = new FlowRecordInfo();
		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid(pdkey);
		workflowService.saveFlow(flowTaskInfo, pdkey);

		busProjectFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());
		result = busProjectFlowService.add(busProjectFlow);
		JsonUtil.outJson(response, "{success:'" + result + "'}");
	}

	/**
	 * 准备表单数据----立项单
	 * 
	 * @return
	 */
	@RequestMapping(value = "project_input")
	public String project_input(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");
		model.addAttribute("taskId", taskId);
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));
		// 使用任务ID，查找请假单ID，从而获取请假单信息
		BusProjectFlow busProjectFlow = busProjectFlowService.getById(flowId + "");
		model.addAttribute("busProjectFlow", busProjectFlow);
		// 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称
		List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);
		model.addAttribute("outcomeList", outcomeList);
		// 查询所有历史审核人的审核信息
		List<Comment> commentList = workflowService.findCommentByTaskId(taskId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("url", "project");
		return "/background/workflow/page/projectSubmit";
	}

	/**
	 * 提交立项
	 */
	@RequestMapping(value = "submit_project")
	public void submit_project(HttpServletRequest request, HttpServletResponse response, FlowTaskInfo flowTaskInfo) {

		logger.log(LogLevel.INFO, "[Workflowcontroller] submit_project start");
		boolean result = false;
		String strUser = request.getParameter("nextName");
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(flowTaskInfo.getTaskId()));
		int flowResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);
		if (flowResult == 0) {
			// 使用任务ID，查找请假单ID，从而获取请假单信息
			BusProjectFlow busProjectFlow = busProjectFlowService.getById(flowId + "");
			BusProject busProject = busProjectService.getByProjectName(busProjectFlow.getProjectName());
			if (busProject != null) {
				JsonUtil.outJson(response, "{success:'true',message:'falseAndTure'}");
				return;
			}
			busProject = new BusProject();
			busProject.setProjectName(busProjectFlow.getProjectName());
			busProject.setProjectDescribe(busProjectFlow.getProjectDescribe());
			result = busProjectService.add(busProject) > 0;
		}
		if (flowResult == 2 || result) {
			result = true;
			busProjectFlowService.delete(flowId + "");
		}
		if (flowResult == 1) {
			result = true;
		}
		JsonUtil.outJson(response, "{success:" + result + "}");
		logger.log(LogLevel.INFO, "[Workflowcontroller] ubmit_project end");
	}

	/**
	 * 准备表单数据----立项单
	 * 
	 * @return
	 */
	@RequestMapping(value = "project_approval")
	public String project_approval(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");
		model.addAttribute("taskId", taskId);
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));
		// 使用任务ID，查找请假单ID，从而获取请假单信息
		BusProjectFlow busProjectFlow = busProjectFlowService.getById(flowId + "");
		model.addAttribute("busProjectFlow", busProjectFlow);
		// 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称
		List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);
		model.addAttribute("outcomeList", outcomeList);
		// 查询所有历史审核人的审核信息
		List<Comment> commentList = workflowService.findCommentByTaskId(taskId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("url", "project");
		return "/background/workflow/page/projectApproval";
	}

	/**
	 * 保存产品工程
	 */
	@RequestMapping(value = "save_product")
	public void save_product(HttpServletRequest request, HttpServletResponse response,
			BusProjectProductProjectFlow busProjectProductProjectFlow) {
		response.setCharacterEncoding("UTF-8");
		boolean result = false;
		String pdkey = request.getParameter("pdkey");
		// String pdid = request.getParameter("pdid");
		FlowRecordInfo recordInfo = new FlowRecordInfo();
		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		// flowTaskInfo.setPdkey(pdid);
		flowTaskInfo.setPdid(pdkey);
		workflowService.saveFlow(flowTaskInfo, pdkey);

		busProjectProductProjectFlow.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());
		result = busprojectproductprojectflowService.add(busProjectProductProjectFlow) > 0;
		JsonUtil.outJson(response, "{success:'" + result + "'}");
	}

	@RequestMapping(value = "product_input")
	public String product_input(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");
		model.addAttribute("taskId", taskId);
		List<String> pd = workflowService.findOutComeListByTaskId(taskId);
		// 放置到上下文对象中
		model.addAttribute("pd", pd);
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));
		// 使用任务ID，查找请假单ID，从而获取请假单信息
		BusProjectProductProjectFlow busProjectProductProjectFlow = busprojectproductprojectflowService
				.getById(flowId + "");
		model.addAttribute("flowId", busProjectProductProjectFlow.getFlowId());
		BusProject busProject = busProjectService.getById(busProjectProductProjectFlow.getProjectId() + "");
		model.addAttribute("busProject", busProject);
		return "/background/workflow/page/productAdd";
	}

	/**
	 * 提交产品电子流
	 */
	@RequestMapping(value = "submit_product")
	public void submit_product(HttpServletRequest request, HttpServletResponse response, FlowTaskInfo flowTaskInfo) {

		logger.log(LogLevel.INFO, "[Workflowcontroller] submit_product start");
		boolean result = false;
		String strUser = request.getParameter("nextName");
		String flowId = request.getParameter("flowId");
		int flowResult = workflowService.nextWorkFlow(strUser, flowTaskInfo);
		if (flowResult == 0) {
			// 插入前缺少重复校验
			result = busProjectProductService.addAll(flowId) > 0;
		}
		if (flowResult == 2 || result) {
			result = true;
			busprojectproductprojectflowService.delete(flowId);
			busprojectproductflowService.delete(flowId);
		}
		if (flowResult == 1) {
			result = true;
		}
		JsonUtil.outJson(response, "{success:" + result + "}");
		logger.log(LogLevel.INFO, "[Workflowcontroller] submit_product end");
	}

	@RequestMapping(value = "product_approval")
	public String product_approval(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");
		model.addAttribute("taskId", taskId);
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));
		BusProjectProductProjectFlow busProjectProductProjectFlow = busprojectproductprojectflowService
				.getById(flowId + "");
		model.addAttribute("flowId", busProjectProductProjectFlow.getFlowId());
		BusProject busProject = busProjectService.getById(busProjectProductProjectFlow.getProjectId() + "");
		model.addAttribute("busProject", busProject);
		return "/background/workflow/page/productApproval";
	}

	/**
	 * 提交入库任务
	 */
	@RequestMapping(value = "submitForm_storage")
	public void submitForm_storage(HttpServletRequest request, HttpServletResponse response,
			FlowTaskInfo flowTaskInfo) {

		logger.log(LogLevel.INFO, "[Workflowcontroller] submitForm_storage start");

		String gridData = request.getParameter("data");

		String projectName = request.getParameter("projectName");

		String taskName = request.getParameter("taskName");

		String taskId = request.getParameter("taskId");

		Long flowId = (long) flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		List<StorageFlowResult> flowResults = buildStorageFlowResult(gridData, projectName, taskName, flowId);

		BusStorage storage = new BusStorage();

		storage.setStorages(flowResults);

		boolean result = true;

		String strUser = SessionContext.get(request).getUserName();
		workflowService.nextWorkFlow(strUser, flowTaskInfo);
		// workflowService.addStorage(strUser, flowTaskInfo, storage);

		JsonUtil.outJson(response, "{success:'" + result + "'}");

		logger.log(LogLevel.INFO, "[Workflowcontroller] submitForm_storage end");
	}

	public List<StorageFlowResult> buildStorageFlowResult(String gridData, String projectName, String taskName,
			Long flowId) {

		List<StorageFlowResult> flowResults = JsonUtil.parseJsonToList(gridData, StorageFlowResult.class);

		if (CollectionUtils.isEmpty(flowResults)) {
			return flowResults;
		}

		for (StorageFlowResult storageFlowResult : flowResults) {
			storageFlowResult.setProjectName(projectName);
			storageFlowResult.setTaskName(taskName);
			storageFlowResult.setFlowId(flowId);
		}

		return flowResults;
	}

	/**
	 * 未处理任务页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "myTaskList")
	public String myTaskList(HttpServletRequest request, Model model, BusLeave busLeave, String pageNow) {
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		// 从Session中获取当前用户名
		String name = SessionContext.get(request).getUserName();
		// 使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
		RuTask task = new RuTask();
		task.setAssignee_(name);
		List<RuTask> tasks = workflowService.findTaskListByName2(pageView, task);
		pageView.setRecords(tasks);
		model.addAttribute("pageView", pageView);
		return "/background/workflow/myTaskList";
	}

	/**
	 * 我的申请查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "myApplyList")
	public String myApplyList(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo, String pageNow) {
		logger.log(LogLevel.ERROR, "[Workflowcontroller] myApplyList start");
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		flowTaskInfo.getFlowRecordInfo().setHandlePerson(SessionContext.get(request).getUserName());
		List<FlowTaskInfo> tasks = workflowService.findApplyFormByName(pageView, flowTaskInfo);
		pageView.setRecords(tasks);
		model.addAttribute("pageView", pageView);
		logger.log(LogLevel.ERROR, "[Workflowcontroller] myApplyList END");
		return "/background/workflow/myApplyList";
	}

	// 启动流程
	@RequestMapping(value = "startProcess")
	public String startProcess(FlowTaskInfo flowTaskInfo) {
		// 更新请假状态，启动流程实例，让启动的流程实例关联业务
		workflowService.saveStartProcess(flowTaskInfo);
		return "redirect:myTaskList.html";
	}

	/**
	 * 打开任务表单
	 */
	@RequestMapping(value = "viewTaskForm")
	public String viewTaskForm(Model model, FlowTaskInfo flowTaskInfo) {
		// 任务ID
		String taskId = flowTaskInfo.getTaskId();
		model.addAttribute("taskId", taskId);
		String pdid = flowTaskInfo.getPdid();
		model.addAttribute("pdid", pdid);
		// 获取任务表单中任务节点的url连接
		String url = workflowService.findTaskFormKeyByTaskId(taskId);
		// String url = "storage_approvalresult";
		model.addAttribute("url", url);
		return "redirect:" + url + ".html";
	}

	@RequestMapping(value = "loadOutComeList")
	public void loadOutComeList(HttpServletRequest request, HttpServletResponse response) {

		String taskId = request.getParameter("taskId");

		// 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称
		List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);

		List<Map<String, String>> outComeList2 = new ArrayList<Map<String, String>>();

		if (CollectionUtils.isEmpty(outcomeList)) {
			JsonUtil.outJson(response, "{'data':[]}");
			return;
		}

		Map<String, String> outComeMap = null;
		for (String outcome : outcomeList) {
			outComeMap = new HashMap<String, String>();

			outComeMap.put("text", outcome);
			outComeMap.put("value", outcome);

			outComeList2.add(outComeMap);
		}

		JsonUtil.outJson(response, JsonUtil.getJsonStr(outComeList2));
	}

	@RequestMapping(value = "loadProcessUser")
	public void loadProcessUser(HttpServletRequest request, HttpServletResponse response) {
		List<User> users = userDao.query(new PageView(), new User());

		JsonUtil.outJson(response, JsonUtil.getJsonStr(users));
	}

	/**
	 * 准备表单数据----请假单
	 * 
	 * @return
	 */
	@RequestMapping(value = "audit_leave")
	public String audit_leave(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");
		model.addAttribute("taskId", taskId);
		// 使用任务ID，查找请假单ID，从而获取请假单信息
		BusLeave leave = workflowService.findLeaveBillByTaskId(taskId);
		model.addAttribute("leave", leave);
		// 已知任务ID，查询ProcessDefinitionEntiy对象，从而获取当前任务完成之后的连线名称
		List<String> outcomeList = workflowService.findOutComeListByTaskId(taskId);
		model.addAttribute("outcomeList", outcomeList);
		// 查询所有历史审核人的审核信息
		List<Comment> commentList = workflowService.findCommentByTaskId(taskId);
		model.addAttribute("commentList", commentList);
		model.addAttribute("url", "leave");
		List<User> users = userDao.query(new PageView(), new User());
		model.addAttribute("users", users);
		return "/background/workflow/taskFormUI";
	}

	/**
	 * 准备入库表单数据-----入库单填写
	 * 
	 * @return
	 */
	@RequestMapping(value = "storage_input")
	public String storage_input(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {
		model.addAttribute("url", "storage");

		initModel(model, flowTaskInfo);
		initBatchNoModel(model, flowTaskInfo);
		
		return "/background/workflow/MaterialtransferUI";
	}

	private void initBatchNoModel(Model model, FlowTaskInfo flowTaskInfo) {

		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(flowTaskInfo.getTaskId()));

		int maxValue = omInstorageFlowService.getMaxNo(flowId + "");

		model.addAttribute("deviceMaxValue", maxValue);
	}

	/**
	 * 打印页面预览
	 * 
	 * @return
	 */
	@RequestMapping(value = "printpage_084_1E")
	public String printViewPage0841e(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {

		String taskId = request.getParameter("taskId");

		String discardType = switchToApprovalpage(taskId);

		if ("1".equals(discardType)) {
			return "/background/workflow/printpage_084-1E";
		}

		return "/background/workflow/printpage_084-1E_1";
	}

	private List<Map<String, Object>> getFlowProjectInfoByTaskId(String taskId) {
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		return omInstorageFlowService.getOmInstorageFlowInfo(flowId + "");
	}

	private List<Map<String, String>> queryProductFigureInfo(int flowId) {
		return busprojectfigureproductflowService.getProductInfoByid(flowId + "");
	}

	/**
	 * 准备入库表单数据-----入库检验
	 * 
	 * @return
	 */
	@RequestMapping(value = "storage_check")
	public String storage_check(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {
		model.addAttribute("url", "storage");
		initModel(model, flowTaskInfo);
		return "/background/workflow/intakeCheckUI";
	}

	/**
	 * 请求grid里的数据
	 */
	@RequestMapping(value = "loadFormGridData", method = RequestMethod.POST)
	private void loadFormGridData(HttpServletRequest request, HttpServletResponse response) {
		int flowId = NumberUtils.toInt(request.getParameter("flowId"));

		List<StorageFlowResult> flowResults = storageFlowResultDao.queryByFlowId(flowId);

		String jsonReuslt = JsonUtil.parseListToJson(flowResults, flowResults.size());

		JsonUtil.outJson(response, jsonReuslt);
	}

	/**
	 * 准备入库表单数据-----审批
	 * 
	 * @return
	 */
	@RequestMapping(value = "storage_approval")
	public String storage_approval(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {
		model.addAttribute("url", "storage");

		initModel(model, flowTaskInfo);

		return "/background/workflow/UnqualifiedtrialUI";
	}

	/**
	 * 准备入库表单数据-----审批结果处理
	 * 
	 * @return
	 */
	@RequestMapping(value = "storage_approvalresult")
	public String storage_approvalresult(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {
		model.addAttribute("url", "storage");

		initModel(model, flowTaskInfo);

		return "/background/workflow/trialResultReviewUI";
	}

	private void initModel(Model model, FlowTaskInfo flowTaskInfo) {
		String taskId = flowTaskInfo.getTaskId();
		model.addAttribute("taskId", taskId);

		List<Map<String, Object>> omInstorageFlowList = getFlowProjectInfoByTaskId(taskId);

		model.addAttribute("projectName", omInstorageFlowList.get(0).get("PROJECTNAME"));
		model.addAttribute("taskName", omInstorageFlowList.get(0).get("TASKNO"));
		model.addAttribute("flowId", omInstorageFlowList.get(0).get("FLOWID"));
		model.addAttribute("deviceType", omInstorageFlowList.get(0).get("DEVNAME"));
		model.addAttribute("ideviceType", omInstorageFlowList.get(0).get("DEVID"));
		model.addAttribute("bustaskId", omInstorageFlowList.get(0).get("TASKID"));
		model.addAttribute("batchno", omInstorageFlowList.get(0).get("BATCHNO"));
		model.addAttribute("taskId", taskId);
	}

	private void initFigureModel(Model model, String taskId) {

		model.addAttribute("taskId", taskId);

		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		List<Map<String, String>> list = queryProductFigureInfo(flowId);

		model.addAttribute("projectName", list.get(0).get("projectname"));
		model.addAttribute("productName", list.get(0).get("productname"));
		model.addAttribute("figureLib", list.get(0).get("figureLib"));
		model.addAttribute("flowId", flowId);
	}

	/**
	 * 准备入库表单数据-----保存
	 * 
	 * @return
	 */
	@RequestMapping(value = "storage_save")
	public String storage_save(HttpServletRequest request, Model model, FlowTaskInfo flowTaskInfo) {
		model.addAttribute("url", "storage");
		initModel(model, flowTaskInfo);
		return "/background/workflow/manageApprovalUI";
	}

	/**
	 * 提交任务
	 */
	@RequestMapping(value = "submitTask")
	public String submitTask(HttpServletRequest request, FlowTaskInfo flowTaskInfo) {

		// flowTaskInfo.setNextName(SessionContext.get(request).getUserName());
		// flowTaskInfo.getFlowRecordInfo().setHandlePerson(SessionContext.get(request).getUserName());
		// workflowService.saveSubmitTask(flowTaskInfo);
		return "redirect:myTaskList.html";
	}

	/**
	 * 查看当前流程图（查看当前活动节点，并使用红色的框标注）
	 */
	@RequestMapping(value = "viewCurrentImage")
	public String viewCurrentImage(Model model, MyTask task) {
		// 任务ID
		String taskId = task.getTaskId();
		/** 查看流程图 */
		// 使用任务对象获取流程定义ID，查询流程定义对象
		ProcessDefinition pd = workflowService.findProcessDefinitionByTaskId(taskId);
		model.addAttribute("deploymentId", pd.getDeploymentId());
		model.addAttribute("imageName", pd.getDiagramResourceName());
		/** 查看当前活动，获取当期活动对应的坐标x,y,width,height */
		Map<String, Object> map = workflowService.findCoordingByTask(taskId);
		model.addAttribute("acs", map);
		return "/background/workflow/image";
	}

	/**
	 * 查看流转记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "hisComment")
	public String hisComment(Model model, MyTask task) {
		// 获取清单ID
		String id = task.getId() + "";
		String className = task.getPdid();
		// 使用请假单ID，查询历史的批注信息
		List<Comment> commentList = workflowService.findLeaveCommentById(id);
		model.addAttribute("commentList", commentList);
		// 根据流程定义的key设置url
		if ("BusLeave".equals(className)) {
			// 使用请假单ID，查询请假单对象
			BusLeave leave = leaveService.getById(id);
			model.addAttribute("leave", leave);
			model.addAttribute("url", "leave");
		}
		if ("BusStorage".equals(className)) {
			model.addAttribute("url", "storage");
		}
		return "/background/workflow/taskFormHis";
	}
	
	/**
	 * 查看流转记录
	 * 
	 * @return
	 */
	@RequestMapping(value = "hisComment_Copy")
	public String hisComment_Copy(Model model, MyTask task) {
		// 获取清单businesskey
		String businesskey = task.getTitle();
		// 使用请假单ID，查询历史的批注信息
		List<Comment> commentList = workflowService.findCommentByBusinessKey(businesskey);
		model.addAttribute("commentList", commentList);
		return "/background/workflow/taskFormHis";
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "queryProjectName", method = RequestMethod.POST)
	public void queryProjectName(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<ProjectInfo> projectInfoList = workflowService.findProjectName();

		String jsonReuslt = JsonUtil.getJsonStr(projectInfoList);

		JsonUtil.outJson(response, jsonReuslt);
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "queryTaskNumber", method = RequestMethod.POST)
	public void queryTaskNumber(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String projectName = request.getParameter("projectName");

		if (StringUtils.isEmpty(projectName)) {
			JsonUtil.outJson(response, Const.JSON_NULL);
			return;
		}

		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setProjectName(projectName);

		List<ProjectInfo> projectInfoList = workflowService.findTaskNumber(new PageView(1), projectInfo);

		String jsonReuslt = JsonUtil.getJsonStr(projectInfoList);

		JsonUtil.outJson(response, jsonReuslt);
	}

	/**
	 * 获取项目名称
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "saveStorage", method = RequestMethod.POST)
	public void saveStorage(ProjectInfo projectInfo, HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		boolean result = false;

		FlowRecordInfo recordInfo = new FlowRecordInfo();

		recordInfo.setHandlePerson(SessionContext.get(request).getUserName());
		recordInfo.setCreatePerson(SessionContext.get(request).getUserName());

		FlowTaskInfo flowTaskInfo = new FlowTaskInfo();
		flowTaskInfo.setFlowRecordInfo(recordInfo);
		flowTaskInfo.setPdid("BusStorage");

		workflowService.saveFlow(flowTaskInfo, "BusStorage");

		FlowProejctInfo flowProejctInfo = new FlowProejctInfo();
		flowProejctInfo.setFlowId(flowTaskInfo.getFlowRecordInfo().getFlowId());
		flowProejctInfo.setProjectName(projectInfo.getProjectName());
		flowProejctInfo.setTaskName(projectInfo.getTaskNumber());

		flowProejctInfoDao.add(flowProejctInfo);

		JsonUtil.outJson(response, "{success:'" + result + "'}");
	}

	/**
	 * 准备表单数据----立项单
	 * 
	 * @return
	 */
	@RequestMapping(value = "omdiscard_input")
	public String omdiscardInput(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initOmDiscardModel(model, taskId);

		return "/background/workflow/omdiscard/omdiscardIntputFormUI";
	}

	@RequestMapping(value = "omdiscard_check")
	public String omdiscardCheck(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initOmDiscardModel(model, taskId);

		return "/background/workflow/omdiscard/omdiscardApprovalUI";

	}

	private String switchToApprovalpage(String taskId) {
		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		return omdiscardstorageflowService.queryDiscardType(flowId + "");
	}

	@RequestMapping(value = "omdiscard_approval")
	public String omdiscardApproval(HttpServletRequest request, Model model) {
		// 获取任务ID
		String taskId = request.getParameter("taskId");

		initOmDiscardModel(model, taskId);

		return "/background/workflow/omdiscard/omdiscardApprovalReviewUI";
	}

	private void initOmDiscardModel(Model model, String taskId) {

		model.addAttribute("taskId", taskId);

		int flowId = flowproejctinfoDao.getFlowIdByTask(NumberUtils.toInt(taskId));

		List<Map<String, Object>> omdiscardInfoList = omdiscardstorageflowService.queryOmdisCardInfo(flowId + "");

		if (!CollectionUtils.isEmpty(omdiscardInfoList)) {
			model.addAttribute("taskno", omdiscardInfoList.get(0).get("TASKNO"));
			model.addAttribute("devname", omdiscardInfoList.get(0).get("DEVNAME"));
			model.addAttribute("discardType", omdiscardInfoList.get(0).get("DISCARDTYPE"));
			model.addAttribute("projectName", omdiscardInfoList.get(0).get("PROJECTNAME"));
		}

		model.addAttribute("flowId", flowId);
	}

	/**
	 * 保存抄送人
	 * 
	 * @param copyPerson
	 */
	public void saveCopyPerson(TaskCopyPerson copyPerson) {
		taskCopyPersonService.add(copyPerson);
	}

	/**
	 * 跳转至抄送人页面
	 * 
	 * @param model
	 * @param copyPerson
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value = "copyPersonUI")
	public String copyPersonUI(Model model, TaskCopyPerson copyPerson, String pageNow, HttpServletRequest request) {
		copyPerson.setCopyperson(SessionContext.get(request).getUserName());
		PageView pageView = null;
		if (Common.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = taskCopyPersonService.query(pageView, copyPerson);
		model.addAttribute("pageView", pageView);
		
//		//先查出抄送我的任务List<RuTask>
//		
//		// 从Session中获取当前用户名
//		String name = SessionContext.get(request).getUserName();
//		// 使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
//		RuTask task = new RuTask();
//		task.setAssignee_(name);
//		List<RuTask> tasks = workflowService.findTaskListByTaskId(pageView, task);
//		pageView.setRecords(tasks);
//		model.addAttribute("pageView", pageView);
		return "/background/workflow/copyPersonList";
	}

	@RequestMapping(value = "loadProject")
	public void loadProjectInfo(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<Map<String, Object>> projectInfoList = omdiscardstorageflowService.queryProjectInfo();

		JsonUtil.outJson(response, JsonUtil.getJsonStr(projectInfoList));
	}

	@RequestMapping(value = "loadTask")
	public void loadTaskInfo(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String projectId = request.getParameter("projectId");

		if (StringUtils.isEmpty(projectId)) {
			JsonUtil.outJson(response, Const.JSON_NULL);
			return;
		}

		List<Map<String, Object>> projectInfoList = omdiscardstorageflowService.queryTaskInfo(projectId);

		JsonUtil.outJson(response, JsonUtil.getJsonStr(projectInfoList));
	}
}
