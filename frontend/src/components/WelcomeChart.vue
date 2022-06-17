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
    current: {
        type: 'doughnut',
        data: {
        labels: [
            'Red',
            'Blue',
            'Yellow'
        ],
        datasets: [{
            label: 'My First Dataset',
            data: [300, 50, 100],
            backgroundColor: [
                'rgb(255, 99, 132)',
                'rgb(54, 162, 235)',
                'rgb(255, 205, 86)'
            ],
            hoverOffset: 4
        }]
        }
        

    },
    current2: {
        type:'bar',
        data: {
        labels: ['%'],
        datasets: [
        {
            label: 'Very low',
            data: [this.verylow],
            backgroundColor:'rgb(235, 23, 0)'
        },
        {
            label: 'Low',
            data: [this.low],
            backgroundColor: 'rgb(255, 239, 0)'
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
                display: false
            },
            plugins: {
                title: {
                    display: true,
                    text: 'Chart.js Bar Chart - Stacked'
                },
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
      console.log('welcomeChartMounted')
      const ctx = document.getElementById('welcome-chart');
      new Chart(ctx,this.current2);

    console.log("high",this.high)
    console.log("target",this.target)
    }


}

</script>