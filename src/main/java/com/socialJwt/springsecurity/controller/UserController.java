package com.socialJwt.springsecurity.controller;

import com.socialJwt.springsecurity.model.User;
import com.socialJwt.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** UserController 클래스에는 현재 인증된 사용자의 세부 정보를 가져오는
 * 보호된(protected) API가 포함되어있음
 * 서버에 로그인이 성공한 경우 접근 가능한 User Api
 * 내 정보를 조회하기 위해 사용되는 api(ROLE_USER로 권한 제한됨)*/
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
