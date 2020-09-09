<template>
    <div>
        <ul>
            <label>Lista głosowań </label>
            <li v-for="(item, index) in VotingInfo" :key="`item-${index}`">
                <br>
                {{VotingInfo[index][1].substr(0, 10)}}&nbsp;
                <input type="submit" value="Sprawdź wyniki" @click="VotingResults(VotingInfo[index][0]), editView(index)">
                <div v-if="EditView === index">
                    <br>
            <li v-for="(item, index) in candidatesResults" :key="`item-${index}`">
                {{candidatesResults[index].candidates.name}} {{candidatesResults[index].candidates.surname}} {{candidatesResults[index].numberOfVotes}}
            </li>
    </div>
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
                name: "UserVotingResults",
                EditView:'',
                candidatesResults:'',
            }
        },

        methods: {

            VotingResults(VotingId) {
                this.axios.post('http://localhost:8080/getVotingResultsForUser', null, {
                    params: {
                        VotingId: VotingId,
                    }
                }).then(response => {
                    console.log(response);
                    this.candidatesResults = response.data;
                    // this.refresh(5);
                }).catch(error => {
                    console.log(error);
                    this.$alert("Brak wyników głosowania");
                })
            },

            editView(ind){
                if(this.EditView === ind){
                    this.EditView = 'a';
                }else {
                    this.EditView = ind;
                }},

        }
    }
</script>

<style scoped>

</style>