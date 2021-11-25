package com.socialJwt.springsecurity.security.oauth2.user;

import java.util.Map;

/** 각 플랫폼 확장성을 위한 추상 클래스
 * 모든 OAuth2 공급자는 인증된 사용자의 세부 정보를 가져올 때 다른 JSON 응답을 반환함
 * 스프링 시큐리티는 키-값 쌍의 일반 Map 형식으로 응답을 구문 분석함
 * 이 클래스가 키-값 쌍의 일반 Map에서 사용자의 필수 세부 상항을 가져오는 데 사용됨*/
public abstract class OAuth2UserInfo {
    protected Map<String, Object> attributes;

    public OAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public abstract String getId();
    public abstract String getName();
    public abstract String getEmail();
    public abstract String getImageUrl();
}
