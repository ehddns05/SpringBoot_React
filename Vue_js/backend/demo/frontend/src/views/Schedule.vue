<template>
  <v-row class="fill-height">
    <v-col>
      <v-sheet height="64">
        <v-toolbar flat color="white">
          <v-menu bottom left>
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                outlined
                color="grey darken-2"
                v-bind="attrs"
                v-on="on"
              >
                <span>{{ typeToLabel[type] }}</span>
                <v-icon right>mdi-menu-down</v-icon>
              </v-btn>
            </template>
            <v-list>
              <v-list-item @click="type = 'day'">
                <v-list-item-title>Day</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'week'">
                <v-list-item-title>Week</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = 'month'">
                <v-list-item-title>Month</v-list-item-title>
              </v-list-item>
              <v-list-item @click="type = '4day'">
                <v-list-item-title>4 days</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
          <v-btn outlined class="mr-4" color="grey darken-2" @click="setToday">
            Today
          </v-btn>
          <v-btn fab text small color="grey darken-2" @click="prev">
            <v-icon small>mdi-chevron-left</v-icon>
          </v-btn>
          <v-btn fab text small color="grey darken-2" @click="next">
            <v-icon small>mdi-chevron-right</v-icon>
          </v-btn>
          <v-toolbar-title v-if="$refs.calendar">
            {{ $refs.calendar.title }}
          </v-toolbar-title>
          <v-spacer></v-spacer>
          
          <!-- add schedule -->
          <v-dialog v-model="dialog" persistent max-width="600px">
            <template v-slot:activator="{ on, attrs }">
              <v-btn
                outlined mid fab color="indigo"
                v-bind="attrs"
                v-on="on"
              >
                <v-icon>mdi-pencil</v-icon>
              </v-btn>
            </template>
            <v-card>
              <v-card-title>
                <span class="headline">Schedule</span>
              </v-card-title>
              <v-card-text>
                <v-container>
                  <v-row>
                    <v-col cols="12">
                      <v-text-field v-model="title" label="Title*" required></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-text-field v-model="context" label="Contents"></v-text-field>
                    </v-col>
                    <v-col cols="12">
                      <v-select
                        v-model="category"
                        multiple
                        chips
                        :items="names"
                        label="category"
                      >
                      </v-select>
                    </v-col>
                    
                    <!-- data picker -->
                    <v-col cols="12" sm="6" md="6">
                      <v-menu
                        ref="datamenu"
                        v-model="datamenu"
                        :close-on-content-click="false"
                        :return-value.sync="date"
                        transition="scale-transition"
                        offset-y
                        min-width="290px"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="date"
                            label="Picker in menu"
                            prepend-icon="event"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-date-picker v-model="date" no-title scrollable>
                          <v-spacer></v-spacer>
                          <v-btn text color="primary" @click="datamenu = false">Cancel</v-btn>
                          <v-btn text color="primary" @click="$refs.datamenu.save(date)">OK</v-btn>
                        </v-date-picker>
                      </v-menu>
                    </v-col>

                    <!-- time picker -->
                    <v-col cols="11" sm="6">
                      <v-menu
                        ref="timemenu"
                        v-model="timemenu"
                        :close-on-content-click="false"
                        :nudge-right="40"
                        :return-value.sync="time"
                        transition="scale-transition"
                        offset-y
                        max-width="290px"
                        min-width="290px"
                      >
                        <template v-slot:activator="{ on, attrs }">
                          <v-text-field
                            v-model="time"
                            label="Picker in menu"
                            prepend-icon="access_time"
                            readonly
                            v-bind="attrs"
                            v-on="on"
                          ></v-text-field>
                        </template>
                        <v-time-picker
                          v-if="timemenu"
                          v-model="time"
                          full-width
                          @click:minute="$refs.timemenu.save(time)"
                        ></v-time-picker>
                      </v-menu>
                    </v-col>
                  </v-row>
                </v-container>
                <small>*indicates required field</small>
              </v-card-text>
              <v-card-actions>
                <v-spacer></v-spacer>
                <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
                <v-btn color="blue darken-1" text @click="saveSchedule()">Save</v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </v-sheet>
      <v-sheet height="600">
        <v-calendar
          ref="calendar"
          v-model="focus"
          color="primary"
          :events="events"
          :event-color="getEventColor"
          :type="type"
          @click:event="showEvent"
          @click:more="viewDay"
          @click:date="viewDay"
          @change="updateRange"
        ></v-calendar>
        <v-menu
          v-model="selectedOpen"
          :close-on-content-click="false"
          :activator="selectedElement"
          offset-x
        >
          <v-card
            color="grey lighten-4"
            min-width="350px"
            flat
          >
            <v-toolbar
              :color="selectedEvent.color"
              dark
            >
              <v-btn icon>
                <v-icon>mdi-pencil</v-icon>
              </v-btn>
              <v-toolbar-title v-html="selectedEvent.name"></v-toolbar-title>
              <v-spacer></v-spacer>
              <v-btn icon>
                <v-icon>mdi-heart</v-icon>
              </v-btn>
              <v-btn icon>
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </v-toolbar>
            <v-card-text>
              <span v-html="selectedEvent.details"></span>
            </v-card-text>
            <v-card-actions>
              <v-btn
                text
                color="secondary"
                @click="selectedOpen = false"
              >
                Cancel
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-menu>
      </v-sheet>
    </v-col>
  </v-row>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator";
