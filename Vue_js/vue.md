# Vue.Js란

1. 특징
 * 엄격히 MVVM 패턴과 관련이 없지만 Vue의 디자인은 부분적으로 그것에 영감을 받음.
 * Virtual DOM을 사용한 빠른 Dom 핸들링
 * 뷰의 단위를 Conponent형태로 관리
 * Vue 인스턴스는 data 객체에 있는 모든 속성을 프록시 처리
#  

2. Life Cycle   
생명주기는 4단계로 나누어 진다
* Creation : 컴포넌트 초기화 단계
* Mounting : Dom 작성 단계
* Updating : 상태 변화로 인한 렌더링 단계
* Destruction : 소멸 단계  

<img width="500" src="https://kr.vuejs.org/images/lifecycle.png" alt="view-model.png" >   

#  

3. Vue Instance

|옵션|설명|설명|
|------|--------------------------------|-------------------|
|el|HTML의 DOM 요소 지정(태그에 지정한 ID, 클래스명, 태그명)||
|data|data 객체를 지정(key와 value를 지정하는 json형식)||
|computed|함수로 정의하고 계산된 값을 리턴해 줌. methods와 차이점은 캐싱(저장)을 시켜놓고 동일한 요청이 올 경우는 함수를 실행하지 않고 캐싱된 값만 리턴해 줌|화살표함수 사용지양|
|methods|함수로 정의하고 계산된 값을 리턴해 줌. computed와 차이점은 캐싱(저장)이 되지 않고 호출될때마다 계속 함수를 실행함|화살표함수 사용지양|
|watch|지정된 변수의 값이 변경되었을때 정의된 함수를 실행시킴||  
#  

4. 문법들  

    4-1. 디렉티브    
    *  **「v-」**접두사가 있는 특수 속성.  
    표현식의 값이 변경될 때 사이드이펙트를 반응적으로 DOM에 적용.  즉, 동적으로 binding  
    EX) ```<span v-bind:title="message">```  

    4-2. 문자열  
    *  데이터 바인딩의 가장 기본 형태는 “Mustache” 구문(이중 중괄호)  
    EX) ```<span>메시지: {{ msg }}</span>```  

    4-3. 속성  
    *  Mustaches는 HTML 속성에서 사용할 수 없으므로 **v-bind 디렉티브**를 사용  
    EX) ```<div v-bind:id="dynamicId"></div>```  

    4-4. 수식어  
    *  특수 접미사로, 디렉티브를 특별한 방법으로 바인딩 해야 함을 나타낸다.  
    EX) ```<form v-on:submit.prevent="onSubmit"> ... </form>```  

#  

5. Vue Components  
화면의 영역을 일정한 단위로 쪼개어 재활용 가능한 형태로 관리

* 특징  
  +  부모 자식의 관계를 가진다.
  +  부모 자식간 props, event emit  

  <img width="250" src="https://kr.vuejs.org/images/props-events.png" alt="view-model.png" >  

    ####  props  
    * 부모가 props를 통해 자식에게 데이터를 전달
    * 하위 컴포넌트의 템플릿에서 상위 데이터를 직접 참조 할 수 없으므로 props로 전달

    ####  event emit  
    * 자식은 events를 통해 부모에게 메시지를 전달


#  
 참조 사이트 

>  https://wikidocs.net/17701  