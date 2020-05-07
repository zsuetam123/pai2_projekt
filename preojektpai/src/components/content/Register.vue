<template>
    <div>
        <div id="login">
            <h2>Rejestracja</h2>
            <label>PESEL</label><br>
            <input type="text" placeholder="PESEL" name="pesel" required>
            <br><br>
            <label>Hasło</label><br>
            <input type="password" placeholder="Hasło" name="password" required>
            <br><br>
            <label>Powrórz hasło</label><br>
            <input type="password" placeholder="Hasło" name="password" required>
            <hr>
            <button type="submit">Zarejestruj się</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Register"
    }
</script>

<style scoped>
    #login{
        text-align: center;
        font-size:20px;
        font-weight: bold;
        margin: 15px auto;
        background: #f1f1f1;
        box-shadow: 0 0 20px 2px #000;
        width: 400px;
        height: 500px;
        border-radius: 10px;
        padding-top: 30px;
    }
    input[type=text]{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        width: 65%;
        text-align: center;
        height: 30px;
        font-size:20px;
        background: #fff;
        border: 1px solid black;
        border-radius: 2px;
    }
    input[type=text]:focus{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        background: #75afff;
        height: 34px;
        width: 80%;
        color: #fff;
    }
    input[type=password]{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        width: 65%;
        text-align: center;
        height: 30px;
        font-size:20px;
        background: #fff;
        border: 1px solid black;
        border-radius: 2px;
    }
    input[type=password]:focus{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        background: #75afff;
        height: 34px;
        width: 80%;
        color: #fff;
    }
    hr{
        margin-top: 45px;
        width: 70%;
    }
    button{
        margin: auto;
        padding: 10px;
        font-size: 18px;
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