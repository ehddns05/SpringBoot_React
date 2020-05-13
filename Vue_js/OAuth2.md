##  OAuth2  
 : 사용자가 가입된 서비스의 API에 접근하기 위해서는 사용자로부터 권한을 위임 받아야 합니다. 이 때 사용자의 패스워드 없이도 권한을 위임 받을 수 있는 방법(토큰을 발행받아 작업)


 Ex) google, facebook 등의 기능 사용가능   


 ※용어
  1. Resource server - 자원을 호스팅해주는 서버(google, facebook 등)
  2. Resource owner(사용자) - 사용자 본인 확인 절차
  3. client(인가) - Resource server에서 자원을 받아 사용하는 애플리케이션
  4. Authorization Server - 권한을 부여하는 서버. 일반적으로 Resource Server와 묶어 생각함
