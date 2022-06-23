<template> <!-- Magnus s191252 -->
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