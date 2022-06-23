<template>
<!-- Magnus s191252 -->
<tr>
    <td id="name"> {{this.observation[0]}} </td>
    <td id="data"> {{this.observation[1]}} </td>
    <td id="time"> {{this.observation[2]}} </td>
</tr>
</template>


<script>
export default {
  name: 'CurrentData',
  props: ['observation'],
  data(){
    return {

    }
  }
}
</script>


<style>

td#time {
  width: 32vw;
}

</style>