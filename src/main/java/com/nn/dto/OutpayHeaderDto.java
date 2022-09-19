package com.nn.dto;

import java.time.LocalDate;

public record OutpayHeaderDto(
        String clntNum,
        String chdrNum,
        String letterType,
        LocalDate printDate,
        String dataId,
        String clntName,
        String clntAddress,
        Double benPercent,
        String role1,
        String role2,
        String cownNum,
        String cownName
) {
}
