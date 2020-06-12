<template>
    <div>
        <admin-header></admin-header>
        <div>
            <committee-menu @menuValue = "menu = $event"></committee-menu>
            <div id="margin">
                <result v-if="menu === 1"></result>
                <admin-candidates v-if="menu === 2"></admin-candidates>
                <admin-election-programme v-if="menu === 3"></admin-election-programme>
            </div>
            <div style="clear: both;"></div>
        </div>
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

    }
</script>

<style scoped>

</style>