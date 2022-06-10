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

    <div id="chart">
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
</style>
