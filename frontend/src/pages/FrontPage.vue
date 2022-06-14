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
.wrap {
  width: 50vw;
  padding: 15px;
  background-color: aqua;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>
