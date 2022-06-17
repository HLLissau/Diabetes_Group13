<template>
    <canvas id="patient-chart"></canvas>
</template>

<script>
import Chart from 'chart.js';
//import 'chartjs-adapter-date-fns';

export default {
  name: 'PatientChart',
  
  props: ['propData','propLabel','propAverageData','propAverage'],
  watch: {
    propLabel: function (newValue) {
      this.updateTable(newValue)
    }
  },
  data() {
    return {
      legend: "average",
      componentKey: 0,
      planetChartData: {
        type: "scatter",
        data: {
          datasets: [
            {
              label: 'average',
              data: [],
              backgroundColor: 'rgba(12,15,166,0)',
              borderColor: 'rgb(255, 88, 88)',
              showLine: true,
              hidden: true
              
            },
            {
              label: '',
              data: [],
              backgroundColor: 'rgba(12,15,166,0.4)',
              borderColor: 'rgb(78,67,190,1)',
              showLine: true
              
            },
          ]
        },
        options: {
          legend: {
            labels: {
               filter: item => {
                    return item.text != this.legend
                }
            }
          },
          maintainAspectRatio: false,
          elements: {
            point:{
              radius: 2,
              backgroundColor: 'rgba(0,0,0,0)'
            }
          },
          scales: {
            xAxes: [{
                type: 'time',
                display: true,
                scaleLabel: {
                    display: true,
                    labelString: 'Date'
                },
                ticks: {
                    major: {
                        fontStyle: 'bold',
                        fontColor: '#FF0000'
                    }
                }
            }],
            yAxes: [{
                    scaleLabel: {
                        display:     true,
                        labelString: 'value'
                    }
                }],
            height: 3000,
            responsive: true
          }
        }
      }
    }
  },

  methods: {
    
    testcon(input) {
      console.log("testcon: ", input)
    },
     
    updateTable(choice){
    this.planetChartData.data.datasets[1].label=choice
    //console.log("PatientChart-updateTable",this.propData)
    //console.log("PatientChart-updateTable2",this.planetChartData.data.datasets[0].label)
    var overTime = []
    this.propData.forEach(data => {
            var payload = {
              x:new Date(data.time),
              y:2
            }
            if (choice == "measurement"){
                payload.y=data.measurement
              }
            if (choice == "bolus"){
                payload.y=data.bolus
            }
            if (choice == "basal"){
                payload.y=data.basal
            }
            if (choice == "meals"){
                payload.y=data.meals
            }
            if (choice == "exercise"){
                payload.y=data.exercise
            }
            overTime.push(payload) 
          });
 
    var averageSpan = []
    this.propAverageData.forEach(data => {
            var payload = {
              x:new Date(data.time),
              y:2
            }
            if (choice == "measurement"){
                payload.y=data.measurement
              }
            if (choice == "bolus"){
                payload.y=data.bolus
            }
            if (choice == "basal"){
                payload.y=data.basal
            }
            if (choice == "meals"){
                payload.y=data.meals
            }
            if (choice == "exercise"){
                payload.y=data.exercise
            }
            averageSpan.push(payload) 
          });
      
          
          //this.chosenData = overTime
          this.planetChartData.data.datasets[1].data=overTime
          this.planetChartData.data.datasets[0].data=averageSpan

          //console.log("updateTable(done)",this.planetChartData.data.datasets[0].data)
          this.planetChartData

          console.log("chartAverage",this.propAverage)
          this.planetChartData.data.datasets[0].hidden = !this.propAverage
          
          if (this.propAverage){
            this.legend = ""
          }
          else { this.legend = "average" }
          
    }
  },

  /* created() {
    console.log("tjekCreated",this.backendData)
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
        console.log("tjekAfterCreated",this.backendData)
        this.planetChartData.data.datasets[0].data=this.dataProp
        this.planetChartData.data.datasets[0].label=this.labelProp
  }, */

  mounted() {

      const ctx = document.getElementById('patient-chart');
      new Chart(ctx, this.planetChartData);
      
  },
  created(){
      this.updateTable(this.propLabel)
  }

}
</script>
