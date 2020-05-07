<template>
    <div>
        <appMenu  @menuValue = "changeMenu($event)"></appMenu>
        <app-index v-if="menu === 1"></app-index>
        <candidates v-if="menu === 2"></candidates>
        <election-programme v-if="menu === 3"></election-programme>
        <help v-if="menu === 4"></help>
        <register v-if="menu === 5"></register>
        <vote v-if="menu === 6 "></vote>

        <app-footer></app-footer>
    </div>
</template>

<script>
    export default{
        data:function () {
            return{
                menu: 1,
                log: true
            }
        },
        methods: {
            changeMenu: function(val){
              this.menu = val;
          }
        },

    }
</script>

<style scoped>

</style>