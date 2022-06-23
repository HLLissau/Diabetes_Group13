<template> <!-- Erik s204438 -->
  <div class="wrap">
 
    <form v-on:submit.prevent ="submitForm">
      <div class="wrap-login">
       <h1 v-if="!$route.meta.hideFrontPage">Doctor Login</h1>
     --><label>Email</label>
       <input class="login-field" v-model="form.Email" id="email" name="email"  placeholder="Email"  >
      <label>Password</label>
      <input class="login-field" type="password" v-model="form.password"  placeholder = "password"
           >
        

     <input class="login-button" type="submit"   value="Sign In"  >
     <input class="goback-button" type="back"  @click="$router.go(-1)" value="Go Back">
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
    submitForm(){// Harald s204436
      
      var link =this.$backend.getUrlLoginDoctor()

      
     this.axios.get(
        link + "/" + this.form.Email + "/" + this.form.password
        
      ).then(

        res => {
          this.$backend.doctor = res.data
          console.log("doctor", this.$backend.doctor)
          this.$router.push('/pages/DoctorWelcomePage')

        }
      ) .catch(function (error) {
    if (error.response) {
      alert("invalid Email or password")
     }
      }
      )
    }
  
    }

}
</script>
