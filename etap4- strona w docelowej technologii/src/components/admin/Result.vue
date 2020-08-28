<template>
    <div id="temp">
        <ul>
            <li>Andrzej Duda - 30%</li>
            <li>Magłgorzata Kidawa-Błońska - 5%</li>
            <li>Szymon Hołownia - 3%</li>
            <li>Robert Biedroń - 0.5%</li>
            <li>Władysław Kosiniak-Kamysz - 0.5%</li>
            <li><b>Krzysztof Bosak - 33%</b></li>
            <li>Stanisława Żółtek - 1%</li>
            <li>Marek Jakubiak - 7%</li>
            <li>Mirosław Piotrowski - 10%</li>
            <li>Paweł Tanajno - 10%</li>
        </ul>
        <hr>
        <button>Opublikuj</button>
    </div>
</template>

<script>

</script>

<style scoped>
    #temp{
        width:70%;
        margin: 30px auto;
    }
    button{
        margin: auto;
        padding:7px;
        font-size: 15px;
        background: #e60000;
        color: #f7f7f7;
        cursor: pointer;
        border-radius: 3px;
        border: 1px solid #f7f7f7;
    }
    button:hover{
        background: #f7f7f7;
        color: #e60000;
        border: 1px solid #e60000;
    }
    button:active{
        position: relative;
        top: 2px;
    }
</style>
