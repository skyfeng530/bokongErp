package com.erp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.BusProjectFigure;

import com.erp.service.BusProjectFigureService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/project/figureLib/")
public class BusProjectFigureController {
    @Autowired
    private BusProjectFigureService busProjectFigureService;
    /**
    * @param model
    * ��ŷ��ؽ����model
    * @return
    */
    @RequestMapping("query")
    public String query(Model model, BusProjectFigure busProjectFigure, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = busProjectFigureService.query(pageView, busProjectFigure);
        model.addAttribute("pageView", pageView);
        return "/background/project/figureLib/list";
    }

    /**
    * �������
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, BusProjectFigure busProjectFigure) {
        busProjectFigureService.add(busProjectFigure);
        return "redirect:query.html";
    }

    /**
    * �ܵ��������
    *
    * @param model
    * @return
     */
    @RequestMapping("addUI")
    public String addUI() {
        return "/background/project/figureLib/add";
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
        busProjectFigureService.delete(strId);
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
        BusProjectFigure busProjectFigure = busProjectFigureService.getById(strId);
        model.addAttribute("busProjectFigure", busProjectFigure);
        return "/background/project/figureLib/edit";
    }

    /**
    * ��������
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, BusProjectFigure busProjectFigure) {
        busProjectFigureService.modify(busProjectFigure);
        return "redirect:query.html";
    }
}
