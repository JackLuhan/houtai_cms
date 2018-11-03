package com.ypxx.manage.manage.job.service;

import com.ypxx.manage.manage.job.entity.Job;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 * Description: JobService
 */
public interface JobService {

    /**
     * 条件分页查询
     */
    Page<Job> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId);

    /**
     * 删除
     */
    Job delete(Long id);

    /**
     * 添加
     */
    Job add(Job job);

    /**
     * 通过id查询
     */
    Job findById(Long id);

    /**
     * 编辑
     */
    Job edit(Job job);

    /**
     * 首页置顶查询
     */
    Job findByStates();


    /**
     * 首页查询五条
     */
    List<Job> listByThree();

    /**
     * 更新是否展示的状态
     */
    Job updateShow(Long id, Integer show);

    /**
     * 是否置顶
     */
    Job updateStates(Long id, Integer states);
}
