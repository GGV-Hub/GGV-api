package com.ggv.domain.auth;

import com.ggv.domain.auth.usecase.SignUpUseCase;
import com.ggv.externalclient.auth.OauthClient;
import com.ggv.infra.auth.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final List<OauthClient> clients;
    private final AuthRepository repository;

    public Long createAccount(SignUpUseCase useCase) {
        Optional<OauthClient> requestedClient = null;
        switch (useCase.type()) {
            case NAVER -> requestedClient = clients.stream().filter(it -> it.getPlatform() == AuthPlatform.NAVER).findFirst();
        }

        OauthClient client = requestedClient.orElseThrow();
        Token token = client.getToken(useCase.code());
        Account account = client.getAccount(token);

        return repository.insert(account);
    }
}
