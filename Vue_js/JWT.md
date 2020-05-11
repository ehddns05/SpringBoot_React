##  Token  
 : Json을 이용하여 사용자 속성을 저장하는 web token   
 * **특징**  
   * stateless : 클라이언트 상태를 유지하지 않고, 요청만을 처리. 즉, 클라이언트와 서버간의 연결고리가 없기 때문에 확장성이 높다.      

   ※stateful이란 클라이언트 상태를 유지하고 정보를 제공하는 상태(session 유지)   

   * 보안성 향상 
  
 * **장점**  

  1.  stateless상태이므로 token을 클라이언트쪽에 저장하기 때문에 서버확장에 용이
  2.  cookie를 전달하지 않으므로 보안성 향상
  3.  여러가지 플렛폼, 도메인을 가리지 않고 적용 할 수 있다.
  4.  웹표준 기반으로 RFC 7519 에 등록되었다.   

 * **기존 서버 기반 인증의 문제점**  
    * session : 유저 수가 많을 시 데이터베이스 성능에 무리가 생길 수 있다.
    * 확장성(expandability) : 세션 사용시 서버 확장이 난해하다.
    * CORS(Cross-Origin Resource sharing) :  이해가 안됨...ㅜ,ㅡ



 ##  JWT(Json Web Token)  
 : Json을 이용하여 사용자 속성을 저장하는 web token   

* **형태** : aaaaa.bbbbb.ccccc   
            =>헤더(header).내용(payload).서명(signature)

      1. 헤더(header)
        *  typ : JWT         
        *  alg : 해싱 알고리즘 지정, 토큰 검증시 signature부분에서 사용됨.  

      2. 내용(payload) - 토큰에 담을 정보 저장. 
            이때, 정보의 한조각을 claim이라고 하고 name,value 한쌍으로 이루어져 있다.  

        *  registered claim : 토큰에 담을 정보 중 이미 이름이 정해진 claim
            (optional 선택적 사용)  

            (1)iss - 토큰발급자 issuer 
            (2)sub - 토큰 제목 subject
            (3)aud - 토큰 대상자 audience
            (4)exp - 토큰 만료 시간 expiration (반드시 현재 이후일것)
            (5)nbf - 토큰 활성화 날짜로 날짜가 안지나면 처리되지 않음 not Before
            (6)iat - 토큰 발급 시간 issued at
            (7)jti - JWT고유 식별자로, 중복처리 방지용 

        *  public claim : 충돌 방지용 이름을 가지고 있어야하며 URL형태이다.        
        *  private claim : 서버, 클라이언트간 협의하에 사용되는 클레임

```
// Example
{
    "iss": "dongdong.com",
    "exp": "1485270000000",
    "https://dongdong.com/jwt_claims/is_admin": true,
    "userId": "11028373727102",
    "username": "dong"
}
```  

      3. 서명(signature) - 헤더의 인코딩값과, 정보의 인코딩값을 합친후 주어진 비밀키로 해쉬를 하여 생성. 




 참조 사이트 

>  https://velopert.com/2350  
>  https://velopert.com/2389