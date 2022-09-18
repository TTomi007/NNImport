package com.nn.dto;

import java.time.LocalDate;

public final class OutpayHeaderDtoBuilder {
    private String clntNum;
    private String chdrNum;
    private String letterType;
    private LocalDate printDate;
    private String claimId;
    private String dataId;
    private LocalDate regDate;
    private String clntName;
    private String clntAddress;
    private Double benPercent;
    private String role1;
    private String role2;
    private String cownNum;
    private String cownName;

    private OutpayHeaderDtoBuilder() {
    }

    public static OutpayHeaderDtoBuilder anOutpayHeaderDto() {
        return new OutpayHeaderDtoBuilder();
    }

    public OutpayHeaderDtoBuilder withClntNum(String clntNum) {
        this.clntNum = clntNum;
        return this;
    }

    public OutpayHeaderDtoBuilder withChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
        return this;
    }

    public OutpayHeaderDtoBuilder withLetterType(String letterType) {
        this.letterType = letterType;
        return this;
    }

    public OutpayHeaderDtoBuilder withPrintDate(LocalDate printDate) {
        this.printDate = printDate;
        return this;
    }

    public OutpayHeaderDtoBuilder withClaimId(String claimId) {
        this.claimId = claimId;
        return this;
    }

    public OutpayHeaderDtoBuilder withDataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public OutpayHeaderDtoBuilder withRegDate(LocalDate regDate) {
        this.regDate = regDate;
        return this;
    }

    public OutpayHeaderDtoBuilder withClntName(String clntName) {
        this.clntName = clntName;
        return this;
    }

    public OutpayHeaderDtoBuilder withClntAddress(String clntAddress) {
        this.clntAddress = clntAddress;
        return this;
    }

    public OutpayHeaderDtoBuilder withBenPercent(Double benPercent) {
        this.benPercent = benPercent;
        return this;
    }

    public OutpayHeaderDtoBuilder withRole1(String role1) {
        this.role1 = role1;
        return this;
    }

    public OutpayHeaderDtoBuilder withRole2(String role2) {
        this.role2 = role2;
        return this;
    }

    public OutpayHeaderDtoBuilder withCownNum(String cownNum) {
        this.cownNum = cownNum;
        return this;
    }

    public OutpayHeaderDtoBuilder withCownName(String cownName) {
        this.cownName = cownName;
        return this;
    }

    public OutpayHeaderDto build() {
        return new OutpayHeaderDto(clntNum, chdrNum, letterType, printDate, claimId, dataId, regDate, clntName, clntAddress, benPercent, role1, role2, cownNum, cownName);
    }
}
