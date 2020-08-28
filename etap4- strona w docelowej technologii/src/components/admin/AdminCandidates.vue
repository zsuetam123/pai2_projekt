<template>
    <div id="temp">
        <table v-for="(candidate, index) in candidates" :key="index">
            <tr>
                <td>
                    {{candidate}}
                </td>
                <td>
                    <button @click="del(index)">X</button>
                </td>
            </tr>
        </table>

            <hr>
            <br>
        <label>Podaj nazwisko nowego kandydata </label><br><br>
            <input id="name" type="text" v-model="newCandidate"><br><br>
        <button @click="addCandidate">Dodaj</button>
    </div>
</template>

<script>
export default{
    data: function(){
        return{
            candidates: [
                'Andrzej Duda',
                'Magłgorzata Kidawa-Błońska',
                'Szymon Hołownia',
                'Robert Biedroń',
                'Władysław Kosiniak-Kamysz',
                'Krzysztof Bosak',
                'Stanisława Żółtek',
                'Marek Jakubiak',
                'Mirosław Piotrowski',
                'Paweł Tanajno'
            ],
            newCandidate: '',
        }
    },
    methods:{
        del(index){
            this.candidates.splice(index, 1);
        },
        addCandidate() {
            this.candidates.push(this.newCandidate);
            this.newCandidate = '';
        }
    }
}
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
    input[type=text]{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        width: 15%;
        text-align: left;
        height: 30px;
        font-size:20px;
        background: #fff;
        border: 1px solid black;
        border-radius: 2px;
        padding: 1px 5px;
    }
    input[type=text]:focus{
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        background: #75afff;
        height: 30px;
        width: 18%;
        color: #fff;
    }
</style>
