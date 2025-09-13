package com.syscode42.pfms.dto;

import com.syscode42.pfms.enums.PixEnum;

import java.math.BigDecimal;

public record PixRequestDto(
        PixEnum channel,
        String from,
        String to,
        BigDecimal value
) {
}
