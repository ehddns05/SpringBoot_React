<template>
  <v-container fill-height >
  <v-card
    class="mx-auto"
    max-width="1000"
    outlined
  >
    <v-row>

        <v-col cols="12" sm="6">
            <v-text-field
            v-model="board_title"
            label="Title"
            counter
            maxlength="20"
            ></v-text-field>
        </v-col>

    </v-row>
   
    <v-textarea
      counter
      label="Text"
      v-model="context"
      :rules="rules"
      :value="value"
    ></v-textarea>
    <v-file-input
    v-model="file"
    color="deep-purple accent-4"
    counter
    label="File input"
    multiple
    placeholder="Select your files"
    prepend-icon="mdi-paperclip"
    outlined
    :show-size="1000"
  >
    <template v-slot:selection="{ index, text }">
      <v-chip
        v-if="index < 2"
        color="deep-purple accent-4"
        dark
        label
        small
      >
        {{ text }}
      </v-chip>

      <span
        v-else-if="index === 2"
        class="overline grey--text text--darken-3 mx-2"
      >
        +{{ files.length - 2 }} File(s)
      </span>
    </template>
  </v-file-input>

    <v-card-actions style="float:right">
      <v-btn text @click="save_board()">Upload</v-btn>
      <v-btn text @click="$router.push({name:'Board'})">Cancel</v-btn>
    </v-card-actions>
  </v-card>
  </v-container>
</template>

<script>
// import {mapActions} from "vuex"

export default {
    data() {
        return {
            board_title:null,
            context:null,
            file:null
        }
    },
    methods: {
        save_board(){
            let formData = new FormData();
            // formData.set("board_title", this.board_title);
            // formData.set("context", this.context);
            formData.set("board", new Blob([JSON.stringify({board_title:this.board_title, context: this.context})], {
              type: "application/json"
            }))
            formData.set("file", this.file[0]);
            console.log(this.file[0]);
            // let board = {board_title:this.board_title, context:this.context}
            this.$store.dispatch('save_board',formData)
        }
    },
}
</script>