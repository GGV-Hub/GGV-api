package com.ggv.wallet.usecase;

import java.time.Instant;

public record UpdateExpenseUseCase(
        Long userId,
        Long expenseId,
        String title,
        Instant dateTime,
        double price,
        String paymentMethod,
        String category,
        String memo
) {
}
