package com.ggv.externalclient.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ggv.domain.auth.Account;
import com.ggv.domain.auth.AuthPlatform;
import com.ggv.domain.auth.Token;
import com.ggv.externalclient.auth.dto.NaverAccountData;
import com.ggv.externalclient.auth.dto.NaverAccountResponse;
import com.ggv.externalclient.auth.dto.NaverGrantType;
import com.ggv.externalclient.auth.dto.NaverTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NaverOauthClient implements OauthClient {
    public AuthPlatform platform = AuthPlatform.NAVER;
    private final NaverOauthProperties properties;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String tokenUrl = "https://nid.naver.com/oauth2.0/token";
    private final String accountUrl = "https://openapi.naver.com/v1/nid/me";

    @Override
    public Token getToken(String code) {
        ZonedDateTime now = ZonedDateTime.now();

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", NaverGrantType.AUTHORIZATION_CODE.getGrantType());
        requestBody.add("client_id", properties.clientId());
        requestBody.add("client_secret", properties.clientSecret());
        requestBody.add("code", code);

        NaverTokenResponse response;
        try {
            response = restTemplate.postForObject(tokenUrl, requestBody, NaverTokenResponse.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("네이버 로그인 정보를 가져올 수 없습니다.", e);
        }

        if (Objects.isNull(response)) {
            throw new RuntimeException("네이버 로그인 정보를 가져올 수 없습니다.");
        }

        return Token.create(
                AuthPlatform.NAVER,
                response.getAccessToken(),
                response.getRefreshToken(),
                now.plusSeconds(response.getExpiresIn())
        );
    }

    @Override
    public Account getAccount(Token token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token.getAccessToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        NaverAccountResponse response;
        try {
            ResponseEntity<NaverAccountResponse> responseEntity = restTemplate.exchange(accountUrl, HttpMethod.GET, entity, NaverAccountResponse.class);
            response = responseEntity.getBody();
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("네이버 계정 정보를 가져올 수 없습니다.", e);
        }

        if (Objects.isNull(response)) {
            throw new RuntimeException("네이버 계정 정보를 가져올 수 없습니다.");
        }

        NaverAccountData data = response.getResponse();

        return Account.create(
                data.id(),
                data.email(),
                data.nickname(),
                data.profileImage(),
                ZonedDateTime.now()
        );
    }
}
