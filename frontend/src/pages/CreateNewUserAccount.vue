<template>
  <div class="wrap-login">
    <h1>Create new User </h1>
    
      <label>User Name</label>
      <input class="login-field" v-model="form.fullName" id="username" name="username"  placeholder="Full name" >
      <label>Password</label>
      <input class="login-field" type="password" v-model="form.password" id='password' placeholder = "password (minimum 4 characters)"
           minlength="4" required>
      <label>Re-enter Password</label>
      <input class="login-field" type="password" v-model="form.password2" id='password2' placeholder = "password (minimum 4 characters)" 
           minlength="4" required>
      <label>Email</label>
      <input class="login-field" v-model="form.email" id="Email" name="Email"  placeholder="Group13@AreGreat.dk"   >


                


    
    <input class="login-button" type="submit"  @click="tryCreateAccount()" value="Create Account"  >
    <input class="goback-button" type="submit"  @click="$router.go(-1)" value="Go Back">
   
    

    
      
  

  </div>
</template>


<script>


export default {
  name: 'CreateUser',
  data() {
    return {
       form: {
          id : 0,
          fullName : "",
          email: "",
          password: "",
          password2: "",
          createdAt: new Date
          
        }
    }
  },
  components: {
   
  },
  methods: {
   
    async tryCreateAccount(){
      // check correct user input in fields
       
       
      if ( this.$regex.checkName(this.form.fullName) &&   this.$regex.checkpassword(this.form.password, this.form.password2) &&  this.$regex.checkEmail(this.form.email)   ){
      
      
      var link =this.$backend.getUrlCreateUserAccount()
     
     await this.axios.post(
        link, this.form
        /* {
          "id" : 0,
          "createdAt": new Date,
          "name" : document.getElementById('username').value,
          "password" : document.getElementById('password').value ,
          "email" :document.getElementById('Email').value 
        }
        */
        
      ).then(

        res => {
          console.log("User created:", res.data)
          this.$backend.user = res.data
          alert('Account created successfully')
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
  
      this.$backend.doctor =  {
          id : 0,
          fullName : "",
          email: "",
          password: "",
          password2: "",
          createdAt: new Date
          }
    }
    }
  
 }
    
}
  

</script>
