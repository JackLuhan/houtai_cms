package com.ypxx.manage.manage.news.service;

import com.ypxx.manage.manage.news.entity.EnterpriseEntity;
import com.ypxx.manage.system.user.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

/**
 * Created by xuwei on 2018/10/5.
 */
public interface IEnterpriseService {

    /**
     * 条件分页查询
     */
    Page<EnterpriseEntity> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId);

    Page<EnterpriseEntity> page(Integer pageNum, Integer pageSize, Date start, Date end, String title, Long userId, String picturenewstag);

    /**
     * 删除
     */
    EnterpriseEntity delete(Long id);

    /**
     * 添加
     */
    EnterpriseEntity add(EnterpriseEntity enterprise);

    /**
     * 通过id查询
     */
    EnterpriseEntity findById(Long id);

    /**
     * 编辑
     */
    EnterpriseEntity edit(EnterpriseEntity enterprise);

    /**
     * 首页置顶查询
     */
    EnterpriseEntity findByStates();

    EnterpriseEntity findByStates(String type);

    /**
     * 首页查询三条
     */
    List<EnterpriseEntity> listByThree();

    List<EnterpriseEntity> listByThree(String type);

    //根据首页分类，获取四条新闻
    List<EnterpriseEntity> indexListByFour(String indextype);

    Page<EnterpriseEntity> getPicture(String type, String place);

    /**
     * 更新是否展示的状态
     */
    EnterpriseEntity updateShow(Long id, Integer show);

    /**
     * 是否置顶
     */
    EnterpriseEntity updateStates(Long id, Integer states);


}
