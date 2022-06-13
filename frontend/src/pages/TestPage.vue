<template>
  <div class="wrap">
    <div id="menubar">
       <MenuBar/>
    </div>
    <h1>testtesttesttesttesttest</h1>
  </div>
</template>


<script>
import MenuBar from '../components/MenuBar.vue'
export default {
  name: 'TestPage',
  components: {
    MenuBar
    
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