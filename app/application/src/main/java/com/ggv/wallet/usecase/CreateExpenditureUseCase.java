package com.ggv.wallet.usecase;

import com.ggv.wallet.Expenditure;

public record CreateExpenditureUseCase(
        Long userId,
        String description,
        String paymentMethod,
        double price
) {
    public Expenditure toEntity() {
        return Expenditure.builder()
                .userId(userId)
                .description(description)
                .paymentMethod(paymentMethod)
                .price(price)
                .build();
    }
}
