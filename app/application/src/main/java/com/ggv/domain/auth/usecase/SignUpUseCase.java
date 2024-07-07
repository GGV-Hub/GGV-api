package com.ggv.domain.auth.usecase;

import com.ggv.domain.auth.AuthPlatform;

public record SignUpUseCase(
    String code,
    AuthPlatform type
) {
}
