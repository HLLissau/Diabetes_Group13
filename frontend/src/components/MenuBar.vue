<template>
<div>
      <router-link class="routerlink" :to="'/pages/StatsPage'">Stats page</router-link>
      <router-link class="routerlink" :to="'/pages/TestPage'">Test page</router-link>
      <router-link class="routerlink" :to="'/pages/UserWelcomePage'" >Menu</router-link>
</div>
</template>


<script>
export default {
  name: 'MenuBar',
}
</script>


<style>
.links .routerlink {
  color:orange;
  background-color: yellow;
  text-decoration: none;

  border-bottom: 3px solid transparent;
  border-top: 3px solid transparent;
  padding: 10px 20px;

}
.welcome-wrap{
  overflow: hidden;
  widows: 50vw;
}
header {
  background-color: #222;
  padding: 15px;
}
</style>