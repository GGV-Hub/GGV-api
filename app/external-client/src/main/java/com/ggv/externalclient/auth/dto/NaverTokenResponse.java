package com.ggv.externalclient.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NaverTokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final String tokenType;
    private final long expiresIn;
}
