package com.nn.dto;

public class PolicyDto {

    private String chdrNum;

    private String cownNum;

    private String ownerName;

    private String lifcNum;

    private String lifcName;

    private String aracde;

    private String agntNum;

    private String mailAddress;

    public String getChdrNum() {
        return chdrNum;
    }

    public void setChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
    }

    public String getCownNum() {
        return cownNum;
    }

    public void setCownNum(String cownNum) {
        this.cownNum = cownNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLifcNum() {
        return lifcNum;
    }

    public void setLifcNum(String lifcNum) {
        this.lifcNum = lifcNum;
    }

    public String getLifcName() {
        return lifcName;
    }

    public void setLifcName(String lifcName) {
        this.lifcName = lifcName;
    }

    public String getAracde() {
        return aracde;
    }

    public void setAracde(String aracde) {
        this.aracde = aracde;
    }

    public String getAgntNum() {
        return agntNum;
    }

    public void setAgntNum(String agntNum) {
        this.agntNum = agntNum;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Override
    public String toString() {
        return "PolicyDto{" +
                "chdrNum='" + chdrNum + '\'' +
                ", cownNum='" + cownNum + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", lifcNum='" + lifcNum + '\'' +
                ", lifcName='" + lifcName + '\'' +
                ", aracde='" + aracde + '\'' +
                ", agntNum='" + agntNum + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                '}';
    }
}
