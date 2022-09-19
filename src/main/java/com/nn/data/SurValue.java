package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "survalues")
public class SurValue {

    @NotNull(message = "SurValue ID is not null")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Chdrnum is not null")
    @Size(max = 8, message = "Chdrnum max length is 8")
    @Column(name = "Chdrnum", nullable = false, length = 8)
    private String chdrNum;

    @NotNull(message = "Survalue is not null")
    @Column(name = "Survalue", nullable = false, length = 15, precision = 2)
    private Double surValue;

    @Size(max = 1, message = "Company max length is 1")
    @Column(nullable = false, length = 1)
    private String company;

    @Size(max = 3, message = "Currency max length is 3")
    @Column(length = 3)
    private String currency;

    @Size(max = 10, message = "ValidDate max length is 10")
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
