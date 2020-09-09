<template>
    <div>

        <ul>
            <li @click="swapLocalView(1)">Strona główna</li>
            <li @click="swapLocalView(2), candidatesRequest()">Kandydaci i programy wyborcze</li>
            <li @click="swapLocalView(3), candidatesRequest(), votingRequest()">Głosowania</li>
            <li @click="swapLocalView(4), getVotingInfo()">Wyniki</li>
            <input type="submit" value="Wyloguj" @click="swapView(1)">
        </ul>

        <div>
            <UserMainPage v-if="View === 1" :userData="userData"></UserMainPage>
            <Candidates v-if="View === 2" :userData="userData" :candidatesInfo="candidatesInfo" @passfavInfo="passfavInfo" ></Candidates>
            <Vote v-if="View === 3" :userData="userData" :candidatesInfo="candidatesInfo" @swapLocalView="swapLocalView"></Vote>
            <UserVotingResults v-if="View === 4" :VotingInfo = "VotingInfo"></UserVotingResults>
        </div>

    </div>

</template>

<script>

    import UserMainPage from '../components/UserMainPage.vue'
    import Candidates from './UserCandidates.vue'
    import Vote from './UserVote.vue'
    import UserVotingResults from '../components/UserVotingResults.vue'

    export default {

        props: ['id'],

        data() {
            return {
                name: "User",
                View:1,
                userData: this.id,
                candidatesInfo:[],
                VotingInfo: '',
            }
        },

        components: {
            UserMainPage,
            Candidates,
            Vote,
            UserVotingResults,
        },

        methods: {
            swapView(text) {
                this.$emit('changeView', text);
            },

            swapLocalView(text) {
                this.View = text;
            },

            passfavInfo(val){
                this.id[2] = val[0];
                this.id[5] = val[1];
                //console.log(this.id)
            },

            candidatesRequest(){
                this.axios.get('http://localhost:8080/candidates',  null, null
                ).then(response =>{
                    console.log(response);
                    this.candidatesInfo = response.data;
                }).catch(error => {
                    console.log(error);
                })
            },

            votingRequest(){
                this.axios.post('http://localhost:8080/votingcheck',  null, { params: {
                        userId: this.userData[0],
                        dateOfVoting: this.userData[1],
                    }}
                ).then(response =>{
                    console.log(response);
                    this.userData[6] = response.data;
                }).catch(error => {
                    console.log(error);
                })
            },

            getVotingInfo(){
                this.axios.get('http://localhost:8080/getVotingInfo',  null, null
                ).then(response =>{
                    console.log(response);
                    this.VotingInfo = response.data;
                }).catch(error => {
                    console.log(error);
                })
            },

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