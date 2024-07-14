package com.ggv.wallet.usecase;

import com.ggv.domain.wallet.UserExpense;
import java.time.Instant;
import java.util.List;
import lombok.Builder;

public record ReadMonthlyExpenseUseCase(
        List<ReadDailyExpenseUseCase> expenses
) {
    public static ReadMonthlyExpenseUseCase from(List<UserExpense> userExpenses) {
        return new ReadMonthlyExpenseUseCase(userExpenses.stream()
                .map(ReadDailyExpenseUseCase::from)
                .toList()
        );
    }

    private record ReadDailyExpenseUseCase(
            long id,
            Instant dateTime,
            String title,
            double price
    ) {

        @Builder
        private ReadDailyExpenseUseCase {
        }

        private static ReadDailyExpenseUseCase from(UserExpense userExpense) {
            return ReadDailyExpenseUseCase.builder()
                    .id(userExpense.getId())
                    .dateTime(userExpense.getDateTime())
                    .title(userExpense.getTitle())
                    .price(userExpense.getPrice())
                    .build();
        }
    }
}
