# Spring-Security-JWT-Social
### Spring Security와 OAuth2 및 JWT를 활용한 일반 로그인과 소셜 로그인 예제(구글, 네이버, 카카오) <br/><br/>
![image](https://user-images.githubusercontent.com/82012938/143465535-bf660b93-3a81-4392-9ce1-c17cac9c6551.png)
### 개발환경
- Java 8
- Win10
- IntelliJ
- VS code
- MySQL
- Spring Boot
- React
### Front-end 설정
```bash
springsecurity>frontend> npm install
```                                                                                                                                         
### Back-end 설정
`application.yml`
```java
spring:
  datasource :
    driver-class-name : com.mysql.cj.jdbc.Driver
    url : jdbc:mysql://localhost:3306/{database}?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
    username : {username}
    password : {password}

    jpa :
      show-sql : true
      hibernate :
        ddl-auto : create
        naming-strategy : org.hibernate.cfg.ImprovedNamingStrategy
      properties :
        hibernate :
          format_sql : true
          dialect : org.hibernate.dialect.MySQL5InnoDBDialect

  security:
    oauth2:
      client:
        registration:
          google:
            clientId: {클라이언트ID}
            clientSecret: {클라이언트시크릿키}
            redirectUri: "{baseUrl}/oauth2/callback/{registrationId}" # http://localhost:8080/oauth2/callback/google
            scope: # 각 플랫폼마다 scope 가 다르므로 직접 방문해서 api 문서를 참고 바람
              - email
              - profile
          naver:
            clientId: {클라이언트ID}
            client-secret: {클라이언트시크릿키}
            redirect-uri: "{baseUrl}/oauth2/callback/{registrationId}" # http://localhost:8080/oauth2/callback/naver
            authorization-grant-type: authorization_code
            scope:
              - name
              - email
              - profile_image
            client-name: Naver
          kakao :
            clientId : {클라이언트ID}
            client-secret : {클라이언트시크릿키}
            redirect-uri : "{baseUrl}/oauth2/callback/{registrationId}"
            authorization-grant-type : authorization_code
            scope :
              - profile_nickname
              - profile_image
              - account_email
            client-authentication-method : POST
            client-name : kakao

        provider:
          naver:
            authorization_uri: https://nid.naver.com/oauth2.0/authorize # api 문서 참고
            token_uri: https://nid.naver.com/oauth2.0/token # api 문서 참고
            user-info-uri: https://openapi.naver.com/v1/nid/me # api 문서 참고
            user_name_attribute: response # api 문서 참고
          kakao :
            authorization_uri : https://kauth.kakao.com/oauth/authorize # api 문서 참고
            token_uri : https://kauth.kakao.com/oauth/token # api 문서 참고
            user-info-uri : https://kapi.kakao.com/v2/user/me # api 문서 참고
            user_name_attribute : id # api 문서 참고
app:
  auth:
    tokenSecret: 926D96C90030DD58429D2751AC1BDBBC # JWT를 암호화 하기 위한 암호화 키 (32글자면 된다)
    tokenExpirationMsec: 864000000  # token 만료 기간 (24h * 60min * 60s * 1000ms)
  oauth2:
    # OAuth2 공급자로 성공적으로 인증 한 후 사용자에 대한 인증 토큰을 생성하고 토큰을
    # 프론트 엔드 클라이언트가 /oauth2/authorize 요청에서 지정한 redirectUri 입니다.
    # 쿠키는 모바일 클라이언트에서 잘 작동하지 않기 때문에 사용하지 않습니다
    authorizedRedirectUris:
      - http://localhost:3000/oauth2/redirect
      - myandroidapp://oauth2/redirect
      - myiosapp://oauth2/redirect
```    

                                                                                                                                         
                                                                                                                                      
                                                                                                                                         
