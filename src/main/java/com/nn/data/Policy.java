package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 8)
    private String chdrNum;

    @Column(nullable = false, length = 8)
    private String cownNum;

    @Column(length = 50)
    private String ownerName;

    @Column(length = 8)
    private String lifcNum;

    @Column(length = 50)
    private String lifcName;

    @Column(length = 3)
    private String aracde;

    @Column(length = 5)
    private String agntNum;

    @Column(length = 50)
    private String mailAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
