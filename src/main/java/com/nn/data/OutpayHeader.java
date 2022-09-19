package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "outpay_header")
public class OutpayHeader {

    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer outpayHeaderId;

    @Column(name = "Clntnum", nullable = false, length = 8)
    private String clntNum;

    @Column(name = "Chdrnum", nullable = false, length = 8)
    private String chdrNum;

    @Column(name = "Lettertype", nullable = false, length = 12)
    private String letterType;

    @Column(name = "Printdate", nullable = false)
    private LocalDate printDate;

    @Column(name = "Dataid", length = 6)
    private String dataId;

    @Column(name = "Clntname", length = 80)
    private String clntName;

    @Column(name = "Clntaddress", length = 80)
    private String clntAddress;

    @Column(name = "Benpercent", length = 6, precision = 2)
    private Double benPercent;

    @Column(length = 2)
    private String role1;

    @Column(length = 2)
    private String role2;

    @Column(name = "Cownnum", length = 8)
    private String cownNum;

    @Column(name = "Cownname", length = 80)
    private String cownName;

    @Column(length = 80)
    private String notice01;

    @Column(length = 80)
    private String notice02;

    @Column(length = 80)
    private String notice03;

    @Column(length = 80)
    private String notice04;

    @Column(length = 80)
    private String notice05;

    @Column(length = 80)
    private String notice06;

    @Column(name = "Tp2processdate")
    private LocalDate tp2ProcessDate;

    public Integer getOutpayHeaderId() {
        return outpayHeaderId;
    }

    public void setOutpayHeaderId(Integer outpayHeaderId) {
        this.outpayHeaderId = outpayHeaderId;
    }

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

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
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

    public Double getBenPercent() {
        return benPercent;
    }

    public void setBenPercent(Double benPercent) {
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

    public String getNotice01() {
        return notice01;
    }

    public void setNotice01(String notice01) {
        this.notice01 = notice01;
    }

    public String getNotice02() {
        return notice02;
    }

    public void setNotice02(String notice02) {
        this.notice02 = notice02;
    }

    public String getNotice03() {
        return notice03;
    }

    public void setNotice03(String notice03) {
        this.notice03 = notice03;
    }

    public String getNotice04() {
        return notice04;
    }

    public void setNotice04(String notice04) {
        this.notice04 = notice04;
    }

    public String getNotice05() {
        return notice05;
    }

    public void setNotice05(String notice05) {
        this.notice05 = notice05;
    }

    public String getNotice06() {
        return notice06;
    }

    public void setNotice06(String notice06) {
        this.notice06 = notice06;
    }

    public LocalDate getTp2ProcessDate() {
        return tp2ProcessDate;
    }

    public void setTp2ProcessDate(LocalDate tp2ProcessDate) {
        this.tp2ProcessDate = tp2ProcessDate;
    }
}
