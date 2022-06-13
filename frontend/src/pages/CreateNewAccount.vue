<template>
  <div class="wrap">
    <h1>Create new account </h1>
     <button @click="$router.go(-1)">Go Back</button>
  </div>
</template>


<script>
export default {
  name: 'DoctorLogin',
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