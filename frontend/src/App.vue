<template>
  <div>
    <StatsPage/>
</div>
</template>

<script>
//import WelcomePage from './pages/WelcomePage.vue'
import StatsPage from './pages/StatsPage.vue'

export default {
  name: 'App',
  data() {
    return {
    }
  },
  components: {
    //WelcomePage, 
    StatsPage
  }
}
</script>

<style>
#app {
  font-family: sans-serif;
  color: #2c3e50;
}
</style>
