<template>
    <div>
        <br>
        <form @submit.prevent="addVoting" >
            <p>
                <label>Data głosowania: </label>
                <input id="Data" type="date" class="form-control" v-model="data" required>&nbsp;
                <input type="submit" value="Dodaj głosowanie">
            </p>
            <br>
            <br>
        </form>
        <ul> <label>Lista głosowań </label>
            <li v-for="(item, index) in VotingInfo" :key="`item-${index}`">
                <br>
                {{VotingInfo[index][1].substr(0, 10)}}&nbsp;
                <input type="submit" value="Usuń" @click="deleteVoting(VotingInfo[index][0])">
            </li>
        </ul>
    </div>
</template>

<script>
    export default {

        props: [
            'VotingInfo',],

        data() {
            return {
                name: "AdminAddVoting",
                data: '',
                status: '',
            }
        },

        methods:{

            addVoting() {
                this.axios.post('http://localhost:8080/addVotingDate',  null, { params: {
                        data: this.data,
                    }}).then(response =>{
                   // console.log(this.data);
                    this.status = response.data;
                    if(this.status === "Termin zajety")
                    {
                        this.data = '';
                        this.$alert("Termin zajęty");
                    }else
                    {
                        this.data = '';
                        this.$alert("Dodano głosowanie");
                    }
                    console.log(response);
                    this.refresh(2);
                }).catch(error => {
                    console.log(error);
                    this.data = ''
                    this.$alert("Podczas dodawania głosowania wystąpił błąd");
                })
            },

            refresh(val){
                this.$emit('refresh',val);
            },

            deleteVoting(dayId) {
                this.axios.post('http://localhost:8080/deleteVotingDate',  null, { params: {
                        dayId: dayId,
                    }}).then(response =>{

                    console.log(response);
                    this.$alert(response.data);
                    this.refresh(2);
                }).catch(error => {

                    console.log(error);
                })},


                }
                }



</script>

<style scoped>

</style>