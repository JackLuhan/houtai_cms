package com.ypxx.manage.manage.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dynamic")
public class DynamicController {

    @RequestMapping("/list")
    public String index() {
        return "news/phone_news";
    }

}
