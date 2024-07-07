package com.ggv.wallet.expenditures.controller;

import com.ggv.wallet.expenditures.dto.CreateExpenseDto;
import com.ggv.wallet.service.ExpenseService;
import com.ggv.wallet.usecase.CreateExpenseUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
        expenseService.saveExpenditure(useCase);

        return ResponseEntity.ok().build();
    }


}
