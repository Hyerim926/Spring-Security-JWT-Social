package com.socialJwt.springsecurity.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

//앱 접두사가 붙은 모든 구성을 POJO클래스에 바인딩
@Getter
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private final Auth auth = new Auth();
    private final OAuth2 oauth2 = new OAuth2();

    @Getter
    @Setter //JWT 토큰의 암호키와 만료기간 설정 시 사용
    public static class Auth {
        private String tokenSecret;
        private long tokenExpirationMsec;
    }

    @Getter //프론트엔드 클라이언트가 /oauth2/authorize 요청에서 지정한 redirectUri
    public static final class OAuth2 {
        private List<String> authorizedRedirectUris = new ArrayList<>();

        public OAuth2 authorizedRedirectUris(List<String> authorizedRedirectUris) {
            this.authorizedRedirectUris = authorizedRedirectUris;
            return this;
        }
    }

}