package com.socialJwt.springsecurity.security.oauth2.user;

import com.socialJwt.springsecurity.exception.OAuth2AuthenticationProcessingException;
import com.socialJwt.springsecurity.model.AuthProvider;

import java.util.Map;

/**모든 소셜 로그인 정보 관리하는 클래스
 *각 플랫폼 클래스를 생성하기 위한 Factory 패턴을 사용한 클래스
 */
public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        System.err.println(attributes);
        switch (AuthProvider.valueOf(registrationId.toLowerCase())) {
            case naver:
                return new NaverOAuth2UserInfo(attributes);
            case kakao:
                return new KakaoOAuth2UserInfo(attributes);
            case google:
                return new GoogleOAuth2UserInfo(attributes);
            default:
                throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
