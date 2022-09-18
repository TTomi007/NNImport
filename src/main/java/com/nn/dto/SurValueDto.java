package com.nn.dto;

import java.time.LocalDate;

public record SurValueDto(
        String company,
        String chdrNum,
        Double surrenderValue,
        String jobUser,
        String jobName,
        LocalDate jobTimestamp) {
}
