package com.ggv.infra.auth;

import com.ggv.infra.auth.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDataClient extends JpaRepository<AccountEntity, Long> {
}
