package com.ggv.externalclient.auth.dto;

public record NaverAccountData(
        String id,
        String nickname,
        String name,
        String email,
        String genter,
        String age,
        String profileImage,
        String birthyear
) {
}
