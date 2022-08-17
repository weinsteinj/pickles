import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import store from './store/index'
import axios from 'axios'
import * as VueGoogleMaps from "vue2-google-maps" // Import package
//import Cloudinary from "cloudinary-vue"

Vue.config.productionTip = false
Vue.use(VueGoogleMaps, {
  load: {
    key: "AIzaSyCbMJBc_MS9mlIMfrzc96ZgSAZWe-ZvpnA",
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

// // Vue.use(Cloudinary, {
// //   configuration: { 
// //     cloudName: "picklepoints",
// //     secure: true,
// //     key:  "576356229922848",
// //     secret: "ohRGYseZ2p7IlOO_m0nIxeUvF_g"}
// // });

// var cloudinary = require('cloudinary');

// cloudinary.config({
//   cloud_name: "picklepoints", // add your cloud_name
//   api_key: "576356229922848", // add your api_key
//   api_secret: "ohRGYseZ2p7IlOO_m0nIxeUvF_g", // add your api_secret
//   secure: true
//  });
 
// //  cloudinary.v2.api.resources({
// //    type: 'upload',
// //    prefix: 'xx' // add your folder
// //  },
// //    function(error, result) { console.log(result, error) });

