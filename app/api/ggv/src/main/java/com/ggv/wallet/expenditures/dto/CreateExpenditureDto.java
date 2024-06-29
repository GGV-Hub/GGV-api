package com.ggv.wallet.expenditures.dto;

import com.ggv.wallet.usecase.CreateExpenditureUseCase;
import jakarta.validation.constraints.NotBlank;

public record CreateExpenditureDto() {

    public record Request(
            @NotBlank(message = "내용이 비어있으면 안됩니다.")
            String description,

            @NotBlank(message = "결제수단은 비어있으면 안됩니다.")
            String paymentMethod,

            double price
    ) {
        public CreateExpenditureUseCase toUseCase(Long userId) {
            return new CreateExpenditureUseCase(
                    userId,
                    this.description,
                    this.paymentMethod,
                    this.price
            );
        }
    }
}
