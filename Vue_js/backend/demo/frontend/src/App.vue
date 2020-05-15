<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list dense>
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content @click="$router.push({name :'Home'})">
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link>
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content @click="$router.push({name:'Board'})">
            <v-list-item-title>board</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="indigo"
      dark
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>Application</v-toolbar-title>
      <v-spacer></v-spacer>
      
      <div class="" v-if="authorization">
        <v-btn text @click="logout()">
          Logout
        </v-btn>
      </div>
      <div class="" v-else>
        <v-btn text @click="$router.push({name : 'SignUp'})">
          sign-up
        </v-btn>
        <v-btn text @click="$router.push({name : 'login'})">
          sign-in
        </v-btn>
      </div>
    </v-app-bar>

    <v-content>
      <router-view></router-view>
    </v-content>
    <v-footer
      color="indigo"
      app
    >
      <span class="white--text">&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import { mapState, mapMutations } from 'vuex'
import axios from 'axios'

  export default {
    props: {
      source: String,
    },
    data: () => ({
      drawer: null,
    }),
    computed: {
      ...mapState(['authorization'])
    },
    methods: {
      logout(){
        axios.get('/logout')
        .then(response => {
          this.$store.commit('logout')
          this.$router.go()
        })
        .catch(error =>{
          console.log(error);
        });
        
      }
    },
  }
</script>