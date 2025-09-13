package com.syscode42.pjms.dto;

import com.syscode42.pjms.enums.PixEnum;

import java.math.BigDecimal;

public record PixRequestDto(
        PixEnum channel,
        String from,
        String to,
        BigDecimal value
) {
}
