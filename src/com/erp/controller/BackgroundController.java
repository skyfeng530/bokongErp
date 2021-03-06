package com.erp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.dao.UserDao;
import com.erp.entity.InstrumentDevice;
import com.erp.entity.Resources;
import com.erp.entity.User;
import com.erp.entity.UserLoginList;
import com.erp.service.IWorkflowService;
import com.erp.service.InstrumentDeviceService;
import com.erp.service.ResourcesService;
import com.erp.service.UserLoginListService;
import com.erp.util.CiphertextUtil;
import com.erp.util.Common;
import com.erp.util.DateUtil;
import com.erp.util.Log4jUtils;
import com.erp.util.PageView;
import com.erp.util.SessionContext;
import com.erp.util.Log4jUtils.LogLevel;

/**
 * 进行管理后台框架界面的类
 */
@Controller
@RequestMapping ("/background/")
public class BackgroundController
{
	Log4jUtils logger = new Log4jUtils(BackgroundController.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserLoginListService userLoginListService;
	@Autowired
	private ResourcesService resourcesService;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	@Autowired
	private InstrumentDeviceService instrumentdeviceService;
	
	@Autowired
	private IWorkflowService workflowService;
	/**
	 * @return
	 */
	@RequestMapping ("login")
	public String login(Model model,HttpServletRequest request)
	{
		//重新登录时销毁该用户的Session
		Object o = request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		if(null != o){
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "/background/framework/login";
	}
	
	@RequestMapping ("loginCheck")
	public String loginCheck(String username,String password,HttpServletRequest request){
		try {
			if (!request.getMethod().equals("POST")) {
				request.setAttribute("error","支持POST方法提交！");
			}
			if (Common.isEmpty(username) || Common.isEmpty(password)) {
				request.setAttribute("error","用户名或密码不能为空！");
				return "/background/framework/login";
			}
			// 验证用户账号与密码是否正确
			password = CiphertextUtil.passAlgorithmsCiphering(password, CiphertextUtil.MD5);
			User users = this.userDao.querySingleUser(username);
			if (users == null || !users.getUserPassword().equals(password)) {
				request.setAttribute("error", "用户或密码不正确！");
			    return "/background/framework/login";
			}
			Authentication authentication = myAuthenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username,password));
			SecurityContext securityContext = SecurityContextHolder.getContext();
			securityContext.setAuthentication(authentication);
			HttpSession session = request.getSession(true);  
		    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
		    // 当验证都通过后，把用户信息放在session里
			request.getSession().setAttribute("userSession", users);
			// 记录登录信息
			UserLoginList userLoginList = new UserLoginList();
			userLoginList.setUserId(users.getUserId());
			userLoginList.setLoginIp(Common.toIpAddr(request));
			userLoginListService.add(userLoginList);
		} catch (AuthenticationException ae) {  
			request.setAttribute("error", "登录异常，请联系管理员！");
		    return "/background/framework/login";
		}
		return "redirect:index.html";
	}
	
	/**
	 * @return
	 */
	@RequestMapping ("index")
	public String index(Model model)
	{
		return "/background/framework/main";
	}
	
	@RequestMapping ("top")
	public String top(Model model)
	{
		return "/background/framework/top";
	}
	
	@RequestMapping ("left")
	public String left(Model model,HttpServletRequest request)
	{
		try {
			String username = request.getUserPrincipal().getName();
			logger.log(LogLevel.ERROR, "*****loginUsername="+username);
			List<Resources> resources = resourcesService.getResourcesByUserName(username);
			model.addAttribute("resources", resources);
		} catch (Exception e) {
			//重新登录时销毁该用户的Session
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "/background/framework/left";
	}
	
	@RequestMapping ("tab")
	public String tab(Model model, HttpServletRequest request)
	{
		PageView pageView =  new PageView(1);
		pageView.setPageCount(5);
		pageView.setPageSize(5);
		// 从Session中获取当前用户名
		String name = SessionContext.get(request).getUserName();
		// 使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>
		List<Task> tasks = workflowService.findTaskListByName(pageView, name);
		pageView.setRecords(tasks);
		model.addAttribute("pageView", pageView);
		
		List<InstrumentDevice> list1 = instrumentdeviceService.queryAll(new InstrumentDevice());
		List<InstrumentDevice> list2 = new ArrayList<InstrumentDevice>();
		int temp = 0;
		for (int i = list1.size() - 1; i >= 0; i--) {
			if (temp < 5) {
				InstrumentDevice device = list1.get(i);
				Date enableDate = DateUtil.parse(device.getEnableDate(), DateUtil.FORMAT_LONG);
				Date disableTime = DateUtil.addDay(enableDate, -device.getHintVerifyDays());
				if (DateUtil.getMillis(new Date()) > disableTime.getTime()) {
					list2.add(device);
					temp++;
				}
			}
		}
		model.addAttribute("deviceTips", list2);
		return "/background/framework/tab/tabMsg";
	}
	
	@RequestMapping ("center")
	public String center(Model model)
	{
		return "/background/framework/center";
	}
	@RequestMapping("noDevelop")
	public String noDevelop(Model model)
	{
		return "/background/noDevelop";
	}
	
	@RequestMapping(value="tree")
	public String query(){
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		return "/background/tree";
	}
	
	@RequestMapping(value="href")
	public void navigatejson(HttpServletRequest request, HttpServletResponse response){
		System.out.println("Href---------------请求到来!");
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 获取单击的节点id
			String node = request.getParameter("node");
			System.out.println("获取的节点ID: " + node);
			String json = "";
			
			if("0".equals(node)) {	// 全部分组
				json += "[{id:'1', text: '我的好友'}, {id:'2', text: '我的同学'}, {id:'3', text: '陌生人', leaf: true}]";
			} else if("1".equals(node)) {
				json += "[{id:'11', text: '张三', leaf: true, qtip: '路人甲'}, {id:'12', text: '李四', leaf: true, qtip: '炮灰乙'}, {id:'13', text: '王五', leaf: true, qtip: '士兵丁'}]";
			} else if("2".equals(node)) {
				json += "[{id:'21', text: '刘备', leaf: true, qtip: '蜀国霸主', href: '../01_CreateTree/TreePanel.html', hrefTarget: '_blank'}, {id:'22', text: '曹操', leaf: true, qtip: '一家三杰'}, {id:'23', text: '孙尚香', leaf: true, qtip: '哥哥威武霸气'}]";
			}
		
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Href---------------请求结束!");
	}
	
	@RequestMapping(value="getUserById")
	public void getUserById(HttpServletRequest request, HttpServletResponse response){
		System.out.println("getUserById---------------请求到来!");
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 获取单击的节点id
			String node = request.getParameter("id");
			System.out.println("获取的节点ID: " + node);
			String json = "";
			json += "[{id:'1', text: '我的好友'}]";
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("getUserById---------------请求结束!");
	}
}
