<template>
  <div>
    <h1>All Users({{allUsersCount}})</h1>
    <p>Seoul User : {{percentOfSeoul}}%</p>
    <v-list two-line>
      <v-list-tile 
        v-for="(user, index) in allUsers"
        :key="index"
        avatar
      >
        <v-list-tile-avatar color="grey lighten-3">
          <img :src="user.src">
        </v-list-tile-avatar>

        <v-list-tile-content>
          <v-list-tile-title v-html="user.name"></v-list-tile-title>
          <v-list-tile-sub-title>id:#{{index}} / {{user.address}} 거주</v-list-tile-sub-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>

  </div>
</template>

<script>
import { EventBus } from '@/main.js'
import { mapGetters, mapState } from 'vuex'

  export default {
    data() {
      return {
        
      }
    },
    mounted() {
      EventBus.$on('signUp', users => {
        this.$store.state.allUsers.push(users)
      })
    },
    computed: {
      ...mapGetters(['allUsersCount', 'percentOfSeoul', 'allUsersCount']),
      ...mapState(['allUsers'])
    },
  }
</script>
