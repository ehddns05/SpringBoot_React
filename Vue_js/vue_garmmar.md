#### Vue.js 문법

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

3. 

#  
 참조 사이트 

>  https://wikidocs.net/17701  
>  https://ux.stories.pe.kr/113  
>  https://joshua1988.github.io/web-development/vuejs/vuejs-tutorial-for-beginner/#vuejs%EB%9E%80-%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80