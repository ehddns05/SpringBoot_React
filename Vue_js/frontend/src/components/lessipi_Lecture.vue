<div id="test">

    <input type="text" v-model="text" /><br/>
        {{text}}

    <template v-for="item in items">
        <ul>
            <li>
                {{item.id}}
            </li> 
            <li>
                <!-- 태그의 attribute에 값 대입시 -->
                <img :src="item.photo">
            </li>
        </ul>
    </template>

    <!-- attribute관련 예제 -->
    <div :style="[style, fontstyle]">
        z
    </div>
    
    <!-- event, methods관련 예제 -->
    <button @click="plus"> add </button>
        {{num}}
    <br/>

    <input type="text" @keyup.enter="keyUP"/>
    <br/>

    <!-- class관련 예제 -->
    <button @click="btnOn">toggle</button>
    <div :class="[dropdown, toggle]">
        <ul>Toggle Test</ul>
    </div>
</div>
     
      
<script>
    new Vue({
        el:"#test",
        data(){
            
            return {
                text : "test",
                items : [
                { 
                    id : 1,
                    photo : 'data:image/jpeg;base64,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'
                }],
              
                style : {background : 'red'},
                fontstyle : {fontSize : '50px'},
                num : 1,
                dropdown : "dropdown",
                toggle : {
                    on : "false"
                } 
            }
        },
        methods : 
            {
            plus(){
                this.num += 1;
            },
            keyUP(ev){
                
                this.num -= 1;
                
            },
            btnOn(){
                this.toggle.on = !this.toggle.on;
            }
        }
    })
</script>
<style>
    .dropdown ul{
        display : none;
    }
    .dropdown.on ul{
        display : block;
    }
</style>