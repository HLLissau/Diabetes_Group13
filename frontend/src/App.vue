<template>
  <div>
    <WelcomePage/>
  <!--<router-view/>-->
</div>
</template>

<script>
import WelcomePage from './pages/WelcomePage.vue'

export default {
  name: 'App',
  data() {
    return {
    }
  },
  components: {
    WelcomePage, 
  }
}
</script>

<style>
#app {
  font-family: sans-serif;
  color: #2c3e50;
}
</style>
