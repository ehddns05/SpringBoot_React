<template>
    <div class="UserEdit">
        UserEdit<br/>
        {{UserId}}
    </div>
</template>

<script>
export default {
    computed : {
        UserId(){
        return this.$route.params.id
        }
    }
}
</script>