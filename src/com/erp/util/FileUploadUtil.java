package com.erp.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.erp.util.Log4jUtils.LogLevel;

public class FileUploadUtil {

	static Log4jUtils logger = new Log4jUtils(FileUploadUtil.class);

	public static File getUploadFile(HttpServletRequest request, UploadFileCommon fileCommon) {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		MultipartFile multipartFile = multipartRequest.getFile("form-file-path");

		if (multipartFile.isEmpty()) {
			return null;
		}

		if (!new File(fileCommon.getFilePath()).exists()) {
			boolean createResult = new File(fileCommon.getFilePath()).mkdirs();

			if (!createResult) {

				logger.log(LogLevel.ERROR,
						"[FileUploadUtil] getUploadFile create this file path is failure:" + fileCommon.getFilePath());
				return null;
			}
		}

		File newFile = new File(FileUtil.getFileName(
				fileCommon.getFilePath() + File.separator + fileCommon.getFilePrefix(), fileCommon.getFileSuffix()));

		try {
			multipartFile.transferTo(newFile);
			
		} catch (IllegalStateException e) {
			logger.log(LogLevel.ERROR, "[FileUploadUtil] getUploadFile has exception:" + e);
		} catch (IOException e) {
			logger.log(LogLevel.ERROR, "[FileUploadUtil] getUploadFile has exception:" + e);
		}

		return newFile;
	}
}
