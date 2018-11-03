package com.ypxx.manage.manage.portal.controller;

import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.manage.news.service.IEnterpriseService;
import com.ypxx.manage.system.user.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "portal/news")
public class NewsController {

    private final IEnterpriseService enterpriseService;
    private final IUserService userService;

    @Autowired
    public NewsController(IEnterpriseService enterpriseService, IUserService userService) {
        this.enterpriseService = enterpriseService;
        this.userService = userService;
    }

    @RequestMapping("/enterprise")
    public String enterprise(Model model) {
        List<EnterpriseEntity> list = enterpriseService.listByThree("1");

        EnterpriseEntity enterprise = enterpriseService.findByStates("1");

        Page<EnterpriseEntity> pic1 = enterpriseService.getPicture("1", "1");
        Page<EnterpriseEntity> pic2 = enterpriseService.getPicture("1", "2");
        Page<EnterpriseEntity> pic3 = enterpriseService.getPicture("1", "3");

        model.addAttribute("pic1", pic1.getContent());
        model.addAttribute("pic2", pic2.getContent());
        model.addAttribute("pic3", pic3.getContent());

        model.addAttribute("enterprise", enterprise);
        model.addAttribute("list", list);
        return "portal/news";
    }

    @RequestMapping("/industry")
    public String industry(Model model) {

        EnterpriseEntity enterprise = enterpriseService.findByStates("2");
        List<EnterpriseEntity> list = enterpriseService.listByThree("2");
        Page<EnterpriseEntity> pic1;
        Page<EnterpriseEntity> pic2;
        Page<EnterpriseEntity> pic3;

        if (enterprise.getType().trim().equals("1")) {
            pic1 = enterpriseService.getPicture("1", "1");
            pic2 = enterpriseService.getPicture("1", "2");
            pic3 = enterpriseService.getPicture("1", "3");
        } else {
            pic1 = enterpriseService.getPicture("2", "1");
            pic2 = enterpriseService.getPicture("2", "2");
            pic3 = enterpriseService.getPicture("2", "3");
        }

        model.addAttribute("pic1", pic1.getContent());
        model.addAttribute("pic2", pic2.getContent());
        model.addAttribute("pic3", pic3.getContent());

        model.addAttribute("enterprise", enterprise);
        model.addAttribute("list", list);
        return "portal/news-industry";
    }

    @RequestMapping("detail")
    public String detail(Model model, Long id) {
        EnterpriseEntity enterprise = enterpriseService.findById(id);
        enterprise.setOperatorName(userService.findById(enterprise.getCreateId()).getUsername());
        model.addAttribute("enterprise", enterprise);
        Page<EnterpriseEntity> pic1;
        Page<EnterpriseEntity> pic2;
        Page<EnterpriseEntity> pic3;

        if (enterprise.getType().trim().equals("1")) {
            pic1 = enterpriseService.getPicture("1", "1");
            pic2 = enterpriseService.getPicture("1", "2");
            pic3 = enterpriseService.getPicture("1", "3");
        } else {
            pic1 = enterpriseService.getPicture("2", "1");
            pic2 = enterpriseService.getPicture("2", "2");
            pic3 = enterpriseService.getPicture("2", "3");
        }

        model.addAttribute("pic1", pic1.getContent());
        model.addAttribute("pic2", pic2.getContent());
        model.addAttribute("pic3", pic3.getContent());
        return "portal/news_detail";
    }

    @RequestMapping("detail_1")
    public String detail_1(Model model, Long id) {
        EnterpriseEntity enterprise = enterpriseService.findById(id);
        enterprise.setOperatorName(userService.findById(enterprise.getCreateId()).getUsername());
        model.addAttribute("enterprise", enterprise);
        Page<EnterpriseEntity> pic1;
        Page<EnterpriseEntity> pic2;
        Page<EnterpriseEntity> pic3;

        if (enterprise.getType().trim().equals("1")) {
            pic1 = enterpriseService.getPicture("1", "1");
            pic2 = enterpriseService.getPicture("1", "2");
            pic3 = enterpriseService.getPicture("1", "3");
        } else {
            pic1 = enterpriseService.getPicture("2", "1");
            pic2 = enterpriseService.getPicture("2", "2");
            pic3 = enterpriseService.getPicture("2", "3");
        }

        model.addAttribute("pic1", pic1.getContent());
        model.addAttribute("pic2", pic2.getContent());
        model.addAttribute("pic3", pic3.getContent());
        return "portal/news_detail_1";
    }
}
