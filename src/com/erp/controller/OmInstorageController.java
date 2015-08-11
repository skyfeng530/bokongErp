package com.erp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

import org.springframework.ui.Model;
import com.erp.entity.OmInstorage;

import com.erp.service.OmInstorageService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/device/material/")
public class OmInstorageController {
    @Autowired
    private OmInstorageService omInstorageService;
    /**
    * @param model
    * 存放返回界面的model
    * @return
    */
    @RequestMapping("mechanicsquery")
    public String mechanicsquery(Model model, OmInstorage omInstorage, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        omInstorage.setType(2);
        pageView = omInstorageService.query(pageView, omInstorage);
        model.addAttribute("pageView", pageView);
        return "/background/device/material/list";
    }
    /**
    * @param model
    * 存放返回界面的model
    * @return
    */
    @RequestMapping("opticalquery")
    public String opticalquery(Model model, OmInstorage omInstorage, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        omInstorage.setType(1);
        pageView = omInstorageService.query(pageView, omInstorage);
        model.addAttribute("pageView", pageView);
        return "/background/device/material/list";
    }

    /**
    * 保存数据
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, OmInstorage omInstorage) {
        omInstorageService.add(omInstorage);
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
        return "/background/device/material/add";
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
        omInstorageService.delete(strId);
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
        OmInstorage omInstorage = omInstorageService.getById(strId);
        model.addAttribute("omInstorage", omInstorage);
        return "/background/device/material/edit";
    }

    /**
    * 更新类型
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, OmInstorage omInstorage) {
        omInstorageService.modify(omInstorage);
        if( omInstorage.getType() == 1)
        {
        	return "redirect:mechanicsquery.html";
        }
        return "redirect:opticalquery.html";
    }
}
