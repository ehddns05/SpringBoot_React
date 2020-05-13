##  Spring Security  
 : Spring Security Framework  

※용어
  1. Principal(주체)
  2. Authentication(인증) - 사용자 본인 확인 절차
  3. Authorize(인가) - 인증된 사용자가 접근 가능한지(권한) 결정
  4. Authority(권한)

* **Login Flow**

  1. 로그인 정보를 입력하고 인증 요청  

  2. AuthenticationFilter(사용할 구현체 UsernamePasswordAuthenticationFilter)가 HttpServletRequest에서 사용자가 보낸 아이디와 패스워드를 인터셉트한다. AuthenticationManager 인터페이스(구현체 - ProviderManager)에게 인증용 객체(UsernamePasswordAuthenticationToken)로 만들어줘서 위임한다.  

  3. AuthenticationFilter로부터 인증용 객체(UsernamePasswordAuthenticationToken)을 전달받는다.  

  4. 실제 인증을 할 AuthenticationProvider에게 Authentication객체(UsernamePasswordAuthenticationToken)을 다시 전달한다.  

  5. DB에서 사용자 인증 정보를 가져올 UserDetailsService 객체에게 사용자 아이디를 넘겨주고 DB에서 인증에 사용할 사용자 정보(사용자 아이디, 암호화된 패스워드, 권한 등)를 UserDetails(인증용 객체와 도메인 객체를 분리하지 않기 위해서 실제 사용되는 도메인 객체에 UserDetails를 상속하기도 한다.)라는 객체로 전달 받는다.  

  6. AuthenticationProvider는 UserDetails 객체를 전달 받아 실제 사용자의 입력정보와 UserDetails 객체를 가지고 인증을 시도한다.  

  7. (그림 8, 9, 10) 인증이 완료되면 사용자 정보를 가진 Authentication 객체를 SecurityContextHolder에 담은 이후 AuthenticationSuccessHandle를 실행한다.(실패시 AuthenticationFailureHandler를 실행한다.)  

    ※ Authentication에 사용자 정보 보관

 <img width="500" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FkSN2h%2FbtquDLF3geH%2Fumf8frkg8cc9pRDq9TgUz1%2Fimg.png" alt="view-model.png" >  



 * **AuthenticationManager**  
  : Spring Security Framework  
   * stateless : 클라이언트 상태를 유지하지 않고, 요청만을 처리. 즉, 클라이언트와 서버간의 연결고리가 없기 때문에 확장성이 높다.      

   ※stateful이란 클라이언트 상태를 유지하고 정보를 제공하는 상태(session 유지)   

   * 보안성 향상 


#    
 ※ 각종 Handler 참조용

  * AuthenticationSuccessHandler : AuthenticationFilter에서 인증 성공시 수행되는 Handler. 성공시 해당 페이지로 리다이렉트 

  * AuthenticationFailureHandler : 로그실 실패시 수행되는 Handler. 성공시 해당 페이지로 리다이렉트

  * LogoutSuccessHandler : 로그아웃 성공시 수행되는 Handler. 성공시 해당 페이지로 리다이렉트 

  * AccessDeniedHandler : 권한체크 실패시 수행되는 Handler. 에러코드와 메시지를 HttpServletResponse에 담아서 반환
 
  * AuthenticationEntryPoint : 인증되지 않은 익명의 사용자가 보호된 리소스에 접근하였을 때, 수행되는 EntryPoint Handler.

  * JwtAuthenticationFilter : Login시 걸리는 Filter이다. UsernamePasswordAuthenticationFilter를 상속. 이 필터는 HttpServletRequest에서 사용자가 Form으로 입력한 로그인 정보를 인터셉트해서 AuthenticationManager에게 Authentication 객체를 넘겨준다.

  * JwtAuthorizationFilter : Login 인증된 이후의 요청에 대해 Header 인증을 담당할 Filter이다. BasicAuthenticationFilter를 상속. JWT 기반 인증에서 실제 JWT 토큰의 인증이 이루어질 필터 부분이다.

  * UserDetailsService : AuthenticationProvider 구현체에서 인증에 사용할 사용자 인증정보를 DB에서 가져오는 역할

  * PasswordEncoder : 암호화 알고리즘 encoder 역할

  * AuthenticationProvider : 실제 인증이 일어나는 클래스이다. UserDetailsService에게 입력받은 사용자 아이디를 넘겨 DB에서 사용자 인증 정보를 받고 암호화된 패스워드를 비교하기 위하여 PasswordEncoder에게 사용자가 입력한 평문 패스워드를 전달해 암호화된 형태로 받아서 암호화<->암호화 형태로 비밀번호를 비교한다. 만약 인증이 완료되면 Authentication객체를 구현한 UsernamePasswordAuthenticationToken객체를 반환한다. 


#    
 ※ 각종 Filter 참조용

  * SecurityContextPersistenceFilter : SecurityContextRepository에서 SecurityContext를 가져오거나 저장하는 역할을 한다. (SecurityContext는 밑에)
  * LogoutFilter : 설정된 로그아웃 URL로 오는 요청을 감시하며, 해당 유저를 로그아웃 처리
  * (UsernamePassword)AuthenticationFilter : (아이디와 비밀번호를 사용하는 form 기반 인증) 설정된 로그인 URL로 오는 요청을 감시하며, 유저 인증 처리
    * AuthenticationManager를 통한 인증 실행
    * 인증 성공 시, 얻은 Authentication 객체를 SecurityContext에 저장 후 AuthenticationSuccessHandler 실행
    * 인증 실패 시, AuthenticationFailureHandler 실행
  * DefaultLoginPageGeneratingFilter : 인증을 위한 로그인폼 URL을 감시한다.
  * BasicAuthenticationFilter : HTTP 기본 인증 헤더를 감시하여 처리한다.
  * RequestCacheAwareFilter : 로그인 성공 후, 원래 요청 정보를 재구성하기 위해 사용된다.
  * SecurityContextHolderAwareRequestFilter : HttpServletRequestWrapper를 상속한 SecurityContextHolderAwareRequestWapper 클래스로 HttpServletRequest 정보를 감싼다. SecurityContextHolderAwareRequestWrapper 클래스는 필터 체인상의 다음 필터들에게 부가정보를 제공한다.
  * AnonymousAuthenticationFilter : 이 필터가 호출되는 시점까지 사용자 정보가 인증되지 않았다면 인증토큰에 사용자가 익명 사용자로 나타난다.
  * SessionManagementFilter : 이 필터는 인증된 사용자와 관련된 모든 세션을 추적한다.
  * ExceptionTranslationFilter : 이 필터는 보호된 요청을 처리하는 중에 발생할 수 있는 예외를 위임하거나 전달하는 역할을 한다.
  * FilterSecurityInterceptor : 이 필터는 AccessDecisionManager 로 권한부여 처리를 위임함으로써 접근 제어 결정을 쉽게해준다.

#  

   
 참조 사이트 

>  https://coding-start.tistory.com/153  
>  https://velog.io/@minholee_93/Spring-Security-JWT-Security-Spring-Boot-10