package com.socialJwt.springsecurity.payload;

import lombok.Getter;
import lombok.Setter;

/**응답을 반환하기 위한 DTO 클래스*/
@Getter
@Setter
public class AuthResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}