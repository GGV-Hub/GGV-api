package com.ggv.domain.auth;

import java.time.ZonedDateTime;

public class Token {
    private AuthPlatform platform;
    private String accessToken;
    private String refreshToken;
    private ZonedDateTime createdAt;
    private ZonedDateTime expiresAt;

    public AuthPlatform getPlatform() {
        return platform;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getExpiresAt() {
        return expiresAt;
    }

    private Token() {
    }

    private Token(AuthPlatform platform, String accessToken, String refreshToken, ZonedDateTime createdAt, ZonedDateTime expiresAt) {
        this.platform = platform;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public static Token create(AuthPlatform platform, String accessToken, String refreshToken, ZonedDateTime expiresAt) {
        return new Token(
                platform,
                accessToken,
                refreshToken,
                ZonedDateTime.now(),
                expiresAt
        );
    }
}
