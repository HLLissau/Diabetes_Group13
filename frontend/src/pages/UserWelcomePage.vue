<template>
   <div class="welcome-wrap">

    <div class="links">
      
    </div>
    
     <router-view :key="$route.path"></router-view>  

    <div id="menubar">
       <MenuBar/>
    </div>

    <div id="chart">
      <div id="welcome">
      <WelcomeChart :veryhigh = "this.veryhigh" :high = "this.high" :target = "this.target" :low = "this.low" :verylow = "this.verylow" :key = "this.key"/>
      </div>
      <div id="current">
      <CurrentData :observation = "this.basal"/>
      <CurrentData :observation = "this.bolus"/>
      <CurrentData :observation = "this.measurement"/>
      <CurrentData :observation = "this.meals"/>
      <CurrentData :observation = "this.exercise"/>
      </div>
    </div>



  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'
import MenuBar from '../components/MenuBar.vue'
import CurrentData from '../components/CurrentData.vue'
import moment from 'moment'

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
        veryhigh: 0,
        high: 0,
        target: 0,
        low: 0,
        verylow: 0,
        key: 0

    }
  },
  methods: {
    printname(){
      console.log("name", this.$backend.getUserId())
    },
    async pullData(){

      var  date= new Date()
      date.setMonth(0)
      date.setDate(28)
      date = moment(String(date)).format('YYYY-MM-DD hh:mm:ss')

      await this.axios
      .get(this.$backend.getUrlCriticalLevels(date,))
      .then(res => {
        console.log("chartRes",res.data)
        this.veryhigh = res.data[0]
        this.high = res.data[1]
        this.target = res.data[2]
        this.low = res.data[3]
        this.verylow = res.data[4]
        console.log("high",this.high)
        console.log("target",this.target)
        this.key++;

      })

        console.log("highOut",this.high)
        console.log("targetOut",this.target)




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
    },
    mounted(){
        this.pullData()
        console.log("data pulled")
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

div#chart {
  justify-content: flex-start;
  float: left;
  width: 30vw;
  padding-top: 15px;

}
div#current {
  position: absolute;
  padding-left: 120px;
  top: 15vh;
}

div#welcome {
    width: 10vw;
    height: 50vh;
    position:absolute;
    top:15vh;
  }

header {
  background-color: #222;
  padding: 15px;
}
</style>
