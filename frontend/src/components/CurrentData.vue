<template>
<div>
    <div id="name"> {{this.observation[0]}}: </div>
    <span id="data"> {{this.observation[1]}} </span>
    <span id="time"> {{this.observation[2]}} </span>
    <div> øhhhh </div>
</div>
</template>


<script>
export default {
  name: 'CurrentData',
  props: 'observation',
  data(){
  },
  methods:{
  }
}
</script>


<style>

div#name {
    float: left;
    width: 10vw;
}
span#data {
    background-color: whitesmoke;
    padding: 2px;
    width: 2vw;
}
span#time{
    color: red;
    font-size: 0.7em;
    padding-left: 10px;
}

</style>