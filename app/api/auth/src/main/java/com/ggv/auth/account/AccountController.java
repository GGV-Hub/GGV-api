package com.ggv.auth.account;

import com.ggv.auth.account.dto.CreateAccountDto;
import com.ggv.auth.model.base.HttpApiResponse;
import com.ggv.auth.model.base.IdResponse;
import com.ggv.domain.auth.AuthPlatform;
import com.ggv.domain.auth.AuthService;
import com.ggv.domain.auth.usecase.SignUpUseCase;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AuthService authService;

    @PostMapping("/v1/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpApiResponse createAccount(
            @RequestBody CreateAccountDto request,
            HttpServletResponse response
    ) {
        Long newAccountId = authService.createAccount(
                new SignUpUseCase(
                        request.code(),
                        AuthPlatform.valueOf(request.socialType())
                )
        );
        return new IdResponse(newAccountId);
    }
}
