package com.socialJwt.springsecurity.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;

/**SecurityContextHolder.getContext().getAuthentication().getPrincipal() 을 통해 UserPrincipal 을
 가져오던 것을 간단하게 처리하기 위해 만들어진 어노테이션
 물론 @AuthenticationPrincipal  로 가능 하지만 더 짧고 명확한 명칭을 주기 위해 만든 것 뿐
 */
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@AuthenticationPrincipal
public @interface CurrentUser {
}
