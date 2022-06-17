<template>
  <div>
    <router-view :key="$route.path"></router-view>
  </div>
</template>

<script>
import './Styling/Global.css'

 

export default {
  name: 'App',
  data() {
    
    return {
      
    }
  },
  components: {
   
}
}
</script>
