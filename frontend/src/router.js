import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospitals.vue'
import AddHospital from './components/AddHospital.vue'
import ListPatients from './components/ListPatients'
import StatsPage from './pages/StatsPage.vue'
import WelcomePage from './pages/WelcomePage.vue'
import TestPage from './pages/TestPage.vue'
import WelcomeChart from './components/WelcomeChart.vue'

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
    name: 'StatsPage',
    meta: { hideWelcomeChart: true }
  },
  {
    path: '/pages/WelcomePage',
    component: WelcomePage,
    name: 'WelcomePage'
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage',
  meta: { hideWelcomeChart: true }
 },
 {
  path: '/pages/WelcomeChart',
  component: WelcomeChart,
  name: 'WelcomeChart'
 }
]

const router = createRouter({
  history: createWebHistory(), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router