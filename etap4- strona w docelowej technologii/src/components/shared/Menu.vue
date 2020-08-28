<template>
    <div>
        <header>
        <h1>System zdanlego głosowania na prezydenta RP</h1>
        <ul>
            <router-link tag="li" to="/">Strona główna</router-link>
            <router-link tag="li" to="/candidates">Kandydaci</router-link>
            <router-link tag="li" to="/election-program">Program wyborczy</router-link>
            <router-link tag="li" to="/help">Pomoc</router-link>
            <router-link tag="li" to="/vote" id="vote">Głosowanie</router-link>
            <router-link tag="li" to="/register" id="reg">Resjestracja</router-link>
        </ul>
        <div style="clear:both;"></div>
        </header>
        <div style="height: 120px;"></div>
    </div>
</template>

<script>

</script>


<style scoped>
    header{
        position: fixed;
        width: 100%;
        background: #4291ff;
        text-align: center;
        box-shadow: 0 5px 10px 0 black;
    }
    ul:hover{
        cursor: pointer;
    }
    ul {
        margin: 0;
        padding: 0 0 0 5px;
        list-style-type: none;
        height: 35px;
        background: #3d3d3d;
        color: #f7f7f7;
        box-shadow:  0 -2px 5px 0 black;
    }
    li{
        float: left;
        padding: 7px;
        border-right: 1px solid black;

    }
    li:hover{
        background: #636363;
    }
    #vote{
        float: right;
        background: #e60000;
        color: #f7f7f7;
        cursor: pointer;
        max-width: 100px;
    }
    #vote:hover{
        background: #f7f7f7;
        color: #e60000;
        border-radius: 3px;
        transition: all 0.15s ease-in-out;
    }
    #vote:active{
        position: relative;
        top: 2px;
    }
    #reg{
        float: right;
        background: #f7f7f7;
        color: #e60000;
        cursor: pointer;
        max-width: 100px;
        margin-right: 3px;
    }
    #reg:hover{
        background: #e60000;
        color: #f7f7f7;
        border-radius: 3px;
        transition: all 0.15s ease-in-out;
    }
    #reg:active{
        position: relative;
        top: 2px;
    }
</style>
