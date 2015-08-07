package com.erp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.dao.TaskCopyPersonDao;
import com.erp.entity.TaskCopyPerson;
import com.erp.service.TaskCopyPersonService;
import com.erp.util.PageView;

@Transactional
@Service("taskCopyPersonService")
public class TaskCopyPersonServiceImpl implements TaskCopyPersonService {
	@Autowired
	private TaskCopyPersonDao taskCopyPersonDao;

	@Override
	public PageView query(PageView pageView, TaskCopyPerson copyPerson) {
		List<TaskCopyPerson> list = taskCopyPersonDao.query(pageView, copyPerson);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(TaskCopyPerson copyPerson)
	{
		taskCopyPersonDao.add(copyPerson);
	}

	@Override
	public void delete(String string) {
		taskCopyPersonDao.delete(string);
	}
}
