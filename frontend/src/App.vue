<template>
  <div>
    <FrontPage/>
  </div>
</template>

<script>
import './Styling/Global.css'
//import WelcomePage from './pages/WelcomePage.vue'
import FrontPage from './pages/FrontPage.vue'
//import StatsPage from './pages/StatsPage.vue'

 

export default {
  name: 'App',
  data() {
    return {
    }
  },
  components: {
    //WelcomePage, 
    //StatsPage
    FrontPage

  }
}
</script>
