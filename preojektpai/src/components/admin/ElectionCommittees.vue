<template>
    <div>
        <table>
            <tr><td>Komitet Andrzeja Dudy</td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Magłgorzaty Kidawy-Błońskiej </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Szymona Hołownia </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Roberta Biedronia </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Władysława Kosiniak-Kamysz </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Krzysztofa Bosaka </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Stanisławy Żółtek </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Mareka Jakubiaka </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Mirosława Piotrowskiego </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
            <tr><td>Komitet Paweła Tanajno </td><td><button @click="openModal"><i class="fas fa-key"></i></button></td></tr>
        </table>
        <div id="modal">
            Login: <b>admin</b><br>
            Hasło: <b>{{password}}</b><br>
            <button id="reset" @click="newPassword">Restart hasła</button><br>
            <hr>
            <button @click="closeModal">Zamknij</button>
        </div>
    </div>
</template>

<script>
    export default {
        data: function(){
            return{
                password: "asdsadasdasdas",
            }
        },
        methods:{
            openModal: function() {
                let modal= document.getElementById("modal");
                modal.style.display = 'block';
                setTimeout(function(){
                    modal.style.display = 'none'
                }, 30000);
            },
            closeModal: function(){
                let modal= document.getElementById("modal");
                modal.style.display = 'none';
                this.password = "asdsadasdasdas";
            },
            newPassword: function () {
                this.password = "admin1";
            }
        },
    }
</script>

<style scoped>
    div{
        margin: 10px;
    }
    #modal{
        display: none;
        position:fixed;
        top: 60px;
        right: 0;
        width: 30%;
        background: #f7f7f7;
        border: 1px solid #000;
        padding: 10px;
        border-radius: 10px;
    }
    table td{
        padding: 3px;
    }
    #reset{
        font-size: 14px;
        padding: 5px;
        background: #4291ff;
        margin-top: 3px;
    }
    #reset:hover{
        border: 1px solid #000;
        color: #000;
        background: #f1f1f1;

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