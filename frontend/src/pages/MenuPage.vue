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



<style>
.links .routerlink {
  color:orange;
  background-color: yellow;
  text-decoration: none;

  border-bottom: 3px solid transparent;
  border-top: 3px solid transparent;
  padding: 10px 20px;

}
.chart {
  justify-content: flex-start;
  float: left;
  width: 30vw;
  padding: 15px;
  background-color: rgb(128, 0, 255);
}
.wrap{
  overflow: hidden;
  widows: 50vw;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>