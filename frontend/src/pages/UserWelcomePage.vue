<template>
   <div class="welcome-wrap">

    <div class="links">
      
    </div>
    
     <router-view :key="$route.path"></router-view>  

    <div id="menubar">
       <MenuBar/>
    </div>

    <div id="chart-welcomepage">
      <WelcomeChart/>
      <CurrentData :observation = "this.basal"/>
      <CurrentData :observation = "this.bolus"/>
      <CurrentData :observation = "this.measurement"/>
      <CurrentData :observation = "this.meals"/>
      <CurrentData :observation = "this.exercise"/>
    </div>



  </div>
</template>

<script>
import '../Styling/WelcomePageStyling.css'
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
        exercise: ['exercise']

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
    }
  },
  created(){
    this.pullData()
  }

}


</script>
