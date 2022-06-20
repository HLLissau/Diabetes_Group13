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
    
  },
  
}
</script>

<style>

div#info {
  padding-top: 80px;
  background-color: yellow;
}

</style>

