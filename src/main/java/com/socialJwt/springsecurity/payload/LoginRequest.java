package com.socialJwt.springsecurity.payload;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**요청을 담기 위한 DTO 클래스
 * 다음 request, response 페이로드는 컨트롤러 API에서 사용됨
 * */
@Getter
public class LoginRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
