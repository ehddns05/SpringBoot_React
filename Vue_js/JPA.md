##  JPA 
 : java의 ERM표준으로 인터페이스의 모음이다.  
 jpa를 구현한 대표적인 구현체는 Hibernate, EclipseLink, DataNucleus이다.


 * 특징  
   * JPA는 app과 JDBC사이에서 동작한다. 
   * entity정보를 바탕으로 sql생성, DB부터 결과값을 받아와 맵핑한다.
    <img width="600" src="https://gmlwjd9405.github.io/images/inflearn-jpa/jpa-insert-structure.png" >  
   
 * 간단한 사용법  
   * 저장 - jpa.persist(entity)
   * 조회 - jpa.find(entity)   
   * 저장 - entity.setName("name info")   
   * 저장 - jpa.remove(entity)

참조 사이트 

>  https://gmlwjd9405.github.io/2019/08/04/what-is-jpa.html  