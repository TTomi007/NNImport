package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Chdrnum is not null")
    @Size(max = 8, message = "Chdrnum max length is 8")
    @Column(name = "Chdrnum", nullable = false, length = 8)
    private String chdrNum;

    @NotNull(message = "Cownnum is not null")
    @Size(max = 8, message = "Cownnum max length is 8")
    @Column(name = "Cownnum", nullable = false, length = 8)
    private String cownNum;

    @Size(max = 50, message = "OwnerName max length is 50")
    @Column(name = "Ownername", length = 50)
    private String ownerName;

    @Size(max = 8, message = "LifcNum max length is 8")
    @Column(name = "Lifcnum", length = 8)
    private String lifcNum;

    @Size(max = 50, message = "LifcName max length is 50")
    @Column(name = "Lifcname", length = 50)
    private String lifcName;

    @Size(max = 3, message = "Aracde max length is 3")
    @Column(length = 3)
    private String aracde;

    @Size(max = 5, message = "Agntnum max length is 5")
    @Column(name = "Agntnum", length = 5)
    private String agntNum;

    @Size(max = 60, message = "Mailaddress max length is 60")
    @Column(name = "Mailaddress", length = 60)
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
