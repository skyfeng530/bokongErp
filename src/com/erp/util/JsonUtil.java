package com.erp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.erp.controller.Workflowcontroller;
import com.erp.util.Log4jUtils.LogLevel;

public class JsonUtil {

	private static Log4jUtils logger = new Log4jUtils(Workflowcontroller.class);

	/**
	 * 把实体Bean、Map对象、数组、列表集合转换成Json串
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 *             String
	 */
	public static String getJsonStr(Object object) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("data", object);

		return JSON.toJSONString(jsonMap);
	}

	/**
	 * 将List集合转换为JSON字符串
	 * 
	 * @param list
	 * @param total
	 * @return
	 */
	public static <T> String parseListToJson(List<T> list, int total) {

		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("data", list);
		jsonMap.put("totalCount", total);

		return JSON.toJSONString(jsonMap);
	}

	/**
	 * 将JSON字符串转换为List
	 * 
	 * @param json
	 * @param clzss
	 * @return
	 */
	public static <T> List<T> parseJsonToList(String json, Class<T> clzss) {

		List<T> list = null;

		try {
			list = JSON.parseArray(json, clzss);
		} catch (Exception e) {
			logger.log(LogLevel.ERROR, "[JsonUtil] parseJsonToList has exception:" + e);
		}

		return list;
	}

	/**
	 * 将JSON字符串作为数据流输出到客户端
	 * 
	 * @param response
	 * @param jsonReuslt
	 */
	public static void outJson(HttpServletResponse response, String jsonReuslt) {

		PrintWriter writer = null;
		try {
			writer = response.getWriter();

			writer.write(jsonReuslt);
			writer.flush();
		} catch (IOException e) {
			logger.log(LogLevel.ERROR, "[JsonUtil] outJson has exception:" + e);
		} finally {
			if (null != writer) {
				writer.close();
			}
		}
	}

	public static String getJsonResultMessage(boolean resultFlag, String message) {
		return "{success:" + resultFlag + ",msg:'" + message + "'}";
	}

	public static String getJsonResultMessage(boolean resultFlag) {
		return "{success:" + resultFlag + "}";
	}
}
