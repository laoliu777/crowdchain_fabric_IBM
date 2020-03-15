<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
  components: {
  }
}
</script>

<style>
#app {
    color: #f9f9f9;
    height: 100%;
    width: 100%;
    min-height: 937px;
    min-width: 1420px; /* 防止页面元素拥挤 */
}
</style>
