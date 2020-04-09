<template>
    <div class="UsersDetail">
        UsersDetail<br/>
        <p>{{UserId}}</p><br/>
        <v-btn @click="modify">modification</v-btn>
    </div>
</template>

<script>
export default {
    computed : {
        UserId(){
        return this.$route.params.id
        }
    },
    methods : {
        modify(){
            // this.$router.push({name : 'userEdit'})
            this.$router.push({path : this.UserId+'/edit'})
        }
    }
}
</script>