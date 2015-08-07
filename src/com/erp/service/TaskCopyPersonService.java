package com.erp.service;


import com.erp.entity.TaskCopyPerson;
import com.erp.util.PageView;

public interface TaskCopyPersonService{
	public PageView query(PageView pageView,TaskCopyPerson copyPerson);

	public void add(TaskCopyPerson copyPerson);

	public void delete(String string);
}
