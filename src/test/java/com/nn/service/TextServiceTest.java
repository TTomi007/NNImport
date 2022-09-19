package com.nn.service;

import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.OutpayHeaderDtoBuilder;
import com.nn.dto.PolicyDto;
import com.nn.dto.PolicyDtoBuilder;
import com.nn.dto.SurValueDto;
import com.nn.dto.SurValueDtoBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TextServiceTest {

    @InjectMocks
    private TextService subject;

    private final ClassLoader classLoader = getClass().getClassLoader();

    @Test
    void readSurValuesInvalidTest() {
        List<SurValueDto> readSurValueDtos = subject.readSurValues(Path.of("invalid_ZTPSPF.txt"));
        assertEquals(0, readSurValueDtos.size());
    }

    @Test
    void readSurValuesEmptyTest() {
        List<SurValueDto> readSurValueDtos = subject.readSurValues(getFilePath("ZTPSPF_EMPTY.TXT"));
        assertEquals(0, readSurValueDtos.size());
    }

    @Test
    void readSurValuesMonthErrorTest() {
        List<SurValueDto> readSurValueDtos = subject.readSurValues(getFilePath("ZTPSPF_MONTH_ERROR.TXT"));
        assertEquals(0, readSurValueDtos.size());
    }

    @Test
    void readSurValuesValidTest() {
        List<SurValueDto> readSurValueDtos = subject.readSurValues(getFilePath("ZTPSPF01.TXT"));
        assertEquals(1, readSurValueDtos.size());
        SurValueDto resultSurValueDto = readSurValueDtos.get(0);
        assertEquals(getReadSurValuesDto(), resultSurValueDto);
    }

    @Test
    void readOutpayHeaderInvalidTest() {
        List<OutpayHeaderDto> readOutpayHeaderDtos = subject.readOutpayHeader(
                Path.of("invalid_OUTPH.txt"));
        assertEquals(0, readOutpayHeaderDtos.size());
    }

    @Test
    void readOutpayHeaderEmptyTest() {
        List<OutpayHeaderDto> readOutpayHeaderDtos = subject.readOutpayHeader(
                getFilePath("OUTPH_CUP_EMPTY.TXT"));
        assertEquals(0, readOutpayHeaderDtos.size());
    }

    @Test
    void readOutpayHeaderDayErrorTest() {
        List<OutpayHeaderDto> readOutpayHeaderDtos = subject.readOutpayHeader(
                getFilePath("OUTPH_CUP_01_DAY_ERROR.TXT"));
        assertEquals(0, readOutpayHeaderDtos.size());
    }

    @Test
    void readOutpayHeaderValidTest() {
        List<OutpayHeaderDto> readOutpayHeaderDtos = subject.readOutpayHeader(
                getFilePath("OUTPH_CUP_01.TXT"));
        assertEquals(1, readOutpayHeaderDtos.size());
        OutpayHeaderDto resultOutpayHeaderDto = readOutpayHeaderDtos.get(0);
        assertEquals(getReadOutpayHeaderDto(), resultOutpayHeaderDto);
    }

    @Test
    void readPolicyInvalidTest() {
        List<PolicyDto> readPolicyDtos = subject.readPolicy(Path.of("invalid_CUSTCOMP.txt"));
        assertEquals(0, readPolicyDtos.size());
    }

    @Test
    void readPolicyEmptyTest() {
        List<PolicyDto> readPolicyDtos = subject.readPolicy(getFilePath("CUSTCOMP_EMPTY.txt"));
        assertEquals(0, readPolicyDtos.size());
    }

    @Test
    void readPolicyColumnErrorTest() {
        List<PolicyDto> readPolicyDtos = subject.readPolicy(getFilePath("CUSTCOMP01_COLUMN_ERROR.txt"));
        assertEquals(0, readPolicyDtos.size());
    }

    @Test
    void readPolicyValidTest() {
        List<PolicyDto> readPolicyDtos = subject.readPolicy(getFilePath("CUSTCOMP01.txt"));
        assertEquals(1, readPolicyDtos.size());
        PolicyDto resultPolicyDto = readPolicyDtos.get(0);
        assertEquals(getReadPolicyDto(), resultPolicyDto);
    }

    private Path getFilePath(String resorceName) {
        try {
            return Path.of(Objects.requireNonNull(classLoader.getResource(resorceName)).toURI());
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private SurValueDto getReadSurValuesDto() {
        return SurValueDtoBuilder.aSurValueDto()
                .withCompany("1")
                .withChdrnum("30059553")
                .withSurrenderValue(1205669.32)
                .withJobUser("K5003MT")
                .withJobName("WEEKEND1")
                .withJobTimestamp(LocalDate.parse("2020-02-15"))
                .build();
    }

    private OutpayHeaderDto getReadOutpayHeaderDto() {
        return OutpayHeaderDtoBuilder.anOutpayHeaderDto()
                .withClntNum("63559755")
                .withChdrNum("71034483")
                .withLetterType("CUP")
                .withPrintDate(LocalDate.parse("20200210", DateTimeFormatter.BASIC_ISO_DATE))
                .withDataId("OUTPAY")
                .withClntName("Kiss Noel")
                .withClntAddress("2353 Békéscsaba, Sajtoló u. 3/a")
                .withBenPercent(100.00)
                .withRole1("OW")
                .withRole2("  ")
                .withCownNum("63559755")
                .withCownName("Kiss Noel")
                .build();
    }

    private PolicyDto getReadPolicyDto() {
        return PolicyDtoBuilder.aPolicyDto()
                .withChdrNum("86000065")
                .withCownNum("76000063")
                .withOwnerName("Kis Benedek")
                .withLifcNum("76000063")
                .withLifcName("Kis Benedek")
                .withAracde("00X")
                .withAgntNum("11111")
                .withMailAddress("9556 Verpelét Martinovics u. 6.")
                .build();
    }
}