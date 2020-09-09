<template>
  <div id="app">

    <Logowanie v-if="View === 1" @passId="passId" @changeView="changeView" ></Logowanie>
    <User v-if="View === 2" @changeView="changeView" :id="id"></User>
    <Register v-if="View === 3" @changeView="changeView"></Register>
    <Admin v-if="View === 4" @changeView="changeView"></Admin>
    <ElectionStaff v-if="View === 5" @changeView="changeView" :id="id"></ElectionStaff>

  </div>
</template>

<script>
import Logowanie from './components/Logowanie.vue'
import User from './components/User.vue'
import Register from './components/Register.vue'
import Admin from './components/Admin.vue'
import ElectionStaff from './components/ElectionStaff.vue'

export default {
  data: function(){
    return{
      View:1,
      log:true,
      id:''
    }
  },

  name: 'App',
  components: {
    Logowanie,
    User,
    Register,
    Admin,
    ElectionStaff,
  },

  methods: {
    changeView(val) {
      this.View = val;
    },

    passId(val){
      this.id = val;
      //console.log(this.id)
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
