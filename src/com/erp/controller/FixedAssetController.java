package com.erp.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erp.entity.FixedAsset;

import com.erp.service.FixedAssetService;

import com.erp.util.Common;
import com.erp.util.PageView;

/**
 * 
 */
@Controller
@RequestMapping("/background/device/fixedasset/")
public class FixedAssetController {
    @Autowired
    private FixedAssetService fixedAssetService;
    /**
    * @param model
    * 存放返回界面的model
    * @return
    */
    @RequestMapping("query")
    public String query(Model model, FixedAsset fixedAsset, String pageNow) {
        PageView pageView = null;
        if (Common.isEmpty(pageNow)) {
            pageView = new PageView(1);
        } else {
            pageView = new PageView(Integer.parseInt(pageNow));
        }
        pageView = fixedAssetService.query(pageView, fixedAsset);
        model.addAttribute("pageView", pageView);
        return "/background/device/fixedasset/list";
    }

    /**
    * 保存数据
    *
    * @param model
    * @param videoType
    * @return
    */
    @RequestMapping("add")
    public String add(Model model, FixedAsset fixedAsset) {
        fixedAssetService.add(fixedAsset);
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
        return "/background/device/fixedasset/add";
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
        fixedAssetService.delete(strId);
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
        FixedAsset fixedAsset = fixedAssetService.getById(strId);
        model.addAttribute("fixedAsset", fixedAsset);
        return "/background/device/fixedasset/edit";
    }

    /**
    * 更新类型
    * 
    * @param model
    * @return
    */
    @RequestMapping("update")
    public String update(Model model, FixedAsset fixedAsset) {
        fixedAssetService.modify(fixedAsset);
        return "redirect:query.html";
    }
}
