package com.syscode42.pixms.dto;

import java.math.BigDecimal;

public record PixRequestDto(String channel, String from, String to, BigDecimal value) {
}
