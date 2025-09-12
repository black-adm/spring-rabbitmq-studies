package com.syscode42.pixms.dto;

import com.syscode42.pixms.enums.PixEnum;

import java.math.BigDecimal;

public record PixRequestDto(
        PixEnum channel,
        String from,
        String to,
        BigDecimal value
) {
}
