<template>
    <button class="list-group-item text-left"
        @click="clickButton">
    {{label}}
    </button>
</template>

<script>
import { eventBus } from '../main'

export default {
  // props: ['label'],
  // 배열의 형태도 가능하지만 Json 형태일 경우 데이터 형태 명시 가능
  props: { label:
    {
      type: String,
      default: 'Default'
    }
  },
  methods: {
    clickButton () {
      this.$emit('componentClick')
      // eventBus.$emit('nowTime', new Date())
      eventBus.whatTimeIsIt(new Date())
    }
  }
}
</script>
