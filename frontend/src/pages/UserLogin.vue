<template>
  <div class="wrap">
    <h1 v-if="!$route.meta.hideFrontPage">User Login</h1>
     <ul>
       <!--
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID"  />
        
        <input type="password" id="password" placeholder="Password"  />
        <button @click="tryLogIn(UserId,password)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
     -->
     
        <div>
        <input v-model="UserId" id="username" name="username" placeholder="user id" >
</div>

<div>
    
    <input type="password" v-model="password" placeholder = "password (minimum 4 characters)"
           minlength="4" required>
</div>

<input type="submit"  @click="tryLogIn(UserId,password)" value="Sign in">

    </ul>
    <h2 v-if="loginerror "> Invalid userId or password </h2>
  </div>
</template>


<script>
export default {
data(){
    return {
        UserId: "test",
        loginerror: false
     }
    
},
  name: 'UserLogin',
  components: {
    
  },
   methods: {
    
    

  


    tryLogIn(id,password){
      
      this.$backend.setUserId(id)  
      this.$backend.setUserpassword(password)
      var link =this.$backend.getUrlLoginUser()
      this.loginerror=true
      
      console.log("exists?" ,this.value);
      
      //console.log("exists?" ,this.$backend.returnerror);
      
     const user = {
          id : this.$backend.getUserId(),
          password : this.$backend.getUserpassword()
        }
      console.log("password: ",user)

     this.axios.get(
        link + "/" + id + "/" + password 
        
      ).then(

        res => {
          console.log("res:", res)
          this.$router.push('/pages/UserWelcomePage')

        }
      ) .catch(function (error) {
    if (error.response) {
      console.log(error.response.data);
      console.log(error.response.status);
      console.log(error.response.headers);
     }
      }
      )

    //  this.$router.push('/pages/UserWelcomePage')
    //console.log("name", this.$backend.getUserId()) 
      
    }
  },
  created() {
    this.loginerror=false
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