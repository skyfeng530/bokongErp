package com.erp.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Spring调度，指定时间执行
 * 利用了spring 3 中使用注解的方式来进行任务调度。 
 * @version 1.0v
 */
@Component
public class SpringTaskController {

	/**
	 * 与用户设置的使用率比较 spirng 调度
	 * 
	 * @throws Exception
	 */
	@Scheduled(cron = "0 0/2 * * * ? ")
	public void task() throws Exception {
		System.out.println("**************************定时器执行了："+new Date()+"***************************");
	}

}
