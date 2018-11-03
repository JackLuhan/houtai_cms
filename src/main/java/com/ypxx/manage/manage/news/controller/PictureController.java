package com.ypxx.manage.manage.news.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.manage.news.service.IEnterpriseService;
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

@Controller
@RequestMapping("picture")
public class PictureController {

    private final IEnterpriseService enterpriseService;
    private final IUserService userService;

    @Autowired
    public PictureController(IEnterpriseService enterpriseService, IUserService userService) {
        this.enterpriseService = enterpriseService;
        this.userService = userService;
    }

    @RequestMapping("/page")
    public String page(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String start, String end, String title, Long userId) {
        System.out.println("------图片新闻-------");
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<EnterpriseEntity> page = enterpriseService.page(pageNum, pageSize, startTime, endTime, title, userId, "1");
        page.getContent().forEach(c -> {
            c.setOperatorName(userService.findById(c.getCreateId()).getUsername());
        });
        List<UserEntity> users = userService.list();
        if (users != null) model.addAttribute("users", users);
        model.addAttribute("page", page);
        model.addAttribute("title", title);
        model.addAttribute("userId", userId);
        return "news/picture_list";
    }

    @GetMapping(value = "to/add")
    public String toAdd() {
        return "news/picture_add";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Map<String, Object> enterpriseAdd(EnterpriseEntity enterprise) {
        Map<String, Object> map = new HashMap<>();
        EnterpriseEntity enterpriseEntity = enterpriseService.add(enterprise);
        if (enterpriseEntity != null) map.put("state", 1);

        return map;
    }

    @PostMapping(value = "del")
    @ResponseBody
    public Map<String, Object> del(@RequestParam(value = "ids[]", required = false) Long[] ids) {
        Map<String, Object> map = new HashMap<>();
        for (Long id : ids) {
            EnterpriseEntity entity = enterpriseService.delete(id);
            if (entity == null) {
                map.put("state", 0);
                return map;
            }
        }
        map.put("state", 1);
        return map;
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(Long id) {
        Map<String, Object> map = new HashMap<>();
        EnterpriseEntity entity = enterpriseService.delete(id);
        if (entity != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "to/edit")
    public String toEdit(Model model, Long id) {
        EnterpriseEntity enterprise = enterpriseService.findById(id);
        model.addAttribute("enterprise", enterprise);
        return "news/picture_edit";
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Map<String, Object> edit(EnterpriseEntity enterprise) {
        Map<String, Object> map = new HashMap<>();
        EnterpriseEntity enterpriseEntity = enterpriseService.edit(enterprise);
        if (enterpriseEntity != null) map.put("state", 1);
        return map;
    }
}
