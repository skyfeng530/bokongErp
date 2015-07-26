package com.erp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope(value="session")
@RequestMapping("/background/storageOutStock")
public class StorageOutStockController {

	@RequestMapping("/queryListData")
	@ResponseBody
	public Map<String,Object> getGridData(@RequestParam(value="start") int start, @RequestParam(value="limit") int limit)
	{
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("PictureNo", "001");
		map.put("ChildPictureNo", "0011");
		map.put("PictureName", "图片名称1");
		map.put("PictureRequire", "图片需求1");
		map.put("PloidyNum", 10);
		map.put("ShouldReceiveNum", 10);
		map.put("RealReceiveNum", 100);
		map.put("DepotSaveNum", 10);
		map.put("SerialNumber", 5);
		list.add(map);
		dataMap.put("totalProperty", 20);
		dataMap.put("data", list);
		return dataMap;
	}
}
