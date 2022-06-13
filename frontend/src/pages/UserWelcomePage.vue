<template>
   <div class="welcome-wrap">

    <div class="links">
      
    </div>
    
     <router-view :key="$route.path"></router-view>

   

    <div id="menubar">
       <MenuBar/>
    </div>

    <div id="chart">
      <WelcomeChart/>
    </div>

  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'
import MenuBar from '../components/MenuBar.vue'

export default {
  name: 'UserWelcomePage',
  components: {
    WelcomeChart,
    MenuBar
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
.welcome-wrap{
  overflow: hidden;
  widows: 50vw;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>
