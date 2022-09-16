package com.nn.dto;

public final class PolicyDtoBuilder {
    private String chdrNum;
    private String cownNum;
    private String ownerName;
    private String lifcNum;
    private String lifcName;
    private String aracde;
    private String agntNum;
    private String mailAddress;

    private PolicyDtoBuilder() {
    }

    public static PolicyDtoBuilder aPolicyDto() {
        return new PolicyDtoBuilder();
    }

    public PolicyDtoBuilder withChdrNum(String chdrNum) {
        this.chdrNum = chdrNum;
        return this;
    }

    public PolicyDtoBuilder withCownNum(String cownNum) {
        this.cownNum = cownNum;
        return this;
    }

    public PolicyDtoBuilder withOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public PolicyDtoBuilder withLifcNum(String lifcNum) {
        this.lifcNum = lifcNum;
        return this;
    }

    public PolicyDtoBuilder withLifcName(String lifcName) {
        this.lifcName = lifcName;
        return this;
    }

    public PolicyDtoBuilder withAracde(String aracde) {
        this.aracde = aracde;
        return this;
    }

    public PolicyDtoBuilder withAgntNum(String agntNum) {
        this.agntNum = agntNum;
        return this;
    }

    public PolicyDtoBuilder withMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
        return this;
    }

    public PolicyDto build() {
        PolicyDto policyDto = new PolicyDto();
        policyDto.setChdrNum(chdrNum);
        policyDto.setCownNum(cownNum);
        policyDto.setOwnerName(ownerName);
        policyDto.setLifcNum(lifcNum);
        policyDto.setLifcName(lifcName);
        policyDto.setAracde(aracde);
        policyDto.setAgntNum(agntNum);
        policyDto.setMailAddress(mailAddress);
        return policyDto;
    }
}
