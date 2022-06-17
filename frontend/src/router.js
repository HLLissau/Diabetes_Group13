import { createRouter, createWebHistory } from 'vue-router'

import StatsPage from './pages/StatsPage.vue'
import MenuPage from './pages/MenuPage.vue'
import TestPage from './pages/TestPage.vue'
import UserLogin from './pages/UserLogin.vue'
import DoctorLogin from './pages/DoctorLogin.vue'
import CreateNewAccount from './pages/CreateNewAccount.vue'
import FrontPage from './pages/FrontPage.vue'
import UserWelcomePage from './pages/UserWelcomePage.vue'
const routes = [
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage',
    meta: { hideWelcomeChart: true, hideFrontPage: true}
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage',
  meta: { hideWelcomeChart: true, hideFrontPage: true,hideRouterLinks: false}
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
  meta: {showCreateMenu:true, hideFrontPage: true }
},
{
  path: '/pages/CreateNewUserAccount',
  component: CreateNewAccount,
  name: 'CreateNewUserAccount',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/CreateNewDoctorAccount',
  component: CreateNewAccount,
  name: 'CreateNewDoctorAccount',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/FrontPage',
  component: FrontPage,
  name: 'FrontPage',
  meta: { hideFrontPage: false }
},
{
  path: '/pages/MenuPage',
  component: MenuPage,
  name: 'MenuPage',
  meta: { hideFrontPage: true }
},
{
  path: '/pages/UserWelcomePage',
  component: UserWelcomePage,
  name: 'UserWelcomePage',
  props: true,
  meta: { hideFrontPage: true }
},

]

const router = createRouter({
  history: createWebHistory(), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router