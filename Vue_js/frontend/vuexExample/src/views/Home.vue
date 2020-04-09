<template>
  <v-container>
    <h1>Home</h1>
    <p>All User : {{$store.getters.allUsersCount}}</p>
    <!-- getters로 간략화 하여 사용 -->
    <p>Seoul User : {{P_seoul}}%</p>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  computed: {
    ...mapGetters({
      // 맵핑하여 더욱 간략화 가능
      P_seoul : 'percentOfSeoul'
    })
    // ...mapGetters(['allUsersCount', 'percentOfSeoul', 'allUsersCount'])
  },
}
</script>