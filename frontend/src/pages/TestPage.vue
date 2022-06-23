<template> <!-- Erik s204438 -->
  <div class="info-wrap">
    <div id="menubar">
       <MenuBar/>
    </div>
    <div id="info">
      <UserInfo :user = "this.user" :doctor = "this.doctor"/>
      <input class="goback-button" type="submit"  @click="this.deleteUser()" value="Delete User">
    </div>

  </div>
</template>


<script>
import MenuBar from '../components/MenuBar.vue'
import UserInfo from '../components/UserInfo.vue'

export default {
  name: 'TestPage',
  components: {
    MenuBar,
    UserInfo,
    id : 0
  },
  data() {
    return {
      user: '',
      doctor: ''
    }
  },
  methods: {
    deleteUser(){ //Erik s204438
     
      var password = prompt('Your message to the user', 'Suggested user input')
    
      console.log("Boom")
      this.axios
        .delete(this.$backend.deleteUrlDeleteUser()+ "/" + password)
        .then(res => {
          var obje = res
          console.log("deleteUserPressed",obje)
          this.$router.push('/')

      
          })
     
  


    }
  },
  
}
</script>

<style>

div#info {
  padding-top: 80px;
  padding-left: 5vw;
}
input.goback-button{
    width: 20vw;
    height: auto;
    margin-bottom: 15px;
    border: none;
    border-radius: 3px;
    color: #ffffff;
    cursor: pointer;
    font-size: 1.8vw;
    margin-top: 5vh;
    margin-bottom: 5vh;
    background: #940000;
}

</style>

