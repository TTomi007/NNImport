package com.nn.dto;

import java.time.LocalDate;

public final class SurValuesDtoBuilder {
    private String company;
    private String chdrnum;
    private float surrenderValue;
    private String jobUser;
    private String jobName;
    private LocalDate jobTimestamp;

    private SurValuesDtoBuilder() {
    }

    public static SurValuesDtoBuilder aSurValuesDto() {
        return new SurValuesDtoBuilder();
    }

    public SurValuesDtoBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public SurValuesDtoBuilder withChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
        return this;
    }

    public SurValuesDtoBuilder withSurrenderValue(float surrenderValue) {
        this.surrenderValue = surrenderValue;
        return this;
    }

    public SurValuesDtoBuilder withJobUser(String jobUser) {
        this.jobUser = jobUser;
        return this;
    }

    public SurValuesDtoBuilder withJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public SurValuesDtoBuilder withJobTimestamp(LocalDate jobTimestamp) {
        this.jobTimestamp = jobTimestamp;
        return this;
    }

    public SurValuesDto build() {
        SurValuesDto surValuesDto = new SurValuesDto();
        surValuesDto.setCompany(company);
        surValuesDto.setChdrnum(chdrnum);
        surValuesDto.setSurrenderValue(surrenderValue);
        surValuesDto.setJobUser(jobUser);
        surValuesDto.setJobName(jobName);
        surValuesDto.setJobTimestamp(jobTimestamp);
        return surValuesDto;
    }
}
