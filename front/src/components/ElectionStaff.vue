<template>
    <div class="main">
        <ul>
            <li @click="swapLocalView(1)">Strona glowna</li>
            <li @click="swapLocalView(2), getDemandsInfo()">Kampania</li>
            <li @click="swapLocalView(3), getFavCandidateInfo()">Statystyki</li>

            <input type="submit" value="Wyloguj" @click="swapView(1)">
        </ul>

        <div>
            <ElectionStaffMainPage v-if="View === 1"></ElectionStaffMainPage>
            <ElectionStaffDemands v-if="View === 2" :DemandsInfo = "DemandsInfo"></ElectionStaffDemands>
            <ElectionStaffFollow v-if="View === 3" :FavCandidateInfo = "FavCandidateInfo"></ElectionStaffFollow>
        </div>

    </div>
</template>

<script>

    import ElectionStaffDemands from '../components/ElectionStaffDemands.vue'
    import ElectionStaffFollow from '../components/ElectionStaffFollow'
    import ElectionStaffMainPage from '../components/ElectionStaffMainPage'

    export default {

        props: ['id'],

        data() {
            return {
                name: "ElectionStaff",
                View: 1,
                DemandsInfo: '',
                FavCandidateInfo:'',
            }
        },

        components: {
            ElectionStaffDemands,
            ElectionStaffMainPage,
            ElectionStaffFollow
        },

        methods: {
            swapView(text) {
                this.$emit('changeView', text);
            },

            swapLocalView(text) {
                this.View = text;
            },

            getDemandsInfo(){
                this.axios.post('http://localhost:8080/getDemandsInfo', null, { params: {
                    id: this.id[1],
                    }}
                ).then(response =>{
                    console.log(response);
                    this.DemandsInfo = response.data;
                }).catch(error => {
                    console.log(error);
                })
            },

            getFavCandidateInfo(){
                this.axios.post('http://localhost:8080/getFavCandidateInfo', null, { params: {
                        id: this.id[2],
                    }}
                ).then(response =>{
                    console.log(response);
                    this.FavCandidateInfo = response.data;
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
