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
        var values = ["measurement","meals","exercise", "basal","bolus"]
        var interval= ["Day","Week","Month","Year","All time"]
        if (values.includes(choice_from_child)) {
        this.label = choice_from_child
        console.log("updateChoice", choice_from_child)
        }
        if (interval.includes(choice_from_child)) {
          var dates =this.getDatesFromChoice(choice_from_child)
          
          this.pullDefaultChartData(2,dates[0],dates[1])
        }


        this.componentKey += 1;
    },
    
    getDatesFromChoice(choice_from_child){
        var myCurrentDate=new Date()
        var myPastDate=new Date(myCurrentDate);
          switch (choice_from_child) {
            case "Day": 
                       myPastDate.setDate(myPastDate.getDate() - 1)  //myPastDate is now 8 days in the past
                       break
            case "Week":
                     myPastDate.setDate(myPastDate.getDate() - 7)  //myPastDate is now 8 days in the past
                       break
            case "Month":
                     myPastDate.setMonth(myPastDate.getMonth() - 1)  //myPastDate is now 8 days in the past
                       break
            case "Year":
                    
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

    pullDefaultChartData(user,before,after){
    var arr = []
    this.axios
        .get(this.$backend.getUrlByInterval(user,before,after))
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
    this.pullDefaultChartData(2,"2020-01-08 00:00:00","2022-01-08 00:00:00")
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