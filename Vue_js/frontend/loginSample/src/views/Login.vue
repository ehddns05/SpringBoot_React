<template>
  <v-container fill-height style="max-width:450px">
    <v-layout align-center row wrap>
      <v-flex xs12>
        <v-alert type="error" :value="isError">
          Login Fail
        </v-alert>
        <v-card>
          <v-toolbar flat height="60">
            <v-toolbar-title>Login</v-toolbar-title>
          </v-toolbar>
          <div class="pa-3">
            <v-text-field
              v-model="email"
              label="email"
              placeholder="email"
              outlined
            >
            </v-text-field>
            <v-text-field
              v-model="password"
              type="password"
              label="password"
              placeholder="password"
              outlined
            >
            </v-text-field>
            <v-btn
              large
              block
              depressed
              color="primary"
              @click="login({ email, password })"
            >
              Login
            </v-btn>
          </div>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";

export default {
  data() {
    return {
      email: null,
      password: null
    };
  },
  methods: {
    ...mapActions(["login"])
  },
  computed: {
    ...mapState(["isLogin", "isError"])
  }
};
</script>
