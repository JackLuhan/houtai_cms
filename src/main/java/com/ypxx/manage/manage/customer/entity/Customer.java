package com.ypxx.manage.manage.customer.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/12
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 * Description: customer 客户信息实体表
 */
@Entity
@Table(name = "tp_customer")
public class Customer extends BaseEntity {

    @Column(nullable = false)
    private String customerName;
    private String customerWechat;
    private String customerPhone;
    private String customerMail;
    private String customerMessage;
    private Integer states = 0;
    private Integer isShow = 1;
    @Transient
    private String operatorName;

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerWechat() {
        return customerWechat;
    }

    public void setCustomerWechat(String customerWechat) {
        this.customerWechat = customerWechat;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerMail() {
        return customerMail;
    }

    public void setCustomerMail(String customerMail) {
        this.customerMail = customerMail;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

    @Override
    public String toString() {
        return "customer{" +
                "customerName='" + customerName + '\'' +
                ", customerWechat='" + customerWechat + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerMail='" + customerMail + '\'' +
                ", customerMessage='" + customerMessage + '\'' +
                '}';
    }
}
