<template>
    <div class="Users">
        Userid는 {{userId}}<br/>
        {{$route.query}}<br/>
        <v-flex xs12>
            <v-text-field label="Input User Number" v-model="userid">

            </v-text-field>
            <v-btn @click="$router.push({name : 'userDetail', params : { id : userid }})">Search</v-btn>
        </v-flex>
        <v-flex xs12>
            <router-view></router-view>
        </v-flex>
    </div>
</template>

<script>
export default {
    data() {
        return {
            userid : null
        }
    },
    computed :{ 
        // eslint-disable-next-line vue/return-in-computed-property
        userId () {
            return this.$route.params.id
        }
    },
    created(){
        // router와 route의 차이
        // new Router객체
        console.log(this.$router)
        // 현재 router 관련 주소, 정보 등
        console.log(this.$route)
    },
    // eslint-disable-next-line no-unused-vars
    beforeRouteLeave (to, from, next) {
        console.log('라우터가 페이지를 떠나기 직전 실행')
        next()
    },
    // eslint-disable-next-line no-unused-vars
    beforeRouteEnter (to, from, next) {
        console.log('라우터가 페이지를 들어올때')
        next()
    },
    destroyed() {
        console.log('페이지가 없어질 때')
    }
}
</script>