<template>
  <div class="wrap">
    <h1 v-if="!$route.meta.hideFrontPage">User Login</h1>
     <ul>
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID" />
        <input v-model="Password" placeholder="Password" />
        <button @click="tryLogIn(UserId)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
        

    </ul>
  </div>
</template>


<script>

export default {
data(){
    return {
        UserId: "test"
     }
},
  name: 'UserLogin',
  components: {
    
  },
   methods: {
    tryLogIn(String){
    this.UserId = String   
      this.$backend.setUserId(String)
      this.$router.push('/pages/UserWelcomePage')
    //console.log("name", this.$backend.getUserId()) 
      
    }
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