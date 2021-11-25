package com.socialJwt.springsecurity.model;

/**각 플랫폼명을 String이 아닌 Enum으로 관리하기 위한 클래스*/
public enum AuthProvider {
    local,
    google,
    naver,
    kakao
}

