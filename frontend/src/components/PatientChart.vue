<template>
    <canvas id="patient-chart"></canvas>
</template>

<script>
import Chart from 'chart.js';
//import 'chartjs-adapter-date-fns';

export default {
  name: 'PatientChart',
  
  props: ['propData','propLabel','propAverageData','propAverage'],
  data() {
    return {
      legend: "average",
      chartData: {
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
     

    updateTable(choice){ //Rolf s193939
    this.chartData.data.datasets[1].label=choice
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
      
          
          this.chartData.data.datasets[1].data=overTime
          this.chartData.data.datasets[0].data=averageSpan

          this.chartData

          console.log("chartAverage",this.propAverage)
          this.chartData.data.datasets[0].hidden = !this.propAverage
          
          if (this.propAverage){
            this.legend = ""
          }
          else { this.legend = "average" }
          
    }
  },

  mounted() {  
    this.updateTable(this.propLabel)
    const ctx = document.getElementById('patient-chart');
    new Chart(ctx, this.chartData);
  }

}
</script>
