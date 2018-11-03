package com.ypxx.manage.manage.company.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.manage.company.entity.Company;
import com.ypxx.manage.manage.company.service.CompanyService;
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
 * Date: 2018/10/10
 * Time: 10:51
 * To change this template use File | Settings | File Templates.
 * Description: CompanyController 公司简介
 */
@Controller
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;
    private final IUserService userService;

    @Autowired
    public CompanyController(CompanyService companyService, IUserService userService) {
        this.companyService = companyService;
        this.userService = userService;
    }

    @RequestMapping("/page")
    public String page(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String start, String end, String title, Long userId) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<Company> page = companyService.page(pageNum,pageSize,startTime,endTime,title,userId);
        page.getContent().forEach(c->{
            c.setOperatorName(userService.findById(c.getCreateId()).getUsername());
        });
        List<UserEntity> users = userService.list();
        if (users != null) model.addAttribute("users",users);
        model.addAttribute("page",page);
        model.addAttribute("title", title);
        model.addAttribute("userId", userId);
        return "company/company_list";
    }

    @PostMapping(value = "del")
    @ResponseBody
    public Map<String,Object> del(@RequestParam(value = "ids[]", required = false)Long[] ids){
        Map<String,Object> map = new HashMap<>();
        for (Long id : ids) {
            Company entity = companyService.delete(id);
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
        Company entity = companyService.delete(id);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "show")
    @ResponseBody
    public Map<String,Object> show(Long id,Integer show){
        Map<String,Object> map = new HashMap<>();
        Company entity = companyService.updateShow(id,show);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "states")
    @ResponseBody
    public Map<String,Object> states(Long id,Integer states){
        Map<String,Object> map = new HashMap<>();
        Company company = companyService.updateStates(id,states);
        if (company != null) map.put("state",1);
        return map;
    }

    @GetMapping(value = "to/add")
    public String toAdd() {
        return "company/company_add";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Map<String, Object> companyAdd(Company companyEntity) {
        Map<String, Object> map = new HashMap<>();
        Company company = companyService.add(companyEntity);
        if (company != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "to/edit")
    public String toEdit(Model model,Long id){

        Company company = companyService.findById(id);
        model.addAttribute("company",company);
        return "company/company_edit";
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Map<String,Object> edit(Company companyEntity){
        Map<String,Object> map = new HashMap<>();
        Company company = companyService.edit(companyEntity);
        if (company != null) map.put("state",1);
        return map;
    }

}
