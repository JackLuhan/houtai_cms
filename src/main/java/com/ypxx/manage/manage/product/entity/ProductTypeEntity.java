package com.ypxx.manage.manage.product.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tp_product_type")
public class ProductTypeEntity extends BaseEntity {

    @Column(unique = true)
    private String typeName;
    private Integer typeWeight;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeWeight() {
        return typeWeight;
    }

    public void setTypeWeight(Integer typeWeight) {
        this.typeWeight = typeWeight;
    }

    @Override
    public String toString() {
        return "ProductTypeEntity{" +
                "typeName='" + typeName + '\'' +
                ", typeWeight=" + typeWeight +
                '}';
    }
}
