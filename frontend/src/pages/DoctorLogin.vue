<template>
  <div class="wrap">
    <h1 v-if="!$route.meta.hideFrontPage">Doctor Login</h1>
     <ul>
       <!--
        <router-view :key="$route.path"></router-view>
        <input v-model="UserId" placeholder="User ID"  />
        
        <input type="password" id="password" placeholder="Password"  />
        <button @click="tryLogIn(UserId,password)">Login</button>
        <button @click="$router.go(-1)">Go Back</button>
     -->
     
        <div>
        <input v-model="UserId" id="username" name="username" placeholder="doctor id" >
</div>

<div>
    
    <input type="password" v-model="password" placeholder = "password (minimum 4 characters)"
           minlength="4" required>
</div>

<input type="submit"  @click="tryLogIn(doctorId,password)" value="Sign in">

    </ul>
    <h2 v-if="loginerror "> Invalid DoctorId or password </h2>
  </div>
</template>


<script>
export default {
data(){
    return {
        doctorId: "test",
        loginerror: false
     }
    
},
  name: 'DoctorLogin',
  components: {
    
  },
   methods: {
    
    

  


    tryLogIn(id,password){
      
      this.$backend.setdoctorId(id)  
      this.$backend.setdoctorpassword(password)
      var link =this.$backend.getUrlLoginDoctor()
      this.loginerror=true
      
      console.log("exists?" ,this.value);
      
      //console.log("exists?" ,this.$backend.returnerror);
      
     const user = {
          id : this.$backend.getDoctorId(),
          password : this.$backend.getDoctorPassword()
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

header {
  background-color: #222;
  padding: 15px;
}
</style>