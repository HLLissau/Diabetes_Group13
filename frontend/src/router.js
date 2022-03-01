import { createRouter, createWebHistory } from 'vue-router'

import ListHospital from './components/ListHospital.vue'
import AddHospital from './components/AddHospital.vue'

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
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router