import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospitals.vue'
import AddHospital from './components/AddHospital.vue'
import ListPatients from './components/ListPatients'
//import StatsPage from './pages/Stats.vue'
//import WelcomePage from './pages/Welcome.vue'

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
 

]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router