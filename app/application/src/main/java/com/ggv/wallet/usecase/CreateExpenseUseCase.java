package com.ggv.wallet.usecase;

import com.ggv.domain.wallet.UserExpense;
import java.time.Instant;

public record CreateExpenseUseCase(
        Long userId,
        String title,
        Instant dateTime,
        double price,
        String paymentMethod,
        String category,
        String memo
) {
    public UserExpense toEntity() {
        return UserExpense.builder()
                .userId(userId)
                .title(title)
                .dateTime(dateTime)
                .price(price)
                .paymentMethod(paymentMethod)
                .category(category)
                .memo(memo)
                .build();
    }
}
