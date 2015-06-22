package com.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.Device;
import com.erp.service.DeviceService;
import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping(value="/background/device/")
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	@RequestMapping(value="list")
	public String queryDevice(Model model,Device device, String pageNow){
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		deviceService.query(pageView, device);
		model.addAttribute("pageView", pageView);
		return "/background/device/list";
	}
	
	@RequestMapping(value="addDevice")
	public String addDevice(Model model,Device device){
		deviceService.add(device);
		return "/background/device/add";
	}
	
	@RequestMapping(value="add")
	public String add(Model model,Device device){
		deviceService.add(device);
		return "redirect:list.html";
	}
	
	/**
	 * É¾³ýËùÑ¡µÄ
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteAll")
	public String deleteAll(Model model, String[] check) {
		for (String string : check) {
			deviceService.delete(string);
		}
		return "redirect:list.html";
	}
}
