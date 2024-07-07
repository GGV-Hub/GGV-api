package com.ggv.externalclient.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "oauth.naver")
record NaverOauthProperties(
    String clientId,
    String clientSecret,
    String redirectUri
) {
}
