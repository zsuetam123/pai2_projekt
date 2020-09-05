<template>
    <div class="main">
        <ul>
            <li @click="swapLocalView(1)">Strona glowna</li>
            <li @click="swapLocalView(2), getVotingInfo()">Głosowania</li>
            <li @click="swapLocalView(3), getCandidatesInfo()" >Kandydaci</li>

            <input type="submit" value="Wyloguj" @click="swapView(1)">
        </ul>

        <div>
            <AdminMainPage v-if="View === 1"></AdminMainPage>
            <AdminAddVoting v-if="View === 2" :VotingInfo="VotingInfo" @refresh="refresh"></AdminAddVoting>
            <AdminCandidates v-if="View === 3" :CandidatesInfo ="CandidatesInfo" @refresh="refresh"></AdminCandidates>
        </div>

    </div>
</template>

<script>

    import AdminAddVoting from '../components/AdminAddVoting.vue'
    import AdminMainPage from '../components/AdminMainPage.vue'
    import AdminCandidates from '../components/AdminCandidates.vue'

    export default {

        data() {
            return {
                name: "Admin",
                View: 1,
                VotingInfo: '',
                CandidatesInfo: '',
            }
        },

        components: {
            AdminAddVoting,
            AdminMainPage,
            AdminCandidates,
        },

        methods: {
            swapView(text) {
                this.$emit('changeView', text);
            },

            swapLocalView(text) {
                this.View = text;
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

            getCandidatesInfo(){
                this.axios.get('http://localhost:8080/getCandidatesInfo',  null, null
                ).then(response =>{
                    console.log(response);
                    this.CandidatesInfo = response.data;
                }).catch(error => {
                    console.log(error);
                })
            },

            refresh(text){
              if(text === 2) {
                  this.swapLocalView(text);
                  this.getVotingInfo();
              }
              if(text === 3){
                  this.swapLocalView(text);
                  this.getCandidatesInfo();
              }
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
