<template>
  <div class="wrap-login">
    <h1>Create new Doctor  </h1>
    
    <label>User Name</label>
      <input class="login-field" v-model="username" id="username" name="username"  placeholder="Full name"  v-on:focusout="checkName()">
      <label>Password</label>
      <input class="login-field" type="password" v-model="password" id='password' placeholder = "password (minimum 4 characters)"
           minlength="4" required>
      <label>Re-enter Password</label>
      <input class="login-field" type="password" v-model="password2" id='password2' placeholder = "password (minimum 4 characters)" v-on:focusout="checkpassword()"
           minlength="4" required>
      <label>Email</label>
      <input class="login-field" v-model="Email" id="Email" name="Email"  placeholder="Group13@AreGreat.dk"  v-on:focusout="checkEmail()" >


    
    
    <input class="login-button" type="submit"  @click="tryCreateAccount()" value="Create Account"  >
    <input class="goback-button" type="submit"  @click="$router.go(-1)" value="Go Back">



      
  </div>
</template>


<script>


export default {
  name: 'CreateDoctor',
 
  components: {
   
  },
  methods: {
    checkEmail() {
      
      var email = document.getElementById('Email');
      var filter = /^([a-zA-Z0-9_.-])+@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

      if (!filter.test(email.value)) {
        alert('Please provide a valid email address');
        email.focus;
        return false;
      }
    },
    checkName() {
      
      var name = document.getElementById('username');
      var filter = /^([a-zA-Z0-9_.-])+((\s)+[a-zA-Z0-9-]+)+$/

      if (!filter.test(name.value)) {
        alert('Please provide firstname and surname');
        name.focus;
        return false;
      }
    },
    checkpassword() {
      var pass1 = document.getElementById('password');
      var pass2 = document.getElementById('password2');
      
      if (pass1.value !=pass2.value) {
        alert('passwords do not match');
        pass2.focus;
        return false;
      }
    },
    

    tryCreateAccount(){
      // check correct user input in fields
      this.checkEmail()  
      this.checkName()
      this.checkpassword()

      


      var link =this.$backend.getUrlCreateDoctorAccount()
      console.log("name:",  document.getElementById('username').value)

     this.axios.post(
        link, {
          "id" : 0,
          "fullName" : document.getElementById('username').value,
          "password" : document.getElementById('password').value ,
          "createdAt" : new Date(),
          "email" :document.getElementById('Email').value 
        }
        
        
      ).then(

        res => {
          this.$backend.doctor = res.data
          console.log("res:", this.$backend.doctor)
          
          alert('Account created successfully')
          this.$router.push('/pages/DoctorWelcomePage')

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
 
 }
    
}
  

</script>
