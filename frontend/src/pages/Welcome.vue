<template>
   <div id="app">
    <h1>Login page</h1>
  <p>
    <router-link to="/Stats">Login</router-link>
  </p>
  <router-view></router-view>
</div>
</template>


<script>
//import StatsPage from '/Stats'
export default {
  name: 'WelcomePage',
  components: {
   // StatsPage
   },
  
}
</script>

<style>
* {
  font-family: sans-serif;
}
.wrap {
  width: 50vw;
  padding: 15px;
}
header {
  background-color: rgb(255, 255, 255);
  padding: 15px;
}
</style>