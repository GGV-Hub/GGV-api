package com.ggv.wallet.expenditures.dto.request;

import com.ggv.wallet.usecase.DeleteExpenseUseCase;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record DeleteExpenseRequest(
        @NotNull(message = "ID 리스트는 null일 수 없습니다.")
        @NotEmpty(message = "ID 리스트는 비어 있을 수 없습니다.")
        List<Long> ids
) {
    public DeleteExpenseUseCase toUseCase(Long userId) {
        return new DeleteExpenseUseCase(
                userId,
                ids
        );
    }
}
