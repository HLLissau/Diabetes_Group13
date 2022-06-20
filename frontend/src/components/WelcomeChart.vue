<template>
    <canvas id="welcome-chart"></canvas>
</template>

<script>
import Chart from 'chart.js'


export default {
    name: 'WelcomeChart',
    props: ['veryhigh','high','target','low','verylow'],
    data() { 
    return {
    current2: {
        type:'bar',
        data: {
        labels: ['%'],
        datasets: [
        {
            label: 'Very low',
            data: [this.verylow],
            backgroundColor:'rgb(0, 200, 255)'
        },
        {
            label: 'Low',
            data: [this.low],
            backgroundColor: 'rgb(0, 255, 200)'
        },
        {
            label: 'Target',
            data: [this.target],
            backgroundColor: 'rgb(0, 182, 55)'
        },
        {
            label: 'High',
            data: [this.high],
            backgroundColor: 'rgb(255, 239, 0)'
        },
        {
            label: 'Very high',
            data: [this.veryhigh],
            backgroundColor:'rgb(235, 23, 0)'
        }
        ]},
        options: {
            legend: {
                position: 'bottom',
                allign: 'end',
                display: true
            },
            responsive: true,
            maintainAspectRatio: false,
            scales: {
                xAxes: [{
                    stacked: true,
                   display: false
                }],
                yAxes: [{
                    stacked: true,
                    display: false
                }]
            }
        }
}   }},
    mounted() {
      const ctx = document.getElementById('welcome-chart');
      new Chart(ctx,this.current2);

    },
    created(){
    //console.log('welcomeChartMounted')
    //console.log("high",this.high)
    //console.log("target",this.target)

    }


}

</script>