package com.ypxx.manage.manage.portal.controller;

import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.manage.news.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwei on 2018/10/5.
 */
@Controller
@RequestMapping(value = "portal/index")
public class IndexController {

    @Autowired
    IEnterpriseService iEnterpriseService;

    @RequestMapping("/index")
    public String index(Model model) {
        List<EnterpriseEntity> list1 = iEnterpriseService.indexListByFour("1");
        EnterpriseEntity one = new EnterpriseEntity();
        List<EnterpriseEntity> onelist = new ArrayList<>();
        if (list1 != null && list1.size() >= 2) {
            one = list1.get(0);
            for (int i = 1; i < list1.size(); i++) {
                onelist.add(list1.get(i));
            }
        }
        model.addAttribute("one", one);
        model.addAttribute("onelist", onelist);


        List<EnterpriseEntity> list2 = iEnterpriseService.indexListByFour("2");
        EnterpriseEntity two = new EnterpriseEntity();
        List<EnterpriseEntity> twolist = new ArrayList<>();
        if (list2 != null && list2.size() >= 2) {
            two = list2.get(0);
            for (int i = 1; i < list2.size(); i++) {
                twolist.add(list2.get(i));
            }
        }
        model.addAttribute("two", two);
        model.addAttribute("twolist", twolist);


        List<EnterpriseEntity> list3 = iEnterpriseService.indexListByFour("3");
        EnterpriseEntity three = new EnterpriseEntity();
        List<EnterpriseEntity> threelist = new ArrayList<>();
        if (list3 != null && list3.size() >= 2) {
            three = list3.get(0);
            for (int i = 1; i < list3.size(); i++) {
                threelist.add(list3.get(i));
            }
        }
        model.addAttribute("three", three);
        model.addAttribute("threelist", threelist);
        return "portal/index";
    }
}
