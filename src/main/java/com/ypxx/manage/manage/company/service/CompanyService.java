package com.ypxx.manage.manage.company.service;

import com.ypxx.manage.manage.company.entity.Company;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 * Description: CompanyService
 */
public interface CompanyService {
        /* List<Company> getCompanyList();
         void save(Company company);
         void edit(Company company);
         void delete(long id);*/
    /**
     * 条件分页查询
     */
    Page<Company> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId);

    /**
     * 删除
     */
    Company delete(Long id);

    /**
     * 添加
     */
    Company add(Company company);

    /**
     * 通过id查询
     */
    Company findById(Long id);

    /**
     * 编辑
     */
    Company edit(Company company);

    /**
     * 首页置顶查询
     */
    Company findByStates();


    /**
     * 首页查询三条
     */
    List<Company> listByThree();

    /**
     * 更新是否展示的状态
     */
    Company updateShow(Long id,Integer show);

    /**
     * 是否置顶
     */
    Company updateStates(Long id, Integer states);
}
