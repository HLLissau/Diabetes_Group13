import { createRouter, createWebHistory } from 'vue-router'

import StatsPage from './pages/StatsPage.vue'
import MenuPage from './pages/MenuPage.vue'
import TestPage from './pages/TestPage.vue'
import UserLogin from './pages/UserLogin.vue'
import DoctorLogin from './pages/DoctorLogin.vue'
import CreateNewAccount from './pages/CreateNewAccount.vue'
import CreateNewUserAccount from './pages/CreateNewUserAccount.vue'
import CreateNewDoctorAccount from './pages/CreateNewDoctorAccount.vue'
import FrontPage from './pages/FrontPage.vue'
import UserWelcomePage from './pages/UserWelcomePage.vue'
import DoctorWelcomePage from './pages/DoctorWelcomePage.vue'




const routes = [
  {
    path: '/pages/StatsPage',
    component: StatsPage,
    name: 'StatsPage',
    meta: { hideWelcomeChart: true, }
  },
 {
  path: '/pages/TestPage',
  component: TestPage,
  name: 'TestPage',
  meta: { hideWelcomeChart: true, hideRouterLinks: false}
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
  meta: {  }
},
{
  path: '/pages/CreateNewAccount',
  component: CreateNewAccount,
  name: 'CreateNewAccount',
  meta: {showCreateMenu:true,  }
},
{
  path: '/pages/CreateNewUserAccount',
  component: CreateNewUserAccount,
  name: 'CreateNewUserAccount',
  meta: { }
},
{
  path: '/pages/CreateNewDoctorAccount',
  component: CreateNewDoctorAccount,
  name: 'CreateNewDoctorAccount',
  meta: { }
},
{
  path: '/pages/FrontPage',
  component: FrontPage,
  name: 'FrontPage',
  meta: { }
},
{
  path: '/pages/MenuPage',
  component: MenuPage,
  name: 'MenuPage',
  meta: { showFrontPage: true }
},
{
  path: '/',
  component: MenuPage,
  name: '/',
  meta: { showFrontPage: true }
},
{
  path: '/pages/UserWelcomePage',
  component: UserWelcomePage,
  name: 'UserWelcomePage',
  props: true,
  meta: {  }
},
{
  path: '/pages/DoctorWelcomePage',
  component: DoctorWelcomePage,
  name: 'DoctorWelcomePage',
  props: true,
  meta: {  }
},

]

const router = createRouter({
  history: createWebHistory(), 

  routes: routes,
  linkActiveClass: 'active'
});

export default router