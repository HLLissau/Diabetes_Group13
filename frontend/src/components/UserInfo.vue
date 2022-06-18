<template>
<div id="userinfo">
<div id="titles"> 
  <div class="titel"><a> Name </a></div>
  <div class="titel"><a> UserId </a></div>
  <div class="titel"><a> email-adress </a></div>
  <div class="titel"><a> Assigned doctor </a></div>
</div>
<div id="props"> 
  <div class="info"><a> Average  </a></div>
  <div class="info"><a> Average </a></div>
  <div class="info"><a> Average </a></div>
  <div class="info"><a> Average </a></div>
</div>
<div id="alter"> 
<div class="change" v-on:click = "this.changeName = !this.changeName, this.changeEmail = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
<div class="invisibel" > invisibel </div>
<div class="change" v-on:click = "this.changeEmail = !this.changeEmail, this.changeName = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
<div class="change" v-on:click = "this.changeDoctor = !this.changeDoctor, this.changeEmail = false, this.changeName = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
</div>

<div id="inputs"> 
<div :class="[changeName?'visibel':'invisibel']"> <input type="text" >  <input class="button" type="submit"  @click="changeNamee()" value="Change"  > </div>
<div class="invisibel"> d <input type="text" > </div>
<div :class="[changeEmail?'visibel':'invisibel']"> <input type="text" > <button>change</button> </div>
<div :class="[changeDoctor?'visibel':'invisibel']"> <input type="text" > <button>change</button> </div>
</div>

</div>
</template>


<script>
export default {
  name: 'UserInfo',
  //props: [UserId, Username, email]
  data() {
    return {   
        changeName: false,
        changeEmail: false,
        changeDoctor: false
    }
  },
  methods: {
    changeNamee(){
      this.changeName= false
      this.changeEmail= false
      this.changeDoctor= false
      console.log("pressed")

    }
  }
}
</script>

<style>

div#titles{
  float: left;
  width: 10vw;
}
div#props{
  float: left;
  width: 10vw;
}
div#alter{
  float:left;
  width: 10vw;
}
img.edit{
  width: 100%;
  height: 100%;
}
img.editOff{
  width: 100%;
  height: 100%;
  filter: invert(80%);
}
.change{
  height: auto;
  width: 1vw;
}
.visibel{
  color: red;
}
.invisibel{
  color: blue;
  visibility: hidden;
}


</style>
