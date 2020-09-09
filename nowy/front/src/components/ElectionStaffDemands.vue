<template>
    <div>
        <Label>Plan wyborczy kandydata: </Label>
        <br>
        <textarea v-model="DemandsInfo.demands" placeholder="Plan wyborczy"></textarea>
        <br>
        <input type="submit" value="Zapisz" @click="setDemandsInfo()">
    </div>
</template>

<script>
    export default {

        props: [
            'DemandsInfo',],

        data() {
            return {
                name: "ElectionStaffDemands",
                message:'',
            }
        },

        methods: {
            setDemandsInfo() {
                this.axios.post('http://localhost:8080/setDemandsInfo', null, {
                        params: {
                            DemandsInfo: this.DemandsInfo.demands,
                            DemandsId: this.DemandsInfo.id,
                        }
                    }
                ).then(response => {
                    console.log(response);
                    this.DemandsInfo = response.data;
                    this.$alert("Zmiany zostały zapisane");
                }).catch(error => {
                    console.log(error);
                    this.$alert("Zmiany nie zostały zapisane");
                })
            },
        }
    }
</script>

<style scoped>

</style>