import axios from "axios";


interface schedule {
  schedulenum: number,
  title: string,
  context: string,
  category: string,
  time: Date,
  userid: string
}

@Component
export default class HelloWorld extends Vue {
  
  //dialog
  dialog= false;
  //data picker
  date = new Date().toISOString().substr(0, 10);
  datamenu = false;
  //time picker
  time= '';
  timemenu= false;
  //add schedule
  title= '';
  context= '';
  category= '';
  schedules: schedule[] = [];

  //calendar
  focus = '';
  type = 'month';
  typeToLabel: object = {
    month: 'Month',
    week: 'Week',
    day: 'Day',
    '4day': '4 Days',
  };
  selectedEvent = {};
  selectedElement = null;
  selectedOpen = false;
  events: any[] = [];
  colors: string[] = ['blue', 'indigo', 'deep-purple', 'cyan', 'green', 'orange', 'grey darken-1'];
  names: string[] = ['Meeting', 'Holiday', 'PTO', 'Travel', 'Event', 'Conference', 'ETC'];

  mounted() {
    console.log('mounted');
    (this.$refs['calendar'] as any).checkChange();
  }

  viewDay ( date: any ): void{
    this.focus = date.date;
    this.type = 'day';
  }

  getEventColor (event: any) {
    return event.color
  }

  setToday () {
    this.focus = ''
  }

  prev () {
    (this.$refs['calendar'] as any).prev()
  }

  next () {
    (this.$refs['calendar'] as any).next()
  }

  showEvent ( events: any) {
    const open = () => {
      this.selectedEvent = events.event;
      this.selectedElement = events.nativeEvent.target;
      setTimeout(() => this.selectedOpen = true, 10)
    }
    if (this.selectedOpen) {
      this.selectedOpen = false
      setTimeout(open, 10)
    } else {
      open()
    }
    events.nativeEvent.stopPropagation()
  }

  async updateRange ( time: any ) {

    console.log(time);

    //array initialize
    this.schedules.length = 0;

    // get Schedule from server
    let calendar_data: any = await this.getMySchedule();
    for (let index = 0; index < calendar_data.length; index++) {
      this.schedules.push(calendar_data[index]);
    }

    const events = [];

    for (let i = 0; i < this.schedules.length; i++) {

      // 0000-00-00T00:00:00 form
      let arrengedTime = this.schedules[i].time.toString().substring(0, 19);

      //start time
      let start_time = new Date(arrengedTime);

      // end time
      let end_time = new Date(arrengedTime);
      end_time.setHours(end_time.getHours()+1);

      // connect coloer and category
      let j: number = 0;
      this.names.some((element: string) => {
        if(element === this.schedules[i].category.substring(2, this.schedules[i].category.length-2).split("\"")[0]){
          return true;
        }
        j++;
      });

      events.push({
        name: this.schedules[i].title,
        start: start_time,
        end: end_time,
        color: this.colors[j],
        timed: 1,
        details: this.schedules[i].context
      })
    }
    this.events = events
  }

  saveSchedule(){
    this.dialog = false;
    axios
      .post("/schedule/add", {
        "title" : this.title,
        "context" : this.context,
        "category" : JSON.stringify(this.category),
        "time" : new Date(this.date + 'T' + this.time +':00')
      })
      .then(response => {
        console.log(response);
        this.schedules = response.data;
        console.log(this.schedules);
      })
      .catch(error => {
        console.log(error);
      });
  }

  getMySchedule(){
    console.log("getMySchedule");
    return new Promise(function(resolve) {
      axios
      .get("/schedule/myschedule")
      .then(response => {
        resolve(response.data);
      })
      .catch(error => {
        console.log(error);
      });
    });
    
  }
}
</script>