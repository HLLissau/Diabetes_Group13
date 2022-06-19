<template>
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
  },
  methods:{
  },
  created(){
    //console.log("created",this.observation)
  }
}
</script>


<style>

/* td#name {
    float: left;
    width: 10em;
}
td#data {
    width: 10vw;
    float:left;
    padding-right: 5vw;
}
td#time{
    color: red;
    font-size: 0.7em;
    float:left;
    /* padding-left: 4em;
    width: 30vw;
} */

td#time {
  width: 32vw;
}

</style>