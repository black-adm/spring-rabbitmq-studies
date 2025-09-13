package com.syscode42.auditms.dto;

import com.syscode42.auditms.enums.PixEnum;

import java.math.BigDecimal;

public record PixRequestDto(
        PixEnum channel,
        String from,
        String to,
        BigDecimal value
) {
}
