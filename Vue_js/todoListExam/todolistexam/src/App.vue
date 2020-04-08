<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <!-- <router-view/> -->
    <div class="col-md-6 offset-md-3">
      <div class="container">
        <Navi></Navi>
        <h2 class="text-center mb-4">Todo</h2>

        <input type="text" class="form-control mb-4" v-model="userInput" @keyup.enter="addNewTodo">

        <div class="list-group mb-4" >
          <template v-for="todo in activeTodoList" >
          <todo
            :label='todo.label'
            @componentClick='toggleTodoState(todo)'
            v-bind:key="todo.index"
          />
          </template>
        </div>
        <div class="text-right">
          <button class="btn btn-sm" @click="changeCurrentState('active')">할 일</button>
          <button class="btn btn-sm" @click="changeCurrentState('done')">완료</button>
          <button class="btn btn-sm" @click="changeCurrentState('all')">전체</button>
        </div>
      </div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import Todo from './components/Todo'

export default {
  name: 'App',
  data () {
    return {
      index: 1,
      userInput: '',
      todolist: [],
      currentState: 'active'
    }
  },
  computed: {
    activeTodoList () {
      return this.todolist.filter(todo => this.currentState === 'all' ||
       todo.status === this.currentState)
    }
  },
  methods: {
    changeCurrentState (state) {
      this.currentState = state
    },
    addNewTodo () {
      this.todolist.push({
        label: this.userInput,
        status: 'active',
        index: this.index++
      })
      this.userInput = ''
    },
    toggleTodoState (todo) {
      todo.status = todo.status === 'active' ? 'done' : 'active'
    }
  },
  components: {
    Todo
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
