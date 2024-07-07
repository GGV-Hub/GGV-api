package com.ggv.infra.wallet.repository;

import com.ggv.domain.wallet.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<UserExpense, Long> {
}
