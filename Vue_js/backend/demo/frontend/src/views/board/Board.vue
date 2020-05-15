<template>
  <v-simple-table height="300px">
    <template v-slot:default>
    
      <thead>
        <tr>
          <th class="text-left">Num</th>
          <th class="text-left">Title</th>
          <th class="text-left">writer</th>
          <th class="text-left">hits</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in board" :key="item.name">
          <td>{{ item.boardnum }}</td>
          <td @click="move_boardDetail(item.boardnum)">{{ item.board_title }}</td>
          <td>{{ item.writer }}</td>
          <td>{{ item.hits }}</td>
        </tr>
      </tbody>
    <v-btn class="ma-2" outlined large fab color="indigo" style="float:right;" v-if="authorization" @click="$router.push({name:'Board_writing_Page'})">
      <v-icon>mdi-pencil</v-icon>
    </v-btn>
    
    </template>
  </v-simple-table>
</template>

<script>
import {mapGetters, mapState} from 'vuex';

export default {
    data() {
        return {
            // board : [
            //     {
            //     board_num : null,
            //     board_title : null,
            //     writer : null,
            //     hits : null,
            //     date : null
            //     }
            // ]
        }
    },
    methods: {
        move_boardDetail(boardnum){
          this.$router.push({name:'BoardDetail', params : { boardnum : boardnum }})
        }
    },
    computed: {
        ...mapState(['authorization','board']),
        ...mapGetters(['get_board'])
    },
    mounted() {
      {{this.get_board}}
    }
}
</script>