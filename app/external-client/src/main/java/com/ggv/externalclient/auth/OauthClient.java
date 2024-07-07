package com.ggv.externalclient.auth;

import com.ggv.domain.auth.Account;
import com.ggv.domain.auth.Token;

public interface OauthClient {
    Token getToken(String code, String state);

    Account getAccount(Token token);
}
