package com.ggv.infra.wallet.repository;

import com.ggv.domain.wallet.UserExpense;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends JpaRepository<UserExpense, Long> {

    @Modifying
    @Query("DELETE FROM UserExpense expense WHERE expense.userId = :userId AND expense.id IN :ids")
    void deleteByUserIdAndIdIn(@Param("userId") Long userId, @Param("ids") List<Long> ids);
}
