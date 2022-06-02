<template>
  <div class="wrap">
    <header>
      <navigationBar/>
    </header>
      <h1>Patient management</h1>

      <h3>Functions</h3>
      <ol>
        <li><router-link :to="{ name: 'ListHospitals' }">List of users</router-link></li>
        <li><router-link :to="{ name: 'AddHospital' }">Create user</router-link></li>
      </ol>

      <router-view
        :hospitals="this.hospitals"
        @new-hospital="refresh"
        @hospital-deleted="refresh" />

      <PatientChart/>
  </div>


</template>

<script>
import PatientChart from './components/PatientChart.vue'
import router from './router.js'
import navigationBar from './components/NavigationBar.vue'

export default {
  name: 'App',
  components: {
    PatientChart,
    navigationBar
   },
  data() {
    return {
      showChart: true,
      hospitals: [],
      isActive: false
    }
  },
  methods: {
    refresh() {
      this.axios
        .get(this.$backend.getUrlUsers())
        .then(res => {
          this.hospitals = res.data
          router.push({ name: 'ListHospitals' })
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
.wrap {
  width: 50vw;
  padding: 15px;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>
