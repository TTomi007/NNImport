package com.nn.service;

import com.nn.Args;
import com.nn.data.OutpayHeader;
import com.nn.data.Policy;
import com.nn.data.SurValue;
import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.OutpayHeaderDtoBuilder;
import com.nn.dto.PolicyDto;
import com.nn.dto.PolicyDtoBuilder;
import com.nn.dto.SurValueDto;
import com.nn.dto.SurValueDtoBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestObjectInitializer {

    static Args createArgs(String ztpspf, String outph, String policy) {
        Args result = new Args();
        result.setZtpspf(ztpspf);
        result.setOutph(outph);
        result.setPolicy(policy);
        return result;
    }

    static SurValue createSurValue() {
        SurValue mappedSurValue = new SurValue();
        mappedSurValue.setChdrNum("42781365");
        mappedSurValue.setSurValue(312.34);
        mappedSurValue.setCompany("2");
        mappedSurValue.setCurrency("HUF");
        mappedSurValue.setValidDate("2020-10-10");
        return mappedSurValue;
    }

    static SurValue createSavedSurValue() {
        SurValue savedSurValue = createSurValue();
        savedSurValue.setId(1);
        return savedSurValue;
    }

    static SurValueDto createSurValueDto() {
        return SurValueDtoBuilder.aSurValueDto()
                .withChdrnum("42781365")
                .withSurrenderValue(312.34)
                .withCompany("2")
                .withJobTimestamp(LocalDate.parse("2020-10-10"))
                .build();
    }

    static OutpayHeader createOutpayHeader() {
        OutpayHeader mappedOutpayHeader = new OutpayHeader();
        mappedOutpayHeader.setClntNum("55555555");
        mappedOutpayHeader.setChdrNum("66666666");
        mappedOutpayHeader.setLetterType("LET");
        mappedOutpayHeader.setPrintDate(LocalDate.parse("20201111", DateTimeFormatter.BASIC_ISO_DATE));
        mappedOutpayHeader.setDataId("TEST");
        mappedOutpayHeader.setClntName("Teszt Elek");
        mappedOutpayHeader.setClntAddress("6666 Pécs Van utca 7.");
        mappedOutpayHeader.setBenPercent(88.75);
        mappedOutpayHeader.setRole1("Role1");
        mappedOutpayHeader.setRole2("Role2");
        mappedOutpayHeader.setCownNum("11111111");
        mappedOutpayHeader.setCownName("Teszt Nóra");
        return mappedOutpayHeader;
    }

    static OutpayHeader createSavedOutpayHeader() {
        OutpayHeader savedOutpayHeader = createOutpayHeader();
        savedOutpayHeader.setOutpayHeaderId(42);
        savedOutpayHeader.setNotice01("Notice01");
        savedOutpayHeader.setNotice02("Notice02");
        savedOutpayHeader.setNotice03("Notice03");
        savedOutpayHeader.setNotice04("Notice04");
        savedOutpayHeader.setNotice05("Notice05");
        savedOutpayHeader.setNotice06("Notice06");
        savedOutpayHeader.setTp2ProcessDate(LocalDate.parse("20201212", DateTimeFormatter.BASIC_ISO_DATE));
        return savedOutpayHeader;
    }

    static OutpayHeaderDto createOutpayHeaderDto() {
        return OutpayHeaderDtoBuilder.anOutpayHeaderDto()
                .withClntNum("55555555")
                .withChdrNum("66666666")
                .withLetterType("LET")
                .withPrintDate(LocalDate.parse("20201111", DateTimeFormatter.BASIC_ISO_DATE))
                .withDataId("TEST")
                .withClntName("Teszt Elek")
                .withClntAddress("6666 Pécs Van utca 7.")
                .withBenPercent(88.75)
                .withRole1("Role1")
                .withRole2("Role2")
                .withCownNum("11111111")
                .withCownName("Teszt Nóra")
                .build();
    }

    static Policy createPolicy() {
        Policy mappedPolicy = new Policy();
        mappedPolicy.setChdrNum("22222222");
        mappedPolicy.setCownNum("11111111");
        mappedPolicy.setOwnerName("Teszt Elek");
        mappedPolicy.setLifcNum("33333333");
        mappedPolicy.setLifcName("Teszt Elek");
        mappedPolicy.setAracde("14R");
        mappedPolicy.setAgntNum("11111");
        mappedPolicy.setMailAddress("4444 Baja Teszt utca 1.");
        return mappedPolicy;
    }

    static Policy createSavedPolicy() {
        Policy savedPolicy = createPolicy();
        savedPolicy.setId(101);
        return savedPolicy;
    }

    static PolicyDto createPolicyDto() {
        return PolicyDtoBuilder.aPolicyDto()
                .withChdrNum("22222222")
                .withCownNum("11111111")
                .withOwnerName("Teszt Elek")
                .withLifcNum("33333333")
                .withLifcName("Teszt Elek")
                .withAracde("14R")
                .withAgntNum("11111")
                .withMailAddress("4444 Baja Teszt utca 1.")
                .build();
    }
}
