package com.api.pay.domain.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record TransactionDto(@NotBlank BigDecimal value,@NotBlank Long senderId,@NotBlank Long recieverId) {
}
