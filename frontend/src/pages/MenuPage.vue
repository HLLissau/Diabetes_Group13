<template>
   <div class="wrap">

    <h1 class="h1menu" v-if="!$route.meta.hideFrontPage">
      Welcome to the Diabetes App
    </h1>

     <div>
              <router-view :key="$route.path"></router-view>
  
              <div v-if="!$route.meta.hideFrontPage" class="login-button"><button @click="$router.push('/pages/UserLogin')"><h1>User Login</h1></button></div>
              <div v-if="!$route.meta.hideFrontPage" class="login-button"><button @click="$router.push('/pages/DoctorLogin')"><h1>Doctor Login</h1></button> </div>
              <div v-if="!$route.meta.hideFrontPage" class="login-button"><button @click="$router.push('/pages/CreateNewAccount')"><h1>Create New Account</h1></button> </div>
      
      
    </div>
  </div>
</template>


<script>
import '../Styling/MenuPageStyling.css'
export default {
  name: 'MenuPage',
  components: {
    
  },
  
}
</script>
