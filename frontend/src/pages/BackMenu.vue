<template>
   <div id="nav">
    <router-view :key="$route.path"></router-view>


    <div id="chart">
      <WelcomeChart/>
    </div>

   
  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'

export default {
  name: 'BackMenu',
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
.wrap {
  width: 50vw;
  padding: 15px;
  background-color: aqua;
}
</style>
