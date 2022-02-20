import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospital.vue'
import AddHospital from './components/AddHospital.vue'
import ListPatients from './components/ListPatients.vue'

const routes = [
  {
    path: '/',
    component: ListHospital,
    name: 'ListHospital'
  },
  {
    path: '/add-hospital',
    component: AddHospital,
    name: 'AddHospital'
  },
  {
    path: '/hospital/:id',
    name: 'ListPatients',
    component: ListPatients
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router