package com.ggv.auth.model.base;

import lombok.Getter;

@Getter
public record HttpErrorResponse(String code, Object data) implements HttpApiResponse{

    public static HttpErrorResponse of(String code, Object data) {
        return new HttpErrorResponse(code, data);
    }
}
