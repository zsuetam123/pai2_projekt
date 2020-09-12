<template>
    <div>
        <br>
        <br>
        <form @submit.prevent="addMember">
            <p>
                <label>Nowy członek: </label>
                <input id="MemberName" type="text" v-model="MemberName" placeholder="Imię" required>&nbsp;
                <input id="MemberSurname" type="text" v-model="MemberSurname" placeholder="Nazwisko" required>&nbsp;

                <select v-model="selected" required>
                    <option value="" disabled selected>Wybierz kandydata</option>
                    <option v-for="option in CandidatesInfo" v-bind:value="option.id" :key="option.id">
                        {{option.name}} {{option.surname}}
                    </option>
                </select>
                &nbsp;
                <select v-model="position" required>
                    <option value="" disabled selected>Wybierz pozycję</option>
                    <option v-for="item in options" v-bind:value="item.text" :key="item.id">
                        {{item.text}}
                    </option>
                </select>
                &nbsp;
                <input type="submit" value="Dodaj">
            </p>
        </form>

        <ul>
            <br>
        <label>Lista członków sztabów:</label>
        <li v-for="(item, index) in MembersInfo" :key="`item-${index}`">
            <br>
            {{MembersInfo[index].name}}&nbsp;{{MembersInfo[index].surname}},&nbsp;{{MembersInfo[index].position}},&nbsp;{{MembersInfo[index].electionStaff.candidates.name}}&nbsp;{{MembersInfo[index].electionStaff.candidates.surname}}
            <input type="submit" value="Usuń" @click="deleteMember(MembersInfo[index].id)">&nbsp;
            <input type="submit" value="Edytuj" @click="editView(index)">
            <div v-if="EditView === index">
                <br>
                <form @submit.prevent="editMember(MembersInfo[index].id)">
                    <label>Edytuj kandydata: </label>
                    <input type="text" v-model="editMemberName" placeholder="Imię" required>&nbsp;
                    <input type="text" v-model="editMemberSurname" placeholder="Nazwisko" required>&nbsp;
                    <select v-model="editSelected" required>
                        <option value="" disabled selected>Wybierz kandydata</option>
                        <option v-for="option in CandidatesInfo" v-bind:value="option.id" :key="option.id">
                            {{option.name}} {{option.surname}}
                        </option>
                    </select>
                    &nbsp;
                    <select v-model="editPosition" required>
                        <option value="" disabled selected>Wybierz pozycję</option>
                        <option v-for="item in options" v-bind:value="item.text" :key="item.id">
                            {{item.text}}
                        </option>
                    </select>&nbsp;
                    <input type="submit" value="Edytuj członka">
                </form>
            </div>&nbsp;
        </li>
    </ul>
    </div>
</template>

<script>

    export default {

        props: [
            'MembersInfo',
            'CandidatesInfo',],

        data() {
            return {
                name: "AdminElectionStaff",
                editMemberName: '',
                editMemberSurname: '',
                EditView:'',
                MemberName: '',
                MemberSurname: '',
                selected: '',
                editSelected: '',
                position: '',
                editPosition: '',
                options: [
                    { text: 'Wolontariusz'},
                    { text: 'Doradca'},
                    { text: 'Asystent'},
                    { text: 'Rzecznik prasowy'},
                    { text: 'Kierownik biura'},
                    { text: 'Prawnik'},
                    { text: 'Koordynator wolontariuszy'},

                ]

            }
        },

        methods: {

            addMember() {
                this.axios.post('http://localhost:8080/addMember', null, {
                    params: {
                        MemberName: this.MemberName,
                        MemberSurname: this.MemberSurname,
                        selected: this.selected,
                        position: this.position,
                    }
                }).then(response => {
                    // console.log(this.data);
                    this.status = response.data;
                    if (this.status === "Czlonek juz istnieje") {
                        this.MemberName = '';
                        this.MemberSurname = '';
                        this.selected = '';
                        this.position = '';
                        this.$alert("Czlonek nie został dodany ponieważ już istnieje");
                    } else {
                        this.MemberName = '';
                        this.MemberSurname = '';
                        this.selected = '';
                        this.position = '';
                        this.$alert("Dodano czlonka");
                    }
                    console.log(response);
                    this.refresh(4);
                }).catch(error => {
                    console.log(error);
                    this.data = '';
                    this.$alert("Podczas dodawania czlonka wystąpił błąd");
                })
            },

            refresh(val){
                this.$emit('refresh',val);
            },

            deleteMember(memberId) {
                this.axios.post('http://localhost:8080/deleteMember',  null, { params: {
                        memberId: memberId,
                    }}).then(response =>{
                    console.log(response);
                    this.$alert(response.data);
                    this.refresh(4);
                }).catch(error => {
                    console.log(error);
                    this.$alert("Podczas usuwania kandydata wystąpił błąd");
                })},

            editMember(MemberId) {
                this.axios.post('http://localhost:8080/editMember',  null, { params: {
                        MemberId: MemberId,
                        editMemberName: this.editMemberName,
                        editMemberSurname: this.editMemberSurname,
                        editSelected: this.editSelected,
                        editPosition: this.editPosition,
                    }}).then(response =>{
                    console.log(response);
                    this.$alert(response.data);
                    this.editMemberName = '';
                    this.editMemberSurname = '';
                    this.editSelected = '';
                    this.editPosition = '';
                    this.editView('a');
                    this.refresh(4);
                }).catch(error => {
                    console.log(error);
                    this.$alert("Podczas edytowania członka wystąpił błąd");
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

    select:required:invalid {
        color: gray;
    }
    option[value=""][disabled] {
        display: none;
    }
    option {
        color: black;
    }

</style>