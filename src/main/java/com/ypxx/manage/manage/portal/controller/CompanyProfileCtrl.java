package com.ypxx.manage.manage.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "portal/companyprofile")
public class CompanyProfileCtrl {

    @RequestMapping("/index")
    public String index() {
        return "portal/companyProfile";
    }
}
