<template>
    <div>
        <textarea id="text" rows="15" cols="34">
            <ul>
                <li>Andrzej Duda</li>
                <li>Magłgorzata Kidawa-Błońska</li>
                <li>Szymon Hołownia</li>
                <li>Robert Biedroń</li>
                <li>Władysław Kosiniak-Kamysz</li>
                <li>Krzysztof Bosak</li>
                <li>Stanisława Żółtek</li>
                <li>Marek Jakubiak</li>
                <li>Mirosław Piotrowski</li>
                <li>Paweł Tanajno</li>
            </ul>
        </textarea>
        <hr>
        <button>Zapisz zmiany</button>
    </div>
</template>

<script>

</script>

<style scoped>
    #text{
        margin: 10px;
        box-shadow: inset 1px 2px 10px 0 black;
        padding: 2px;
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