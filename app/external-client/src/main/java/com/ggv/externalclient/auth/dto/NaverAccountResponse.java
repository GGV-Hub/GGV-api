package com.ggv.externalclient.auth.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NaverAccountResponse {
    String resultCode;
    String message;
    NaverAccountData response;
}
