<template>
   <div class="welcome-wrap">

    <div class="links">
      
    </div>
    
     <router-view :key="$route.path"></router-view>  

    <div id="menubar">
       <MenuBar/>
    </div>

    <div id="chart-welcomepage">
      <WelcomeChart/>
    </div>

  </div>
</template>

<script>
import '../Styling/WelcomePageStyling.css'
import WelcomeChart from '../components/WelcomeChart.vue'
import MenuBar from '../components/MenuBar.vue'

export default {
  name: 'UserWelcomePage',
  props: ['Id'],
  components: {
    WelcomeChart,
    MenuBar
  },
  methods: {
    printname(){
      console.log("name", this.$backend.getUserId())
    }
  }

}


</script>
