<template>
    <div>
        <br>
        <br>
        <br>
        <label>Głosowanie {{userData[4]}} {{userData[1]}}</label>
        <br>
        <br>
        <label v-if="userData[5] !== nullCandidate">Ulubiony kandydat {{userData[5]}}<br> Program wyborczy: <br> {{userData[2]}}</label>
        <label v-if="userData[5] === nullCandidate">Brak ulubionego kandydata, przejdź do sekcji "Kandydaci i programy wyborcze" aby wybrać kandydata.</label>
    </div>
</template>

<script>

    export default {

        props: ['userData'],

        data(){
            return {
            name: "UserMainPage",
                nullCandidate:"Brak ulubionego kandydata",
        }
        }

    }



</script>

<style scoped>
    h3 {
        margin: 40px 0 0;
    }
    ul {
        list-style-type: none;
        padding: 0;
    }
    li {
        display: inline-block;
        margin: 0 10px;
    }
    a {
        color: #42b983;
    }
</style>