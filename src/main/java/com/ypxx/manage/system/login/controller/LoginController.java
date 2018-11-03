package com.ypxx.manage.system.login.controller;

import com.ypxx.manage.system.login.service.ILoginService;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.user.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Map;

/**
 * Created by xuwei on 2018/10/4.
 */
@Controller
public class LoginController {

    private final ILoginService loginService;

    @Autowired
    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/")
    public String portalIndex(){
        return "redirect:portal/index/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(UserEntity user){
        //添加用户认证信息
        Subject subject = SecurityUtils.getSubject();
        Principal principal = (Principal)subject.getPrincipal();
        if (principal == null) return "redirect:/login";
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(usernamePasswordToken);
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }

    //登出
    @RequestMapping(value = "/logout")
    public String logout(){
        return "logout";
    }

    //错误页面展示
    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public String error(){
        return "404";
    }

    @RequestMapping(value = "/unauthorized",method = RequestMethod.GET)
    public String unauthorized(){
        return "404";
    }

    //数据初始化
    @RequestMapping(value = "/addUser")
    public String addUser(@RequestBody Map<String,Object> map){
        UserEntity user = loginService.addUser(map);
        return "addUser is ok! \n" + user;
    }

    //角色初始化
    @RequestMapping(value = "/addRole")
    public String addRole(@RequestBody Map<String,Object> map){
        RoleEntity role = loginService.addRole(map);
        return "addRole is ok! \n" + role;
    }

    //注解的使用
    @RequiresRoles("admin")
    @RequiresPermissions("create")
    @RequestMapping(value = "/create")
    public String create(){
        return "Create success!";
    }


}
