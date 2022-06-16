<template>
   <div class="welcome-wrap">

    <div class="links">
      
    </div>
    
     <router-view :key="$route.path"></router-view>  

    <div id="menubar">
       <MenuBar/>
    </div>

    <div id="chart">
      <WelcomeChart :veryhigh = "this.veryhigh" :high = "this.high" :target = "this.target" :low = "this.low" :verylow = "this.verylow"/>
      <CurrentData :observation = "this.basal"/>
      <CurrentData :observation = "this.bolus"/>
      <CurrentData :observation = "this.measurement"/>
      <CurrentData :observation = "this.meals"/>
      <CurrentData :observation = "this.exercise"/>
    </div>



  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'
import MenuBar from '../components/MenuBar.vue'
import CurrentData from '../components/CurrentData.vue'

export default {
  name: 'UserWelcomePage',
  props: ['Id'],
  components: {
    WelcomeChart,
    MenuBar,
    CurrentData
  },
  data(){
    return{
        basal: ['basal'],
        bolus: ['bolus'],
        measurement: ['measurement'],
        meals: ['meals'],
        exercise: ['exercise'],
        veryhigh: '',
        high: '',
        target: '',
        low: '',
        verylow: ''

    }
  },
  methods: {
    printname(){
      console.log("name", this.$backend.getUserId())
    },
    pullData(){
      //basal
        this.axios
        .get(this.$backend.getUrlRecentBasal())
        .then(res => {
          this.basal.push(res.data[0])
          this.basal.push(res.data[1])
        })
        
      //bolus
      this.axios
        .get(this.$backend.getUrlRecentBolus())
        .then(res => {
          this.bolus.push(res.data[0])
          this.bolus.push(res.data[1])
        })
      //measurement
      this.axios
        .get(this.$backend.getUrlRecentMeasurement())
        .then(res => {
          this.measurement.push(res.data[0])
          this.measurement.push(res.data[1])
        })
      //meals
      this.axios
        .get(this.$backend.getUrlRecentMeals())
        .then(res => {
          this.meals.push(res.data[0])
          this.meals.push(res.data[1])
        })
      //exercise
      this.axios
        .get(this.$backend.getUrlRecentExercise())
        .then(res => {
          this.exercise.push(res.data[0])
          this.exercise.push(res.data[1])
        })
      
      //chart data
      this.axios
        .get(this.$backend.getUrlCriticalLevels())
        .then(res => {
          this.veryhigh = res.data[0]
          this.high = res.data[1]
          this.target = res.data[2]
          this.low = res.data[3]
          this.verylow = res.data[4]
        })
    }
  },
  created(){
    this.pullData()
  }

}


</script>

<style>
/* .links .routerlink {
  color:orange;
  background-color: yellow;
  text-decoration: none;

  border-bottom: 3px solid transparent;
  border-top: 3px solid transparent;
  padding: 10px 20px;

} */
.chart {
  justify-content: flex-start;
  float: left;
  width: 30vw;
  padding: 15px;
  background-color: rgb(128, 0, 255);
}

header {
  background-color: #222;
  padding: 15px;
}
</style>
