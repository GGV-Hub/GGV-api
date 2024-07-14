package com.ggv.wallet.service;

import com.ggv.domain.wallet.UserExpense;
import com.ggv.infra.wallet.repository.ExpenseRepository;
import com.ggv.wallet.usecase.CreateExpenseUseCase;
import com.ggv.wallet.usecase.DeleteExpenseUseCase;
import com.ggv.wallet.usecase.ReadMonthlyExpenseUseCase;
import com.ggv.wallet.usecase.UpdateExpenseUseCase;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public void saveExpense(CreateExpenseUseCase useCase) {
        expenseRepository.save(useCase.toEntity());
    }

    @Transactional
    public void deleteExpense(DeleteExpenseUseCase useCase) {
        expenseRepository.deleteByUserIdAndIdIn(useCase.userId(), useCase.userExpenseIds());
    }

    public ReadMonthlyExpenseUseCase findMonthlyExpenses(Long userId, int year, int month) {
        List<UserExpense> userExpenses = expenseRepository.findByUserIdAndYearAndMonth(userId, year, month);
        return ReadMonthlyExpenseUseCase.from(userExpenses);
    }

    @Transactional
    public void updateUserExpense(UpdateExpenseUseCase useCase) {
        UserExpense userExpense = findById(useCase.expenseId());

        userExpense.updateAll(
                useCase.title(),
                useCase.dateTime(),
                useCase.price(),
                useCase.paymentMethod(),
                useCase.category(),
                useCase.memo()
        );
    }

    private UserExpense findById(Long expenseId) {
        return expenseRepository.findById(expenseId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("%s번 지출 데이터가 존재하지 않습니다.", expenseId)
                )); // TODO 예외 처리 논의
    }
}
