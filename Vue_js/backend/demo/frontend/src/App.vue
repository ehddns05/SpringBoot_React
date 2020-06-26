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
        <v-list-item link v-if="authorization">
          <v-list-item-action>
            <v-icon>info</v-icon>
          </v-list-item-action>
          <v-list-item-content @click="$router.push({name:'schedule'})">
            <v-list-item-title>Info</v-list-item-title>
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

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import HelloWorld from "./components/HelloWorld.vue";
import { mapState } from 'vuex';
import axios from 'axios';

@Component({
  components: {
    HelloWorld
  },
  methods: {
    logout(){
        axios.get('/logout')
        .then(response => {
          console.log(response.status);
          this.$store.commit('logout');
          this.$router.go(0);
        })
        .catch(error =>{
          console.log(error);
        });
      }
  },
  computed :{
    ...mapState(['authorization'])
  }
})
export default class App extends Vue {
  drawer= false;
}
</script>

// <style lang="scss">
// #app {
//   font-family: Avenir, Helvetica, Arial, sans-serif;
//   -webkit-font-smoothing: antialiased;
//   -moz-osx-font-smoothing: grayscale;
//   text-align: center;
//   color: #2c3e50;
//   margin-top: 60px;
// }
// </style>
