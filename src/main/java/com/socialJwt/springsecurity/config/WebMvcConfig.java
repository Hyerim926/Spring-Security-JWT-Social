package com.socialJwt.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**프론트엔드 클라이언트가 다른 출처의 API에 엑세스할 수 있도록 CORS를 활성화 - 클라이언트와 백단의 포트가 달라서 CORS 충돌 발생
 *다음 구성에서 모든 origin을 활성화함
 *cors를 설정할 때 사용 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") //외부에서 들어오는 모든 url들 허용(보통은 파트너 또는 api를 사용하는 곳만 열어둠)
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
                .allowedHeaders("*") //허용되는 헤더 정의
                .allowCredentials(true) //자격증명 허용
                .maxAge(MAX_AGE_SECS); //최대 1시간 허용
    }
}
