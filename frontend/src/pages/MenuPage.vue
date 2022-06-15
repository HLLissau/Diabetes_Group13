<template>
   <div class="wrap">

    <h1 v-if="!$route.meta.hideFrontPage">Welcome to group 13's project.</h1>
     <div class="links">
              <router-view :key="$route.path"></router-view>
              <button v-if="!$route.meta.hideFrontPage" @click="$router.push('/pages/UserLogin')">Login as user</button>
              <button v-if="!$route.meta.hideFrontPage" @click="$router.push('/pages/DoctorLogin')">Login as doctor</button>
              <button v-if="!$route.meta.hideFrontPage" @click="$router.push('/pages/CreateNewAccount')">Create new account</button>
      
      
    </div>
  </div>
</template>


<script>
export default {
  name: 'MenuPage',
  components: {
    
  },
  
}
</script>
