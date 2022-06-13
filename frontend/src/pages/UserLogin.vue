<template>
  <div class="wrap">
    <h1>User Login</h1>
     <ul>
        <button @click="$router.go(-1)">Go Back</button>
    </ul>
  </div>
</template>


<script>
export default {
  name: 'UserLogin',
  components: {
    
  }
}
</script>



<style>
* {
  font-family: sans-serif;
}
.wrap {
  width: 50vw;
  padding: 15px;
}
</style>