<template>
   <div id="nav">
   

    <router-link :to="'/pages/StatsPage'">Stats page</router-link>
    <router-link :to="'/pages/TestPage'">Test page</router-link>
    <router-link :to="'/pages/BackMenu'" >Back Menu</router-link>

    <div id="chart">
      <WelcomeChart v-if="!$route.meta.closeWelcomeChart"/>
    </div>
    
     <router-view :key="$route.path"></router-view>

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
.test {
  position: absolute;
  left: 100px;
}
</style>
