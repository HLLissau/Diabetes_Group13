import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospitals.vue'
import AddHospital from './components/AddHospital.vue'
import ListPatients from './components/ListPatients'
import StatsPage from './pages/WelcomePage.vue'
import WelcomePage from './pages/StatsPage.vue'
import TestPage from './pages/TestPage.vue'

const routes = [
  {
    path: '/',
    component: ListHospital,
    name: 'ListHospitals'
  },
  {
    path: '/add-hospital',
    component: AddHospital,
    name: 'AddHospital'
  },
  {
    path: '/hospital/:id/:patients',
    component: ListPatients,
    name: 'ListPatients'
  },
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage'
  },
  {
    path: '/pages/WelcomePage',
    component: WelcomePage,
    name: 'WelcomePage'
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage'
 }
]

const router = createRouter({
  history: createWebHistory('configure-admin'), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router