<template>
  <div class="wrap">
   <!-- <h1>Create new account </h1> -->


    <div>
              <router-view :key="$route.path"></router-view>
              <div v-if="$route.meta.showCreateMenu" class="login-button"><button @click="$router.push('/pages/CreateNewUserAccount')"><h1>Create User Account</h1></button></div>
              <div v-if="$route.meta.showCreateMenu"  class="login-button"><button @click="$router.push('/pages/CreateNewDoctorAccount')"><h1>Create Doctor Account</h1></button> </div>
              <div v-if="$route.meta.showCreateMenu" class="login-button"><button @click="$router.go(-1)"><h1>Go Back</h1></button> </div>
      
      
    </div>

  </div>
</template>


<script>
import '../Styling/MenuPageStyling.css'
export default {
  name: 'CreateAccountMenu',
  components: {
    
  }
}
</script>
