package com.ggv.externalclient.auth;

import com.ggv.domain.auth.Account;
import com.ggv.domain.auth.AuthPlatform;
import com.ggv.domain.auth.Token;

public interface OauthClient {
    AuthPlatform getPlatform();

    Token getToken(String code);

    Account getAccount(Token token);
}
