package com.ypxx.manage.manage.product.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tp_products")
public class ProductEntity extends BaseEntity {

    @Column(unique = true)
    private String productName;

    private Long productTypeID;

    private String productTypeNames;

    private String pictures;

    private String describes;

    @Override
    public String toString() {
        return "ProductEntity{" +
                "productName='" + productName + '\'' +
                ", productTypeID='" + productTypeID + '\'' +
                ", productTypeNames='" + productTypeNames + '\'' +
                ", pictures='" + pictures + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(Long productTypeID) {
        this.productTypeID = productTypeID;
    }

    public String getProductTypeNames() {
        return productTypeNames;
    }

    public void setProductTypeNames(String productTypeNames) {
        this.productTypeNames = productTypeNames;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }
}
