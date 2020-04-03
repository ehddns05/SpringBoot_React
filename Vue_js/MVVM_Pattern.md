# MVVM 패턴( Model-View-ViewModel )

* 로직과 UI의 분리를 위해 설계된 패턴  
  
웹페이지는 돔과 자바스크립트로 만들어지는데 돔이 View 역할, 자바스크립트가 Model 역할을 한다.  
이때, 직접 모델과 뷰를 연결하는 것이 MVVM이다.  

<img width="500" src="https://wikidocs.net/images/page/17701/view-model.png" alt="view-model.png" >  

 * Flow  
   +  view의 요청을 ViewModel이 받아서 Model에 Data를 요청
   +  전달받은 Data를 ViewModel에서 가공
   +  view에서는 ViewModel과의 Data Binding을 통해 데이터를 자동으로 갱신  

 -  Data Binding : 뷰와 뷰모델의 상태를 동기화한다.  
                뷰모델의 상태가 변경되면 뷰의 상태가 함께 변경됨 (반대도 적용)
   
#  
#  

참조 사이트 

>  https://wikidocs.net/17701  
>  https://justhackem.wordpress.com/2017/03/05/mvvm-architectural-pattern/