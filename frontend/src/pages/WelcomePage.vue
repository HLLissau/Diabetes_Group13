<template>
   <div class="wrap">

    <div class="links">
      <ul>
        <router-link class="routerlink" :to="'/pages/StatsPage'">Stats page</router-link>
        <router-link class="routerlink" :to="'/pages/TestPage'">Test page</router-link>
        <router-link class="routerlink" :to="'/pages/WelcomePageNoLinks'" >Menu</router-link>
      </ul>
    </div>

    <router-view :key="$route.path"></router-view>

    

    <div class="chart">
      <WelcomeChart v-if="!$route.meta.hideWelcomeChart"/>
    </div>

   
  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'

export default {
  name: 'WelcomePage',
  components: {
    WelcomeChart
  }
}
/* 
  align-items: center;
  justify-content: center;
  position: relative;
 */




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
  width: 50vw;
  padding: 15px;
  background-color: rebeccapurple;
}
.wrap{
}
</style>
