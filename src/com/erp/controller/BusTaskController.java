package com.erp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.BusTask;

import com.erp.service.BusTaskService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/project/task/")
public class BusTaskController {
    @Autowired
    private BusTaskService busTaskService;
    /**
    * @param model
    * 存放返回界面的model
    * @return
    */
    @RequestMapping("query")
    public String query(Model model, BusTask busTask, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = busTaskService.query(pageView, busTask);
        model.addAttribute("pageView", pageView);
        return "/background/project/task/list";
    }

    /**
    * 保存数据
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, BusTask busTask) {
        busTaskService.add(busTask);
        return "redirect:query.html";
    }

    /**
    * 跑到新增界面
    *
    * @param model
    * @return
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/project/task/add";
    }

    /**
    * 删除
    *
    * @param model
    * @param videoTypeId
    * @return
    * @throws UnsupportedEncodingException
     */
    @RequestMapping("deleteById")
    public String deleteById(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        String strId =request.getParameter("id");
        byte b[] =strId.getBytes("ISO-8859-1");
        strId = new String(b, "utf-8");
        busTaskService.delete(strId);
        return "redirect:query.html";
    }

    /**
    * 修改界面
    *
    * @param model
    * @param videoTypeIds
    * @return
    * @throws UnsupportedEncodingException
    */
    @RequestMapping("getById")
    public String getById(Model model, HttpServletRequest request, int type) throws UnsupportedEncodingException {
        String strId =request.getParameter("id");
        byte b[] =strId.getBytes("ISO-8859-1");
        strId = new String(b, "utf-8");
        BusTask busTask = busTaskService.getById(strId);
        model.addAttribute("busTask", busTask);
        return "/background/project/task/edit";
    }

    /**
    * 更新类型
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, BusTask busTask) {
        busTaskService.modify(busTask);
        return "redirect:query.html";
    }
}
