<template>
<div>
<div id="titles"> 
  <div class="titel"><a> User ID </a></div>
  <div class="titel"><a> Full Name </a></div>
  <div class="titel"><a> email-address </a></div>
  <div class="titel"><a> Doctor ID </a></div>
</div>
<div id="props"> 
  <div class="info"><a> {{this.user.id}} </a></div>
  <div class="info"><a> {{this.user.fullName}} </a></div>
  <div class="info"><a> {{this.user.email}} </a></div>
  <div class="info"><a> {{this.doctor}} </a></div>
</div>
<div id="alter"> 
  <div class="invisibel"> invisibel </div>
  <div class="change" v-on:click = "this.changeName = !this.changeName, this.changeEmail = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
  <div class="change" v-on:click = "this.changeEmail = !this.changeEmail, this.changeName = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
  <div class="change" v-on:click = "this.changeDoctor = !this.changeDoctor, this.changeEmail = false, this.changeName = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
</div>

<div id="inputs"> 
  <div class="invisibel"> d <input type="text" > </div>
  <div :class="[changeName?'visibel':'invisibel']"> <input type="text" id="changedname">  <input class="button" type="submit"  @click="changeNamee()" value="Change"  > </div>
  <div :class="[changeEmail?'visibel':'invisibel']"> <input type="text" id="changedemail">   <input class="button" type="submit"  @click="changeNamee()" value="Change"  > </div>
  <div :class="[changeDoctor?'visibel':'invisibel']"> <input type="text" id="changeddoctor" >  <input class="button" type="submit"  @click="changeNamee()" value="Change"  > </div>
</div>

</div>
</template>


<script>
export default {
  name: 'UserInfo',
  props: ['user','doctor'],
  data() {
    return {   
        changeName: false,
        changeEmail: false,
        changeDoctor: false,
    }
  },
  methods: {
    changeNamee(){
      if (this.changeName){
        console.log("pressed name:", document.getElementById("changedname").value )
        console.log (this.$regex.checkName(document.getElementById("changedname").value ))
        this.changeName= false
      }

      if (this.changeEmail){
         console.log("pressed email:", document.getElementById("changedemail").value )
        console.log (this.$regex.checkEmail(document.getElementById("changedemail").value ))
         this.changeEmail= false
      } 

      if (this.changeDoctor){
         console.log("pressed Doctor:", document.getElementById("changedemail").value )
        this.changeDoctor= false
        
      } 
    }
  },
      created(){
      console.log("propDoctor",this.doctor)
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
  padding-left: 5vw;
  float:left;
  width: 10vw;
}
img.edit{
  width: 100%;
  height: auto;
}
img.editOff{
  width: 100%;
  height: 100%;
  filter: invert(80%);
}
.info{
  height: 2vw;
}
.change{
  height: 2vw;
  width: 1vw;
}
.titel{
  height: 2vw;
}
.visibel{
  height: 2vw;
}
.invisibel{
  height: 2vw;
  visibility: hidden;
}


</style>
