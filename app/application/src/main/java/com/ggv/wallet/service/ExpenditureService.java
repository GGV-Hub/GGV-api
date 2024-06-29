package com.ggv.wallet.service;

import com.ggv.wallet.repository.ExpenditureRepository;
import com.ggv.wallet.usecase.CreateExpenditureUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExpenditureService {

    private final ExpenditureRepository expenditureRepository;

    @Transactional
    public void saveExpenditure(CreateExpenditureUseCase useCase) {
        expenditureRepository.save(useCase.toEntity());
    }
}
