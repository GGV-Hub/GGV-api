package com.ggv.auth.model.base;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class IdResponse implements HttpApiResponse {
    private final Long id;
}
