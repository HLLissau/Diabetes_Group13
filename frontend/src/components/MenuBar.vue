<template>
<nav class = "nav-menubar">
      <router-link class="routerlink" :to="'/pages/StatsPage'"><a>Detailed Data</a></router-link>
      <router-link class="routerlink" :to="'/pages/TestPage'"><a>Test</a></router-link>
      <router-link class="routerlink" :to="'/pages/UserWelcomePage'" ><a class="title">Overview</a></router-link>
</nav>
</template>


<script>
import '../Styling/MenuBarStyling.css';
export default {
  name: 'MenuBar',
}
</script>