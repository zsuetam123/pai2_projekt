import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import VueSimpleAlert from "vue-simple-alert";

Vue.use(VueAxios, axios)
Vue.use(VueSimpleAlert);
Vue.config.productionTip = false

//const axios = require('axios')
//console.log(axios)


new Vue({
  render: h => h(App),
}).$mount('#app')
