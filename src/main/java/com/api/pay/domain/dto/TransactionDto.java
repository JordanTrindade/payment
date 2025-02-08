package com.api.pay.domain.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransactionDto(@NotNull @Positive BigDecimal value, @NotNull Long senderId, @NotNull Long recieverId) {
}
