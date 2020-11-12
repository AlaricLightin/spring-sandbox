<template>
  <div id="app">
    <root-element/>
  </div>
</template>

<script>
import RootElement from "@/components/RootElement";

export default {
  name: 'App',
  components: {
      RootElement,
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
