package com.ggv.wallet.expenditures.dto;

import com.ggv.wallet.usecase.CreateExpenseUseCase;
import jakarta.validation.constraints.NotBlank;

public record CreateExpenseDto() {

    public record Request(
            @NotBlank(message = "내용이 비어있으면 안됩니다.")
            String description,

            @NotBlank(message = "결제수단은 비어있으면 안됩니다.")
            String paymentMethod,

            double price
    ) {
        public CreateExpenseUseCase toUseCase(Long userId) {
            return new CreateExpenseUseCase(
                    userId,
                    this.description,
                    this.paymentMethod,
                    this.price
            );
        }
    }
}
