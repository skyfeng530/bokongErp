package com.erp.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class FileUtil {

	/**
	 * 生成文件名
	 * @param filePrefix
	 * @param fileSuffix
	 * @return
	 */
	public static String getFileName(String filePrefix, String fileSuffix) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

		StringBuffer fileBuf = new StringBuffer();

		fileBuf.append(filePrefix).append("_").append(df.format(new Date())).append(fileSuffix);

		return fileBuf.toString();
	}

	/**
	 * 获取应用根目录绝对路径
	 * @param request
	 * @return
	 */
	public static String getWebAppPath(HttpServletRequest request) {
		return request.getServletContext().getRealPath("/");
	}

	/**
	 * 获取文件上传路径
	 * @param request
	 * @return
	 */
	public static String getUploadImageFilePath(HttpServletRequest request, String flowWorkFilePath) {
		return FileUtil.getWebAppPath(request) + Const.UPLOAD_FILE_PATH + File.separator + flowWorkFilePath;
	}
}
