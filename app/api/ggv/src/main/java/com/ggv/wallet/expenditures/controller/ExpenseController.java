package com.ggv.wallet.expenditures.controller;

import com.ggv.wallet.expenditures.dto.CreateExpenseDto;
import com.ggv.wallet.expenditures.dto.request.DeleteExpenseRequest;
import com.ggv.wallet.service.ExpenseService;
import com.ggv.wallet.usecase.CreateExpenseUseCase;
import com.ggv.wallet.usecase.DeleteExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @PostMapping("/v1/wallet/expense")
    public ResponseEntity<Void> createExpense(
            @Valid @RequestBody CreateExpenseDto.Request request
    ) {
        Long userId = 1L; // TODO 로그인 기능 구현되면 수정
        CreateExpenseUseCase useCase = request.toUseCase(userId);
        expenseService.saveExpense(useCase);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/wallet/expense")
    public ResponseEntity<Void> deleteExpenses(
            @Valid @RequestBody DeleteExpenseRequest request
    ) {
        Long userId = 1L; // TODO 로그인 기능 구현되면 수정
        DeleteExpenseUseCase useCase = request.toUseCase(userId);
        expenseService.deleteExpense(useCase);

        return ResponseEntity.ok().build();
    }


}
