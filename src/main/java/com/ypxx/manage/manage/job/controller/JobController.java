package com.ypxx.manage.manage.job.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.manage.job.entity.Job;
import com.ypxx.manage.manage.job.service.JobService;
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
 * Description: JobController 招聘
 */
@Controller
@RequestMapping("job")
public class JobController {

    private final JobService jobService;
    private final IUserService userService;

    @Autowired
    public JobController(JobService jobService, IUserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

    @RequestMapping("/page")
    public String page(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String start, String end, String title, Long userId) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<Job> page = jobService.page(pageNum,pageSize,startTime,endTime,title,userId);
        page.getContent().forEach(c->{
            c.setOperatorName(userService.findById(c.getCreateId()).getUsername());
        });
        List<UserEntity> users = userService.list();
        if (users != null) model.addAttribute("users",users);
        model.addAttribute("page",page);
        model.addAttribute("title", title);
        model.addAttribute("userId", userId);
        return "job/job_list";
    }

    @PostMapping(value = "del")
    @ResponseBody
    public Map<String,Object> del(@RequestParam(value = "ids[]", required = false)Long[] ids){
        Map<String,Object> map = new HashMap<>();
        for (Long id : ids) {
            Job entity = jobService.delete(id);
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
        Job entity = jobService.delete(id);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "show")
    @ResponseBody
    public Map<String,Object> show(Long id,Integer show){
        Map<String,Object> map = new HashMap<>();
        Job entity = jobService.updateShow(id,show);
        if (entity != null) map.put("state",1);
        return map;
    }

    @PostMapping(value = "states")
    @ResponseBody
    public Map<String,Object> states(Long id,Integer states){
        Map<String,Object> map = new HashMap<>();
        Job job = jobService.updateStates(id,states);
        if (job != null) map.put("state",1);
        return map;
    }

    @GetMapping(value = "to/add")
    public String toAdd() {
        return "job/job_add";
    }

    @PostMapping(value = "add")
    @ResponseBody
    public Map<String, Object> jobAdd(Job jobEntity) {
        Map<String, Object> map = new HashMap<>();
        Job job = jobService.add(jobEntity);
        if (job != null) map.put("state", 1);
        return map;
    }

    @GetMapping(value = "to/edit")
    public String toEdit(Model model,Long id){

        Job job = jobService.findById(id);
        model.addAttribute("job",job);
        return "job/job_edit";
    }

    @PostMapping(value = "edit")
    @ResponseBody
    public Map<String,Object> edit(Job jobEntity){
        Map<String,Object> map = new HashMap<>();
        Job job = jobService.edit(jobEntity);
        if (job != null) map.put("state",1);
        return map;
    }

}

