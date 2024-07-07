package com.ggv.auth.account.dto;

public record CreateAccountDto(
    String socialType,
    String code
) {
}
