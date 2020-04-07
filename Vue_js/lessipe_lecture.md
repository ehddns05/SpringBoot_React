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
 * scripts  
   *  serve : 로컬 웹서버를 돌려 코드를 실시간 확인할수 있게 하는 스크립트
   *  build : 개발 완료후 서버에 올릴 파일들을 생성하는 스크립트
   *  lint : 스크립트 문법 체크