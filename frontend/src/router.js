import { createRouter, createWebHistory } from 'vue-router'

import StatsPage from './pages/StatsPage.vue'
import WelcomePageNoLinks from './pages/WelcomePageNoLinks.vue'
import TestPage from './pages/TestPage.vue'

const routes = [
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage',
    meta: { hideWelcomeChart: true }
  },
  {
    path: '/pages/WelcomePageNoLinks',
    component: WelcomePageNoLinks,
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