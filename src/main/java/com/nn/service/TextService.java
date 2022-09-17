package com.nn.service;

import com.nn.dto.OutpayHeaderDto;
import com.nn.dto.OutpayHeaderDtoBuilder;
import com.nn.dto.PolicyDto;
import com.nn.dto.PolicyDtoBuilder;
import com.nn.dto.SurValueDto;
import com.nn.dto.SurValueDtoBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TextService {

    private static final Logger log = LoggerFactory.getLogger(TextService.class);

    public List<SurValueDto> readSurValues(Path filePath) {
        List<SurValueDto> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.ISO_8859_1)) {
            result.addAll(lines.map(this::mapToSurValuesDto).toList());
        } catch (IOException e) {
            log.error(e.toString());
            System.out.printf("Invalid surrender value file path: %s%n", filePath);
        }
        return result;
    }

    public List<OutpayHeaderDto> readOutpayHeader(Path filePath) {
        List<OutpayHeaderDto> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.ISO_8859_1)) {
            result.addAll(lines.map(line -> mapToOutpayHeaderDto(line.split(";", -1))).toList());
        } catch (IOException e) {
            log.error(e.toString());
            System.out.printf("Outpay header value file path: %s%n", filePath);
        }
        return result;
    }

    public List<PolicyDto> readPolicy(Path filePath) {
        List<PolicyDto> result = new ArrayList<>();
        try (Stream<String> lines = Files.lines(filePath, StandardCharsets.ISO_8859_1)) {
            result.addAll(lines.map(line -> mapToPolicyDto(line.split("\\|", -1))).toList());
        } catch (IOException e) {
            log.error(e.toString());
            System.out.printf("Policy file path: %s%n", filePath);
        }
        return result;
    }

    private SurValueDto mapToSurValuesDto(String line) {
        return SurValueDtoBuilder.aSurValuesDto()
                .withCompany(String.valueOf(line.charAt(0)))
                .withChdrnum(line.substring(1, 9))
                .withSurrenderValue(Float.parseFloat(line.substring(9, 24).trim()))
                .withJobUser(line.substring(24, 31))
                .withJobName(line.substring(31, 42).trim())
                .withJobTimestamp(LocalDate.parse(line.substring(42, 54).trim()))
                .build();
    }

    private OutpayHeaderDto mapToOutpayHeaderDto(String[] values) {
        return OutpayHeaderDtoBuilder.anOutpayHeaderDto()
                .withClntNum(values[0])
                .withChdrNum(values[1])
                .withLetterType(values[2])
                .withPrintDate(LocalDate.parse(values[3], DateTimeFormatter.BASIC_ISO_DATE))
                //TODO claimId hiányzik a fájlból
                .withDataId(values[4])
                //TODO regDate hiányzik a fájlból
                .withClntName(values[5])
                .withClntAddress(values[6])
                //TODO null jön, talán ben Percent?
                //TODO 100.00 jön ez mi???
                .withRole1(values[9])
                .withRole2(values[10])
                .withCownNum(values[11])
                .withCownName(values[12])
                .build();
    }

    private PolicyDto mapToPolicyDto(String[] values) {
        return PolicyDtoBuilder.aPolicyDto()
                .withChdrNum(values[0].trim())
                .withCownNum(values[1].trim())
                .withOwnerName(values[2].trim())
                .withLifcNum(values[3].trim())
                .withLifcName(values[4].trim())
                .withAracde(values[5].trim())
                .withAgntNum(values[6].trim())
                .withMailAddress(values[7].trim())
                .build();
    }

}
