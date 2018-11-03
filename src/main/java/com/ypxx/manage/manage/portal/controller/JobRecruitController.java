package com.ypxx.manage.manage.portal.controller;

import com.ypxx.manage.common.utils.DateUtils;
import com.ypxx.manage.manage.company.entity.Company;
import com.ypxx.manage.manage.company.service.CompanyService;
import com.ypxx.manage.manage.job.entity.Job;
import com.ypxx.manage.manage.job.service.JobService;
import com.ypxx.manage.system.user.entity.UserEntity;
import com.ypxx.manage.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/11
 * Time: 13:50
 * To change this template use File | Settings | File Templates.
 * Description: JobRecruitController 入口
 */
@Controller
@RequestMapping(value = "portal/job")
public class JobRecruitController {

    private final JobService jobService;
    private final IUserService userService;

    @Autowired
    public JobRecruitController(JobService jobService, IUserService userService) {
        this.jobService = jobService;
        this.userService = userService;
    }

 /*   @RequestMapping("/job")
    public String company(Model model) {
        Job job = jobService.findByStates();
        List<Job> list = jobService.listByThree();
        model.addAttribute("job",job);
        model.addAttribute("list",list);
        return "portal/recruit";
    }*/

    @RequestMapping("/job")
    public String page(@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize, Model model, String start, String end, String title, Long userId) {
        Date startTime = DateUtils.strToDate(start);
        Date endTime = DateUtils.strToDate(end);
        Page<Job> page = jobService.page(pageNum,pageSize,startTime,endTime,title,userId);
        page.getContent().forEach(c->{
            c.setOperatorName(userService.findById(c.getCreateId()).getUsername());
        });
        List<UserEntity> users = userService.list();
        if (users != null) model.addAttribute("users",users);
        List<Job> list = jobService.listByThree();
        model.addAttribute("list",list);
        model.addAttribute("page",page);
        model.addAttribute("title", title);
        model.addAttribute("userId", userId);
        return "portal/recruit";
    }
}
