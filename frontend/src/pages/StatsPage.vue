<template>
  
  <div class="wrap"> 
    
    <header>
      
      <navigationBar v-on:child-choice="updateChoice"   />
    </header>
    <h1>Stats page</h1>

     <canvas id="myChart"></canvas>
    <PatientChart :propLabel = "label" :propData = "backendData" :key = "componentKey" />
  </div>
</template>


<script>
import moment from 'moment'
import navigationBar from '../components/NavigationBar.vue'
import PatientChart from '../components/PatientChart.vue'

export default {
  testfunctions: true,
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
    testfunctions: true,
    refresh() {
      this.axios
        .get(this.$backend.getUrlUsers())
        .then(res => {
          this.hospitals = res.data
          //router.push({ name: 'ListHospitals' })
        })
    },
    
    updateChoice(choice_from_child){
        var values = ["measurement","meals","exercise", "basal","bolus"]
        var interval= ["Day","Week","Month","Year","All time"]
        if (values.includes(choice_from_child)) {
        this.label = choice_from_child
        //console.log("updateChoice", choice_from_child)
        }
        if (interval.includes(choice_from_child)) {
          var dates =this.getDatesFromChoice(choice_from_child)
          
          this.pullChartData(2,dates[0],dates[1],choice_from_child)
        }



        this.componentKey += 1;
    },
    
    getDatesFromChoice(choice_from_child){
        var  myCurrentDate= new Date()
        if (this.testfunctions){
           myCurrentDate.setMonth(0)
           myCurrentDate.setDate(29)
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
            
          return [myPastDate,myCurrentDate]
    },

    pullChartData(user,before,after,choice){
    var data = []
    switch (choice) {
          case "Day": 
                      data =this.$backend.getUrlByInterval(user,before,after) 
                      break
          case "Week": 
                      data =this.$backend.getUrlByUserIdbyHourBetween(user,before,after)
                      break
          case "Month": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(user,before,after)
                      break
          
          case "Year": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(user,before,after)
                      break
          case "All time": 
                      data =this.$backend.getUrlByUserIdbyDayBetween(user,before,after)
                      break
          
          
          }

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
        
  }
  },
  mounted() {
    if (this.testfunctions){ console.log("parentmount")}
    this.refresh()
    
  },
  created(){
    this.testfunctions = true
    this.pullChartData(2,"2020-01-08 00:00:00","2022-01-08 00:00:00","Day")
    this.componentKey += 1;
        
  },
  
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