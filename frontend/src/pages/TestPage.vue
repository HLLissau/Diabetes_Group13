<template>
  <div class="wrap">
    <div id="menubar">
       <MenuBar/>
    </div>
    <div id="info">
      <UserInfo :user = "this.user" :doctor = "this.doctor"/>
    </div>
     <input class="goback-button" type="submit"  @click="this.deleteUser()" value="Delete User">

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
    deleteUser(){
     
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
}

</style>

