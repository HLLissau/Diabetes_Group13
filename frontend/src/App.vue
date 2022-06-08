<template>
  <div>
    <router-link to="/pages/TestPage">Go to next page</router-link>
  <router-view/>
</div>
</template>

<script>
//import WelcomePage from './pages/WelcomePage.vue'

export default {
  name: 'App',
  data() {
    return {
      title: 'test'
    }
  },
  components: {
    //WelcomePage, 
  }
}
</script>

<style>
#app {
  font-family: sans-serif;
  color: #2c3e50;
}
</style>
