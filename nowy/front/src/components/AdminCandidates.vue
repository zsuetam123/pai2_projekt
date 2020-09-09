<template>
    <div>
        <br>
        <br>
        <form @submit.prevent="addCandidate">
            <p>
                <label>Nowy kandydat: </label>
                <input id="CandidateName" type="text" v-model="CandidateName" placeholder="Imię" required>&nbsp;
                <input id="CandidateSurname" type="text" v-model="CandidateSurname" placeholder="Nazwisko" required>&nbsp;
                <input type="submit" value="Dodaj kandydata">
            </p>
        </form>
            <br>
            <br>
        <ul> <label>Lista kandydatów:</label>
            <br>
            <li v-for="(item, index) in CandidatesInfo" :key="`item-${index}`">
                <br>
                {{CandidatesInfo[index].name}}&nbsp;{{CandidatesInfo[index].surname}}&nbsp;
                <input type="submit" value="Usuń" @click="deleteCandidate(CandidatesInfo[index].id)">&nbsp;
                <input type="submit" value="Edytuj" @click="editView(index)">
                <div v-if="EditView === index">
                    <br>
                <form @submit.prevent="editCandidate(CandidatesInfo[index].id)">
                    <label>Edytuj kandydata: </label>
                    <input type="text" v-model="editCandidateName" placeholder="Imię" required>&nbsp;
                    <input type="text" v-model="editCandidateSurname" placeholder="Nazwisko" required>&nbsp;
                    <input type="submit" value="Edytuj kandydata">
                </form>
                </div>
            </li>
        </ul>
    </div>
</template>

<script>
    export default {

        props: [
            'CandidatesInfo',],

        data() {
            return {
                name: "AdminCandidates",
                CandidateName:'',
                CandidateSurname:'',
                editCandidateName:'',
                editCandidateSurname:'',
                status: '',
                EditView:'',
            }
        },

        methods:{

            addCandidate() {
                this.axios.post('http://localhost:8080/addCandidate',  null, { params: {
                        CandidateName: this.CandidateName,
                        CandidateSurname: this.CandidateSurname,
                    }}).then(response =>{
                    // console.log(this.data);
                    this.status = response.data;
                    if(this.status === "Kandydat już istnieje")
                    {
                        this.CandidateName = '';
                        this.CandidateSurname = '';
                        this.$alert("Kandydat nie został dodany ponieważ już istnieje");
                    }else
                    {
                        this.CandidateName = '';
                        this.CandidateSurname = '';
                        this.$alert("Dodano kandydata");
                    }
                    console.log(response);
                    this.refresh(3);
                }).catch(error => {
                    console.log(error);
                    this.data = '';
                    this.$alert("Podczas dodawania kandydata wystąpił błąd");
                })},

            refresh(val){
                this.$emit('refresh',val);
            },

            deleteCandidate(candidateId) {
                this.axios.post('http://localhost:8080/deleteCandidate',  null, { params: {
                        candidateId: candidateId,
                    }}).then(response =>{
                    console.log(response);
                    this.$alert(response.data);
                    this.refresh(3);
                }).catch(error => {
                    console.log(error);
                    this.$alert("Podczas usuwania kandydata wystąpił błąd");
                })},

            editCandidate(candidateId) {
                this.axios.post('http://localhost:8080/editCandidate',  null, { params: {
                        candidateId: candidateId,
                        CandidateName: this.editCandidateName,
                        CandidateSurname: this.editCandidateSurname,
                    }}).then(response =>{
                    console.log(response);
                    this.$alert(response.data);
                    this.CandidateName = '';
                    this.CandidateSurname = '';
                    this.editView('a');
                    this.refresh(3);
                }).catch(error => {
                    console.log(error);
                    this.$alert("Podczas edytowania kandydata wystąpił błąd");
                })},

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