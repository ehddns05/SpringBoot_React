<template>
    <div>
      <p>Global compoent</p>
      <p>EventBus Date : {{nowTime}}</p>
      <p>mixins : {{whatTimeIsIt(nowTime)}}</p>
      <p>mixins : {{ this.mixinVaule }}</p>
    </div>
</template>

<script>
import { eventBus } from '../main'
import { dataFormat } from '../mixins/dataFormat'

export default {
  data () {
    return {
      nowTime: null
    }
  },
  created () {
    this.nowTime = new Date()

    // eventBus 예제
    eventBus.$on('nowTime', time => {
      this.nowTime = time
    })
  },
  mixins: [dataFormat]
}
</script>
