import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospitals.vue'
import AddHospital from './components/AddHospital.vue'
import ListPatients from './components/ListPatients'
import StatsPage from './pages/WelcomePage.vue'
import WelcomePage from './pages/StatsPage.vue'

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
    path: './pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage'
  },
  {
    path: './pages/WelcomePage',
    component: WelcomePage,
    name: 'WelcomePage'
  },
  
 

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router