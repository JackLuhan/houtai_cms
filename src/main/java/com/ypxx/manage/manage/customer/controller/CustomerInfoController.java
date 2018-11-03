package com.ypxx.manage.manage.customer.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.manage.customer.entity.Customer;
import com.ypxx.manage.manage.customer.service.CustomerInfoService;
import com.ypxx.manage.system.user.entity.UserEntity;
import com.ypxx.manage.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/11
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 * Description: CustomerInfoController 客户信息
 */
@Controller
@RequestMapping("customer")
public class CustomerInfoController {

    private final CustomerInfoService customerInfoService;
    private final IUserService userService;

    @Autowired
    public CustomerInfoController(CustomerInfoService customerInfoService, IUserService userService) {
        this.customerInfoService = customerInfoService;
        this.userService = userService;
    }

    @RequestMapping("/page")
    public String page(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String start, String end, String title, Long userId) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<Customer> page = customerInfoService.page(pageNum,pageSize,startTime,endTime,title,userId);
        page.getContent().forEach(c->{
            c.setOperatorName(userService.findById(c.getCreateId()).getUsername());
        });
        List<UserEntity> users = userService.list();
        if (users != null) model.addAttribute("users",users);
        model.addAttribute("page",page);
        model.addAttribute("title", title);
        model.addAttribute("userId", userId);
        return "customer/customer_info_list";
    }

    @PostMapping(value = "del")
    @ResponseBody
    public Map<String,Object> del(@RequestParam(value = "ids[]", required = false)Long[] ids){
        Map<String,Object> map = new HashMap<>();
        for (Long id : ids) {
            Customer entity = customerInfoService.delete(id);
            if (entity == null) {
                map.put("state",0);
                return map;
            }
        }
        map.put("state",1);
        return map;
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(Long id){
        Map<String,Object> map = new HashMap<>();
        Customer entity = customerInfoService.delete(id);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "show")
    @ResponseBody
    public Map<String,Object> show(Long id,Integer show){
        Map<String,Object> map = new HashMap<>();
        Customer entity = customerInfoService.updateShow(id,show);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "states")
    @ResponseBody
    public Map<String,Object> states(Long id,Integer states){
        Map<String,Object> map = new HashMap<>();
        Customer customer = customerInfoService.updateStates(id,states);
        if (customer != null) map.put("state",1);
        return map;
    }

    @GetMapping(value = "to/add")
    public String toAdd() {
        return "customer/customer_add";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Map<String, Object> customerAdd(Customer customerEntity) {
        Map<String, Object> map = new HashMap<>();
        Customer customer = customerInfoService.add(customerEntity);
        if (customer != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "to/edit")
    public String toEdit(Model model,Long id){

        Customer customer = customerInfoService.findById(id);
        model.addAttribute("customer",customer);
        return "customer/customer_info_edit";
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Map<String,Object> edit(Customer customerEntity){
        Map<String,Object> map = new HashMap<>();
        Customer customer = customerInfoService.edit(customerEntity);
        if (customer != null) map.put("state",1);
        return map;
    }

}

