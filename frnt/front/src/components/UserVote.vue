<template>
    <div class = vot>
        <br>
        <br>
        <div v-if="userInfo[4] === dataCheck">
            <ul  v-if="userInfo[6] !== alreadyVoted">
                <li  v-for="(item, index) in candidatesInfo" :key="`item-${index}`">
                    <br>
                    {{candidatesInfo[index].electionStaff.candidates.name}} {{candidatesInfo[index].electionStaff.candidates.surname}}
                    <input type="submit" value="Zagłosuj" @click="voting(candidatesInfo[index].id)">
                </li>
            </ul>
            <ul v-else>Oddales juz glos</ul>
        </div>
        <div v-else>Dziś nie ma głosowania</div>
    </div>
</template>

<script>
    export default {

        props: [
            'userData',
            'candidatesInfo'],

        data() {
            return {
                name: "Vote",
                dataCheck: "odbedzie sie dzis:",
                alreadyVoted: "alreadyVoted",
                userInfo: this.userData,
            }
        },

        methods: {

            voting(candidateId) {
                this.axios.post('http://localhost:8080/vote', null, {
                        params: {
                            candidateId: candidateId,
                            userId: this.userInfo[0],
                            dateOfVoting: this.userInfo[1],
                        }
                    }
                ).then(response => {
                    //  console.log(candidateId);
                    //  console.log(this.userData[0]);
                    console.log(response);
                    this.userInfo[6] = response.data;
                    //this.passfavInfo(response.data);
                    this.$alert("Oddano głos i zostales przekierowany na strone glowna");
                    this.swapLocalView(1);
                }).catch(error => {
                    //  console.log(candidateId);
                    //  console.log(this.userData[0]);
                    console.log(error);
                    this.$alert("Wystąpił błąd podczas głosowania");
                })
            },

            swapLocalView(text) {
                this.$emit('swapLocalView', text);
            },
        }
    }

</script>

<style scoped>

</style>