<template>
  <div class="wrap">
    <h1>Create new User account </h1>
    
    
    <Div>
    <div>
    <div>
      <label>User Name</label>
    </div>
    
    <input class="login-field" v-model="username" id="username" name="username"  placeholder="Full name"  v-on:focusout="checkName()">
    
    </div>
    <div>
      <div>
           <label>Password</label>
      </div>
   
   
     
    <input class="login-field" type="password" v-model="password" id='password' placeholder = "password (minimum 4 characters)"
           minlength="4" required>
     
    </div>
    <div>
      <div>
           <label>Re-enter Password</label>
      </div>
   
   
     
    <input class="login-field" type="password" v-model="password2" id='password2' placeholder = "password (minimum 4 characters)" v-on:focusout="checkpassword()"
           minlength="4" required>
     
    </div>

    <DIV>
      <div>
                <label>Email</label>
          </div>

          
          <input class="login-field" v-model="Email" id="Email" name="Email"  placeholder="Group13@AreGreat.dk"  v-on:focusout="checkEmail()" >
          

    </DIV>
    
    <input class="login-button" type="submit"  @click="tryCreateAccount()" value="Create Account"  >
    <input class="goback-button" type="submit"  @click="$router.go(-1)" value="Go Back">

    </Div>
   
    

    
      
  

  </div>
</template>


<script>


export default {
  name: 'CreateUser',
 
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

      

      this.$backend.setUserName(document.getElementById('username').value  )
      this.$backend.setUserpassword(document.getElementById('password').value )
      this.$backend.setUserEmail(document.getElementById('Email').value )

      var link =this.$backend.getUrlCreateUserAccount()
      console.log("name:",  document.getElementById('username').value)

     this.axios.post(
        link, {
          "id" : 0,
          "name" : document.getElementById('username').value,
          "password" : document.getElementById('password').value ,
          "email" :document.getElementById('Email').value 
        }
        
        
      ).then(

        res => {
          console.log("res:", res)
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
      
    }
 
 }
    
}
  

</script>
