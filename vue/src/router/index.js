import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import petRegister from '../views/RegisterPet.vue'
import GoogleMapView from '@/views/GoogleMapView.vue'
import RegisterPlaydate from '@/views/RegisterPlaydate.vue'
import PlaydateDetails from '@/views/PlaydateDetails.vue'
import PlaydateView from '@/views/PlaydateView.vue'
import Profile from '@/views/Profile.vue'
import PetDetails from '@/views/PetDetails.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/pet",
      name: "pet-register",
      component: petRegister,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/playdate",
      name: "register-playdate",
      component: RegisterPlaydate,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/view-playdates",
      name: "view-playdates",
      component: PlaydateView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/map",
      name: "map",
      component: GoogleMapView,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/playdate/:playdateId",
      name: "playdate-details",
      component: PlaydateDetails,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/profile/:userId",
      name: "profile",
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },
      {
        path: "/pet/:petId",
        name: "pet-info",
        component: PetDetails,
        meta: {
          requiresAuth: false
        }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
