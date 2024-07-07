package com.ggv.wallet.usecase;

import com.ggv.domain.wallet.Expense;

public record CreateExpenseUseCase(
        Long userId,
        String description,
        String paymentMethod,
        double price
) {
    public Expense toEntity() {
        return Expense.builder()
                .userId(userId)
                .description(description)
                .paymentMethod(paymentMethod)
                .price(price)
                .build();
    }
}
