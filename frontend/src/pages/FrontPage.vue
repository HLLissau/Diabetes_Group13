<template>
   <div class="wrap">
  
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

<style>


.wrap{
  overflow: hidden;
  widows: 50vw;
}
</style>
