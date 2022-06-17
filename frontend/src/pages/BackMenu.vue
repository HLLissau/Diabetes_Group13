<template>
   <div id="nav">
 
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
<!--
<style>
.test {
  position: absolute;
  left: 100px;
}

</style>-->
