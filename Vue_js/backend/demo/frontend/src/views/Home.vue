<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <p>1.{{ this.$store.state.authorization }}</p>
    <p>2.{{ $store.state.authorization }}</p>
  </div>
</template>

<script>
export default {
  name: "Home",
  components: {}
};
</script>
