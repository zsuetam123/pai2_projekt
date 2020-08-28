import Index from "./components/content/Index.vue";
import Candidates from './components/content/Candidates.vue';
import ElectionProgramme from './components/content/ElectionProgramme.vue'
import Help from './components/content/Help.vue';
import Vote from './components/content/Vote.vue';
import Result from './components/admin/Result.vue';
import AdminCandidates from './components/admin/AdminCandidates.vue';
import AdminElectionProgramme from './components/admin/AdminElectionProgramme.vue';
import ElectionCommittees from './components/admin/ElectionCommittees.vue';
import Login from './components/admin/Login.vue';
import Register from "./components/content/Register.vue";


export const routes = [
    {path: '', component: Index},
    {path: '/candidates', component: Candidates},
    {path: '/election-program', component: ElectionProgramme},
    {path: '/help', component: Help},
    {path: '/register', component: Register},
    {path: '/vote', component: Vote},
    {path: '/result', component: Result},
    {path: '/admin-candidates', component: AdminCandidates},
    {path: '/admin-election-programme', component: AdminElectionProgramme},
    {path: '/election-committee', component: ElectionCommittees},
    {path: '/login', component: Login},
];
