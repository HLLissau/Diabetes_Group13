<template>
   <div id="nav">
    <router-view :key="$route.path"></router-view>

    <router-link :to="'/pages/StatsPage'">Stats page</router-link>
    <router-link :to="'/pages/TestPage'">Test page</router-link>
    <!--<router-link :to="'/pages/WelcomeChart'" >Menu</router-link>-->

    <div id="chart">
      <WelcomeChart v-if="!$route.meta.hideWelcomeChart"/>
    </div>

    <div id="test">
      PLACE
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
.test {
  position: absolute;
  left: 100px;
}
</style>
