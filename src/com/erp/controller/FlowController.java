package com.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;




/**
 * 电子流处理
 */
@Controller
@RequestMapping(value="/background/flow/")
public class FlowController 
{
	@RequestMapping(value="create")
	public String queryFlow(Model model,String pageNow)
	{
		return "/background/flow/start";
	}
	@RequestMapping(value="queryfirst")
	public String queryFlowFirst(String pageNow)
	{
		return "/background/flow/first";
	}
	
}
