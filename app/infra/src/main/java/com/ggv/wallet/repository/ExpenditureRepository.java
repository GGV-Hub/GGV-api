package com.ggv.wallet.repository;

import com.ggv.wallet.Expenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenditureRepository extends JpaRepository<Expenditure, Long> {
}
