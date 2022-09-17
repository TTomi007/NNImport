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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 8)
    private String chdrnum;

    @Column(nullable = false, length = 15, precision = 2)
    private Double survalue;

    @Column(nullable = false, length = 1)
    private String company;

    @Column(length = 3)
    private String currency;

    @Column(length = 10)
    private String validdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChdrnum() {
        return chdrnum;
    }

    public void setChdrnum(String chdrnum) {
        this.chdrnum = chdrnum;
    }

    public Double getSurvalue() {
        return survalue;
    }

    public void setSurvalue(Double survalue) {
        this.survalue = survalue;
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

    public String getValiddate() {
        return validdate;
    }

    public void setValiddate(String validdate) {
        this.validdate = validdate;
    }
}
