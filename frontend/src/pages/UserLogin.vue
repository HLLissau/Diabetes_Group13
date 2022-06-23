<template>
  <div class="wrap-login">
    <h1 v-if="!$route.meta.hideFrontPage">User Login</h1>

       <!--
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID"  />
        
        <input type="password" id="password" placeholder="Password"  />
        <button @click="tryLogIn(UserId,password)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
     --><label>E-mail</label>
       <input class="login-field" v-model="Email" id="username" name="username"  placeholder="Email"  v-on:keyup.enter="tryLogIn(Email,password)" >
      <label>Password</label>
      <input class="login-field" type="password" v-model="password"  v-on:keyup.enter="tryLogIn(UserId,password)" placeholder = "password (minimum 4 characters)"
           minlength="4" required>
        

     <input class="login-button" type="submit"  @click="tryLogIn(Email,password)" value="Sign In"  >
     <input class="goback-button" type="submit"  @click="$router.go(-1)" value="Go Back">

    
    <h2 v-if="loginerror "> Invalid userId or password </h2>
  </div>
</template>


<script>
import '../Styling/UserLoginStyling.css'

export default {
  
data(){
    return {
        Email: "email1@group13.rocks",
        password: "password1",
        
     }
    
},
  name: 'UserLogin',
  components: {
    
  },
   methods: {
     
    
    async tryLogIn(Email,password){
      
      await this.getUserdata(Email,password)
      this.getdoctor()
    //  this.$router.push('/pages/UserWelcomePage')
    //console.log("name", this.$backend.getUserId()) 
   
     
    
    
    },
    async getUserdata(Email,password) {
    
      var link =this.$backend.getUrlLoginUser()
      this.loginerror=true
      

      await this.axios.get(
        link + "/" + Email + "/" + password 
        
      ).then(

        res => {
          console.log("user: ", this.$backend.user )
          this.$backend.user = res.data
          console.log("user: ", this.$backend.user )
          this.$router.push('/pages/UserWelcomePage')

        }
      ) .catch(function (error) {
    if (error.response) {
      this.loginerror=true
     }
      }
      )
    },
     getdoctor() {
  this.axios
        .get(this.$backend.getUrlDoctorOfUser())
        .then(res => {
          var obje = res.data
          this.$backend.doctor =  obje[0]

      
          })
      console.log("inDoctor2: ", this.$backend.doctor)
      

    }
  },
  created() {
    this.loginerror=false
  }

}
</script>
