import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
// import Cloudinary from "cloudinary-vue";

import * as VueGoogleMaps from "vue2-google-maps" // Import package
Vue.config.productionTip = false
Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyDyHKfEtvzTREQ5KW4YnJhYlWBMnlL1Rdk",
    libraries: "places"
  }
});



Vue.config.productionTip = false

axios.defaults.baseURL = process.env.VUE_APP_REMOTE_API;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

// Vue.use(Cloudinary, {
//   configuration: { 
//     cloudName: "demo",
//     secure: true }
// });



