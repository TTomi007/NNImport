package com.nn.dto;

import java.time.LocalDate;

public class OutpayHeaderDto {

    private String clntNum;

    private String chdrNum;

    private String letterType;

    private LocalDate printDate;

    private String claimId;

    private String dataId;

    private LocalDate regDate;

    private String clntName;

    private String clntAddress;

    private float benPercent;

    private String role1;

    private String role2;

    private String cownNum;

    private String cownName;

    public String getClntNum() {
        return clntNum;
    }

    public void setClntNum(String clntNum) {
        this.clntNum = clntNum;
    }

    public String getChdrNum() {
        return chdrNum;
    }

    public void setChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public LocalDate getPrintDate() {
        return printDate;
    }

    public void setPrintDate(LocalDate printDate) {
        this.printDate = printDate;
    }

    public String getClaimId() {
        return claimId;
    }

    public void setClaimId(String claimId) {
        this.claimId = claimId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getClntName() {
        return clntName;
    }

    public void setClntName(String clntName) {
        this.clntName = clntName;
    }

    public String getClntAddress() {
        return clntAddress;
    }

    public void setClntAddress(String clntAddress) {
        this.clntAddress = clntAddress;
    }

    public float getBenPercent() {
        return benPercent;
    }

    public void setBenPercent(float benPercent) {
        this.benPercent = benPercent;
    }

    public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
    }

    public String getRole2() {
        return role2;
    }

    public void setRole2(String role2) {
        this.role2 = role2;
    }

    public String getCownNum() {
        return cownNum;
    }

    public void setCownNum(String cownNum) {
        this.cownNum = cownNum;
    }

    public String getCownName() {
        return cownName;
    }

    public void setCownName(String cownName) {
        this.cownName = cownName;
    }

    @Override
    public String toString() {
        return "OutpayHeaderDto{" +
                "clntNum='" + clntNum + '\'' +
                ", chdrNum='" + chdrNum + '\'' +
                ", letterType='" + letterType + '\'' +
                ", printDate=" + printDate +
                ", claimId='" + claimId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", regDate=" + regDate +
                ", clntName='" + clntName + '\'' +
                ", clntAddress='" + clntAddress + '\'' +
                ", benPercent=" + benPercent +
                ", role1='" + role1 + '\'' +
                ", role2='" + role2 + '\'' +
                ", cownNum='" + cownNum + '\'' +
                ", cownName='" + cownName + '\'' +
                '}';
    }
}
