<template>
  <div>
    <FrontPage   />
  </div>
</template>

<script>
import './Styling/Global.css'
import FrontPage from './pages/FrontPage.vue'

 

export default {
  name: 'App',
  data() {
    return {
    }
  },
  components: {
   
    FrontPage
}
}
</script>
