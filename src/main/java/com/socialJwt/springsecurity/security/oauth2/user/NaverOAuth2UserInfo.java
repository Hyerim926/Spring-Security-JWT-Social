package com.socialJwt.springsecurity.security.oauth2.user;

import java.util.Map;

/** 네이버에 요청하여 유저 정보를 응답 받는 클래스
 * {
 *   resultcode=00,
 *   message=success,
 *   response={
 *     id=아이디,
 *     profile_image=이미지주소.png,
 *     email=이메일, name=이름
 *   }
 * }
 */
public class NaverOAuth2UserInfo extends OAuth2UserInfo{

    /** naver 는 response 안에 담겨져있기 때문에 response 를 해준다 */
    public NaverOAuth2UserInfo(Map<String, Object> attributes) {
        super((Map<String, Object>) attributes.get("response"));
    }

    @Override
    public String getId() {
        return (String) attributes.get("id");
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
        return (String) attributes.get("profile_image");
    }
}
