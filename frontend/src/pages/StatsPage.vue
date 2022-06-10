<template>
  <div class="wrap"> 
    <header>
      <navigationBar v-on:child-choice="updateChoice"/>
    </header>
    <h1>Patient management</h1>
    <h1>Stats page</h1>

     <canvas id="myChart"></canvas>
    <PatientChart :propLabel = "label" :propData = "backendData" :key = "componentKey" />
  </div>
</template>


<script>
import navigationBar from '../components/NavigationBar.vue'
import PatientChart from '../components/PatientChart.vue'
export default {
  name: 'StatsPage',
  components: {
    navigationBar,
    PatientChart
  },
   data() {
    return {
      showChart: true,
      hospitals: [],
      backendData: [],
      label: 'measurement',
      loaded: [],
    }
  },
  methods: {
    refresh() {
      this.axios
        .get(this.$backend.getUrlUsers())
        .then(res => {
          this.hospitals = res.data
          //router.push({ name: 'ListHospitals' })
        })
    },
    
    updateChoice(choice_from_child){
        console.log(choice_from_child)
        this.label = choice_from_child
        console.log("test",PatientChart.myChart)
        this.componentKey += 1;
        
        
        
    },
    pullChartData(){
    var arr = []
    this.axios
        .get(this.$backend.getAllData())
        .then(res => {
          this.backendData = res.data
          this.backendData.forEach(data => {
            var payload = {
              t:new Date(data.time),
              measurement:data.measurement,
              meal:data.meals,
              exercise:data.exercise,
              bolus:data.bolus,
              basal:data.basal
            }  
            arr.push(payload) 
          });
        })
        this.backendData = arr
        
  }
  },
  mounted() {
    console.log("parentmount")
    this.refresh()
    
  },
  created(){
    this.pullChartData()
    this.componentKey += 1;
        
  },
  pullData() {
    this.axios
        .get(this.$backend.getUrlUsers())
        .then(res => {
          this.hospitals = res.data
          //router.push({ name: 'ListHospitals' })
        })
  }
}
</script>



<style>
* {
  font-family: sans-serif;
}
.wrap {
  width: 50vw;
  padding: 0;
  background-color: aqua;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>