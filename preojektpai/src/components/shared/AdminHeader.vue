<template>
        <header>
            <h1>System zdanlego głosowania na prezydenta RP
                <i class="fas fa-sign-out-alt" @click="send"></i>
            </h1>
        </header>
</template>

<script>
    export default {
        method: {
            send: function(){
                this.$emit('logged', false);
            }
        },
    }
</script>

<style scoped>
    header{
        position: relative;
        width: 100%;
        background: #4291ff;
        box-shadow: 0 5px 10px 0 black;
        margin-top: -15px;
        padding: 2px;
    }
    i{
        color:black;
        float:right;
        margin-right: 10px;
        padding: 3px;
        transition: background 0.1s ease-in-out;
    }
    i:hover{
        color: #f7f7f7;
        border-radius: 5px;
        box-shadow: 0 0 5px 1px #3d3d3d;
        background: #3d3d3d;
        transition: background 0.1s ease-in-out;
    }
</style>