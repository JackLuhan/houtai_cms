package com.ypxx.manage.manage.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "portal/contactus")
public class ContactUsCtrl {

    @RequestMapping("index")
    public String index() {
        return "portal/contactUs";
    }
}
