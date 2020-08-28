<template>
    <div id="temp">
        <ul v-for="(candidate, index) in candidates" :key="index">
            <li>
                <b>{{candidate.name}}       </b>
                <button @click="setVal(index)">X</button>
            </li>
            <li>
                {{candidate.progrmae}}
            </li>
        </ul>
        <hr>
        <div>
            <label>Podaj nowy program dla <b>{{currentCandidate}}</b></label><br>
            <input id="text" type="text" v-model="newProgram"><br><br>
            <button @click="changeVal">Dodaj</button>
        </div>
        <br>

    </div>
</template>

<script>
    export default{
        data: function(){
            return{
                candidates: [
                    {name: 'Andrzej Duda', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Magłgorzata Kidawa-Błońska', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Szymon Hołownia', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Robert Biedroń', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Władysław Kosiniak-Kamysz', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Krzysztof Bosak', progrmae:'bosakLorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Stanisława Żółtek', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Marek Jakubiak', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Mirosław Piotrowski', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                    {name: 'Paweł Tanajno', progrmae:'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'},
                ],
                newProgram: '',
                currentCandidate: '',
                index: 0,
            }
        },
        methods:{
            setVal(index){
                this.index = index;
                this.currentCandidate = this.candidates[index].name;
                this.newProgram = this.candidates[index].progrmae;
            },
            changeVal(){
                this.candidates[this.index].progrmae = this.newProgram;
            },
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
        margin:10px 0;
        transition: width 0.4s ease-in-out, height 0.4s ease-in-out, background 0.4s ease-in-out;
        width: 35%;
        text-align: left;
        height: 30px;
        font-size:18px;
        background: #fff;
        border: 1px solid black;
        border-radius: 2px;
        padding: 1px 5px;
    }
    input[type=text]:focus{
        transition: width 0.4s ease-in-out, background 0.4s ease-in-out;
        background: #75afff;
        width: 70%;
    }
    ul, li{
        list-style-type: none;
    }
</style>
