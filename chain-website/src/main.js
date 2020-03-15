import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

// antd
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
Vue.use(Antd);

// vue-router
import router from './router.js'

// vuex
import store from './store/index.js'

// vue-axios
import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios,axios);
axios.defaults.headers.post['Content-Type'] = 'application/json';
axios.defaults.baseURL='http://192.168.1.104:8081/';

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})