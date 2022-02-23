
import { createApp } from 'vue'
import axios from 'axios'
import App from './App.vue'
import Backend from './services/backend'
import router from './router'
import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import { Vue } from 'vue/types/vue'

Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

const app = createApp(App)

app.use(router)

app.config.globalProperties.axios = axios
app.config.globalProperties.$backend = new Backend()

app.mount('#app')


