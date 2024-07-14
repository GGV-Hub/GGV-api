package com.ggv.wallet.expenditures.dto.request;

import com.ggv.wallet.usecase.UpdateExpenseUseCase;
import java.time.Instant;

public record UpdateExpenseRequest(
        String title,
        Instant dateTime,
        double price,
        String paymentMethod, // TODO 지출수단 CRUD 구현 후 수가
        String category, // TODO 카테고리 CRUD 구현 후 수가
        String memo
) {
    public UpdateExpenseUseCase toUseCase(Long userId, Long expenseId) {
        return new UpdateExpenseUseCase(
                userId,
                expenseId,
                this.title,
                this.dateTime,
                this.price,
                this.paymentMethod,
                this.category,
                this.memo
        );
    }
}
