package com.ggv.wallet.service;

import com.ggv.infra.wallet.repository.ExpenseRepository;
import com.ggv.wallet.usecase.CreateExpenseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Transactional
    public void saveExpenditure(CreateExpenseUseCase useCase) {
        expenseRepository.save(useCase.toEntity());
    }
}
