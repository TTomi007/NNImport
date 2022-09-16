package com.nn.dto;

import java.time.LocalDate;

public class SurValuesDto {

    private String company;

    private String chdrnum;

    private float surrenderValue;

    private String jobUser;

    private String jobName;

    private LocalDate jobTimestamp;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getChdrnum() {
        return chdrnum;
    }

    public void setChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
    }

    public float getSurrenderValue() {
        return surrenderValue;
    }

    public void setSurrenderValue(float surrenderValue) {
        this.surrenderValue = surrenderValue;
    }

    public String getJobUser() {
        return jobUser;
    }

    public void setJobUser(String jobUser) {
        this.jobUser = jobUser;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public LocalDate getJobTimestamp() {
        return jobTimestamp;
    }

    public void setJobTimestamp(LocalDate jobTimestamp) {
        this.jobTimestamp = jobTimestamp;
    }

    @Override
    public String toString() {
        return "SurValuesDto{" +
                "company='" + company + '\'' +
                ", chdrnum='" + chdrnum + '\'' +
                ", surrenderValue=" + surrenderValue +
                ", jobUser='" + jobUser + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobTimestamp=" + jobTimestamp +
                '}';
    }
}
