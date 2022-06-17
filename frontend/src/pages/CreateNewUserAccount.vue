<template>
  <div class="wrap">
    <h1>Create new User account </h1>


    <div>
              <router-view :key="$route.path"></router-view>
             
      
      
    </div>

  </div>
</template>


<script>
export default {
  name: 'CreateUser',
  components: {
    
  }
}
</script>
