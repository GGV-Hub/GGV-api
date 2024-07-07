package com.ggv.infra.auth.entity;

import com.ggv.domain.auth.Account;
import com.ggv.domain.auth.AccountId;
import com.ggv.domain.auth.AccountKey;
import com.ggv.domain.auth.AuthPlatform;
import com.ggv.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountEntity extends BaseEntity {

    @Id
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String profileImage;

    @Column(nullable = false)
    private AuthPlatform platform;

    @Builder
    private AccountEntity(long id, String key, String email, String nickname, String profileImage, AuthPlatform platform) {
        this.id = id;
        this.key = key;
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.platform = platform;
    }

    public Account toDomain() {
        return new Account(
                new AccountId(id),
                new AccountKey(key),
                this.email,
                this.nickname,
                this.profileImage,
                this.platform
        );
    }

    public static AccountEntity toEntity(Account account) {
        return new AccountEntity(
                account.getId().value(),
                account.getKey().value(),
                account.getEmail(),
                account.getNickname(),
                account.getProfileImage(),
                account.getPlatform()
        );
    }
}
