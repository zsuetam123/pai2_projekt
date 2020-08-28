import Vue from 'vue';
import App from './App.vue';
import VueRouter from 'vue-router';

import Menu from './components/shared/Menu.vue';
import AdminHeader from './components/shared/AdminHeader.vue';
import Index from "./components/content/Index.vue";
import Footer from './components/shared/Footer.vue';
import Candidates from './components/content/Candidates.vue';
import ElectionProgramme from './components/content/ElectionProgramme.vue'
import Help from './components/content/Help.vue';
import Vote from './components/content/Vote.vue';
import AdminMenu from './components/shared/AdminMenu.vue';
import Result from './components/admin/Result.vue';
import AdminCandidates from './components/admin/AdminCandidates.vue';
import AdminElectionProgramme from './components/admin/AdminElectionProgramme.vue';
import ElectionCommittees from './components/admin/ElectionCommittees.vue';
import Login from './components/admin/Login.vue';
import Register from "./components/content/Register.vue";
import CommitteeMenu from "@/components/shared/CommitteeMenu.vue";

Vue.component('vote', Vote);
Vue.component('help', Help);
Vue.component('candidates', Candidates);
Vue.component('electionProgramme', ElectionProgramme);
Vue.component('appMenu', Menu);
Vue.component('AdminHeader', AdminHeader);
Vue.component('AdminMenu', AdminMenu);
Vue.component('appIndex', Index);
Vue.component('appFooter', Footer);
Vue.component('result', Result);
Vue.component('adminCandidates', AdminCandidates);
Vue.component('adminElectionProgramme', AdminElectionProgramme);
Vue.component('ElectionCommittees', ElectionCommittees);
Vue.component('Login', Login);
Vue.component('register', Register);
Vue.component('committeeMenu', CommitteeMenu);

import {routes} from './routes';

Vue.use(VueRouter);

const router = new VueRouter({
  mode: 'history',
  routes,
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
