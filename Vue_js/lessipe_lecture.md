 +  v-model : input태그의 값과 javascript 변수값이 동기화 된다.(vue의 변수)   

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

 +  v-for : 반복문  

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
  
  #  

  *  attribute binding  

1. Case 1
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

2. Case 2
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

  

