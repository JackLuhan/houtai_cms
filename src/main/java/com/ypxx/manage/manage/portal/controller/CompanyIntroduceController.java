package com.ypxx.manage.manage.portal.controller;

import com.ypxx.manage.manage.company.entity.Company;
import com.ypxx.manage.manage.company.service.CompanyService;
import com.ypxx.manage.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/11
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 * Description: CompanyIntroduceController 入口
 */
@Controller
@RequestMapping(value = "portal/company")
public class CompanyIntroduceController {

    private final CompanyService companyService;
    private final IUserService userService;

    @Autowired
    public CompanyIntroduceController(CompanyService companyService, IUserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @RequestMapping("/company")
    public String company(Model model) {
        Company company = companyService.findByStates();
        List<Company> list = companyService.listByThree();
        model.addAttribute("company",company);
        model.addAttribute("list",list);
        return "portal/companyProfile";
    }

    @RequestMapping("detail")
    public String detail(Model model,Long id) {
        Company company = companyService.findById(id);
        company.setOperatorName(userService.findById(company.getCreateId()).getUsername());
        model.addAttribute("enterprise",company);
        return "portal/news_detail";
    }
}
