<template>
<nav class = "nav-menubar">
      <router-link class="routerlink" :to="'/pages/StatsPage'">Stats page</router-link>
      <router-link class="routerlink" :to="'/pages/TestPage'">Test page</router-link>
      <router-link class="routerlink" :to="'/pages/UserWelcomePage'" >Menu</router-link>
</nav>
</template>


<script>
import '../Styling/MenuBarStyling.css';
export default {
  name: 'MenuBar',
}
</script>