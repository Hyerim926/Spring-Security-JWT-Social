package com.socialJwt.springsecurity.security.oauth2.user;

import java.util.Map;

/**구글에 요청하여 유저 정보를 응답 받는 클래스*/
public class GoogleOAuth2UserInfo extends OAuth2UserInfo {
    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
    }
    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }
    @Override
    public String getName() {
        return (String) attributes.get("name");
    }
    @Override
    public String getEmail() {
        return (String) attributes.get("email");
    }
    @Override
    public String getImageUrl() {
        return (String) attributes.get("picture");
    }
}