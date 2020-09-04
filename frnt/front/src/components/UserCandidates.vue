<template>
    <div class = cand>
        <br>
        <br>
        <ul>
            <li v-for="(item, index) in candidatesInfo" :key="`item-${index}`">
                <br>
                {{candidatesInfo[index].electionStaff.candidates.name}} {{candidatesInfo[index].electionStaff.candidates.surname}}
                <br> {{candidatesInfo[index].demands}}
                <br> <input type="submit" value="Ulubiony kandydat" @click="favouriteCandidate(candidatesInfo[index].id)">
            </li>
        </ul>
        </div>

</template>

<script>

    export default {
        props: [
            'userData',
            'candidatesInfo'],

        data() {
            return {
                name: "Candidates",
            }
        },

        methods:{

        favouriteCandidate(candidateId){
            this.axios.post('http://localhost:8080/addfavcandidate',  null, { params: {
                    candidateId: candidateId,
                    userId: this.userData[0]
                }}
            ).then(response =>{
              //  console.log(candidateId);
              //  console.log(this.userData[0]);
                console.log(response);
                this.passfavInfo(response.data);
                this.$alert("Dodano kandydata do ulubionych");
            }).catch(error => {
              //  console.log(candidateId);
              //  console.log(this.userData[0]);
                console.log(error);
                this.$alert("Wystąpił błąd podczas dodawania kandydata");
            })
        },

            passfavInfo(favInfo){
                this.$emit('passfavInfo', favInfo);
            },

    }
    }
</script>

<style scoped>

</style>