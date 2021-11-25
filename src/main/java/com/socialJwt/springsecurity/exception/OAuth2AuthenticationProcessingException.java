package com.socialJwt.springsecurity.exception;

import org.springframework.security.core.AuthenticationException;

/**OAuth2 인증과정 중에서 발생하는 exception 클래스 AuthenticationException 클래스 상속 받음*/
public class OAuth2AuthenticationProcessingException extends AuthenticationException {
    public OAuth2AuthenticationProcessingException(String msg, Throwable t) {
        super(msg, t);
    }

    public OAuth2AuthenticationProcessingException(String msg) {
        super(msg);
    }
}