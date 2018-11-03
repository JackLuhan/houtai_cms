package com.ypxx.manage.manage.customer.service;

import com.ypxx.manage.manage.customer.entity.Customer;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 * Description: CustomerService
 */
public interface CustomerInfoService {

    /**
     * 条件分页查询
     */
    Page<Customer> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId);

    /**
     * 删除
     */
    Customer delete(Long id);

    /**
     * 添加
     */
    Customer add(Customer customer);

    /**
     * 通过id查询
     */
    Customer findById(Long id);

    /**
     * 编辑
     */
    Customer edit(Customer customer);

    /**
     * 首页置顶查询
     */
    Customer findByStates();


    /**
     * 首页查询五条
     */
    List<Customer> listByThree();

    /**
     * 更新是否展示的状态
     */
    Customer updateShow(Long id, Integer show);

    /**
     * 是否置顶
     */
    Customer updateStates(Long id, Integer states);
}
