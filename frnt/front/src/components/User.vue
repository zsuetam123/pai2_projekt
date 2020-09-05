<template>
    <div class="main">

        <ul>
            <li @click="swapLocalView(1)">Strona główna</li>
            <li @click="swapLocalView(2), candidatesRequest()">Kandydaci i programy wyborcze</li>
            <li @click="swapLocalView(3), candidatesRequest(), votingRequest()">Głosowania</li>
            <input type="submit" value="Wyloguj" @click="swapView(1)">
        </ul>

        <div>
            <UserMainPage v-if="View === 1" :userData="userData"></UserMainPage>
            <Candidates v-if="View === 2" :userData="userData" :candidatesInfo="candidatesInfo" @passfavInfo="passfavInfo" ></Candidates>
            <Vote v-if="View === 3" :userData="userData" :candidatesInfo="candidatesInfo" @swapLocalView="swapLocalView"></Vote>
        </div>

    </div>

</template>

<script>

    import UserMainPage from '../components/UserMainPage.vue'
    import Candidates from './UserCandidates.vue'
    import Vote from './UserVote.vue'

    export default {

        props: ['id'],

        data() {
            return {
                name: "User",
                View:1,
                userData: this.id,
                candidatesInfo:[],
            }
        },

        components: {
            UserMainPage,
            Candidates,
            Vote
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
        background: #f7f7f7;
        padding: 2px;
        width: 60%;
        margin: 0 auto 5px auto;
        border-radius: 5px;
    }
    li {
        display: inline-block;
        margin: 0 10px;

        padding: 5px;
    }
    li:hover {
        cursor: pointer;
        background: #737373;
        color: #f7f7f7;
        border-radius: 5px;
        transition: background .2s ease-in-out, color .2s ease-in-out;
    }
    a {
        color: #42b983;
    }

</style>
