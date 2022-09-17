package com.nn.dto;

import java.time.LocalDate;

public record SurValueDto(
        String company,
        String chdrnum,
        Double surrenderValue,
        String jobUser,
        String jobName,
        LocalDate jobTimestamp) {
}
