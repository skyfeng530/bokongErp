package com.erp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.BusProject;

import com.erp.service.BusProjectService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/project/")
public class BusProjectController {
    @Autowired
    private BusProjectService busProjectService;
    /**
    * @param model
    * ��ŷ��ؽ����model
    * @return
    */
    @RequestMapping("query")
    public String query(Model model, BusProject busProject, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = busProjectService.query(pageView, busProject);
        model.addAttribute("pageView", pageView);
        return "/background/project/list";
    }

    /**
    * ��������
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, BusProject busProject) {
        busProjectService.add(busProject);
        return "redirect:query.html";
    }

    /**
    * �ܵ���������
    *
    * @param model
    * @return
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/project/add";
    }

    /**
    * ɾ��
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
        busProjectService.delete(strId);
        return "redirect:query.html";
    }

    /**
    * �޸Ľ���
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
        BusProject busProject = busProjectService.getById(strId);
        model.addAttribute("busProject", busProject);
        return "/background/project/edit";
    }

    /**
    * ��������
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, BusProject busProject) {
        busProjectService.modify(busProject);
        return "redirect:query.html";
    }
}
