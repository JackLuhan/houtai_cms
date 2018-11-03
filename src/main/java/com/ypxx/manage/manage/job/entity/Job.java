package com.ypxx.manage.manage.job.entity;

import com.ypxx.manage.common.base.BaseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: 后羿
 * Date: 2018/10/10
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 * Description: Job 招聘实体表
 */
@Entity
@Table(name = "tp_job")
public class Job extends BaseEntity {

    @Column(nullable = false)
    /**
     * 职位名称
     */
    private String jobName;
    /**
     * 所属部门
     */
    private String jobDept;
    /**
     * 工作地点
     */
    private String jobLocation;
    /**
     * 学历
     */
    private String jobEduction;
    /**
     * 工作年限
     */
    private String jobYear;
    /**
     * 职位要求
     */
    private String jobDictate;

    private String jobNum;

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    private Integer states = 0;
    private Integer isShow = 1;
    @Transient
    private String operatorName;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDept() {
        return jobDept;
    }

    public void setJobDept(String jobDept) {
        this.jobDept = jobDept;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobEduction() {
        return jobEduction;
    }

    public void setJobEduction(String jobEduction) {
        this.jobEduction = jobEduction;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }

    public String getJobDictate() {
        return jobDictate;
    }

    public void setJobDictate(String jobDictate) {
        this.jobDictate = jobDictate;
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

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", jobDept='" + jobDept + '\'' +
                ", jobLocation='" + jobLocation + '\'' +
                ", jobEduction='" + jobEduction + '\'' +
                ", jobYear='" + jobYear + '\'' +
                ", jobDictate='" + jobDictate + '\'' +
                ", states=" + states +
                ", isShow=" + isShow +
                ", operatorName='" + operatorName + '\'' +
                '}';
    }
}
