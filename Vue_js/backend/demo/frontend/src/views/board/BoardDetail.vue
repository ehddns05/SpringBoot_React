<template>
<v-container fill-height>
  <v-row align="center">
    <v-item-group
      v-model="window"
      class="shrink mr-6"
      mandatory
      tag="v-flex"
    >
      <!-- <v-item
        v-for="n in length"
        :key="n"
        v-slot:default="{ active, toggle }"
      >
        <div>
          <v-btn
            :input-value="active"
            icon
            @click="toggle"
          >
            <v-icon>mdi-record</v-icon>
          </v-btn>
        </div>
      </v-item> -->
    </v-item-group>

    <v-col>
      <v-window
        v-model="window"
        class="elevation-1"
        vertical
      >
        
          <v-card flat>
            <v-card-text>
              <v-row class="mb-4" align="baseline">
                <v-avatar color="grey" class="mr-4"></v-avatar>
                <strong class="title">{{board.board_title}} </strong>
                <v-spacer></v-spacer>
                <v-btn icon>
                  <v-icon>mdi-account</v-icon>
                </v-btn>
              </v-row>

              <p>
                {{board.context}}
              </p>

            </v-card-text>
          </v-card>
        
      </v-window>
    </v-col>
    
  </v-row>
  <v-row align="baseline" justify="end">
      <v-col>
        <div class="my-2">
            <v-btn small color="primary" align="right">Primary</v-btn>
        </div>
      </v-col>
  </v-row>
</v-container>
</template>

<script>
// import {mapGetters, mapState} from 'vuex';
import {mapState} from 'vuex';
import axios from "axios";

export default {
    data() {
        return {
            window:null,
            board:null
        }
    },
    computed: {
        ...mapState(['board'])
    },
    mounted() {
      console.log(this.$route.params)
      axios.get('/board/getBoardDetail?boardnum='+this.$route.params.boardnum )
      .then(response => {
        console.log(response);
        this.board = response.data;

      })
      .catch(error =>{
        console.log(error);
      });
    },
}
</script>