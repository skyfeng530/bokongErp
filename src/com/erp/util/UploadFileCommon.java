package com.erp.util;

public class UploadFileCommon {
	private String filePrefix;

	private String fileSuffix;

	private String filePath;

	public UploadFileCommon(String filePrefix, String fileSuffix, String filePath) {
		this.filePrefix = filePrefix;
		this.fileSuffix = fileSuffix;
		this.filePath = filePath;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
