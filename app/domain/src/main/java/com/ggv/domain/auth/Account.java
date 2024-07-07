package com.ggv.domain.auth;

import java.time.ZonedDateTime;

public class Account {
    private final AccountId id;
    private final AccountKey key;
    private final String email;
    private final String nickname;
    private final String profileImage;
    private final AuthPlatform platform;

    public AccountId getId() {
        return id;
    }

    public AccountKey getKey() {
        return key;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public AuthPlatform getPlatform() {
        return platform;
    }

    public Account(AccountId id, AccountKey key, String email, String nickname, String profileImage, AuthPlatform platform) {
        this.id = id;
        this.key = key;
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.platform = platform;
    }

    public static Account create(
            String key,
            String email,
            String nickname,
            String profileImage,
            AuthPlatform platform
    ) {
        return new Account(
                null,
                new AccountKey(key),
                email,
                nickname,
                profileImage,
                platform
        );
    }
}
