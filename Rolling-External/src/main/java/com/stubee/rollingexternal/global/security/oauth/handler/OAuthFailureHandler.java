package com.stubee.rollingexternal.global.security.oauth.handler;

import com.stubee.rollingexternal.global.exception.security.OAuthFailException;
import com.stubee.rollingexternal.global.cookie.CookieAuthorizationRequestRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private final CookieAuthorizationRequestRepository cookieAuthorizationRequestRepository;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) {
        cookieAuthorizationRequestRepository.removeAuthorizationRequestCookies();

        throw OAuthFailException.EXCEPTION;
    }

}