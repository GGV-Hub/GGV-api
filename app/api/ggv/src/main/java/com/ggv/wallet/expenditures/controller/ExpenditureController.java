package com.ggv.wallet.expenditures.controller;

import com.ggv.wallet.expenditures.dto.CreateExpenditureDto;
import com.ggv.wallet.service.ExpenditureService;
import com.ggv.wallet.usecase.CreateExpenditureUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExpenditureController {

    private final ExpenditureService expenditureService;

    @PostMapping("/v1/wallet/expenditures")
    public ResponseEntity<Void> createExpenditures(
            @Valid @RequestBody CreateExpenditureDto.Request request
    ) {
        Long userId = 1L; // TODO 로그인 기능 구현되면 수정
        CreateExpenditureUseCase useCase = request.toUseCase(userId);
        expenditureService.saveExpenditure(useCase);

        return ResponseEntity.ok().build();
    }


}
