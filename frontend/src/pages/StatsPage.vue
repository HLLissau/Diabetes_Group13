<template>
  <div class="wrap"> 
    <div id="menubar">
       <MenuBar/>
    </div>
    
    <div class="header">
      <navigationBar v-on:child-choice="updateChoice"   />
    </div>
    <router-view :key="$route.path"></router-view>
    <h1 id = "statpageHeading">Stats page</h1>
     <!-- <canvas id="myChart"></canvas> -->
     <div id="chart-statspage">
           <PatientChart :propLabel = "label" :propData = "backendData" :propAverageData = "backendAverage" :propAverage = "average" :key = "componentKey" />
     </div>
  </div>
</template>


<script>
import '../Styling/StatsPageStyling.css'
import moment from 'moment'
import navigationBar from '../components/NavigationBar.vue'
import PatientChart from '../components/PatientChart.vue'
import MenuBar from '../components/MenuBar.vue'

export default {
  testfunctions: true,
  name: 'StatsPage',
  components: {
    navigationBar,
    PatientChart,
    MenuBar
  },
   data() {
    return {
      showChart: true,
      hospitals: [],
      backendData: [],
      backendAverage: [],
      average: false,
      label: 'measurement',
      loaded: [],
    }
  },
  methods: {
    testfunctions: true,
    refresh() {
      this.axios
        .get(this.$backend.getUrlUsers())
        .then(res => {
          this.hospitals = res.data
          //router.push({ name: 'ListHospitals' })
        })
    },

    pullAverage(before,after,choice){
          var data
          switch (choice) {
          case "Day": 
                      data =this.$backend.getUrlAverageForDay(after)
                      break
          case "Week": 
                      data =this.$backend.getUrlAverageForWeek(after)

                      break
          case "Month": 
                      data =this.$backend.getUrlAverageForMonth(after)
                      break
          
          case "Year": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(before,after)
                      break
          case "All time": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(before,after)
                      break
          
          
          }
      var  startDate= new Date()
      startDate.setDate(startDate.getDate() - 2000)
      startDate =moment(String(startDate)).format('YYYY-MM-DD hh:mm:ss')


      //pull all averages for alle variable
      var arr = []
      this.axios
        //.get(this.$backend.getUrlAveragesByHour(startDate, moment(String(new Date())).format('YYYY-MM-DD hh:mm:ss')))
        .get(data)
        .then(res => {
          this.backendAverage = res.data
          this.backendAverage.forEach(data => {
            var payload = {
              t:new Date(data.time),
              measurement:data.measurement,
              meal:data.meals,
              exercise:data.exercise,
              bolus:data.bolus,
              basal:data.basal
            } 
            //console.log("payload time before:", payload.t) 
            var temptime = new Date(new Date(payload.t).setDate(29)) 
            //console.log("payload time middle:", temptime) 
            payload.t=temptime
            //console.log("payload time after:", payload.t) 
            //console.log("complete payload:", payload) 
            arr.push(payload) 
          });
        })
        this.backendAverage = arr

        console.log("pullaverage",this.backendAverage)
        this.backendAverage
    },
    
    updateChoice(choice_from_child){
        console.log("choice from child",choice_from_child)
        var values = ["measurement","meals","exercise", "basal","bolus"]
        var interval= ["Day","Week","Month","Year","All time"]
        if (values.includes(choice_from_child)) {
        this.label = choice_from_child
        //console.log("updateChoice", choice_from_child)
        }

        if (interval.includes(choice_from_child)) { 
          var dates =this.getDatesFromChoice(choice_from_child)
          
          this.pullChartData(dates[0],dates[1],choice_from_child)

        }
        else {
          this.average = choice_from_child
        }
        console.log("Average registered as",this.average)
        this.componentKey += 1;
        
    },
    
    getDatesFromChoice(choice_from_child){
        var  myCurrentDate= new Date()
        if (this.testfunctions){
           myCurrentDate.setMonth(0)
           myCurrentDate.setDate(28)
           console.log("testdate:", myCurrentDate)
        }


        var myPastDate=new Date(myCurrentDate);
          switch (choice_from_child) {
            case "Day": 
                      myPastDate.setDate(myPastDate.getDate() - 1)  //myPastDate is now 8 days in the past
                       break
            case "Week":
                     myPastDate.setDate(myPastDate.getDate() - 7)  //myPastDate is now 8 days in the past
                       break
            case "Month":
                      if (this.testfunctions) console.log("getMonth")   
                     myPastDate.setMonth(myPastDate.getMonth() - 1)  //myPastDate is now 8 days in the past
                       break
            case "Year":      
                      
                     if (this.testfunctions) console.log("getyear")  
                          
                     myPastDate.setFullYear(myPastDate.getFullYear() - 1)  //myPastDate is now 8 days in the past
                       break
            case "All time":
                     myPastDate.setDate(myPastDate.getDate() - 2000)  //myPastDate is now 8 days in the past
                       break
                       
              
          }
           
         
          
            myCurrentDate =moment(String(myCurrentDate)).format('YYYY-MM-DD hh:mm:ss')
            myPastDate =moment(String(myPastDate)).format('YYYY-MM-DD hh:mm:ss')
            
            console.log("Currentdate set to: ",myCurrentDate)
            console.log("Pastdate set to: ",myPastDate)
          return [myPastDate,myCurrentDate]
    },

    pullChartData(before,after,choice){
    var data = []
    //var average = []
    switch (choice) {
          case "Day": 
                      data =this.$backend.getUrlByInterval(before,after) 
                      break
          case "Week": 
                      data =this.$backend.getUrlByUserIdbyHourBetween(before,after)
                      break
          case "Month": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(before,after)
                      break
          
          case "Year": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(before,after)
                      break
          case "All time": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(before,after)
                      break
          
          
          }
    console.log("data:",data)
    var arr = []
    this.axios
        .get(data)
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
        this.pullAverage(before,after,choice)

        this.backendData = arr

        
        
  }



  },
  mounted() {
    if (this.testfunctions){ console.log("parentmount")}
    this.refresh()
    
  },
  created(){
    this.testfunctions = true

    this.pullChartData("2020-01-08 00:00:00","2022-01-08 00:00:00","Day")

    this.pullAverage("2020-01-08 00:00:00","2022-01-08 00:00:00","Day")
    this.updateChoice("measurement")

    this.componentKey += 1;
        
  },
}
</script>