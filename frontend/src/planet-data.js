//let newLabel = ''

//function test(){
//  let newLabel = 'Dataset 2'
//}

export const planetChartData = {

    type: "scatter",
    data: {datasets: [{
      label: 'ghjk',
      data: [
        {x:12,y:17},{x:14,y:19},{x:25,y:21},{x:33,y:24},{x:37,y:22},{x:40,y:27}
      ],
      backgroundColor: 'rgba(12,15,166,0.2)',
      borderColor: 'rgb(78,67,190,1)',
      showLine: true
    }]},
    options: {
      maintainAspectRatio: true,
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
};
  
  export default planetChartData;