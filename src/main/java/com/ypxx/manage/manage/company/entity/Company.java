package com.ypxx.manage.manage.company.entity;

import com.ypxx.manage.common.base.BaseEntity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 * Description: Company
 */
@Entity
@Table(name = "tp_company")
public class Company extends BaseEntity {

    @Column(nullable = false)
    private String companyTitle;
    private Integer companyWeight;
    private String companyDescription;
    private String companyPicture;
    private Integer states = 0;
    private Integer isShow = 1;

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

    @Transient
    private String operatorName;


    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public Integer getCompanyWeight() {
        return companyWeight;
    }

    public void setCompanyWeight(Integer companyWeight) {
        this.companyWeight = companyWeight;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyPicture() {
        return companyPicture;
    }

    public void setCompanyPicture(String companyPicture) {
        this.companyPicture = companyPicture;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyTitle='" + companyTitle + '\'' +
                ", companyWeight=" + companyWeight +
                ", companyDescription='" + companyDescription + '\'' +
                ", companyPicture='" + companyPicture + '\'' +
                ", states=" + states +
                ", isShow=" + isShow +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
