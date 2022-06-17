<template>
  <div class="wrap-login">
    <h1 v-if="!$route.meta.hideFrontPage">User Login</h1>

       <!--
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID"  />
        
        <input type="password" id="password" placeholder="Password"  />
        <button @click="tryLogIn(UserId,password)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
     --><label>User ID</label>
       <input class="login-field" v-model="UserId" id="username" name="username"  placeholder="user id"  v-on:keyup.enter="tryLogIn(UserId,password)" >
      <label>Password</label>
      <input class="login-field" type="password" v-model="password"  v-on:keyup.enter="tryLogIn(UserId,password)" placeholder = "password (minimum 4 characters)"
           minlength="4" required>
        

     <input class="login-button" type="submit"  @click="tryLogIn(UserId,password)" value="Sign In"  >
     <input class="goback-button" type="submit"  @click="$router.push('/pages/MenuPage')" value="Go Back">

    
    <h2 v-if="loginerror "> Invalid userId or password </h2>
  </div>
</template>


<script>
import '../Styling/UserLoginStyling.css'

export default {
  
data(){
    return {
        UserId: "1",
        password: "password1",
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
