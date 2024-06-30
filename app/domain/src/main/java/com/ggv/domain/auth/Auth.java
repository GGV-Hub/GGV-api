package com.ggv.domain.auth;

import jakarta.inject.Named;

@Named
class Auth {
    private AuthPlatform platform;
    private String accessToken;
    private String refreshToken;
    private String createdAt;
    private String expiresAt;

    public AuthPlatform getPlatform() {
        return platform;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    private Auth() {
    }

    private Auth(AuthPlatform platform, String accessToken, String refreshToken, String createdAt, String expiresAt) {
        this.platform = platform;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }

    public static Auth createFromGoogle(String accessToken, String refreshToken, String createdAt, String expiresAt) {
        return new Auth(
                AuthPlatform.GOOGLE,
                accessToken,
                refreshToken,
                createdAt,
                expiresAt
        );
    }
}
