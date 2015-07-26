package com.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope(value="session")
@RequestMapping("/background/storageOut")
public class StorageOutController {

	
	@RequestMapping("/queryProjectName")
	@ResponseBody 
	public List<Map<String,String>> queryProjectNames(HttpServletRequest request, HttpServletResponse response)
	{
		//PrintWriter pw =  response.getWriter();
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("value", "1");
		map.put("text", "project1");
		list.add(map);
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("value", "2");
		map1.put("text", "project2");
		list.add(map1);
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("value", "3");
		map2.put("text", "project3");
		list.add(map2);
		return list;
	}
	
	@RequestMapping("/querytaskNumber")
	@ResponseBody 
	public List<Map<String,String>> querytaskNumbers(@RequestParam(value="projectName") String  projectName, HttpServletRequest request, HttpServletResponse response)
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		if ("project1".equals(projectName))
		{
			Map<String,String> map = new HashMap<String,String>();
			map.put("value", "1");
			map.put("text", "taskNumber1");
			list.add(map);	
		}
		if ("project2".equals(projectName))
		{
			Map<String,String> map1 = new HashMap<String,String>();
			map1.put("value", "2");
			map1.put("text", "taskNumber2");
			list.add(map1);
		}
		if ("project3".equals(projectName))
		{
			Map<String,String> map2 = new HashMap<String,String>();
			map2.put("value", "3");
			map2.put("text", "taskNumber3");
			list.add(map2);
		}
		
		return list;
	}
	
	@RequestMapping("/queryDeviceType")
	@ResponseBody 
	public List<Map<String,String>> queryDeviceTypes(HttpServletRequest request, HttpServletResponse response)
	{
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Map<String,String> map = new HashMap<String,String>();
		map.put("value", "1");
		map.put("text", "devicetype1");
		list.add(map);
		Map<String,String> map1 = new HashMap<String,String>();
		map1.put("value", "2");
		map1.put("text", "devicetype2");
		list.add(map1);
		Map<String,String> map2 = new HashMap<String,String>();
		map2.put("value", "3");
		map2.put("text", "devicetype3");
		list.add(map2);
		return list;
	}
}
