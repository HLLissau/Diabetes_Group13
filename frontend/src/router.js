import { createRouter, createWebHistory } from 'vue-router'

import StatsPage from './pages/StatsPage.vue'
import WelcomePage from './pages/WelcomePageNoLinks.vue'
import TestPage from './pages/TestPage.vue'

const routes = [
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage',
    meta: { closeWelcomeChart: true }
  },
  {
    path: '/pages/WelcomePageNoLinks',
    component: WelcomePage,
    name: 'WelcomePageNoLinks'
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage',
  meta: { hideWelcomeChart: true }
 }
]

const router = createRouter({
  history: createWebHistory(), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router