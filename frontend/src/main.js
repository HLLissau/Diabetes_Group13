import { createApp } from 'vue'
import axios from 'axios'
import App from './App.vue'
import Backend from './services/backend'
import router from './router'
import Regexchecks from './services/regexchecks'

const app = createApp(App)

app.use(router)


app.config.globalProperties.axios = axios
app.config.globalProperties.$backend = new Backend()
app.config.globalProperties.$regex = new Regexchecks()
app.mount('#app')
router.push('/')
