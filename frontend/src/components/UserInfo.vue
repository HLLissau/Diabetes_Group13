<template>
<div>
<div id="titles"> 
  <div class="titel"><a> User ID </a></div>
  <div class="titel"><a> Doctor Name </a></div>
  <div class="titel"><a> Full Name </a></div>
  <div class="titel"><a> email-address </a></div>
    <div class="titel"><a> password </a></div>
</div>
<div id="props"> 
  <div class="lockedinfo"><a> {{this.$backend.user.id}} </a></div>
  <div class="lockedinfo"><a> {{this.$backend.doctor.fullName}} </a></div>
  <div class="info"><a> {{this.$backend.user.fullName}} </a></div>
  <div class="info"><a> {{this.$backend.user.email}} </a></div>
  <div class="info"><a> ****** </a></div>
</div>
<div id="alter"> 
  <div class="invisibel"> invisibel </div>
  <div class="invisibel"> invisibel </div>
  <div class="change" v-on:click = "this.changeName = !this.changeName, this.changePassword = false, this.changeEmail = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
  <div class="change" v-on:click = "this.changeEmail = !this.changeEmail, this.changePassword = false, this.changeName = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
  <div class="change" v-on:click = "this.changePassword = !this.changePassword, this.changeEmail = false, this.changeName = false, this.changeDoctor = false" > <img class="edit" src="../assets/editing.png" alt="Fejl"> </div>
</div>

<div id="inputs"> 
  <div class="invisibel"> d <input type="text" > </div>
  <div class="invisibel"> d <input type="text" > </div>
  <div :class="[changeName?'visibel':'invisibel']"> <input type="text" id="changedname" placeholder="new name">  <input class="button" type="submit"  @click="change()" value="Change"  > </div>
  <div :class="[changeEmail?'visibel':'invisibel']"> <input type="text" id="changedemail" placeholder="new email">   <input class="button" type="submit"  @click="change()" value="Change"  > </div>
  <div :class="[changePassword?'visibel':'invisibel']"> <input type="text" id="oldpassword" placeholder="old password"> <input type="text" id="newpassword" placeholder="new password"> <input class="button" type="submit"  @click="change()" value="Change"> </div>
  
</div>

</div>
</template>


<script>
export default {
  name: 'UserInfo',
  props: [],
  data() {
    return {   
        changeName: false,
        changeEmail: false,
        changePassword: false
    }
  },
  methods: {
    change(){
      console.log("kørt")
      if (this.changeName){
        this.$regex.checkName(document.getElementById("changedname").value )
        this.$backend.user.fullName = document.getElementById("changedname").value
        this.changeName= false
      }
      if (this.changeEmail){
        this.$regex.checkEmail(document.getElementById("changedemail").value)
        this.$backend.user.email = document.getElementById("changedemail").value
        this.changeEmail= false
      } 
      if (this.changePassword){
        this.$regex.checkpassword(document.getElementById("oldpassword").value, this.$backend.user.password)
        this.$backend.user.password = document.getElementById("newpassword").value
        this.changePassword = false
      }
      console.log("url",this.$backend.getUrlUpdateUser())
            this.axios
        .get(this.$backend.getUrlUpdateUser())
        .then(res => {
          console.log("updated",res)
        })
             
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
.lockedinfo{
  font-weight: bold;
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
