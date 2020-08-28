<template>
  <div id="app">
    <!--<app-menu></app-menu>-->
    <admin-header></admin-header>
    <committee-menu></committee-menu>
    <router-view></router-view>
    <app-footer></app-footer>
  </div>
</template>

<script>
  export default {
    el: '#app',
  }
</script>

<style>
body{
  background: #f7f7f7;
  margin: 0;
  padding: 0;
  font-family: 'PT Sans', sans-serif;
  max-width: 100%;
  overflow-x: hidden;
}
  #app{
    margin: 0;
    padding: 0;
  }
  div{
    margin: 0;
    padding: 0;
  }
  h1{
    text-align: left;
    padding-left: 10px;
    padding-top: 5px;
    font-weight: bold;
    font-size: 25px;
    letter-spacing: 1px;
  }
</style>
