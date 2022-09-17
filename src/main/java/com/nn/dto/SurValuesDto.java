package com.nn.dto;

import java.time.LocalDate;

public record SurValuesDto(
        String company,
        String chdrnum,
        float surrenderValue,
        String jobUser,
        String jobName,
        LocalDate jobTimestamp) {
}
