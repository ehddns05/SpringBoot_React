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
        <!-- <v-hover
          v-slot:default="{ hover }"
        >
          <v-card
            :elevation="hover ? 16 : 2"
            class="mx-auto"
            height="100"
            max-width="150"
          >
            <v-card-text class="font-weight-medium mt-12 text-center subtitle-1" @click="filedownload()">
              attached file
            </v-card-text>
          </v-card>
        </v-hover> -->
        <v-btn class="ma-2" color="indigo" dark @click="filedownload()">
          <v-icon dark>mdi-arrow-up-bold-box-outline</v-icon>
        </v-btn>
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
            board:null,
            uploadfile:null
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
    methods: {
      filedownload(){
        axios.get('/board/filedownload?boardnum='+this.$route.params.boardnum, {
        responseType: "blob",
    } )
      .then(response => {
        console.log(response);
        const url = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement("a");

        const contentDisposition = response.headers['content-disposition']; // 파일 이름
        var match = contentDisposition.match(/filename\s*=\s*"(.+)"/i);
        var filename = match[1];
        console.log(filename);

        link.href = url;
        link.setAttribute("download", filename);
        document.body.appendChild(link);
        link.click();
        link.parentNode.removeChild(link);
      })
      .catch(error =>{
        console.log(error);
      });
      }
    },
}
</script>