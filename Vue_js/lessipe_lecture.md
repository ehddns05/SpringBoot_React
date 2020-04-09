 ##  v-model  
 : input태그의 값과 javascript 변수값이 동기화 된다.(vue의 변수)   

   ``<input type="text" v-model="text" />``
```
data(){      
  return {
    text : "test"
  }
}
```  

➡ input 태그의 출력값 : test 

※ {{ text }} 역시 test가 출력 됨.   

#  

 ##  v-for 
 : 반복문  

 ```
 <ul v-for="item in items">
  {{item.id}} 
  //태그의 attribute에 값 대입시
  <img :src="item.photo">
</ul>
```  

```
data(){
  items : 
    [
      { 
        id : 1,
        photo : 'www.xxx.jpg'
      }
    ]
}
```
  
※ template : 하나 이상의 태그로 나누어 졌을때 묶어줌 　

⇩⇩⇩⇩⇩⇩⇩⇩⇩

 ```
<ul>
  <template v-for="item in items">
    <li>
      {{item.id}}
    </li> 
    <li>
      //태그의 attribute에 값 대입시
      <img :src="item.photo">
    </li>
  </template>
</ul>
```
※ 「v-bind:src」가 정식 지시자이지만 생략하여 사용가능　　

※ 「:src」이후의 「" "」내부는 자바스크립트가 된다.  
  #  

  ##  attribute binding  

1. Case 1  (style)  
```
<div :style="style">
  test
</div>
```  
```
return(){
  style : "background : red" // string 형태
}
```  

2. Case 2  (style)  
```
<div :style="[style, fontstyle]">
  test
</div>
```  
```
return(){
  style : {background : 'red'}, // json 형태
  fontstyle : {fontSize : '30px'} 
}
```  
※ 이때, Case 2에서 style을 string형태로 바꾸면 적용 안됨  
attribute가 배열 형태로 받을시 안되는 것 같다. :bow:  
  
  3. Case 3  (class)  

```
<div :class="[toggle, dropdown]">
  test
</div>
```  

 #   

  ##  methods , Event

* **methods**
```
<button @click="plus"> add </button>
```  
※ v-on:click = @click

```
methods : {
  plus(){
    this.num += 1;
  }
}
```  
※화살표 함수는 사용 불가  


* **Event**  
키보드를 누르는 이벤트 발생시 메서드 실행 
```
<input type="text" @keyup="keyUP"/>
```
```
methods : {
  keyUP(ev){
    if(ev.keyCode != 13){
      this.num -= 1;
    }
  }
}
```
※Enter 누를시 keyUP발동
```
<input type="text" @keyup.enter="keyUP"/>
```    

<------->

* **computed**  
  getter메서드 처럼 사용 가능!

* **props**  
  부모 컴포넌트에서 자식 컴포넌트로의 값 전달

* **$emit**  
  자식컴포넌트가 부모에게 신호 (값의 변화)를 보내는 것 

* **mixin**  
  여러 컴포넌트에서 불러와 재사용할 수 있는 기능 
  

 #   
 

  ##  component  
  반복되는 태그 묶음을 손쉽게 사용할 수 있다.

```
Vue.component('tagName',{
  props : ['inputValue'],
  template : 
    '<div>
      Html 태그 정리
      <p>{{inputValue}}</p>
    </div>'
})
```  

➡ 설정해둔 컴포넌트를 이용해 태그를 만들어 사용  

```
<tagName
  inputValue="Value">
</tagName>
```  

 #   

  ##  eventBus
  *    


 #   

  ##  프로젝트 구조  

* node_modules : 개발에 필요한 패키지들  
* index.html : vue.js를 마운트 <div>를 소지  
* bable or eslint : 기본 설정
* package.json : npm에서 사용하는 파일  
* src
  * main.js : webpack이 파일을 읽어들일 시작지점  

**-- package.json**
node_modules에서 설치해야 할 내역을 적어두는 파일
 * scripts  
   *  serve : 로컬 웹서버를 돌려 코드를 실시간 확인할수 있게 하는 스크립트
   *  build : 개발 완료후 서버에 올릴 파일들을 생성하는 스크립트
   *  lint : 스크립트 문법 체크
  

**-- XXX.vue**  

※ javascript태그의 export default는 ECMAScript 6의 모듈 추출 방식
```
export default {

}
```

 #   

  ##  Router  

* http://localhost:8080/xxx 에서 router는 xxx찾아 매치하는 컴포넌트를 찾는다.

* lazyloading : 페이지를 읽어들일때(주소창 검색), 해당리소스 로딩을 추 후에 하는 기술  
※ SPA에서 일반적으로 시작할 때 전체를 읽어옴(속도 느림)

* history모드 : 라우터의 기본 모드는 '해쉬모드'로써 해쉬태그 뒤의 주소를 인식하게 된다.  
히스토리 모드에서는 해쉬태그 생략하고 사용 가능  
http://localhost:8080/#/주소 => http://localhost:8080/주소

* children  
  하위 경로(컴포넌트)를 랜더링 할 수있다. 그러므로 중첩된 컴포넌트를 사용할 수 있다.   
```
const routes = [
  {
    path: '/home',
    name: 'Home',
    component: Home,
    children : [
      {
      path: '/login',
      name: 'userDetail',
      component: UsersDetail
      }
    ]
  }
```  
즉, /home/login이 하위 경로로 컴포넌트를 불러올 수 있다.

 #   

  ##  Vuex  

  * 애플리케이션에 대한 상태 관리 패턴 + 라이브러리 
  * 모든 컴포넌트에 대한 **중앙 집중식 저장소** 역할  
  ex) 게임 속 창고는 어느 곳에서도 동일한 데이터를 가지고 있는것과 같다.

  * store.js
    *  state : vue의 data역할, 변수 등을 관리 
    *  getters : computed의 역할을 수행, 공통 사용하는 로직 저장
    *  Mapgetter : 사용하고자 하는 getters를 간단하게 컴포넌트로 불러주는 역할
    *  mutation : 각각의 컴포넌트의 함수가 state를 변화시키지 않고 
    같은 기능을 하는 함수를 mutation에서 만들어 놓고 각각의 *컴포넌트에서 실행(commit)*시켜 state의 값 변경  

    => 각각의 컴포넌트에서 mutation에 저장된 함수를 commit 하여 state를 변화 시킨다.

    ※ 문제점 : 모든 기능이 동기로 동작한다.

    *  actions : 비동기 로직에서 사용(비지니스 로직 작성)
    각각의 컴포넌트에서 actions를 사용하는 것은 dispatch라고 한다.  

    => 각각의 컴포넌트 => action을 dispatch => actions에서 mutation을 commit => mutation이 state값을 변경