<template>
    <div id="content">
        <div id="login" v-if="!vote">
            <label>PESEL</label><br>
            <input type="text" placeholder="PESEL" name="pesel" required>
            <br><br>
            <label>Hasło</label><br>
            <input type="password" placeholder="Hasło" name="password" required>
            <router-link tag="p" to="register">Nie masz konta? Zarejestruj się!</router-link>
            <hr>
            <button type="submit" @click="vote=!vote">Login</button>
        </div>
        <div id="vote" v-if="vote && !end">
            <h1>Zagłosuj na wybranego kandydata</h1>
            <label><input type="radio" name="person" @click="id = 1">Andrzej Duda</label><br>
            <label><input type="radio" name="person" @click="id = 2">Magłgorzata Kidawa-Błońska</label><br>
            <label><input type="radio" name="person" @click="id = 3">Szymon Hołownia</label><br>
            <label><input type="radio" name="person" @click="id = 4">Robert Biedroń</label><br>
            <label><input type="radio" name="person" @click="id = 5">Władysław Kosiniak-Kamysz</label><br>
            <label><input type="radio" name="person" @click="id = 6">Krzysztof Bosak</label><br>
            <label><input type="radio" name="person" @click="id = 7">Stanisława Żółtek</label><br>
            <label><input type="radio" name="person" @click="id = 8">Marek Jakubiak</label><br>
            <label><input type="radio" name="person" @click="id = 9">Mirosław Piotrowski</label><br>
            <label><input type="radio" name="person" @click="id = 10">Paweł Tanajno</label>
            <div id="send">
                <hr>
                <button type="submit" @click="data">ZAGŁOSUJ</button>
            </div>
        </div>
        <div id="end" v-if="end">
            <h1>Zagłosowano na {{candidates[id-1]}}</h1><br>
            <h1>Naród Polski Dziękuje!</h1>
            <hr>
            <router-link tag="button" type="submit" to="/" >Powrót na strone główną</router-link>
        </div>
    </div>

</template>

<script>
    export default {
        data: function () {
            return {
                registration: false,
                vote: false,
                end: false,
                id: -1,
                candidates: [
                    'Andrzej Duda','Magłgorzata Kidawa-Błońska','Szymon Hołownia','Robert Biedroń','Władysław Kosiniak-Kamysz','Krzysztof Bosak',
                    'Stanisława Żółtek','Marek Jakubiak','Mirosław Piotrowski','Paweł Tanajno'
                ],
            }
        },
        methods:{
          data(){
              let txt;
              if (confirm("Czy zgadasz się na przetwarzanie twoich danych?")) {
                  txt = "tak";
              } else {
                  txt = "nie";
              }
              console.log(txt);
              this.end = true;
          }
        },
    }
</script>

<style scoped>
    #content{
        padding-top: 20px;
        text-align: center;
        width:70%;
        margin: auto;
    }
    #login{
        font-size:20px;
        font-weight: bold;
        margin: 28px auto;
        background: #f1f1f1;
        box-shadow: 0 0 20px 2px #000;
        width: 400px;
        height: 300px;
        border-radius: 10px;
        padding-top: 30px;
    }
    #vote{
        text-align: left;
        font-size: 18px;
    }
    input[type=radio]{
        appearance: none;
        width: 16px;
        height: 16px;
        border: 2px solid #4291ff;
        transition: 0.2s all linear;
        margin-right: 5px;
        background: #f1f1f1;
    }
    input[type=radio]:checked{
        border: 2px solid #000;
        background: #4291ff;
        transition: 0.2s all linear;
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
        margin: 0 auto 10px auto;
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
    td{
        text-align: left;
        padding: 0 0 10px 5px;
    }
    #send{
        text-align: right;
    }
    #send #end hr{
        width: 90%;
        margin: 10px;
    }
    p{
        font-size: 15px;
        margin-top: 35px;
        cursor: pointer;
    }
    p:hover{
        color: #75afff;
    }
</style>
