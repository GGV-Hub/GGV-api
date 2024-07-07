package com.ggv.infra.wallet.repository;

import com.ggv.domain.wallet.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
