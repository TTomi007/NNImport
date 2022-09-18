package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "survalues")
public class SurValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Chdrnum", nullable = false, length = 8)
    private String chdrNum;

    @Column(name = "Survalue", nullable = false, length = 15, precision = 2)
    private Double surValue;

    @Column(nullable = false, length = 1)
    private String company;

    @Column(length = 3)
    private String currency;

    @Column(name = "Validdate", length = 10)
    private String validDate;

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

    public Double getSurValue() {
        return surValue;
    }

    public void setSurValue(Double surValue) {
        this.surValue = surValue;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
}
