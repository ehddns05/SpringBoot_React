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
            context:null
        }
    },
    methods: {
        save_board(){
            // let board = new FormData();
            // board.set("title", this.title);
            // board.set("context", this.context);
            // console.log(this.title);console.log(this.context);
            let board = {board_title:this.board_title, context:this.context}
            this.$store.dispatch('save_board',board)
        }
    },
}
</script>