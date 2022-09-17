package com.nn.dto;

import java.time.LocalDate;

public record OutpayHeaderDto(
        String clntNum,
        String chdrNum,
        String letterType,
        LocalDate printDate,
        String claimId,
        String dataId,
        LocalDate regDate,
        String clntName,
        String clntAddress,
        float benPercent,
        String role1,
        String role2,
        String cownNum,
        String cownName
) {
}
