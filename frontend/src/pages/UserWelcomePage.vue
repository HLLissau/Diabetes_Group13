<template>
  <MenuBar/>
   <div id="welcome-wrap">
    <div v-if="$route.meta.showDoctorback"> >
     
      <input class="goback-button" type="submit"  @click="$router.push('/pages/DoctorWelcomePage')" value="Go Back"/> 
      </div>   

    
  
     <router-view :key="$route.path"></router-view>  
    <div id="chart">
          <WelcomeChart :veryhigh = "this.veryhigh" :high = "this.high" :target = "this.target" :low = "this.low" :verylow = "this.verylow" :key = "this.key"/>
        </div>
    <div id="data-view">
    
    <h1 id="WelcomeHeading">Welcome {{this.$backend.user.fullName}}</h1>
    <table id="current">
      <!-- <CurrentData id="heading" :observation = "this.heading"/> -->
      <tbody>
        <tr>
          <td id="heading">Data Measured</td>
          <td id="heading">Value</td>
          <td id="heading">Time</td>
        </tr>
        <CurrentData class="table-data" :observation = "this.basal"/>
        <CurrentData class="table-data" :observation = "this.bolus"/>
        <CurrentData class="table-data" :observation = "this.measurement"/>
        <CurrentData class="table-data" :observation = "this.meals"/>
        <CurrentData class="table-data" :observation = "this.exercise"/>
      </tbody>
      
    </table>
  </div>


  </div>
</template>

<script>
import WelcomeChart from '../components/WelcomeChart.vue'
import MenuBar from '../components/MenuBar.vue'
import CurrentData from '../components/CurrentData.vue'
import moment from 'moment'
import '../Styling/WelcomePageStyling.css'

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
        heading: ['Data Measured', 'Value', 'Time'],
        basal: ['Basal'],
        bolus: ['Bolus'],
        measurement: ['Measurement'],
        meals: ['Meals'],
        exercise: ['Exercise'],
        veryhigh: 0,
        high: 0,
        target: 0,
        low: 0,
        verylow: 0,
        key: 0

    }
  },
  methods: {
    getDoctor() {
      var doctorlink = this.$backend.getUrlDoctorOfUser()
      this.$backend.doctor = doctorlink
    },

    printname(){
      console.log("name", this.$backend.getUserId())
    },
    // push measurement and date (in correct format)
    pushMeasurementAndDate(measurementVariable, measurementValue, dateString) { // assuming date arrives as string
        measurementVariable.push(measurementValue)
        measurementVariable.push(moment(new Date(dateString)).format('HH:MM:SS, MMMM Do YYYY'))
    },

    async pullData(){

      var  date= new Date()
      // date.setMonth(0)
      // date.setDate(28)
      date = moment(String(date)).format('YYYY-MM-DD hh:mm:ss')
      console.log("date", date);
      await this.axios
      .get(this.$backend.getUrlCriticalLevels(date))
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
          this.pushMeasurementAndDate(this.basal, res.data[0], res.data[1])
        })
        
      //bolus
      this.axios
        .get(this.$backend.getUrlRecentBolus())
        .then(res => {
          this.pushMeasurementAndDate(this.bolus, res.data[0], res.data[1])
        })
      //measurement
      this.axios
        .get(this.$backend.getUrlRecentMeasurement())
        .then(res => {
          this.pushMeasurementAndDate(this.measurement, res.data[0], res.data[1])
        })
      //meals
      this.axios
        .get(this.$backend.getUrlRecentMeals())
        .then(res => {
          this.pushMeasurementAndDate(this.meals, res.data[0], res.data[1])
        })
      //exercise
      this.axios
        .get(this.$backend.getUrlRecentExercise())
        .then(res => {
          this.pushMeasurementAndDate(this.exercise, res.data[0], res.data[1])
        })

    }
  },
    mounted(){
       // this.getDoctor()
        



        this.pullData()
        console.log("data pulled")
    }

}


</script>


