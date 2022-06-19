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
    UserInfo
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
        .get(this.$backend.getDoctorOfUser())
        .then(res => {
          this.doctor = res.data
          console.log("inDoctor",this.doctor)
          });
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

