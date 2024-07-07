package com.ggv.wallet.usecase;

import java.util.List;

public record DeleteExpenseUseCase(
        Long userId,
        List<Long> userExpenseIds
) {
}
