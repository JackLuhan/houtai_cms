package com.ypxx.manage.manage.news.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by xuwei on 2018/10/10.
 */
@Entity
@Table(name = "tp_news_dynamic")
public class DynamicEntity extends BaseEntity {

    @Column(unique = true)
    private String title;
    @Column(unique = true)
    private String content;
    private String picture;

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
}
