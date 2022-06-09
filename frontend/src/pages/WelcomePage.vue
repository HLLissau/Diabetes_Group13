<template>
   <div id="nav">
    <router-view/>
    <router-link :to="'/pages/StatsPage'">Stats page</router-link>
    <router-link :to="'/pages/TestPage'">Test page</router-link>

   
  </div>
</template>

<script>
export default {
  name: 'WelcomePage',
  components: {

  }
}
</script>
