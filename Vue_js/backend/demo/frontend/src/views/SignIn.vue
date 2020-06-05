<template>
  <v-container fill-height>
    <v-row justify="center">
      <v-col cols="12" sm="10" md="8" lg="6">
        <v-card>
          <v-card-text>
            <v-text-field
              ref="username"
              v-model="username"
              :rules="[() => !!username || 'This field is required']"
              :error-messages="errorMessages"
              label="ID"
            ></v-text-field>
            <v-text-field
              label="password"
              v-model="password"
              type="password"
            ></v-text-field>
          </v-card-text>
          <v-divider class="mt-12"></v-divider>
          <v-card-actions>
            <v-btn text>Cancel</v-btn>
            <v-spacer></v-spacer>
            <!-- <v-slide-x-reverse-transition>
              <v-tooltip
                v-if="formHasErrors"
                left
              >
                <template v-slot:activator="{ on }">
                  <v-btn
                    icon
                    class="my-0"
                    @click="resetForm"
                    v-on="on"
                  >
                    <v-icon>mdi-refresh</v-icon>
                  </v-btn>
                </template>
                <span>Refresh form</span>
              </v-tooltip>
            </v-slide-x-reverse-transition> -->
            <v-btn color="primary" text @click="login()">Submit</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
// import { mapMutations } from 'vuex'

export default {
  data() {
    return {
      username: null,
      password: null,
      name: null,
      age: null,
      errorMessages: "",
      formHasErrors: false
    };
  },
  methods: {
    // ...mapMutations({loginSuccess}),
    // resetForm () {
    //   this.errorMessages = []
    //   this.formHasErrors = false
    //   Object.keys(this.form).forEach(f => {
    //     this.$refs[f].reset()
    //   })
    // },
    // submit () {
    //   this.formHasErrors = false
    //   Object.keys(this.form).forEach(f => {
    //     if (!this.form[f]) this.formHasErrors = true
    //     this.$refs[f].validate(true)
    //   })
    // },
    login() {
      let formData = new FormData();
      formData.set("username", this.username);
      formData.set("password", this.password);
      axios
        .post("/login", formData, {
          headers: { "Content-Type": "application/x-www-form-urlencoded" }
        })
        .then(response => {
          console.log(response);
          sessionStorage.setItem(
            "authorization",
            response.headers.authorization
          );
          axios.defaults.headers.common["Authorization"] =
            response.headers.authorization;
          this.$store.commit("loginSuccess");
          this.$router.push({ name: "Home" });
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  computed: {
    form() {
      return {
        name: this.name,
        address: this.address,
        city: this.city,
        state: this.state,
        zip: this.zip,
        country: this.country
      };
    }
  }
};
</script>
