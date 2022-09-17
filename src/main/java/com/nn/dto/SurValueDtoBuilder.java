package com.nn.dto;

import java.time.LocalDate;

public final class SurValueDtoBuilder {
    private String company;
    private String chdrnum;
    private float surrenderValue;
    private String jobUser;
    private String jobName;
    private LocalDate jobTimestamp;

    private SurValueDtoBuilder() {
    }

    public static SurValueDtoBuilder aSurValuesDto() {
        return new SurValueDtoBuilder();
    }

    public SurValueDtoBuilder withCompany(String company) {
        this.company = company;
        return this;
    }

    public SurValueDtoBuilder withChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
        return this;
    }

    public SurValueDtoBuilder withSurrenderValue(float surrenderValue) {
        this.surrenderValue = surrenderValue;
        return this;
    }

    public SurValueDtoBuilder withJobUser(String jobUser) {
        this.jobUser = jobUser;
        return this;
    }

    public SurValueDtoBuilder withJobName(String jobName) {
        this.jobName = jobName;
        return this;
    }

    public SurValueDtoBuilder withJobTimestamp(LocalDate jobTimestamp) {
        this.jobTimestamp = jobTimestamp;
        return this;
    }

    public SurValueDto build() {
        return new SurValueDto(company, chdrnum, surrenderValue, jobUser, jobName, jobTimestamp);
    }
}
