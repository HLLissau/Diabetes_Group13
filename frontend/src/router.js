import { createRouter, createWebHistory } from 'vue-router'

import StatsPage from './pages/StatsPage.vue'
import MenuPage from './pages/MenuPage.vue'
import TestPage from './pages/TestPage.vue'
import UserLogin from './pages/UserLogin.vue'
import DoctorLogin from './pages/DoctorLogin.vue'
import CreateNewAccount from './pages/CreateNewAccount.vue'
import FrontPage from './pages/FrontPage.vue'
const routes = [
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage',
    meta: { hideWelcomeChart: true }
  },
  {
    path: '/Menu',
    component: MenuPage,
    name: 'MenuPage'
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage',
  meta: { hideWelcomeChart: true }
 },
 {
  path: '/pages/UserLogin',
  component: UserLogin,
  name: 'UserLogin',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/DoctorLogin',
  component: DoctorLogin,
  name: 'DoctorLogin',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/CreateNewAccount',
  component: CreateNewAccount,
  name: 'CreateNewAccount',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/FrontPage',
  component: FrontPage,
  name: 'FrontPage',
},

]

const router = createRouter({
  history: createWebHistory(), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router