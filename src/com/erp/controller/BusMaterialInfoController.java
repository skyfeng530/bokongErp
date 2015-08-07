package com.erp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.BusMaterialInfo;

import com.erp.service.BusMaterialInfoService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/device/material/")
public class BusMaterialInfoController {
    @Autowired
    private BusMaterialInfoService busMaterialInfoService;
    /**
    * @param model
    * ��ŷ��ؽ����model
    * @return
    */
    @RequestMapping("mechanicsquery")
    public String mechanicsquery(Model model, BusMaterialInfo busMaterialInfo, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = busMaterialInfoService.query(pageView, busMaterialInfo);
        model.addAttribute("pageView", pageView);
        return "/background/device/material/list";
    }

    /**
     * @param model
     * ��ŷ��ؽ����model
     * @return
     */
     @RequestMapping("opticalquery")
     public String opticalquery(Model model, BusMaterialInfo busMaterialInfo, String pageNow) {
         PageView pageView = null;
         if (Common.isEmpty(pageNow)) {
             pageView = new PageView(1);
         } else {
             pageView = new PageView(Integer.parseInt(pageNow));
         }
         pageView = busMaterialInfoService.query(pageView, busMaterialInfo);
         model.addAttribute("pageView", pageView);
         return "/background/device/material/list";
     }
     
    /**
    * �������
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, BusMaterialInfo busMaterialInfo) {
        busMaterialInfoService.add(busMaterialInfo);
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
        return "/background/device/material/add";
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
        busMaterialInfoService.delete(strId);
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
        BusMaterialInfo busMaterialInfo = busMaterialInfoService.getById(strId);
        model.addAttribute("busMaterialInfo", busMaterialInfo);
        return "/background/device/material/edit";
    }

    /**
    * ��������
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, BusMaterialInfo busMaterialInfo) {
        busMaterialInfoService.modify(busMaterialInfo);
        return "redirect:query.html";
    }
}
