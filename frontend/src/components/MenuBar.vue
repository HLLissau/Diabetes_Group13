<template>
<nav class = "nav-menubar">
      <!-- Magnus s191252 -->
      <router-link class="routerlink" :to="'/pages/StatsPage'">Detailed Data</router-link>
      <router-link class="routerlink" :to="'/pages/TestPage'">User</router-link>
      <router-link class="routerlink" :to="'/pages/UserWelcomePage'" >Overview</router-link>
</nav>
</template>


<script>
import '../Styling/MenuBarStyling.css';
export default {
  name: 'MenuBar',
}
</script>