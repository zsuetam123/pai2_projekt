<template>
    <div id="menu">
        <ul>
            <li class="free" @click="changeMenu(1)">Wyniki</li>
            <li class="free" @click="changeMenu(2)">Kandydaci</li>
            <li class="free" @click="changeMenu(3)">Program wyborczy</li>
        </ul>
    </div>
</template>

<script>
    export default{
        methods:{
            changeMenu(id) {
                this.$emit('menuValue', id);
            }
        }

    }
</script>

<style scoped>
    #menu{
        padding-top: 10px;
        height: 100%;
        background: #f1f1f1;
        width: 12%;
        position: fixed;
        box-shadow: 1px 2px 10px 0 black;
        float:left
    }
    ul{
        float: left;
        list-style-type: none;
        padding: 7px;
        margin: 4px;
    }
    li{
        padding: 5px;
        transition: background 0.1s ease-in-out;
    }
    li:hover{
        background: #fff;
        cursor: pointer;
        border-radius: 5px;
        box-shadow: 0 0 5px 1px #fff;
        transition: background 0.1s ease-in-out;
    }

</style>