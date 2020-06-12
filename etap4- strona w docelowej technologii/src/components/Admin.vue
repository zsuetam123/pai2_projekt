<template>
    <div>
        <admin-header></admin-header>
        <div>
            <admin-menu @menuValue = "menu = $event"></admin-menu>
            <div id="margin">
                <result v-if="menu === 1"></result>
                <admin-candidates v-if="menu === 2"></admin-candidates>
                <admin-election-programme v-if="menu === 3"></admin-election-programme>
                <election-committees v-if="menu === 4"></election-committees>
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