<template>
   <div id="nav">
    <h1>Welcome!</h1>
    <router-link :to="'/pages/TestPage'">Test page</router-link>
    <router-link :to="'/pages/StatsPage'">Stats page</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'WelcomePage',
  components: {

  }
}
</script>
