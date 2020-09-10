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
      View:4,
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
  ul, li {
    list-style-type: none;
  }
  #app {
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  body{
    background: #f7f7f7;
    font-family: 'Barlow', sans-serif;
  }
  input[type=submit], input[type=button]{
    background: #75afff;
    border-radius: 5px;
    border: 2px solid #4291ff;
    padding: 5px 10px;
  }
  input[type=button]{
    border: 2px solid #42b983;
    background: #3c9c6c;
    color: #f7f7f7;
  }
  input[type=text]{
    margin: 5px 7px;
    padding: 5px;
    border: 1px solid #3d3d3d;
    border-radius: 3px;
    background: white;
  }
  input[type=text]:focus{
    border: 1px solid #272727;
    background: #dedede;
  }
  input[type=button]:hover{
    background: #3c8c5c;
  }
  input[type=submit]:hover{
    background: #7593ea;
  }
  .main{
    background: #efefef;
    width: 80%;
    margin: auto;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 0 10px 1px #6d6d6d;
  }
</style>
