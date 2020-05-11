<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <p>1.{{this.$store.state.isLogin}}</p>
    <p>2.{{$store.state.isLogin}}</p>
  </div>
</template>

<script>


export default {
  name: "Home",
  components: {

  }
};
</script>
