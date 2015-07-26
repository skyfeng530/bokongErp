package com.erp.util;

import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.ExclusiveGateway;
import org.activiti.bpmn.model.ParallelGateway;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.bpmn.model.UserTask;

/**
 * 创建流程组建工具类
 * @author Administrator
 *
 */
public class TaskModuleUtil {
	
	/**
	 *  创建UserTask
	 * @param id  id
	 * @param name 名称
	 * @param assignee 办理人
	 * @param formKey 
	 * @return
	 */
	public static UserTask createUserTask(String id, String name, String assignee, String formKey) {
		UserTask userTask = new UserTask();
		userTask.setName(name);
		userTask.setId(id);
		userTask.setAssignee(assignee);
		if (null != formKey) {
			userTask.setFormKey(formKey);
		}
		return userTask;
	}

	/**
	 *  创建连线
	 * @param from 起始节点
	 * @param to 结束节点
	 * @param name 连线名称
	 * @return
	 */
	public static SequenceFlow createSequenceFlow(String from, String to,
			String name) {
		SequenceFlow flow = new SequenceFlow();
		flow.setSourceRef(from);
		flow.setTargetRef(to);
		if (null != name) {
			flow.setName(name);
			flow.setConditionExpression("${outcome=='" + name + "'}");
		}
		return flow;
	}

	/**
	 * 创建起始节点
	 * @return
	 */
	public static StartEvent createStartEvent() {
		StartEvent startEvent = new StartEvent();
		startEvent.setId("start");
		return startEvent;
	}

	/**
	 * 创建结束节点
	 * @return
	 */
	public static EndEvent createEndEvent() {
		EndEvent endEvent = new EndEvent();
		endEvent.setId("end");
		return endEvent;
	}
	
	/**
	 * 创建并行网关
	 * @return
	 */
	public static ParallelGateway createParallelGateway(){
		ParallelGateway parallelGateway = new ParallelGateway();
		return parallelGateway;
	}
	
	/**
	 * 创建排他网关
	 * @return
	 */
	public static ExclusiveGateway createExclusiveGateWay(){
		ExclusiveGateway exclusiveGateway = new ExclusiveGateway();
		return exclusiveGateway;
	}
}
