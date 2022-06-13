<template>
  <div class="wrap">
    <h1 v-if="!$route.meta.hideFrontPage">User Login</h1>
     <ul>
        <router-view :key="$route.path"></router-view>
        <input v-model="message" placeholder="User ID" />
        <p>Message is: {{ message }}</p>
        <button @click="$router.push('/pages/UserWelcomePage')">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
        

    </ul>
  </div>
</template>


<script>
export default {
  name: 'UserLogin',
  components: {
    
  }
}
</script>



<style>
* {
  font-family: sans-serif;
}
.wrap {
  width: 50vw;
  padding: 15px;
  background-color: aqua;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>