#### Vue.Js란

1. 특징
 * MVVM 패턴의 ViewModel 레이어에 해당하는 화면단 라이브러리
 * Virtual DOM을 사용한 빠른 Dom 핸들링
 * 뷰의 단위를 Conponent형태로 관리
#  

2. Life Cycle   
생명주기는 4단계로 나누어 진다
* Creation : 컴포넌트 초기화 단계
* Mounting : Dom 작성 단계
* Updating : 상태 변화로 인한 렌더링 단계
* Destruction : 소멸 단계  

<img width="500" src="https://wikidocs.net/images/page/17701/vue%EC%9D%B8%EC%8A%A4%ED%84%B4%EC%8A%A4_%EB%9D%BC%EC%9D%B4%ED%94%84_%EC%82%AC%EC%9D%B4%ED%81%B4.jpg" alt="view-model.png" >   

#  

3. Vue Instance

|옵션|설명|설명|
|------|--------------------------------|-------------------|
|el|HTML의 DOM 요소 지정(태그에 지정한 ID, 클래스명, 태그명)||
|data|data 객체를 지정(key와 value를 지정하는 json형식)||
|computed|함수로 정의하고 계산된 값을 리턴해 줌. methods와 차이점은 캐싱을 시켜놓고 동일한 요청이 올 경우는 함수를 실행하지 않고 캐싱된 값만 리턴해 줌|화살표함수 사용지양|
|methods|함수로 정의하고 계산된 값을 리턴해 줌. computed와 차이점은 캐싱이 되지 않고 호출될때마다 계속 함수를 실행함|화살표함수 사용지양|
|watch|지정된 변수의 값이 변경되었을때 정의된 함수를 실행시킴||

  
#  
 참조 사이트 

>  https://wikidocs.net/17701  