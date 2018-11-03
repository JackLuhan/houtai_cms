package com.ypxx.manage.manage.news.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by xuwei on 2018/10/10.
 */
@Entity
@Table(name = "tp_news_enterprise")
public class EnterpriseEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;
    private String content;
    private String picture;
    private Integer states = 0;
    private Integer isShow = 1;
    @Transient
    private String operatorName;

    private String type;//顶部新闻分类：1.企业新闻2.行业动态
    private String indextype;//首页新闻分类


    private String picturenewstag="0";//是否为图片新闻:0.默认否 1.是图片新闻
    private String picturenewslocation="1";//图片新闻位置：1.顶部 2.中部 3.底部

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIndextype() {
        return indextype;
    }

    public void setIndextype(String indextype) {
        this.indextype = indextype;
    }

    public String getPicturenewstag() {
        return picturenewstag;
    }

    public void setPicturenewstag(String picturenewstag) {
        this.picturenewstag = picturenewstag;
    }

    public String getPicturenewslocation() {
        return picturenewslocation;
    }

    public void setPicturenewslocation(String picturenewslocation) {
        this.picturenewslocation = picturenewslocation;
    }
}
