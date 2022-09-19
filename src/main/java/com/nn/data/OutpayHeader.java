package com.nn.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "outpay_header")
public class OutpayHeader {

    @NotNull(message = "Outpay_Header_ID is not null")
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer outpayHeaderId;

    @NotNull(message = "Clntnum is not null")
    @Size(max = 8, message = "Clntnum max length is 8")
    @Column(name = "Clntnum", nullable = false, length = 8)
    private String clntNum;

    @NotNull(message = "Chdrnum is not null")
    @Size(max = 8, message = "Chdrnum max length is 8")
    @Column(name = "Chdrnum", nullable = false, length = 8)
    private String chdrNum;

    @NotNull(message = "LetterType is not null")
    @Size(max = 12, message = "LetterType max length is 12")
    @Column(name = "Lettertype", nullable = false, length = 12)
    private String letterType;

    @NotNull(message = "PrintDate is not null")
    @Column(name = "Printdate", nullable = false)
    private LocalDate printDate;

    @Size(max = 6, message = "DataID max length is 6")
    @Column(name = "Dataid", length = 6)
    private String dataId;

    @Size(max = 80, message = "ClntName max length is 80")
    @Column(name = "Clntname", length = 80)
    private String clntName;

    @Size(max = 80, message = "ClntAddress max length is 80")
    @Column(name = "Clntaddress", length = 80)
    private String clntAddress;

    @Column(name = "Benpercent", length = 6, precision = 2)
    private Double benPercent;

    @Size(max = 2, message = "Role1 max length is 2")
    @Column(length = 2)
    private String role1;

    @Size(max = 2, message = "Role2 max length is 2")
    @Column(length = 2)
    private String role2;

    @Size(max = 8, message = "CownNum max length is 8")
    @Column(name = "Cownnum", length = 8)
    private String cownNum;

    @Size(max = 80, message = "CownName max length is 80")
    @Column(name = "Cownname", length = 80)
    private String cownName;

    @Size(max = 80, message = "Notice01 max length is 80")
    @Column(length = 80)
    private String notice01;

    @Size(max = 80, message = "Notice02 max length is 80")
    @Column(length = 80)
    private String notice02;

    @Size(max = 80, message = "Notice03 max length is 80")
    @Column(length = 80)
    private String notice03;

    @Size(max = 80, message = "Notice04 max length is 80")
    @Column(length = 80)
    private String notice04;

    @Size(max = 80, message = "Notice05 max length is 80")
    @Column(length = 80)
    private String notice05;

    @Size(max = 80, message = "Notice06 max length is 80")
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
