package com.ggv.wallet.expenditures.dto;

import com.ggv.wallet.usecase.CreateExpenseUseCase;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.Instant;

public record CreateExpenseDto() {

    public record Request(
            @NotBlank(message = "제목이 비어있으면 안됩니다.")
            String title,

            @NotNull(message = "시간은 비어있으면 안됩니다.")
            Instant dateTime,

            @Positive(message = "가격은 0보다 커야 합니다.")
            double price,

            @NotBlank(message = "결제수단은 비어있으면 안됩니다.")
            String paymentMethod, // TODO 지출수단 CRUD 구현 후 수가

            @NotBlank(message = "카테고리는 비어있으면 안됩니다.")
            String category, // TODO 카테고리 CRUD 구현 후 수가

            String memo

    ) {
        public CreateExpenseUseCase toUseCase(Long userId) {
            return new CreateExpenseUseCase(
                    userId,
                    this.title,
                    this.dateTime,
                    this.price,
                    this.paymentMethod,
                    this.category,
                    this.memo
            );
        }
    }
}
