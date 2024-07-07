package com.ggv.externalclient.auth.dto;

public enum NaverGrantType {
    AUTHORIZATION_CODE("authorization_code"),
    REFRESH_TOKEN("refresh_token"),
    DELETE("delete");

    private String grantType;

    NaverGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getGrantType() {
        return grantType;
    }
}
