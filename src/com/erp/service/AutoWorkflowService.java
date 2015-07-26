package com.erp.service;

import com.erp.entity.FlowTaskInfo;

public interface AutoWorkflowService {
	public void autoDynamicDeploy(String processId, String processName);

	public void saveSubmitTask(FlowTaskInfo flowTaskInfo);
}
