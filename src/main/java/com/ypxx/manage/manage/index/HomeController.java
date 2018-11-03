package com.ypxx.manage.manage.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xuwei on 2018/10/5.
 */
@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
