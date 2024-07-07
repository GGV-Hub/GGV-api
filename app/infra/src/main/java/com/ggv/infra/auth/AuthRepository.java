package com.ggv.infra.auth;

import com.ggv.domain.auth.Account;
import com.ggv.infra.auth.entity.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthRepository {
    private final AuthDataClient dataClient;

    public Long insert (Account account) {
        AccountEntity saved = dataClient.save(AccountEntity.toEntity(account));
        return saved.getId();
    }
}
