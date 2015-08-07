package com.erp.dao.impl;
import org.springframework.stereotype.Repository;

import com.erp.base.impl.BaseDaoImpl;
import com.erp.dao.TaskCopyPersonDao;
import com.erp.entity.TaskCopyPerson;


@Repository("taskCopyPersonDao")
public class TaskCopyPersonDaoImpl extends BaseDaoImpl<TaskCopyPerson> implements TaskCopyPersonDao
{
}
