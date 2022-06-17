<template>
   <div class="wrap">
  <router-view :key="$route.path"></router-view>
      <MenuPage/>
    
  </div>
</template>

<script>
import MenuPage from './MenuPage.vue'
export default {
  name: 'FrontPage',
  components: {
      MenuPage
   
  }
}


</script>
