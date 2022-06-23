<template>
  <div>
  <MenuBar/>
  <div class="header">
    <navigationBar v-on:child-choice="updateChoice"   />
  </div>
  <div class="wrap"> 
    
    
     <div id="chart-statspage">
           <PatientChart :propLabel = "label" :propData = "backendData" :propAverageData = "backendAverage" :propAverage = "average" :key = "componentKey" />
     </div>
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
   

    pullAverage(after,choice){ //Rolf s193939
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
                      data =this.$backend.getUrlAverageForYear(after)
                      break
          case "All time": 
                      data =this.$backend.getUrlAverageForAllTime(after)
                      break
          
          
          }
      var  startDate= new Date()
      startDate.setDate(startDate.getDate() - 2000)
      startDate =moment(String(startDate)).format('YYYY-MM-DD hh:mm:ss')

      var arr = []
      this.axios
        .get(data)
        .then(res => {
          this.backendAverage = res.data
          console.log("res: ", res)
          this.backendAverage.forEach(data => {
            
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
        this.backendAverage = arr
    },
    
    updateChoice(choice_from_child){ // Harald s204436
        console.log("choice from child",choice_from_child)
        var values = ["measurement","meals","exercise", "basal","bolus"]
        var interval= ["Day","Week","Month","Year","All time"]
        if (values.includes(choice_from_child)) {
        this.label = choice_from_child
        }

        else if (interval.includes(choice_from_child)) { 
          var dates =this.getDatesFromChoice(choice_from_child)
          
          this.pullChartData(dates[0],dates[1],choice_from_child)

        }
        else {
          this.average = choice_from_child
        }
        console.log("Average registered as",this.average)
        
        this.componentKey += 1;
    },
    
    getDatesFromChoice(choice_from_child){ // Harald s204436
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

    pullChartData(before,after,choice){ // Rolf s193939
    var data = []
    console.log("chart date choice", choice)
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
                      data =this.$backend.getUrlByUserIdbyWeekBetween(before,after)
                      break
          case "All time": 
                      data =this.$backend.getUrlByUserIdbyAllTimeBetween(before,after)
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
    this.backendData = arr
     this.pullAverage(after,choice)
    
        
        
  }

  },
  mounted() {
    if (this.testfunctions){ console.log("parentmount")}
    var dates = this.getDatesFromChoice("Day")
    this.pullChartData(dates[0],dates[1],"Day")

    
  },
  created(){
    this.testfunctions = true
    this.updateChoice("measurement")   
  },
}
</script>