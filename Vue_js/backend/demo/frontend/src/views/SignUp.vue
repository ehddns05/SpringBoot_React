<template>
  <v-container fill-height>
    <v-row justify="center">
      <v-col cols="12" sm="10" md="8" lg="6">
        <v-card>
          <v-card-text>
            <v-text-field
              ref="id"
              v-model="id"
              :rules="[() => !!id || 'This field is required']"
              :error-messages="errorMessages"
              label="ID"
            ></v-text-field>
            <v-text-field
              label="password"
              v-model="password"
              type="password"
            ></v-text-field>
            <v-text-field
              ref="name"
              v-model="name"
              :rules="[() => !!name || 'This field is required']"
              :error-messages="errorMessages"
              label="Full Name"
            ></v-text-field>
            <v-text-field
              ref="age"
              v-model="age"
              :rules="[() => !!age || 'This field is required']"
              :error-messages="errorMessages"
              label="Age"
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
            <v-btn color="primary" text @click="signup()">Submit</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios'


export default {
  data() {
    return {
      id:null,
      password:null,
      name:null,
      age:null,
      errorMessages: '',
      formHasErrors: false
    }
  },
  methods: {
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
    signup(){
      axios.post('/signup', {
        id: this.id,
        password: this.password,
        name: this.name,
        age: this.age
      })
      .then(response => {
        console.log(response);
      })
      .catch(error =>{
        console.log(error);
      });
    }
  }
}
</script>