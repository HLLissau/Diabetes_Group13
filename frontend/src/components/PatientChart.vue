<template>
  <div>
    <canvas id="patient-chart"></canvas>
  </div>
</template>

<script>
import planetChartData from '../planet-data.js'
import Chart from 'chart.js'

export default {
  name: 'PatientChart',
  data() {
    return {
      planetChartData: planetChartData
    }
  },
  mounted() {
    const ctx = document.getElementById('patient-chart');
    new Chart(ctx, this.planetChartData);
  }
}
</script>