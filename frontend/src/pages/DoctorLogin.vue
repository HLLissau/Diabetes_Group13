<template>
  <div class="wrap">
 
    <form v-on:submit.prevent ="submitForm">
      <div class="wrap-login">
       <h1 v-if="!$route.meta.hideFrontPage">Doctor Login</h1>

       <!--
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID"  />
        
        <input type="password" id="password" placeholder="Password"  />
        <button @click="tryLogIn(UserId,password)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
     --><label>Email</label>
       <input class="login-field" v-model="form.Email" id="email" name="email"  placeholder="Email"  >
      <label>Password</label>
      <input class="login-field" type="password" v-model="form.password"  placeholder = "password (minimum 4 characters)"
           minlength="4" required>
        

     <input class="login-button" type="submit"  @click="submitForm(UserId,password)" value="Sign In"  >
     <input class="goback-button" type="submit"  @click="$router.go(-1)" value="Go Back">
    </div>
    </form>
    
  </div>
</template>


<script>
export default {
  name: 'DoctorLogin',
  data(){
    return {
        form: {
          Email: "",
          password: ""
          
        }
    }
    
  },
  methods: {
    submitForm(){
      
      this.$backend.setDoctorEmail(this.form.Email)  
      this.$backend.setUserpassword(this.form.password)
      var link =this.$backend.getUrlLoginDoctor()

      
     this.axios.get(
        link + "/" + this.form.Email + "/" + this.form.password
        
      ).then(

        res => {
          console.log("res:", res)
          this.$router.push('/pages/DoctorWelcomePage')

        }
      ) .catch(function (error) {
    if (error.response) {
      alert("invalid Email or password")
     }
      }
      )

    //  this.$router.push('/pages/UserWelcomePage')
    //console.log("name", this.$backend.getUserId()) 
      
    }
  
    }

}
</script>
