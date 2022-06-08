<template>
   <div id="nav">
    <h1>Login page</h1>
  <p>
    <router-link to="/StatsPage">Login</router-link>
  </p>
  <router-view/>
</div>
</template>


<script>
export default {
  name: 'WelcomePage',
  components: {
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