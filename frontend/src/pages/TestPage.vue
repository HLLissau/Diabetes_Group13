<template>
  <div class="wrap">
    <div id="menubar">
       <MenuBar/>
    </div>
    <div id="info">
      <UserInfo :user = "this.user" :doctor = "this.doctor"/>
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
    async pullData(){
      this.user = this.$backend.getUser()
      await this.axios
        .get(this.$backend.getUrlDoctorOfUser())
        .then(res => {
          var obje = res.data
          this.$backend.doctor =  obje[0]

          console.log("inDoctor: ", this.$backend.doctor)
          })
      console.log("inDoctor2: ", this.$backend.doctor)
      

    },
  },
  async created(){
      await this.pullData()
  }
}
</script>

<style>

div#info {
  padding-top: 80px;
  background-color: yellow;
}

</style>

