<template>
  <div>
    <canvas id="patient-chart"></canvas>
  </div>
</template>

<script>
import Chart from 'chart.js';
import 'chartjs-adapter-date-fns';

export default {
  name: 'PatientChart',
  props: ['propData','propLabel'],
  watch: {
    propLabel: function (newValue) {
      this.updateTable(newValue)
    }
  },
  chosenData: [],
  data() {
    return {
      planetChartData: {
        type: "scatter",
        data: {
          datasets: [
            {
              label: '',
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

  methods: {
    updateTable(choice){
    this.planetChartData.data.datasets[0].label=choice
    console.log("PatientChart-updateTable",this.propData)
    var overTime = []
    this.propData.forEach(data => {
            var payload = {
              x:new Date(data.time),
              y:1
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
            console.log("payload",payload)
            overTime.push(payload) 
          });
          this.chosenData = overTime
          console.log("updateTable(done)",this.chosenData)
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
      this.planetChartData.data.datasets[0].data=this.chosenData
      const ctx = document.getElementById('patient-chart');
      new Chart(ctx, this.planetChartData);
  },
  created(){
      this.updateTable("measurement")
  }

}
</script>