<template>
  <WelcomePage></WelcomePage>
  
</template>

<script>
import WelcomePage from './pages/WelcomePage'

export default {
  name: 'App',
  data() {
    return {
      title: 'test'
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
