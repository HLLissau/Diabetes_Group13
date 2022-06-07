<template>
  <div>
    <canvas id="patient-chart"></canvas>
  </div>
</template>

<script>
//import planetChartData from '../planet-data.js'
import Chart from 'chart.js'
import 'chartjs-adapter-date-fns';
// import axios from 'axios';
// import { getAllData } from '../services/backend';

export default {
  name: 'PatientChart',
  raw: '',
  data() {
    return {
      dataLoaded: [],
      planetChartData: {
        type: "scatter",
        data: {
          datasets: [
            {
              label: 'label',
              data: [],
              backgroundColor: 'rgba(12,15,166,0.2)',
              borderColor: 'rgb(78,67,190,1)',
              showLine: true
            }
          ]
        },
        options: {
          maintainAspectRatio: true,
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
          }
        }
      }
    }
  },

  mounted() {
    var arr = []
    this.axios
        .get(this.$backend.getAllData())
        .then(res => {
          var result = res.data
          result.forEach(data => {
            var payload = {
              x:new Date(data.time),
              y:data.measurement
            }
              arr.push(payload)
              
              
          });
            this.dataLoaded = arr
            this.planetChartData.data.datasets[0].data = arr

            console.log("planet: ",this.planetChartData.data.datasets[0].data)

             console.log("mounting: ",this.planetChartData.data.datasets[0].data)
          const ctx = document.getElementById('patient-chart');
          new Chart(ctx, this.planetChartData);

        })

  }
}
</script>