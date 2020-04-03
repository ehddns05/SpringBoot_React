# Vue.js 문법

1. 기본 형태

````
<!DOCTYPE html>
<html>
  <head>
    <title>Vue.js Sample</title>
  </head>
  <body>
    <div id="app">
      {{ message }}
    </div>

    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script>
      new Vue({
        el: "#app",
        data: {
          message: "Hello Vue.js!"
        }
      });
    </script>
  </body>
</html>
````
#  

2. Vue Instance

 * Vue Instance 생성자
 ```
 new Vue({
  // instance option properties
});
```

````
<script>
    new Vue({
        el: "#app",
        data: {
            message: "Hello Vue.js!"
        }
        computed : {
            multi : function() {
            return 10;
            }
        }
        watch: {
            message: function(v){
                console.log("a변경");
            }
        }
    });
</script>
````
#   
  

3. Vue Components  

```
<div id="app">
  <my-component></my-component>
</div>
```


 * 로컬 컴포넌트
```
new Vue({
  el: "#app",
  components: {
    // '컴포넌트 이름': 컴포넌트 내용
    "my-component": {
      template: "<div>A custom component!</div>"
    }
  }
});
````


 * 전역 컴포넌트 
```
Vue.component('my-component', {
  // 옵션
})
```
　　

 * props
```
Vue.component('child', {
  // props 정의
  props: ['message'],
  // 데이터와 마찬가지로 prop은 템플릿 내부에서 사용할 수 있으며
  // vm의 this.message로 사용할 수 있습니다.
  template: '<span>{{ message }}</span>'
})
```
⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩⇩
```
<child message="안녕하세요!"></child>
```




#  
 참조 사이트 

>  https://wikidocs.net/17701  
>  https://ux.stories.pe.kr/113  
>  https://joshua1988.github.io/web-development/vuejs/vuejs-tutorial-for-beginner/#vuejs%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80