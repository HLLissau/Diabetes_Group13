<template>
<nav class = "nav-menubar">
      <router-link class="routerlink" :to="'/pages/StatsPage'">Detailed Data</router-link>
      <router-link class="routerlink" :to="'/pages/TestPage'">Test</router-link>
      <router-link class="routerlink" :to="'/pages/UserWelcomePage'" >Overview</router-link>
</nav>
</template>


<script>
import '../Styling/MenuBarStyling.css';
export default {
  name: 'MenuBar',
}
</script>