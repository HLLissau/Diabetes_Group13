<template>
  <div>
      <h1>Patient management</h1>

      <h3>Functions</h3>
      <ol>
        <li><router-link :to="{ name: 'ListHospital' }">List of patients</router-link></li>
        <li><router-link :to="{ name: 'AddHospital' }">Add new patient</router-link></li>
      </ol>

      <router-view
        :hospitals="this.hospitals"
        @new-hospital="refresh"
        @hospital-deleted="refresh" />

      <button @click="showChart = !showChart">Chart</button>
  </div>
  <div v-if="showChart">
    <PatientChart/>
  </div>
</template>

<script>
import PatientChart from './components/PatientChart.vue'
import router from './router.js'

export default {
  name: 'App',
  components: {
    PatientChart
   },
  data() {
    return {
      showChart: true,
      hospitals: []
    }
  },
  methods: {
    refresh() {
      this.axios
        .get(this.$backend.getUrlHospitalList())
        .then(res => {
          this.hospitals = res.data
          router.push({ name: 'ListHospital' })
        })
    }
  },
  mounted() {
    this.refresh()
  }
}
</script>

<style>
* {
  font-family: sans-serif;
}
</style>
